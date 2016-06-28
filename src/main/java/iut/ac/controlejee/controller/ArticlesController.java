package iut.ac.controlejee.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import iut.ac.controlejee.bean.Article;
import iut.ac.controlejee.bean.Commande;
import iut.ac.controlejee.bean.ListeArticles;
import iut.ac.controlejee.common.Const;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/articles")
public class ArticlesController {

		private List<Article> articles;
		
		public ArticlesController(){
			articles = ListeArticles.getList();
		}
		
		@RequestMapping(value="/", method = RequestMethod.GET)
		public String getAllArticles(ModelMap model){
			model.addAttribute("articles", this.articles);
			return "articles";
		}
		
		@RequestMapping(value="/add/{id}", method = RequestMethod.GET)
		public String addArticle(ModelMap model, @PathVariable("id") String id, HttpServletRequest request){
			HttpSession session = request.getSession(false);
			Commande command = (session.getAttribute(Const.COMMANDE) != null)?(Commande)session.getAttribute(Const.COMMANDE):new Commande(); 
			Article article = ListeArticles.chercherArticle((LinkedList) articles, id);
			if(article != null){
				command.commanderArticle(article);
				model.addAttribute(Const.MESSAGE, "L'objet a bien été ajouté à la commande en cours.");
			} else {
				model.addAttribute(Const.MESSAGE, "erreur lors de la commande: Article non trouvé");
			}
			session.setAttribute(Const.COMMANDE, command);
			model.addAttribute("articles", this.articles);
			return "articles";
		}
}
