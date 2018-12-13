package com.imooc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by MySelf on 2018/12/12.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

    /** 返回码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;

}
