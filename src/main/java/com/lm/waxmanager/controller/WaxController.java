package com.lm.waxmanager.controller;

import com.lm.waxmanager.domain.Wax;
import com.lm.waxmanager.domain.WaxInTmp;
import com.lm.waxmanager.service.WaxInTmpService;
import com.lm.waxmanager.service.WaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * 蜡块入库控制器
 */
@RestController
@RequestMapping("/wax")
public class WaxController {

    @Autowired
    private WaxService waxService;

    /**
     * 获取所有wax
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Wax> getAllTmpWaxIn() {
        return this.waxService.getAll();
    }

    /**
     * 确认入库
     * @param waxinid
     * @return
     */
    @RequestMapping(value = "/in/{waxinid}", method = RequestMethod.POST)
    public String waxIn(@PathVariable("waxinid") int waxinid) {
        return this.waxService.addWax(waxinid);
    }
}
