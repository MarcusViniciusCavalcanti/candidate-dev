package br.com.zonework.candidatedevs.structure.erros;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error-handler")
public class HandlerErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Throwable throwable = (Throwable)
                req.getAttribute("javax.servlet.error.exception");

        Integer statusCode = (Integer)
                req.getAttribute("javax.servlet.error.status_code");

        Class exceptionType = (Class)req.getAttribute("javax.servlet.error.exception_type");

        String servletName = (String)
                req.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null){
            servletName = "Unknown";
        }

        String requestUri = (String)
                req.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null){
            requestUri = "Unknown";
        }


        if (throwable == null && statusCode == null) {
            req.setAttribute("title_error", "Error desconhecido");
            req.setAttribute("message_error", "Não há informação sobre o erro");
            req.setAttribute("status", "desconhecido");
            resp.sendRedirect("/WEB-INF/views/errors/generic-errors.jsp");
        }
    }
}
