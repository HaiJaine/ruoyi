package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.vo.BannerVO;

import java.util.List;
import java.util.Map;
/**
 * @author LongHaiJiang
 * @date 2021/3/12 10:37
 */
public interface BannerMapper {

    List<BannerVO> findBannerList(Params params);

    List<Long> findBanners(Map<String, Object> map);

    int create(BannerVO bannerVO);

    int update(BannerVO bannerVO);

    int isEnable(Map<String, Object> map);

    int delete(Map<String, Object> map);

    List<Integer> findBannerStatus(Map<String, Object> map);
}