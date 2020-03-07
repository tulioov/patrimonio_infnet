package edu.infnet.patrimonio.negocio.servico;

import edu.infnet.patrimonio.negocio.dao.PatrimonioDAO;
import edu.infnet.patrimonio.negocio.modelo.Patrimonio;

public class PatrimonioService {
	
	private PatrimonioDAO dao;
	
	public PatrimonioService() {
		dao = new PatrimonioDAO();
	}
	
	public Boolean validarpatrimonio(String descricao, String localizacao) {
		
		if(!"".equals(descricao) && !"".equals(localizacao)) {
			return true;
		}
		
		return false;
	}

	public void save(Patrimonio patrimonio) {
		dao.save(patrimonio);
	}
	

}
