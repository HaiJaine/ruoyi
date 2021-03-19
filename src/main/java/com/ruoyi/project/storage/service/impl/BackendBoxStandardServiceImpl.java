package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.storage.domain.BoxInfoVO;
import com.ruoyi.project.storage.domain.BoxStandardSelectVO;
import com.ruoyi.project.storage.domain.BoxStandardVO;
import com.ruoyi.project.storage.mapper.BoxInfoMapper;
import com.ruoyi.project.storage.mapper.BoxStandardMapper;
import com.ruoyi.project.storage.service.BackendBoxStandardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BackendBoxStandardServiceImpl implements BackendBoxStandardService {
    @Resource
    private BoxStandardMapper boxStandardMapper;

    @Resource
    BoxInfoMapper boxInfoMapper;

    @Override
    public List<BoxStandardVO> getBoxStandardList(BoxStandardVO boxStandardVO) {
        return boxStandardMapper.findBoxStandardList(boxStandardVO);
    }

    @Override
    public List<BoxStandardSelectVO> selectBoxStandardSelectList() {
        return boxStandardMapper.selectBoxStandardSelectList();
    }

    @Override
    @Transactional(rollbackFor = CustomException.class)
    public int createBoxStandard(BoxStandardVO boxStandardVO) throws CustomException {
        String loginUserId = String.valueOf(SecurityUtils.getLoginUser().getUser().getUserId());
        boxStandardVO.setCreateBy(loginUserId);
        boxStandardVO.setCreateTime(new Date());
        boxStandardVO.setSortNo(0L);
        boxStandardVO.setUpdateBy(loginUserId);
        boxStandardVO.setUpdateTime(new Date());
        boxStandardVO.setVersion(0L);
        boxStandardVO.setDelFlag("0");
        int result = boxStandardMapper.createBoxStandard(boxStandardVO);
        if (result > 0) {
            List<BoxInfoVO> boxInfoVOList = new ArrayList<>();
            for (int i = 0; i < boxStandardVO.getInventoryNumber(); i++) {
                BoxInfoVO boxInfoVO = new BoxInfoVO();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String boxCode = simpleDateFormat.format(new Date());
                boxInfoVO.setBoxCode(Long.valueOf(boxCode));
                boxInfoVO.setBoxStandard(boxStandardVO.getBoxStandard());
                boxInfoVO.setBoxUnitPrice(boxStandardVO.getBoxUnitPrice());
                boxInfoVO.setIsUsed("0");
                boxInfoVO.setRemark(boxStandardVO.getRemark());
                boxInfoVO.setSortNo(0L);
                boxInfoVO.setCreateTime(new Date());
                boxInfoVO.setCreateBy(loginUserId);
                boxInfoVO.setUpdateTime(new Date());
                boxInfoVO.setUpdateBy(loginUserId);
                boxInfoVO.setVersion(0L);
                boxInfoVO.setDelFlag("0");
                boxInfoVOList.add(boxInfoVO);
            }
            int boxInfo = boxInfoMapper.createBoxInfo(boxInfoVOList);
            if (boxInfo <= 0) {
                throw new CustomException("出错了");
            }
        } else {
            throw new CustomException("出错了");
        }
        return result;
    }

    @Override
    public int deleteBoxStandards(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("updateBy", SecurityUtils.getLoginUser().getUser().getUserId());
        return boxStandardMapper.deleteBoxStandards(map);
    }
}
