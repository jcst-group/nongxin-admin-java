package com.nongxin.terminal.controller.backstage.base;


import com.nongxin.terminal.service.base.SugarContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nongxin
 * @since 2019-10-29
 */
@RestController
@RequestMapping("/sugarContent")
public class SugarContentController {

    @Autowired
    private SugarContentService sugarContentService;



}
