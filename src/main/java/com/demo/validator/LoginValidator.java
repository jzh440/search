package com.demo.validator;


import com.demo.from.LoginFrom;
import com.demo.util.CommonUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @Author 
 * @date 2016/9/12 15:11
 */
public class LoginValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginFrom.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "userName", null, CommonUtil.getTipMsg("NOTEMPTY", "用户名"));
        ValidationUtils.rejectIfEmpty(errors, "password", null, CommonUtil.getTipMsg("NOTEMPTY", "密码"));
    }
}
