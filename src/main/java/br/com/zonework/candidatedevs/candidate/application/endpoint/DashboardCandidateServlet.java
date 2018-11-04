package br.com.zonework.candidatedevs.candidate.application.endpoint;

import br.com.zonework.candidatedevs.candidate.application.service.CandidateService;
import br.com.zonework.candidatedevs.candidate.domain.entity.Candidate;
import br.com.zonework.candidatedevs.security.domain.entity.Credential;
import br.com.zonework.candidatedevs.structure.Render;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/protected/candidate/dashboard")
@ServletSecurity(
        @HttpConstraint(
                rolesAllowed = {"admin", "candidate", "reviewer", "creator"},
                transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL
        )
)
@DeclareRoles({"admin", "candidate", "reviewer", "creator"})
public class DashboardCandidateServlet extends HttpServlet {
    private CandidateService service;

    @Override
    public void init() throws ServletException {
        this.service = new CandidateService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Credential credential = (Credential) req.getSession().getAttribute("credentials");
        Candidate candidate = service.getCandidateFromCredentials(credential);
        req.getSession().setAttribute("candidate", candidate);
        Render.view(req, resp, "/candidate/dashboard");
    }

    @Override
    public void destroy() {
        this.service = null;
    }
}
