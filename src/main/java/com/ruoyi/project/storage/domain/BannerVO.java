package com.ruoyi.project.storage.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * t_advertisement
 * @author 
 */
@Data
public class BannerVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片路径
     */
    private String imgUrl;

    /**
     * 可获积分
     */
    private Long points;

    /**
     * 是否启用（0：启用；1：停用）
     */
    private Byte isEnable;

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