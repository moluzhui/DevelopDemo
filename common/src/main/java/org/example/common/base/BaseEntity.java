package org.example.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础数据模型公共属性
 */
@Data
public class BaseEntity  implements Serializable {

    /**
     * 数据库唯一标识
     */
    Long id;

    /**
     * 创建者
     */
    String  createBy;
    /**
     * 创建时间
     */
    Date createDate;
    /**
     * 更新者
     */
    String  updateBy;

    /**
     * 更新时间
     */
    Date   updateDate;

    /**
     * 是否有效(0:有效，1：删除)
     */
    Integer   enable;
    /**
     * 租户编码
     */
    String  tenant;
}
