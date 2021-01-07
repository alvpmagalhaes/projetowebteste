package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.SalasDeTeatroDAO;
import br.ufscar.dc.dsw.domain.SalasDeTeatro;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/promocoes/*")
public class PromoController extends HttpServlet {

    private static final long serialVersionUID = 1L; 
   // private LivroDAO dao;
    private SalasDeTeatroDAO dao;

    @Override
    public void init() {
        dao = new SalasDeTeatroDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {           
        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }
        
        try {
        	 lista(request, response);
        }

    catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SalasDeTeatro> listapromos = dao.getAll();
        request.setAttribute("listapromos", listapromos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/promo/lista.jsp");
        dispatcher.forward(request, response);
    }

}