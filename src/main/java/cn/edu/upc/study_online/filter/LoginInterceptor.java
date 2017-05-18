package cn.edu.upc.study_online.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by songqiaolin on 2017/5/18.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String ,String> user = (Map<String ,String>) request.getSession().getAttribute("user");
        if(user == null || user.get("role") == null || user.get("name") == null) {
            response.sendRedirect("/login");
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
