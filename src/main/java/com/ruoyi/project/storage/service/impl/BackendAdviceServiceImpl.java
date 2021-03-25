package com.ruoyi.project.storage.service.impl;

import com.ruoyi.project.storage.domain.vo.AdviceVO;
import com.ruoyi.project.storage.domain.Params;
import com.ruoyi.project.storage.mapper.BackendAdviceMapper;
import com.ruoyi.project.storage.service.BackendAdviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LongHaiJiang
 * @date 2021/3/12 11:00
 */
@Service
public class BackendAdviceServiceImpl implements BackendAdviceService {

    @Resource
    private BackendAdviceMapper backendAdviceMapper;

    @Override
    public List<AdviceVO> findAdviceList(Params params) {
        return backendAdviceMapper.findAdviceList(params);
    }
}
