package org.woehlke.greenshop.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"transientBasket"})
public class LoginController extends AbstractController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	 public String showLoginForm(Model model){
		super.getDefaultBoxContent(model);
		return "login";
	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String showAdminLoginForm(Model model){
		return "admin/login";
	}
}
