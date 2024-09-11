package zhj.region_nbs_get.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_base_region_url")
@Data
public class RegionUrl {
    @TableId
    public long id;
    @TableField
    public String url;
}
