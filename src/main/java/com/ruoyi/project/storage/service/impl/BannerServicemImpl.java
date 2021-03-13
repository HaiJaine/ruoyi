package com.ruoyi.project.storage.service.impl;

import com.ruoyi.project.storage.domain.BannerVO;
import com.ruoyi.project.storage.mapper.BannerMapper;
import com.ruoyi.project.storage.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/13 8:46
 */
@Service
public class BannerServicemImpl implements BannerService {
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<BannerVO> findBannerList() {
        return bannerMapper.findBannerList();
    }
}
