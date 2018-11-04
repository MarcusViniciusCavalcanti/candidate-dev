package br.com.zonework.candidatedevs.security.application.filter;

import br.com.zonework.candidatedevs.security.application.service.SecurityService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@WebFilter(urlPatterns = "/login")
public class SecurityCredentialsFilter implements Filter {
    private SecurityService service;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.service = new SecurityService();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        HttpServletRequest req = (HttpServletRequest) request;

        boolean isCandidate = req.isUserInRole("candidate");
        if (isCandidate) {
            ((HttpServletResponse)response).sendRedirect("/protected/candidate/dashboard");
            return;
        }

        boolean isAdmin = req.isUserInRole("admin");

        if (isAdmin) {
            ((HttpServletResponse)response).sendRedirect("/protected/members/dashboard");
            return;
        }

    }

    @Override
    public void destroy() {
        service = null;
    }
}
