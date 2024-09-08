package zhj.region_nbs_get.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//@Component("regionurl")
@TableName
@Data
public class RegionUrl {
    @TableId
    public long id;
    @TableField
    public String url;
}
