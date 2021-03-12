package com.ruoyi.project.storage.service.impl;

import com.ruoyi.project.storage.domain.AdviceVO;
import com.ruoyi.project.storage.mapper.BackendAdviceMapper;
import com.ruoyi.project.storage.service.BackendAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/12 11:00
 */
@Service
public class BackendAdviceServiceImpl implements BackendAdviceService {

    @Autowired
    private BackendAdviceMapper backendAdviceMapper;

    @Override
    public List<AdviceVO> findAdviceList() {
        return backendAdviceMapper.findAdviceList();
    }
}
