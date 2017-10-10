package com.lm.waxmanager.controller;

import com.lm.waxmanager.domain.WaxInTmp;
import com.lm.waxmanager.service.WaxInTmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 蜡块入库临时表控制器
 */
@RestController
@RequestMapping("/waxIn")
public class WaxInTmpController {

    @Autowired
    private WaxInTmpService waxInTmpService;

    @RequestMapping(value = "/allTmpWaxIn", method = RequestMethod.GET)
    public List<WaxInTmp> getAllTmpWaxIn() {
        return this.waxInTmpService.getAll();
    }
}
