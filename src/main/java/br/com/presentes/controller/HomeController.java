package br.com.presentes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.presentes.Utils.Constants;
import springfox.documentation.annotations.ApiIgnore;



@ApiIgnore
@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/")
	public String Index() {
		return Constants.INDEX_VIEW;
	}

}
