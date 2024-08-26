package com.works.overview.configs;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import com.works.overview.entities.Customer;
import com.works.overview.entities.Info;
import com.works.overview.repositories.InfoRepository;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class GlobalFilter implements Filter {

    final InfoRepository infoRepository;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("Server UP");
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) arg0;
        HttpServletResponse res = (HttpServletResponse) arg1;

        // info
        String url = req.getRequestURI();
        String email = "";
        Object userSession = req.getSession().getAttribute("user");
        if (userSession != null) {
            Customer customer = (Customer) userSession;
            email = customer.getEmail();
        }
        String time = ""+ System.currentTimeMillis();
        String ip = req.getHeader("X-FORWARDED-FOR");  
        if (ip == null) {  
            ip = req.getRemoteAddr();  
        }
        String sessionid = req.getSession().getId();
        String useragent = req.getHeader("user-agent");

        Info i = new Info();
        i.setEmail(email);
        i.setIp(ip);
        i.setSessionid(sessionid);
        i.setTime(time);
        i.setUrl(url);
        i.setUseragent(useragent);
        infoRepository.save(i);


        String[] freeUrls = {"/customer/", "/info/"};
        boolean loginStatus = true;
        for (String item : freeUrls) {
            if (url.contains(item)) {
                loginStatus = false;
                break;
            }
        }

        if (loginStatus) {
            // session control
            Object userObject = req.getSession().getAttribute("user");
            if (userObject == null) {
                PrintWriter writer = res.getWriter();
                writer.println("{ \"status\": false, \"result\": \"Please Login!\" }");
                res.setStatus(HttpStatus.UNAUTHORIZED.value());
                res.setContentType("application/json");
            }else {
                arg2.doFilter(req, res);
            }
        }else {
            arg2.doFilter(req, res);
        }
        
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
            System.out.println("Server DOWN");
        }
    }
    
}
