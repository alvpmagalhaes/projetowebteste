package br.ufscar.dc.dsw.controller;
import br.ufscar.dc.dsw.dao.PromoDAO;
import br.ufscar.dc.dsw.domain.Promo;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cadastropromos/*")
public class PromoController extends HttpServlet {

	private static final long serialVersionUID = 1L; 
    private PromoDAO dao;
	
    @Override
    public void init() {
        dao = new PromoDAO();
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
               switch (action) {         
                       insere(request, response);
                       break;
                   default:
                       lista(request, response);
                       break;
               }
           } catch (RuntimeException | IOException | ServletException e) {
               throw new ServletException(e);
           }
    	
    	
    }
    
    
    
    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Promo> listaPromos = dao.getAll();
        request.setAttribute("listapromos", listaPromos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promo/lista.jsp");
        dispatcher.forward(request, response);
    }
    
   
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String cnpj = request.getParameter("cnpj");
        String nomePeca = request.getParameter("nomePeca");
        String endereco = request.getParameter("endereco");
        String preco = request.getParameter("preco");
        
        
        Promo promo = new Promo(cnpj, nomePeca, endereco, preco);
        dao.insert(promo);
        response.sendRedirect("lista");
    }
}
