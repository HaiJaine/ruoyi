package com.ruoyi.project.storage.service.impl;

import com.ruoyi.project.storage.domain.BoxStandardSelectVO;
import com.ruoyi.project.storage.domain.BoxStandardVO;
import com.ruoyi.project.storage.mapper.BoxStandardMapper;
import com.ruoyi.project.storage.service.BackendBoxStandardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BackendBoxStandardServiceImpl implements BackendBoxStandardService {
    @Resource
    private BoxStandardMapper boxStandardMapper;

    @Override
    public List<BoxStandardVO> getBoxStandardList(BoxStandardVO boxStandardVO) {
        List<BoxStandardVO> boxStandardList = boxStandardMapper.findBoxStandardList(boxStandardVO);
        return boxStandardList;
    }

    @Override
    public List<BoxStandardSelectVO> selectBoxStandardSelectList() {
        return boxStandardMapper.selectBoxStandardSelectList();
    }
}
