package com.demo.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author 
 * @date 2016/9/19 14:52
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession sess =  request.getSession();
//        Manager manager = (Manager) sess.getAttribute("managerInfo");
//        String uri = request.getRequestURI();
//        String url = request.getRequestURL().toString();
//        System.out.println(url);
//        System.out.println(uri);
//        if (CommonUtil.checkURI(uri)){
//            return true;
//        }else {
//            if(manager == null){
//               throw  new LoginException("LOGINTIMEOUTORNOT");
//            }else {
//                System.out.println("已登录："+ manager.getManagername());
//                return true;
//            }
//        }
		return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
