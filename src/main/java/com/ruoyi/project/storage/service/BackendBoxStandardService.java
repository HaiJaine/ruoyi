package com.ruoyi.project.storage.service;

import com.ruoyi.project.storage.domain.vo.BoxStandardSelectVO;
import com.ruoyi.project.storage.domain.vo.BoxStandardVO;

import java.util.List;
/**
 * @author LongHaijiang
 * @date 2021/3/13 21:12
 */
public interface BackendBoxStandardService {
    List<BoxStandardVO> getBoxStandardList(BoxStandardVO boxStandardVO);

    List<BoxStandardSelectVO> selectBoxStandardSelectList();

    int createBoxStandard(BoxStandardVO boxStandardVO);

    int deleteBoxStandards(Long[] ids);
}
