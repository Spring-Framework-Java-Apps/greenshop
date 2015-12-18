package org.woehlke.greenshop.oodm.cart;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.woehlke.greenshop.oodm.cart.model.TransientBasket;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.service.LanguageService;


@Named("populateBasketAfterLogin") 
public class PopulateBasketAfterLogin extends
		SavedRequestAwareAuthenticationSuccessHandler {
	
	@Inject
	private CartService cartService;

    @Inject
    private LanguageService languageService;
	
	@Override
    public void onAuthenticationSuccess(
    		HttpServletRequest request, 
    		HttpServletResponse response, 
    		Authentication authentication) throws ServletException, IOException {
		super.onAuthenticationSuccess(request, response, authentication);
		HttpSession session = request.getSession();
		TransientBasket transientBasket = (TransientBasket) session.getAttribute("transientBasket");
		Language language = languageService.findLanguageByCode("en");
		TransientBasket newTransientBasket = cartService.polulateByPersistentBasket(transientBasket,language,authentication);
		session.setAttribute("transientBasket", newTransientBasket);
	}
}
