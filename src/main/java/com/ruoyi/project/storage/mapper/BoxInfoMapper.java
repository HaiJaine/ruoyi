package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.vo.BoxInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BoxInfoMapper {

    int createBoxInfo(@Param("boxInfoVOList") List<BoxInfoVO> boxInfoVOList);

    List<BoxInfoVO> findBoxInfoList(BoxInfoVO boxInfoVO);

    int deleteBoxStandards(Map<String, Object> map);

    List<Integer> findBoxInfoStatusList(Map<String, Object> map);
}