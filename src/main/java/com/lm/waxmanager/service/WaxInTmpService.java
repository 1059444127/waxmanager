package com.lm.waxmanager.service;

import com.lm.waxmanager.domain.WaxInTmp;
import com.lm.waxmanager.mapper.WaxInTmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaxInTmpService {

    @Autowired
    private WaxInTmpMapper waxInTmpMapper;

    public List<WaxInTmp> getAll() {
        return this.waxInTmpMapper.queryAll();
    }

    public void addWaxIn(WaxInTmp waxInTmp) {
        this.waxInTmpMapper.insertWaxIn(waxInTmp);
    }

    public Integer deleteAllWaxInTmp() {
        return this.waxInTmpMapper.deleteAll();
    }

    public WaxInTmp getById(int id) {
        return this.waxInTmpMapper.queryByid(id);
    }

    public Integer delById(int id) {
        return this.waxInTmpMapper.delById(id);
    }
}
