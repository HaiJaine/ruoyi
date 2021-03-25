package com.ruoyi.project.storage.mapper;

import com.ruoyi.project.storage.domain.vo.BoxInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @author LongHaiJiang
 * @date 2021/3/12 10:37
 */
public interface BoxInfoMapper {

    int createBoxInfo(@Param("boxInfoVOList") List<BoxInfoVO> boxInfoVOList);

    List<BoxInfoVO> findBoxInfoList(BoxInfoVO boxInfoVO);

    int deleteBoxInfo(Map<String, Object> map);

    List<Integer> findBoxInfoStatusList(Map<String, Object> map);

    void deleteBoxStandard();
}