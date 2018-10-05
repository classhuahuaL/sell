package com.lhhclazz.sell.VO;

import lombok.Data;

/**
 * http请求响应vo最外层对象
 */
@Data
public class ResultVO <T> {

    /** 错误码 */
    private Integer code;

    /** 响应消息 */
    private String msg;

    /** 响应的数据 */
    private T data;
}
