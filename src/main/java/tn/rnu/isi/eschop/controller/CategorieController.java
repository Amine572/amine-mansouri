package tn.rnu.isi.eschop.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tn.rnu.isi.eschop.model.Categorie;
import tn.rnu.isi.eschop.service.CategorieService;


 
@Controller("categorieController")
public class CategorieController {
	
	private final Logger logger = LoggerFactory.getLogger(CategorieController.class);

 
	@Autowired
	CategorieService categorieService;
 

@RequestMapping(value = "/categorie/listAll", method = RequestMethod.GET)

	protected ModelAndView showAllCategories() throws Exception {
		/*
		 * Lancement du Service et recupeation donnees en base
		 */
		List<Categorie> listeCategories = categorieService.getAll();

		/*
		 * Envoi Vue + Modele MVC pour Affichage donnees vue
		 */
		return new ModelAndView("categorie/showAllCategories", "categories", listeCategories);
	}

	 	@RequestMapping(value = "/categorie/list", method = RequestMethod.GET)
	    public String list(Model model) throws Exception {
	        model.addAttribute("categories", categorieService.getAll());
	        return "categorie/showAllCategories"; // Afficher la page showAllCategories.html qui se trouve sous /categorie
	        
	    }

	    @RequestMapping(value = "/categorie/get/{id}" , method = RequestMethod.GET)
	    public String get(@PathVariable Long id, Model model) throws Exception {
	        model.addAttribute("categorieToShow", categorieService.getByIdCateg(id));
	        return "categorie/showCategorie"; // Afficher la page showCategorie.html qui se trouve sous /categorie
	    }
	    
	    
	    @RequestMapping(value = "/categorie/save", method = RequestMethod.POST)
	    public String saveOrUpdate(@ModelAttribute("categorieForm") Categorie categorie, Model model, final RedirectAttributes redirectAttributes) throws Exception {
	    	try {
				
			
			Long idCateg = categorieService.save(categorie);

	    	
	    	if(  categorie.getIdCateg()!=null){
				redirectAttributes.addFlashAttribute("typeAlert", "info");
		    	redirectAttributes.addFlashAttribute("msgAlert", "Categorie dont ID : "+categorie.getIdCateg()+" a été mise à jour.");

			}else{
				redirectAttributes.addFlashAttribute("typeAlert", "success");
		    	redirectAttributes.addFlashAttribute("msgAlert", "Nouvelle Categorie a été enregsitrée avec ID : "+idCateg);
			}
	    	
	    	} catch (Exception e) {
				e.printStackTrace();
			}
	        return "redirect:/categorie/listAll";
	    }
	    

 
	    @RequestMapping("/categorie/update/{id}")
	    public String update(@PathVariable Long id, Model model, final RedirectAttributes redirectAttributes) throws Exception {
	        Categorie categorie = categorieService.getByIdCateg(id);
	        model.addAttribute("categorieForm", categorie);
	        return "categorie/addUpdateCategorie";
	    }
	    
	    @RequestMapping(value = "/categorie/delete/{id}")
	    public String delete(@PathVariable Long id) throws Exception {
	        categorieService.deleteCategorie(id);
	        return "redirect:/categorie/listAll";
	    }
 
}
