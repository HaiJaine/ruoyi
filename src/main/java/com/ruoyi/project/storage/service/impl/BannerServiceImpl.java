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
        return bannerMapper.update(bannerVO);
    }

    @Override
    public int operate(String operate, Long ids) {
        int result = 0;
        BannerVO bannerVO = new BannerVO();
        bannerVO.setId(ids);
        if ("enable".equalsIgnoreCase(operate)) {
            bannerVO.setIsEnable(0);
            result = bannerMapper.isEnable(bannerVO);
        } else if ("disable".equalsIgnoreCase(operate)) {
            bannerVO.setIsEnable(1);
            result = bannerMapper.isEnable(bannerVO);
        } else if ("delete".equalsIgnoreCase(operate)) {
            bannerVO.setDelFlag(2);
            result = bannerMapper.delete(bannerVO);
        }
        return result;
    }
}
