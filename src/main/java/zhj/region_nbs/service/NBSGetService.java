package zhj.region_nbs.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhj.region_nbs.entity.Region;
import zhj.region_nbs.mapper.RegionMapper;

@Service
public class NBSGetService extends ServiceImpl<RegionMapper, Region> implements INBSGetService {

    @Override
    public Document getDoc(String URI) {
        return (Document) Jsoup.connect(URI);
    }

}
