package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Pais;
import Service.Service;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/Pais.do")
public class PaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		Long pPpopulacao = Long.parseLong(request.getParameter("populacao"));
		Double pArea = Double.parseDouble(request.getParameter("area"));
		
		//instanciar o javabean
		Pais pais = new Pais();
		pais.setNome(pNome);
		pais.setPopulacao(pPpopulacao);
		pais.setArea(pArea);
		
		//instanciar o service
		Service ps = new Service();
		ps.create(pais);
		pais = ps.select(pais);
		
		//enviar o Objeto Pais para JSP
		request.setAttribute("pais", pais);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("Pais.jsp");
		view.forward(request, response);
		
		
	}

}
