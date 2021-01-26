package tn.rnu.isi.eschop.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.rnu.isi.eschop.model.Produit;
import tn.rnu.isi.eschop.service.ProduitService;
import tn.rnu.isi.eschop.model.Commande;
import tn.rnu.isi.eschop.service.CommandeService;

import tn.rnu.isi.eschop.model.Client;
import tn.rnu.isi.eschop.service.ClientService;

import tn.rnu.isi.eschop.model.Categorie;
import tn.rnu.isi.eschop.service.CategorieService;


 


 
 
@Controller 
@RequestMapping("/") //make all URL's through this controller relative to /index
public class IndexController {
	
	private final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	ProduitService produitService;
	CommandeService commandeService;
	ClientService clientService;
	CategorieService categorieService;
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String index(Map<String, Object> model) throws Exception {
	 
    return "index";
	}   
	
 
	/**************************************
	 * Gestion produit
	 * **Nouvelle : /produit/new
     * **Rechercher : /produit/search
     * **Liser Tous : /produit/listAll
	 ***************************************/	
	 
	// show new Produit form
		@RequestMapping(value = "/produit/new", method = RequestMethod.GET)
		public String showNewProduit(Model model) {

			logger.debug(":::showNewProduit:::");

			Produit produit = new Produit();
			
			model.addAttribute("produitForm", produit);

	 
			 return "produit/addUpdateProduit";// C'est le nom de la page JSP à rediriger (newProduit.jsp)

		}
		
	
				
	 // show list of All Produit
		@RequestMapping({"/produit/listAll","produitList"})
		protected ModelAndView lisAllProduits(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			/*
			 * Lancement du Service et récupération données en base
			 */
			List<Produit> listeProduits = produitService.getAll();

			/*
			 * Envoi Vue + Modèle MVC pour Affichage données vue
			 */
			return new ModelAndView("produit/showAllProduits", "produits", listeProduits);
		} 

		// show new Commande form
		@RequestMapping(value = "/commande/new", method = RequestMethod.GET)
		public String showNewCommande(Model model) {

			logger.debug(":::showNewCommande:::");

			Commande commande = new Commande();
			
			model.addAttribute("commandeForm", commande);

	 
			 return "commande/addUpdateCommande";// C'est le nom de la page JSP à rediriger (newCommande.jsp)

		}
		
	
				
	 // show list of All Commande
		@RequestMapping({"/commande/listAll","commandeList"})
		protected ModelAndView lisAllCommandes(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			/*
			 * Lancement du Service et récupération données en base
			 */
			List<Commande> listeCommandes = commandeService.getAll();

			/*
			 * Envoi Vue + Modèle MVC pour Affichage données vue
			 */
			return new ModelAndView("commande/showAllCommandes", "commandes", listeCommandes);
		} 
		// show new Client form
		@RequestMapping(value = "/client/new", method = RequestMethod.GET)
		public String showNewClient(Model model) {

			logger.debug(":::showNewClient:::");

			Client client = new Client();
			
			model.addAttribute("clientForm", client);

	 
			 return "client/addUpdateClient";// C'est le nom de la page JSP à rediriger (newClient.jsp)

		}
		
	
				
	 // show list of All Client
		@RequestMapping({"/client/listAll","clientList"})
		protected ModelAndView lisAllClients(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			/*
			 * Lancement du Service et récupération données en base
			 */
			List<Client> listeClients = clientService.getAll();

			/*
			 * Envoi Vue + Modèle MVC pour Affichage données vue
			 */
			return new ModelAndView("client/showAllClients", "clients", listeClients);
		} 

		// show new Categorie form
		@RequestMapping(value = "/categorie/new", method = RequestMethod.GET)
		public String showNewCategorie(Model model) {

			logger.debug(":::showNewCategorie:::");

			Categorie categorie = new Categorie();
			
			model.addAttribute("categorieForm", categorie);

	 
			 return "categorie/addUpdateCategorie";// C'est le nom de la page JSP à rediriger (newCategorie.jsp)

		}
		
	
				
	 // show list of All Categorie
		@RequestMapping({"/categorie/listAll","categorieList"})
		protected ModelAndView lisAllCategories(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			/*
			 * Lancement du Service et récupération données en base
			 */
			List<Categorie> listeCategories = categorieService.getAll();

			/*
			 * Envoi Vue + Modèle MVC pour Affichage données vue
			 */
			return new ModelAndView("categorie/showAllCategories", "categories", listeCategories);
		} 
	
}

