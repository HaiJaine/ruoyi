package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.BoxInfoVO;

public interface BoxInfoMapper {

    int insert(BoxInfoVO record);

    int insertSelective(BoxInfoVO record);

    int updateByPrimaryKeySelective(BoxInfoVO record);

    int updateByPrimaryKey(BoxInfoVO record);
}