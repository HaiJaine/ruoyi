package com.ruoyi.project.storage.service.impl;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.project.common.util.SeqGeneratorUtil;
import com.ruoyi.project.storage.domain.BoxInfoVO;
import com.ruoyi.project.storage.domain.BoxStandardSelectVO;
import com.ruoyi.project.storage.domain.BoxStandardVO;
import com.ruoyi.project.storage.mapper.BoxInfoMapper;
import com.ruoyi.project.storage.mapper.BoxStandardMapper;
import com.ruoyi.project.storage.service.BackendBoxStandardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    /**
     * 箱子新增
     *
     * @param boxStandardVO boxStandardVO
     * @return 结果
     * @throws CustomException 异常
     */
    @Override
    @Transactional(rollbackFor = CustomException.class)
    public int createBoxStandard(BoxStandardVO boxStandardVO) throws CustomException {
        boolean flag = true;
        String loginUserId = String.valueOf(SecurityUtils.getLoginUser().getUser().getUserId());
        boxStandardVO.setCreateBy(loginUserId);
        boxStandardVO.setCreateTime(new Date());
        boxStandardVO.setSortNo(0L);
        boxStandardVO.setUpdateBy(loginUserId);
        boxStandardVO.setUpdateTime(new Date());
        boxStandardVO.setVersion(0L);
        boxStandardVO.setDelFlag("0");
        final List<BoxStandardSelectVO> list = selectBoxStandardSelectList();
        for (BoxStandardSelectVO boxStandardSelectVO : list) {
            if (boxStandardSelectVO.getBoxStandard().equals(boxStandardVO.getBoxStandard())) {
                flag = false;
                if (!boxStandardSelectVO.getBoxUnitPrice().equals(boxStandardVO.getBoxUnitPrice())) {
                    throw new CustomException("新增失败，已存在相同规格的箱子");
                }
            }
        }
        int result = 0;
        if (flag) {
            result = boxStandardMapper.createBoxStandard(boxStandardVO);
        }
        if (result > 0 || !flag) {
            result = createBoxInfo(boxStandardVO, loginUserId);
        } else {
            throw new CustomException("出错了");
        }
        return result;
    }

    /**
     * 创建箱子信息
     *
     * @param boxStandardVO boxStandardVO
     * @param loginUserId   loginUserId
     */
    private int createBoxInfo(BoxStandardVO boxStandardVO, String loginUserId) {
        List<BoxInfoVO> boxInfoVOList = new ArrayList<>();
        for (int i = 0; i < boxStandardVO.getInventoryNumber(); i++) {
            BoxInfoVO boxInfoVO = new BoxInfoVO();
            boxInfoVO.setBoxCode(Long.valueOf(SeqGeneratorUtil.seqGenerator(DateUtils.getNowDateStr(), 6)));
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
        return boxInfo;
    }

    @Override
    @Transactional(rollbackFor = CustomException.class)
    public int deleteBoxStandards(Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("updateBy", SecurityUtils.getLoginUser().getUser().getUserId());
        List<Integer> boxInfoStatusList = boxInfoMapper.findBoxInfoStatusList(map);
        if (boxInfoStatusList.contains(0)) {
            throw new CustomException("删除箱子规格失败，规格下仍有箱子");
        }
        return boxStandardMapper.deleteBoxStandards(map);
    }

}
