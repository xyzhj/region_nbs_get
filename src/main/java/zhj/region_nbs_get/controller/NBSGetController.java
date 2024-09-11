package zhj.region_nbs_get.controller;

import com.alibaba.fastjson2.JSON;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zhj.region_nbs_get.entity.Region;
import zhj.region_nbs_get.entity.Uid;
import zhj.region_nbs_get.mapper.RegionMapper;
import zhj.region_nbs_get.service.HYPinyinHelper;
import zhj.region_nbs_get.service.NBSGetService;

import java.io.IOException;
import java.util.Objects;

@RestController
public class NBSGetController {

    @Autowired
    private NBSGetService nbsGetService;

    private RegionMapper regionMapper;

    private RestTemplate restTemplate;

    private Uid uid;

    @Value("${stats.region.rootURI.prefix}")
    private String URIpre;

    @Value("${stats.region.rootURI.postfix}")
    private String URIpost;

    @Value("${http.UIDURI}")
    private String UidUri;

    public NBSGetController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/get")
    public void get() throws IOException {
        Document doc = nbsGetService.getDoc(URIpre+URIpost);

        Elements elements = doc.getElementsByClass("provincetable");
        Elements contents = Objects.requireNonNull(elements.first()).getElementsByTag("a");
//        List<Region> regions = new ArrayList<>();
        for (Element content : contents) {
            Region r = new Region();
            long newUid = getUid();
            r.setId(newUid);
            r.setRn(content.text());
            r.setRh(HYPinyinHelper.getFirstSpell(r.rn));
            r.setRsn("");
            r.setRsh("");
            r.setFn(r.rn);
            r.setRc(content.attr("href").substring(0, 2) + "0000000000");
            r.setRt(1);
            r.setRtt("");
            r.setR1(newUid);
            r.setR2(0L);
            r.setR3(0L);
            r.setR4(0L);
            r.setRp(1);
            r.setRt(1);
            System.out.println(JSON.toJSONString(r));
//            regionMapper.insert(r);
        }
        //return r;
    }

    public Long getUid() {

        uid = JSON.parseObject(restTemplate.getForObject(UidUri, String.class),Uid.class);
        if (uid != null) {
            return uid.ID;
        }
        else {return 0L;}
    }

}
