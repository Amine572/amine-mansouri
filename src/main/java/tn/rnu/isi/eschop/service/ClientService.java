package tn.rnu.isi.eschop.service;

import java.util.Date;
import java.util.List;

import tn.rnu.isi.model.Client;


 


public interface ClientService {

	public Long save (Client client) throws Exception ;
	
	List<Client> getAll();
 
	Client getByIdClient(Long idClient) throws Exception;
	
	int updateId (Long idClient);
	
	int updateDesigClient(String dateNaissanceClient, String numeroAdrClient, Long idClient);
	

	void deleteClient(Long idClient);

   
}
