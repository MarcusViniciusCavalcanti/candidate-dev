package br.com.zonework.candidatedevs.security.application.endpoint;

import br.com.zonework.candidatedevs.security.application.service.SecurityService;
import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import br.com.zonework.candidatedevs.structure.Render;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

import static br.com.zonework.candidatedevs.structure.utils.Constants.PASSWORD;
import static br.com.zonework.candidatedevs.structure.utils.Constants.USERNAME;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Render.view(req, resp, "security/form-login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String password = req.getParameter(PASSWORD.asString());
            String username = req.getParameter(USERNAME.asString());

            Principal userPrincipal = req.getUserPrincipal();

            if (userPrincipal == null) {
                req.logout();
            }

            req.login(username, password);

            SecurityService securityService = new SecurityService();
            Credential credential = securityService.getCredentialWith(username);
            HttpSession session = req.getSession();

            if (session.isNew()) {
                session.setAttribute("credentials", credential);
                req.getRequestDispatcher("/dashboard").forward(req, resp);
            }
        } catch (ServletException | LoginException e) {
            req.setAttribute("loginFailure", "Usuário ou senha não corresponde");
            doGet(req, resp);
        }

    }
}
