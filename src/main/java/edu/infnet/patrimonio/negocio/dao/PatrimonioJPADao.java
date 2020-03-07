package edu.infnet.patrimonio.negocio.dao;

import edu.infnet.patrimonio.negocio.modelo.Patrimonio;

public class PatrimonioJPADao extends JpaDAO<Patrimonio, Integer> {

	public PatrimonioJPADao() {
		super(Patrimonio.class);
	}

}
