package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.AdviceVO;

import java.util.List;

/**
 * @author HaiJaine
 * @date 2021/3/12 10:37
 */
public interface BackendAdviceMapper {
    List<AdviceVO> findAdviceList();
}
