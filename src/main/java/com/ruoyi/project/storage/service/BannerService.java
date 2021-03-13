package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.BannerParam;
import com.ruoyi.project.storage.domain.BannerVO;

import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/13 8:14
 */
public interface BannerService {
    List<BannerVO> findBannerList(BannerParam param);

    int creat(BannerVO bannerVO);
}
