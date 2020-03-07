package edu.infnet.patrimonio.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.infnet.patrimonio.negocio.MysqlConection;
import edu.infnet.patrimonio.negocio.dao.PatrimonioDAO;
import edu.infnet.patrimonio.negocio.dao.PatrimonioJPADao;
import edu.infnet.patrimonio.negocio.modelo.Patrimonio;
import edu.infnet.patrimonio.negocio.servico.PatrimonioService;

@WebServlet(urlPatterns = { "/PatrSrv" })
public class PatrimonioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String id = null;
	private String descricao;
	private String localizacao;
	private String action;
	private PatrimonioService service;
	private PatrimonioDAO patrimonioDAO;
	private PatrimonioJPADao dao; 

	public PatrimonioServlet() {
		super();
		dao = new PatrimonioJPADao();
		patrimonioDAO =  new PatrimonioDAO();
		service = new PatrimonioService();
	}
	
	private void initVariaveis(HttpServletRequest request) {
		id = request.getParameter("id");
		descricao = request.getParameter("descricao");
		localizacao = request.getParameter("localizacao");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("teste1");
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("teste2");
		
		action = request.getParameter("action");
		try {
			if ("new".equals(action)) {
				initVariaveis(request);
				if(id.equals(null))
					salvarUmNovoPatrimonio(request);
				else {
					int idInteger = Integer.parseInt(id);
					Patrimonio patrimonio = new Patrimonio();
					patrimonio.setId(idInteger);
					patrimonio.setDescricao(descricao);
					patrimonio.setLocalizacao(localizacao);
					patrimonioDAO.alterar(patrimonio);
					listaPatrimonio(request, response);
				}
			}
			if ("alterar".equals(action)) {
				initVariaveis(request);
				alterarPatrimonio(request, response);
			}
			if ("deletar".equals(action)) {
				initVariaveis(request);
				deletarPatrimonio(request, response);
			}
			if ("lista".equals(action)) {
				listaPatrimonio(request,response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Erro no no banco de dados!");
		} 

	}
	
	private void salvarUmNovoPatrimonio(HttpServletRequest request) {
		if (service.validarpatrimonio(descricao, localizacao)) {
			
			int idInteger = -1;
			if(!id.equals("")) {
				idInteger = Integer.parseInt(id);
			}
			
			Patrimonio patrimonio = new Patrimonio(idInteger, descricao, localizacao);
			service.save(patrimonio);
			request.setAttribute("Sucesso", "Salvo com sucesso!");
		} else {
			request.setAttribute("error", "descricao ou localizacao inválidos!");
		}
	}
	
	private void alterarPatrimonio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("id", id);
		request.setAttribute("descricao", descricao);
		request.setAttribute("localizacao", localizacao);
		request.getRequestDispatcher("pages/patrimonio.jsp").forward(request, response);
		
	}

	private void deletarPatrimonio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int inInteger = Integer.parseInt(id);
		//Patrimonio patrimonio = new Patrimonio(inInteger);
		patrimonioDAO.delete(id);
		listaPatrimonio(request, response);
		
	}
	private void listaPatrimonio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Patrimonio> patrimonios = patrimonioDAO.findAllProdutos();
		request.setAttribute("lista_patrimonios", patrimonios);
		request.getRequestDispatcher("pages/home.jsp").forward(request, response);
		
	}

}
