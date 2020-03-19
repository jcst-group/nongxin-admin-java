package com.nongxin.terminal.dao.base;

import com.nongxin.terminal.entity.base.FruitGrading;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nongxin
 * @since 2019-11-01
 */
public interface FruitGradingMapper extends BaseMapper<FruitGrading> {

    FruitGrading selectByBaseId(@Param("baseId") Integer baseId);

}
