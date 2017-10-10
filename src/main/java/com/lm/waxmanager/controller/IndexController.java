package com.lm.waxmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 导航Controller
 */
@Controller
public class IndexController {

    @RequestMapping("/show")
    public String show() {
        return "show";
    }

    @RequestMapping("/waxM")
    public String waxManager() {
        return "waxManager";
    }

    @RequestMapping("/uao")
    public String updAndOCR() {
        return "uploadAndOCR";
    }
}
