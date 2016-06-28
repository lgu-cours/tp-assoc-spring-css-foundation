package iut.ac.controlejee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpErrorHandlerController {

	@RequestMapping("/404")
	public String error404(){
		return "404";
	}
}
