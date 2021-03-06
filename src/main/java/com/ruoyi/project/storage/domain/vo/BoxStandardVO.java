package com.ruoyi.project.storage.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LongHaiJiang
 * @date 2021/3/13 9:48
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BoxStandardVO extends BaseEntity implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 箱子规格（如20*20*20）
     */
    private String boxStandard;

    /**
     * 箱子积分单价（每月积分单价）
     */
    private Long boxUnitPrice;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    /**
     * 总数量
     */
    private Long totalNumber;

    /**
     * 已用数量
     */
    private Long usedNumber;

    /**
     * 库存
     */
    private Long inventoryNumber;

    /**
     * 使用比例
     */
    private String useRatio;

    private static final long serialVersionUID = 1L;

}