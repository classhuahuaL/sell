package com.lhhclazz.sell.utils;

import com.lhhclazz.sell.VO.ResultVO;

/**
 *
 */
public class ResultVOUtil {
    /** 操作成功返回参数*/
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    /**
     * 操作成功不需要返回数据
     * @return
     */
    public static ResultVO success(){
        return success(null);
    }
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;
    }

}
