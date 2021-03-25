package com.ruoyi.project.storage.domain;

import lombok.Data;

/**
 * @author LongHaiJiang
 * @date 2021/3/13 9:48
 */
@Data
public class Params {
    private String searchValue;

    private String nickName;
    private Integer status;
    private String emptyBoxOrderTimeStart;
    private String emptyBoxOrderTimeEnd;
    private String heavyBoxOrderTimeStart;
    private String heavyBoxOrderTimeEnd;
}
