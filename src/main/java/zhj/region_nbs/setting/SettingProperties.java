package zhj.region_nbs.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SettingProperties {

    @Value("${stats.region.rootURI}")
    private String rootURI = null;
}
