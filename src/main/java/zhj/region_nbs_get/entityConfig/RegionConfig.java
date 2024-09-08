package zhj.region_nbs_get.entityConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import zhj.region_nbs_get.entity.Region;

import java.time.LocalDateTime;

@Configuration
@ComponentScan("zhj.region_nbs_get.entity")
public class RegionConfig {
    public Region initRegion(long id,String rn,String rh,String rsn,String rsh,String fn,String rc,long rt,String rtt,long r1,long r2,long r3,long r4,long rp) {
        var region = new Region();
        region.setId(id);
        region.setRn(rn);
        region.setRh(rh);
        region.setRsn(rsn);
        region.setRsh(rsh);
        region.setFn(fn);
        region.setRc(rc);
        region.setRt(rt);
        region.setRtt(rtt);
        region.setR1(r1);
        region.setR2(r2);
        region.setR3(r3);
        region.setR4(r4);
        region.setRp(rp);
        region.setSt(1);
        region.setCt(LocalDateTime.now());
        region.setUt(LocalDateTime.now());
        return region;
    }
}
