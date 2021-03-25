package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.vo.BoxStandardSelectVO;
import com.ruoyi.project.storage.domain.vo.BoxStandardVO;

import java.util.List;
import java.util.Map;
/**
 * @author LongHaiJiang
 * @date 2021/3/12 10:37
 */
public interface BoxStandardMapper {

    List<BoxStandardVO> findBoxStandardList(BoxStandardVO boxStandardVO);

    List<BoxStandardSelectVO> selectBoxStandardSelectList();

    int createBoxStandard(BoxStandardVO boxStandardVO);

    int deleteBoxStandards(Map<String, Object> map);
}