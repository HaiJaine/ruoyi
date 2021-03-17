package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.BoxStandardVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;

public interface BoxStandardMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BoxStandardVO record);

    int insertSelective(BoxStandardVO record);

    int updateByPrimaryKeySelective(BoxStandardVO record);

    int updateByPrimaryKey(BoxStandardVO record);

    List<BoxStandardVO> findBoxStandardList(Params params);
}