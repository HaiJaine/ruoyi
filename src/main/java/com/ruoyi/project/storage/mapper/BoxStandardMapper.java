package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.BoxStandardSelectVO;
import com.ruoyi.project.storage.domain.BoxStandardVO;

import java.util.List;
import java.util.Map;

public interface BoxStandardMapper {

    List<BoxStandardVO> findBoxStandardList(BoxStandardVO boxStandardVO);

    List<BoxStandardSelectVO> selectBoxStandardSelectList();

    int createBoxStandard(BoxStandardVO boxStandardVO);

    int deleteBoxStandards(Map<String, Object> map);
}