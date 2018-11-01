package br.com.zonework.candidatedevs.candidate.application.endpoint;

import br.com.zonework.candidatedevs.structure.Render;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/candidate/dashboard")
public class DashboardCandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Render.view(req, resp, "/candidate/dashboard");
    }
}
