package org.woehlke.greenshop.oodm.cart;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.woehlke.greenshop.oodm.cart.model.TransientBasket;
import org.woehlke.greenshop.oodm.catalog.entities.Language;

public interface CartService {

	TransientBasket addProductToCart(TransientBasket transientBasket,
			long productId, Map<Long, Long> optionsAndValues,Language language);

	TransientBasket removeProductFromCart(TransientBasket transientBasket,
			long productId, Map<Long, Long> optionsAndValues, Language language);

	void update(int[] cartQuantity, TransientBasket transientBasket);

	TransientBasket polulateByPersistentBasket(TransientBasket transientBasket,Language language,Authentication auth);

}
