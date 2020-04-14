package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Pais;
import Service.Service;

/**
 * Servlet implementation class PaisController
 */
@WebServlet("/PaisController.do")
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
		

		Pais pais = new Pais();
		pais.setId(0);
		pais.setNome(pNome);
		pais.setPopulacao(pPpopulacao);
		pais.setArea(pArea);
		
		Service ps = new Service();
		ps.criar(pais);
		pais = ps.select(pais);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Pais Cadastrado</title></head><body>");
		out.println(	"id: "+pais.getId()+"<br>");
		out.println(	"nome: "+pais.getNome()+"<br>");
		out.println(	"populacao: "+pais.getPopulacao()+"<br>");
		out.println(	"area: "+pais.getArea()+"<br>");
	    out.println("</body></html>");
		
	}

}