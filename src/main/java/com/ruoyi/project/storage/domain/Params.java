package com.ruoyi.project.storage.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author HaiJaine
 * @date 2021/3/13 9:48
 */
@Data
public class Params {
    private String searchValue;

    private String nickName;
    private Integer status;
    private Date emptyBoxOrderTimeStart;
    private Date emptyBoxOrderTimeEnd;
    private Date heavyBoxOrderTimeStart;
    private Date heavyBoxOrderTimeEnd;
}
