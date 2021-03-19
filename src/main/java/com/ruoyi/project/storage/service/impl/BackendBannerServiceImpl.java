package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.domain.BannerVO;
import com.ruoyi.project.storage.mapper.BannerMapper;
import com.ruoyi.project.storage.service.BackendBannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HaiJaine
 * @date 2021/3/13 8:46
 */
@Service
public class BackendBannerServiceImpl implements BackendBannerService {
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<BannerVO> findBannerList(Params params) {
        return bannerMapper.findBannerList(params);
    }

    @Override
    public int creat(BannerVO bannerVO) {
        if (bannerVO.getTitle().length() > 20) {
            throw new CustomException("广告标题最大长度为20");
        }
        if (bannerVO.getContent().length() > 1000) {
            throw new CustomException("广告内容最大长度为1000");
        }
        if (bannerVO.getPoints() <= 0) {
            throw new CustomException("积分必须为正整数");
        }
        if (bannerVO.getImgUrl().length() > 512) {
            throw new CustomException("图片路劲最大长度为512");
        }
        bannerVO.setDelFlag(0);
        bannerVO.setCreateTime(new Date());
        bannerVO.setCreateBy(SecurityUtils.getLoginUser().getUsername());
        bannerVO.setIsEnable(0);
        bannerVO.setUpdateTime(new Date());
        bannerVO.setUpdateBy(SecurityUtils.getLoginUser().getUsername());
        bannerVO.setVersion(0L);
        return bannerMapper.create(bannerVO);
    }

    @Override
    public int update(BannerVO bannerVO) {
        return bannerMapper.update(bannerVO);
    }

    @Override
    public int operate(String operate, Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        List<Long> list = bannerMapper.findBanners(ids);
        int result = 0;
        if ("enable".equalsIgnoreCase(operate)) {
            if (!list.contains(0L)) {
                map.put("isEnable", 0);
                result = bannerMapper.isEnable(map);
            } else {
                throw new CustomException("状态为启用的用户，不能启用");
            }
        } else if ("disable".equalsIgnoreCase(operate)) {
            map.put("isEnable", 1);
            result = bannerMapper.isEnable(map);
        }
        return result;
    }

    /**
     * 删除广告
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public int delete(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        String updateBy = SecurityUtils.getLoginUser().getUsername();
        map.put("ids", ids);
        map.put("updateBy", updateBy);
        return bannerMapper.delete(map);
    }
}
