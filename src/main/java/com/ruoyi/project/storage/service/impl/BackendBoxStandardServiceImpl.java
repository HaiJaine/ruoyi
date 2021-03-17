package com.ruoyi.project.storage.service.impl;

import com.ruoyi.project.storage.domain.BoxStandardVO;
import com.ruoyi.project.storage.domain.Params;
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
    public List<BoxStandardVO> getBoxStandardList(Params params) {
        List<BoxStandardVO> boxStandardList = boxStandardMapper.findBoxStandardList(params);
        for (BoxStandardVO boxStandardVO : boxStandardList) {
            boxStandardVO.setSearchValue(params.getSearchValue());
        }
        return boxStandardList;
    }
}
