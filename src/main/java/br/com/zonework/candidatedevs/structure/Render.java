package br.com.zonework.candidatedevs.structure;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class Render {
    private static final String address = "/WEB-INF/views/";

    public static void view(HttpServletRequest request, HttpServletResponse response, String view) {
        try {
            view = view.endsWith(".jsp") ? view : view + ".jsp";
            request.getRequestDispatcher(address + view).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
