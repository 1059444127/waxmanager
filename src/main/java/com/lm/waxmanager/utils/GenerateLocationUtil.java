package com.lm.waxmanager.utils;

import com.lm.waxmanager.domain.Wax;

/**
 * 生成位置编号
     几号柜  B00
     几层	F00
     几列	C00
     第几个	N00
     补位    A00
 */
public class GenerateLocationUtil {

    /**
     * 生成编号
     * @return
     */
    public String getLocation(Wax lastOne) {
        // 获取最后一个wax的location
        String lastOneLocation = lastOne.getLocation();
        // 获取柜BOX
        String b = lastOneLocation.substring(getIndex(lastOneLocation, "B") , getIndex(lastOneLocation, "B") + 2);
        // 获取层Float
        String f = lastOneLocation.substring(getIndex(lastOneLocation, "F") , getIndex(lastOneLocation, "F") + 2);
        // 获取柜COLUMN
        String c = lastOneLocation.substring(getIndex(lastOneLocation, "C") , getIndex(lastOneLocation, "C") + 2);
        // 获取柜NUMBER
        String n = lastOneLocation.substring(getIndex(lastOneLocation, "N") , getIndex(lastOneLocation, "N") + 2);

        // n+1
        int iN = Integer.parseInt(n) + 1;
        if (iN > 3) {
            int iC = Integer.parseInt(c) + 1;
            iN = 1;
            // 自动补足2位整数
            if (iC > 3) {
                int iF = Integer.parseInt(f) + 1;
                iC = 1;
                if (iF > 3) {
                    int iB = Integer.parseInt(b) + 1;
                    iF = 1;
                    if (iB > 3) {
                        return null;
                    }
                    b = String.format("%02d", iB);
                }
                f = String.format("%02d", iF);
            }
            c = String.format("%02d", iC);
        }
        n = String.format("%02d", iN);
        return "B" + b + "F" + f + "C" + c + "N" + n;
    }

    /**
     * 根据key获取其在location中的index
     * @param key
     * @return
     */
    public int getIndex(String location, String key) {
        return location.indexOf(key) + 1;
    }

}
