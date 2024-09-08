package zhj.region_nbs_get.mapper;

import com.baomidou.mybatisplus.core.mapper.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseMapper<T> extends Mapper<T> {
    int insert(T entity);
}
