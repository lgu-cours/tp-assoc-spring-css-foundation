package iut.ac.controlejee.controller;


import iut.ac.controlejee.bean.Adherent;
import iut.ac.controlejee.bean.ListeAdherents;
import iut.ac.controlejee.bean.ListePays;
import iut.ac.controlejee.common.Const;
import iut.ac.controlejee.utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class AdherentController {
	private LinkedList<Adherent> listeAdherents;
	
	public AdherentController(){
		this.listeAdherents = ListeAdherents.getList();
	}
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String connection(ModelMap model, HttpServletRequest request){
		boolean connected = false;
		
		String page = "login";
		for(Adherent adherentFromList: this.listeAdherents){
			String ident = (adherentFromList.getIdent() == null)?adherentFromList.getNom():adherentFromList.getIdent();
			System.out.println(request.getParameter("ident"));
			if(request.getParameter("ident").equals(ident)){
				String pass = (adherentFromList.getMotpasse() != null)? adherentFromList.getMotpasse() : "OK";
				connected =  request.getParameter("pass").equals(pass) ;	
				if(connected){
					page = "redirect:/";
					HttpSession session = request.getSession();
					session.setAttribute(Const.ADHERENT, adherentFromList);
				}
				break;
			}
		}
		if(!connected){
			model.addAttribute(Const.MESSAGE, "Adherent non trouvé ou mot de passe incorrect");
		}
		return page;
	}
	
	@RequestMapping(value="/compte", method= RequestMethod.GET)
	public String compteForm(ModelMap model){
		model.addAttribute(Const.LISTE_PAYS, ListePays.getList());
		return "creercompte";
	}
	
	@RequestMapping(value="/compte", method= RequestMethod.POST)
	public String creerCompte(HttpServletRequest request, ModelMap model){
		//Map<String, String[]> params = request.getParameterMap();
		//Set<String> keys = params.keySet();
		Adherent adherent = new Adherent(null, null, null, 0, null, null);
//		if(params.get("motpasse")[0].equals(params.get("motpasseconfirm")[0])){			
//			for(String key: keys){
//				try {
//					if(!key.equals("motpasseconfirm")){
//						Class<?> fieldClass = Utils.getFieldClass(adherent.getClass().getDeclaredField(key));
//						Method m = Utils.getSet(adherent, key, fieldClass);
//						m.invoke(adherent, Utils.parseValue(params.get(key)[0], fieldClass));
//					}
//				} catch (NoSuchMethodException | SecurityException
//						| InstantiationException | IllegalAccessException
//						| IllegalArgumentException | InvocationTargetException
//						| ClassNotFoundException | NoSuchFieldException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
		String motpasse = request.getParameter("motpasse");
		String motpasseconfirm = request.getParameter("motpasseconfirm");
		if ( motpasse != null && motpasseconfirm != null && motpasse.equals(motpasseconfirm) ) {
			adherent.setIdent(request.getParameter("nom"));
			adherent.setMotpasse(motpasse);

			adherent.setNom(request.getParameter("nom"));
			adherent.setPrenom(request.getParameter("prenom"));
			// etc
			listeAdherents.add(adherent);
			
			
		} else{
			model.addAttribute(Const.MESSAGE, "Mots de passes non egaux");
		}
		model.addAttribute(Const.LISTE_PAYS, ListePays.getList());
		return "creercompte";
	}
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		session.invalidate();
		request.setAttribute(Const.MESSAGE, "Vous avez été déconnecté !");
		return "redirect:/";
	}
}
