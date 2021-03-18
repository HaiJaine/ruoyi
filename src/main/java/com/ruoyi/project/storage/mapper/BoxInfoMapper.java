package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.BoxInfoVO;

import java.util.List;

public interface BoxInfoMapper {

    int insert(BoxInfoVO record);

    int insertSelective(BoxInfoVO record);

    int updateByPrimaryKeySelective(BoxInfoVO record);

    int updateByPrimaryKey(BoxInfoVO record);

    List<BoxInfoVO> findBoxInfoList(BoxInfoVO boxInfoVO);
}