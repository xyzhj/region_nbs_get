package zhj.region_nbs_get.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import zhj.region_nbs_get.entity.Region;
import zhj.region_nbs_get.mapper.RegionMapper;

import java.io.IOException;

@Service
public class NBSGetService extends ServiceImpl<RegionMapper, Region> implements INBSGetService {

    @Override
    public Document getDoc(String URI) throws IOException {
        return SSLHelper.getConnection(URI)
                .timeout(30000)
                .userAgent("Mozilla")
                .get();
    }
}
