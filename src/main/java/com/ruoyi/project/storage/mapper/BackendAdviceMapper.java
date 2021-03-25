package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.vo.AdviceVO;
import com.ruoyi.project.storage.domain.Params;

import java.util.List;

/**
 * @author LongHaiJiang
 * @date 2021/3/12 10:37
 */

public interface BackendAdviceMapper {
    List<AdviceVO> findAdviceList(Params params);
}
