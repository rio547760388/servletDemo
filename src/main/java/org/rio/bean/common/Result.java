package org.rio.bean.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Mloong
 * @version 0.0.1
 * <p></p>
 * @since 2020/8/5
 **/
@Data
public final class Result<T> implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 时间戳
     */
    private long timestamp;

    /**
     * 状态
     */
    private int status;

    /**
     * 描述
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 请求处理成功
     * 适用于无返回值的情况
     *
     * @return Result
     */
    public static Result succ() {
        return succ("", "");
    }

    /**
     * 请求处理成功
     * 适用于无返回值的情况
     *
     * @return Result
     */
    public static <T> Result<T> succ(T data) {
        return succ(data, "");
    }

    /**
     * 请求处理成功
     *
     * @param data 待返回的对象
     * @return Result
     */
    public static <T> Result<T> succ(T data, String path) {
        Result<T> result = new Result<>();
        setTime(result);
        result.setStatus(200);
        result.setMessage("请求处理成功");
        result.setData(data);
        return result;
    }

    /**
     * 请求处理失败
     *
     * @param status 状态码
     * @return
     */
    public static <T> Result<T> error(int status) {
        return error(status, "");
    }

    /**
     * 请求处理失败
     *
     * @param status 状态码
     * @param data   待返回的对象
     * @return
     */
    public static <T> Result<T> error(int status, T data) {
        return error(status, "", data);
    }

    /**
     * 请求处理失败
     *
     * @param status   状态码
     * @param describe 描述
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(int status, String describe) {
        return error(status, describe, null);
    }

    /**
     * 请求处理失败
     *
     * @param status   状态码
     * @param describe 描述
     * @param data     待返回的对象
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(int status, String describe, T data) {
        Result<T> result = new Result<>();
        setTime(result);
        result.setStatus(status);
        result.setMessage(describe);
        result.setData(data);
        return result;
    }

    /**
     * 服务异常
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> serverError() {
        return serverError("");
    }

    /**
     * 服务异常
     *
     * @param describe 描述说明
     * @param <T>
     * @return
     */
    public static <T> Result<T> serverError(String describe) {
        return error(500, describe);
    }

    private static void setTime(Result rs) {
        rs.setTimestamp(System.currentTimeMillis());
    }

}
