package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.BannerVO;

import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/13 8:14
 */
public interface BackendBannerService {
    List<BannerVO> findBannerList(Params param);

    int creat(BannerVO bannerVO);

    int update(BannerVO bannerVO);

    int operate(String enAble, Long[] ids);

    int delete(Long[] ids);
}