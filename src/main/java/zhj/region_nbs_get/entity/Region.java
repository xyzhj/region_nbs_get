package zhj.region_nbs_get.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@TableName("t_base_region")
@Data
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
    @TableField(fill = FieldFill.INSERT)
    public LocalDateTime ct;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    public LocalDateTime ut;
}
