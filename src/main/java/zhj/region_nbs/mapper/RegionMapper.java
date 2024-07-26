package zhj.region_nbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import zhj.region_nbs.entity.Region;

public interface RegionMapper extends BaseMapper<Region> {

    Region getRegionById(long id);
}
