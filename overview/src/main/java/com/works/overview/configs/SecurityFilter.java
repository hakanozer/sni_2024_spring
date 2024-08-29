package com.works.overview.configs;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.works.overview.entities.Customer;
import com.works.overview.entities.Info;
import com.works.overview.repositories.InfoRepository;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityFilter implements Filter {

    final InfoRepository infoRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // info
        String url = req.getRequestURI();
        String email = "";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        email = auth.getName();
        String roles = auth.getAuthorities().toString();


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
        i.setRoles(roles);
        infoRepository.save(i);

        chain.doFilter(req, res);
        
    }


    
}
