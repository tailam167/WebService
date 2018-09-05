package com.fsoft.intern.courseplan;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class ApiResponseBuider {

    private static final AbstractMap.SimpleEntry<String, Object> CODE
            = new AbstractMap.SimpleEntry<>("code", 0);
    private static final AbstractMap.SimpleEntry<String, Object> MESSAGE
            = new AbstractMap.SimpleEntry<>("message", "");
    private static final AbstractMap.SimpleEntry<String, Object> DATA
            = new AbstractMap.SimpleEntry<>("data", null);
    private static int ERROR_CODE = -1;
    private static int SUCCESS_CODE = 0;
    private static int DATA_CODE = 1;

    public static HashMap<String, Object> buildError(String message) {
        return build(ERROR_CODE, message, null);
    }

    public static HashMap<String, Object> buildSuccess(String message) {
        return build(SUCCESS_CODE, message, null);
    }

    public static HashMap<String, Object> buildSuccess(String message, Object data) {
        return build(SUCCESS_CODE, message, data);
    }

    public static HashMap<String, Object> buildContainsData(String message, Object data) {
        return build(DATA_CODE, message, data);
    }

    private static HashMap<String, Object> build(int code, String message, Object data) {
        CODE.setValue(code);
        MESSAGE.setValue(message);
        DATA.setValue(data);
        HashMap<String, Object> res = new HashMap<>();
        res.put(CODE.getKey(), CODE.getValue());
        res.put(MESSAGE.getKey(), MESSAGE.getValue());
        res.put(DATA.getKey(), DATA.getValue());
        return res;
    }
}
