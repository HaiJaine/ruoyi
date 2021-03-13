package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.BannerParam;
import com.ruoyi.project.storage.domain.BannerVO;

import java.util.List;

public interface BannerMapper {

    List<BannerVO> findBannerList(BannerParam param);

    int create(BannerVO bannerVO);
}