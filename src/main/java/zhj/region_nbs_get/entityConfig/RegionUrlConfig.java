package zhj.region_nbs_get.entityConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import zhj.region_nbs_get.entity.RegionUrl;

@Configuration
@ComponentScan("zhj.region_nbs_get.entity")
public class RegionUrlConfig {
    public RegionUrl initRegionUrl(long id,String url) {
        var regionurl = new RegionUrl();
        regionurl.setId(id);
        regionurl.setUrl(url);
        return regionurl;
    }
}
