package com.lcw.base.bean;

public class Result {

    public static String SUCCESS = "0";
    public static String ERROR = "-1";
    public static String VALID_ERROR = "1000";
    public static String RE_LOGIN = "999";

    private static final ResponseMessage RESPONSE_MESSAGE_SUCCESS = new ResponseMessage(SUCCESS, "");

    public static ResponseMessage success() {
        return RESPONSE_MESSAGE_SUCCESS;
    }

    public static <T> ResponseMessage<T> success(T t) {
        return new ResponseMessage(SUCCESS, "", t);
    }

    public static ResponseMessage error() {
        return error("");
    }

    public static ResponseMessage error(String message) {
        return error(ERROR, message);
    }

    public static ResponseMessage error(String code, String message) {
        return message(code, message);
    }

    public static <T> ResponseMessage error(String code, String message, T t) {
        return message(code, message, t);
    }
    public static ResponseMessage message(String code, String message) {
        return message(code, message, null);
    }

    public static <T> ResponseMessage<T> message(String code, String message, T t) {
        return new ResponseMessage(code, message, t);
    }
}
