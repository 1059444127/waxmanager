package com.lm.waxmanager.service;

import com.lm.waxmanager.domain.Wax;
import com.lm.waxmanager.domain.WaxInTmp;
import com.lm.waxmanager.mapper.WaxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class WaxService {

    @Autowired
    private WaxMapper waxMapper;

    @Autowired
    private WaxInTmpService waxInTmpService;

    public List<Wax> getAll() {
        return this.waxMapper.queryAll();
    }

    /**
     * 添加wax
     * @param waxinid
     * @return
     */
    public String addWax(int waxinid) {

        // 从数据库临时表中查询出该id数据
        WaxInTmp waxInTmp = this.waxInTmpService.getById(waxinid);

        // 赋值给新wax插入入库表
        Wax wax = new Wax();
        wax.setPathnum(waxInTmp.getPathnum());
        wax.setImgurl(waxInTmp.getImgurl());
        wax.setLocation(waxInTmp.getLocation());
        wax.setIner("系统管理员");
        wax.setIntime(new Timestamp(System.currentTimeMillis()));
        wax.setState(1);
        int i = this.waxMapper.insertWax(wax);

        // 清除临时表中该id数据
        this.waxInTmpService.delById(waxinid);
        if (i > 0) {
            return "入库成功";
        } else {
            return "入库失败";
        }
    }

}
