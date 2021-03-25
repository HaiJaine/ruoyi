package com.ruoyi.project.storage.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LongHaiJiang
 * @date 2021/3/12 10:43
 */
@Data
public class AdviceVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 手机端用户id
     */
    private Long userId;

    /**
     * 提交人
     */
    private String nickName;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

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

    private static final long serialVersionUID = 1L;
}