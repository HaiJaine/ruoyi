package com.ruoyi.project.storage.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_box_info
 * @author 
 */
@Data
public class BoxInfoVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 箱子编号（年月日+6位序列）
     */
    private Long boxCode;

    /**
     * 箱子规格（如20*20*20）
     */
    private String boxStandard;

    /**
     * 箱子积分单价（每月积分单价）
     */
    private Long boxUnitPrice;

    /**
     * 使用人
     */
    private Long usedBy;

    /**
     * 是否被使用（0：未使用；1：已使用）
     */
    private Byte isUsed;

    /**
     * 备注
     */
    private String remark;

    /**
     * 序号
     */
    private Long sortNo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 删除标记（0：未删除；2：已删除）
     */
    private String delFlag;

    private static final long serialVersionUID = 1L;
}