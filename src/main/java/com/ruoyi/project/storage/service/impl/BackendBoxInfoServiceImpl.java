package com.ruoyi.project.storage.service.impl;

import com.ruoyi.project.storage.domain.BoxInfoVO;
import com.ruoyi.project.storage.mapper.BoxInfoMapper;
import com.ruoyi.project.storage.service.BackendBoxInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BackendBoxInfoServiceImpl implements BackendBoxInfoService {
    @Resource
    private BoxInfoMapper boxInfoMapper;
    @Override
    public List<BoxInfoVO> getBoxInfoList(BoxInfoVO boxInfoVO) {
        return boxInfoMapper.findBoxInfoList(boxInfoVO);
    }
}
