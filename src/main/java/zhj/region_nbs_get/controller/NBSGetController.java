package zhj.region_nbs_get.controller;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zhj.region_nbs_get.entity.Region;
import zhj.region_nbs_get.entity.RegionUrl;
import zhj.region_nbs_get.entity.Uid;
import zhj.region_nbs_get.entityConfig.RegionConfig;
import zhj.region_nbs_get.entityConfig.RegionUrlConfig;
import zhj.region_nbs_get.mapper.RegionMapper;
import zhj.region_nbs_get.mapper.RegionUrlMapper;
import zhj.region_nbs_get.service.HYPinyinHelper;
import zhj.region_nbs_get.service.NBSGetService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class NBSGetController {

    @Autowired
    private NBSGetService nbsGetService;

    private RegionMapper regionMapper;

    private RegionUrlMapper regionUrlMapper;

    private RegionConfig regionConfig;

    private RegionUrlConfig regionUrlConfig;

    private RestTemplate restTemplate;

    private Uid uid;

    @Value("${stats.region.rootURI.prefix}")
    private String URIpre;

    @Value("${stats.region.rootURI.postfix}")
    private String URIpost;

    @Value("${http.UIDURI}")
    private String UidUri;

    public NBSGetController(RegionMapper regionMapper, RegionUrlMapper regionUrlMapper, RegionConfig regionConfig, RegionUrlConfig regionUrlConfig, RestTemplate restTemplate) {
        this.regionMapper = regionMapper;
        this.regionUrlMapper = regionUrlMapper;
        this.regionConfig = regionConfig;
        this.regionUrlConfig = regionUrlConfig;
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/get")
    public void get() throws IOException {
        Document doc = nbsGetService.getDoc(URIpre + URIpost);

        Elements elements = doc.getElementsByClass("provincetable");
        Elements contents = Objects.requireNonNull(elements.first()).getElementsByTag("a");
        List<Region> regions = new ArrayList<>();
        List<RegionUrl> regionUrls = new ArrayList<>();

        List<Region> oldRegions = getRegionByType(1);
        for (Element content : contents) {
            long newUid = getUid();
            String Url = content.attr("href");
            String rn = content.text();
            Region r = regionConfig.initRegion(newUid, rn, HYPinyinHelper.getFirstSpell(rn), "", "", rn, Url.substring(0, 2) + "0000000000", 1, "", newUid, 0L, 0L, 0L, 1);
            regions.add(r);
            //System.out.println(JSON.toJSONString(r));
            RegionUrl ru = regionUrlConfig.initRegionUrl(newUid, URIpre + Url);
            regionUrls.add(ru);
            //System.out.println(JSON.toJSONString(ru));
        }
        regionMapper.insert(regions);
        regionUrlMapper.insert(regionUrls);
    }

    public Long getUid() {
        uid = JSON.parseObject(restTemplate.getForObject(UidUri, String.class), Uid.class);
        if (uid != null) {
            return uid.ID;
        } else {
            return 0L;
        }
    }

    private List<Region> getRegionByType(int regionType) {
        QueryWrapper<Region> queryWrapper = new QueryWrapper<>();
        return regionMapper.selectList(queryWrapper.eq("rt", regionType));
    }

}
