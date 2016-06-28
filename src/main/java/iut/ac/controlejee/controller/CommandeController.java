package iut.ac.controlejee.controller;

import iut.ac.controlejee.bean.Commande;
import iut.ac.controlejee.common.Const;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/commandes")
public class CommandeController {
	
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String getAllCommande(ModelMap model, HttpServletRequest request){
		HttpSession session = request.getSession(false);
		Commande commande = (Commande) session.getAttribute(Const.COMMANDE);
		boolean hasCommand = false;
		if(commande != null){
			model.addAttribute("articles", commande.getListe());
			hasCommand = commande.getNbArticles() > 0;
		}
		if(!hasCommand){
			model.addAttribute(Const.MESSAGE, "Pas de commande en cours");
		}
		model.addAttribute("hasCommand", hasCommand);
		System.out.println(hasCommand);
		return "commandes";
	}
	
	@RequestMapping("/destroy")
	public String destroyCommand(HttpServletRequest request, ModelMap model){
		HttpSession session = request.getSession(false);
		session.setAttribute(Const.COMMANDE, new Commande());
		return "redirect:/commandes/";
	}
}
