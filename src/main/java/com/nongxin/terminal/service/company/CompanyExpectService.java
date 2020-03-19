package com.nongxin.terminal.service.company;

import com.nongxin.terminal.entity.company.CompanyExpect;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nongxin
 * @since 2019-10-29
 */
public interface CompanyExpectService extends IService<CompanyExpect> {

    List<CompanyExpect> getCompanyExpect(Integer companyId);

    boolean add(CompanyExpect companyExpect);

    boolean delete(Integer id);

    boolean update(CompanyExpect companyExpect);

}
