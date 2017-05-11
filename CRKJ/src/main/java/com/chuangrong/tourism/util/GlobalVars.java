package com.chuangrong.tourism.util;

/**
 * Created by DELL on 2017/5/8.
 */

public class GlobalVars {
    /**
     * 全局变量单例
     */
    private static GlobalVars vars = null;
    //http://192.168.1.181:8080/api/allScenicSpot
    public String baseUrl = "http://192.168.1.181:8080/";


    private GlobalVars() {

    }

    /**
     * 获取全局变量类实例
     *
     * @return GlobalVars
     */
    public synchronized static GlobalVars getVars() {
        if (vars == null) {
            vars = new GlobalVars();
        }
        return vars;
    }
}
