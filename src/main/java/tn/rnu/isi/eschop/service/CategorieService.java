package tn.rnu.isi.eschop.service;

import java.util.List;

import tn.rnu.isi.eschop.model.Categorie;

 


public interface CategorieService {

	public Long save (Categorie categorie) throws Exception ;
	
	List<Categorie> getAll();
 
	Categorie getByIdCateg(Long idCateg) throws Exception;
	
	int updateId (Long idCateg);
	
  	int updateDesig (String codeCateg, String libelleCateg, Long idCateg); 
  	
  	void deleteCategorie(Long idCateg);
  	
   
}
