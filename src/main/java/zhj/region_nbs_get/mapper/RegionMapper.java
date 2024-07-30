package zhj.region_nbs_get.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import zhj.region_nbs_get.entity.Region;

public interface RegionMapper extends BaseMapper<Region> {

    Region getRegionById(long id);
}
