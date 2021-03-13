package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.storage.domain.BannerParam;
import com.ruoyi.project.storage.domain.BannerVO;
import com.ruoyi.project.storage.mapper.BannerMapper;
import com.ruoyi.project.storage.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/13 8:46
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<BannerVO> findBannerList(BannerParam param) {
        return bannerMapper.findBannerList(param);
    }

    @Override
    public int creat(BannerVO bannerVO) {
        bannerVO.setDelFlag(0);
        bannerVO.setCreateTime(new Date());
        bannerVO.setCreateBy(SecurityUtils.getLoginUser().getUsername());
        bannerVO.setIsEnable(0);
        bannerVO.setUpdateTime(new Date());
        bannerVO.setUpdateBy(SecurityUtils.getLoginUser().getUsername());
        bannerVO.setVersion(0L);
        int result = bannerMapper.create(bannerVO);
        return result;
    }

    @Override
    public int update(BannerVO bannerVO) {
        // bannerVO.setVersion(bannerVO.getVersion() + 1);
        return bannerMapper.update(bannerVO);
    }
}
