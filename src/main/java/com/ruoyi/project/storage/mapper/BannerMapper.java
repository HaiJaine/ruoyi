package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.BannerParam;
import com.ruoyi.project.storage.domain.BannerVO;

import java.util.List;
import java.util.Map;

public interface BannerMapper {

    List<BannerVO> findBannerList(BannerParam param);

    int create(BannerVO bannerVO);

    int update(BannerVO bannerVO);

    int isEnable(Map<String, Object> map);

    int delete(Map<String, Object> map);
}