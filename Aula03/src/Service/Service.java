package Service;

import Model.Pais;
import DAO.DAO;


public class Service {
	DAO dao = new DAO();
	
	public void criar(Pais pais) {
		System.out.println("deu certo a criação");
		//return dao.criar(pais);
	}
	
	public void update(Pais pais){
		dao.update(pais);
	}
	
	public void delete(Pais pais){
		dao.delete(pais);
	}
	
	public Pais select(Pais pais){
		return dao.select(pais);
	}

}