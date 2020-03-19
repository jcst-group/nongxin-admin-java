package com.nongxin.terminal.vo.app;

import com.nongxin.terminal.entity.base.BaseInfo;

import java.util.List;

public class BaseParamVo {

    private List<BaseInfo> baseId;

    private Integer typeId;

    private Integer pageNo = 1;

    private Integer pageSize = 5;

    public List<BaseInfo> getBaseId() {
        return baseId;
    }

    public void setBaseId(List<BaseInfo> baseId) {
        this.baseId = baseId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
