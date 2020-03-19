package com.nongxin.terminal.vo.monitorboard;

import lombok.Data;

import java.util.List;

@Data
public class RainVo {

    private Integer equipmentId;

    private List<String> day;

    private List<String> month;

    private List<String> year;

}
