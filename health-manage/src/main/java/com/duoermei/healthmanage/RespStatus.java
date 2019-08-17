package com.duoermei.healthmanage;


import com.alibaba.fastjson.JSONObject;

/**
 * @Description: 返回对象
 * @Author GoldFu
 * @Date 2019/5/30
 * @Version V1.0
 **/
public class RespStatus {
    /**
     * 成功
     *
     * @param object
     * @return
     */
    public static JSONObject success(Object object) {
        JSONObject obj = new JSONObject();
        obj.fluentPut("code", "10000");
        obj.fluentPut("msg", "操作成功");
        obj.fluentPut("data", object);
        return obj;
    }
    public static JSONObject success() {
        JSONObject obj = new JSONObject();
        obj.fluentPut("code", "10000");
        obj.fluentPut("msg", "操作成功");
        return obj;
    }

    /**
     * 失败
     *
     * @param msg
     * @return
     */
    public static JSONObject fail(String msg) {
        JSONObject obj = new JSONObject();
        obj.fluentPut("code", "10001");
        obj.fluentPut("msg", msg);
        return obj;
    }

    /**
     * 异常
     *
     * @param exception
     * @return
     */
    public static JSONObject exception(Exception exception) {
        JSONObject obj = new JSONObject();
        obj.fluentPut("code", "10002");
        obj.fluentPut("msg", "操作异常" + exception);
        return obj;
    }


}
