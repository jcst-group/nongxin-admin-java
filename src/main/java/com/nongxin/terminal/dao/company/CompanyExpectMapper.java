package com.nongxin.terminal.dao.company;

import com.nongxin.terminal.entity.company.CompanyExpect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author nongxin
 * @since 2019-10-29
 */
public interface CompanyExpectMapper extends BaseMapper<CompanyExpect> {

    List<CompanyExpect> getCompanyExpect(@Param("companyId")Integer companyId);

}
