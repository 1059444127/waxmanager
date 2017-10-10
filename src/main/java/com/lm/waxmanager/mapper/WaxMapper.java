package com.lm.waxmanager.mapper;

import com.lm.waxmanager.domain.Wax;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WaxMapper {

    @Select("select * from wax")
    List<Wax> queryAll();

    @InsertProvider(type = waxDao.class, method = "addwax")
    int insertWax(Wax wax);

    @Select("select * from wax where waxid = (select max(waxid) from wax)")
    Wax queryLastOne();

    @Select("select * from wax where waxid = #{waxid})")
    Wax queryById(int waxid);

    class waxDao {
        /**
         * 插入wax
         * @param wax
         * @return
         */
        public String addwax(Wax wax) {
            return "insert into wax(pathnum, imgurl, location, state, iner, intime, ouer, outtime, outreason) values('" +
                    wax.getPathnum() + "', '" +
                    wax.getImgurl() + "', '" +
                    wax.getLocation() + "', " +
                    wax.getState() + ", '" +
                    wax.getIner() + "', '" +
                    wax.getIntime() + "', '" +
                    wax.getOuer() + "', " +
                    wax.getOuttime() + ", '" +
                    wax.getOutreason() +
                    "')";
        }
    }


}
