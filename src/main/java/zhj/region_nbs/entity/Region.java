package zhj.region_nbs.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName
public class Region {

    @TableId
    public long id;
    @TableField
    public String rn;
    @TableField
    public String rh;
    @TableField
    public String rsn;
    @TableField
    public String rsh;
    @TableField
    public String fn;
    @TableField
    public String rc;
    @TableField
    public long rt;
    @TableField
    public String rtt;
    @TableField
    public long r1;
    @TableField
    public long r2;
    @TableField
    public long r3;
    @TableField
    public long r4;
    @TableField
    public long rp;
    @TableField
    public int st;
    @TableField
    public LocalDateTime ct;
    @TableField
    public LocalDateTime ut;
}
