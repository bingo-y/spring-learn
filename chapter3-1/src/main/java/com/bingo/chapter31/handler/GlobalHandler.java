package com.bingo.chapter31.handler;

import com.bingo.chapter31.exception.MyException;
import com.bingo.chapter31.model.BaseInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: tyx
 * @Date: create in 2018/6/28 19:04
 * @Description:
 */
@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public BaseInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) {
        BaseInfo<String> baseInfo = new BaseInfo<>();
        baseInfo.setCode(BaseInfo.ERROR);
        baseInfo.setMessage(e.getMessage());
        baseInfo.setUrl(req.getRequestURL().toString());
        baseInfo.setData("spring boot");
        return baseInfo;
    }

}
