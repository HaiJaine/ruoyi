package com.ruoyi.project.storage.domain;

import lombok.Data;

/**
 * @author HaiJaine
 * @date 2021/3/12 10:43
 */
@Data
public class AdviceVO {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private Long sortNo;
    private String createTime;
    private String createBy;
    private String updateTime;
    private String updateBy;
    private Long version;
    private String delFlag;
}
