package org.woehlke.greenshop.oodm.cart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.oodm.cart.entities.CustomersBasket;
import org.woehlke.greenshop.oodm.cart.model.TransientBasket;
import org.woehlke.greenshop.oodm.cart.model.TransientProduct;
import org.woehlke.greenshop.oodm.cart.repository.CustomersBasketAttributeRepository;
import org.woehlke.greenshop.oodm.cart.repository.CustomersBasketRepository;
import org.woehlke.greenshop.oodm.catalog.CatalogService;
import org.woehlke.greenshop.oodm.catalog.entities.Language;
import org.woehlke.greenshop.oodm.catalog.entities.ProductDescription;
import org.woehlke.greenshop.oodm.catalog.entities.ProductOption;
import org.woehlke.greenshop.oodm.catalog.model.ProductAttributes;
import org.woehlke.greenshop.oodm.catalog.model.ProductOptionAttribute;
import org.woehlke.greenshop.oodm.catalog.service.ProductService;
import org.woehlke.greenshop.oodm.customer.CustomerService;
import org.woehlke.greenshop.oodm.customer.entities.Customer;

@Named
@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
public class CartServiceImpl implements CartService {

	@Inject
	private CustomersBasketRepository customersBasketRepository;
	
	@Inject
	private CustomersBasketAttributeRepository customersBasketAttributeRepository;
	
	@Inject
	private CustomerService customerService;
	
	@Inject
	private CatalogService catalogService;

    @Inject
    private ProductService productService;

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public TransientBasket addProductToCart(TransientBasket transientBasket,
			long productId, Map<Long, Long> optionsAndValues, Language language) {
		TransientProduct transientProduct = getTransientProductFactory(productId, optionsAndValues, language);
		transientBasket.addProduct(transientProduct);
		//Check wether the User is logged in:
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null && auth.isAuthenticated()){
			String customerEmail = auth.getName();
			Customer customer = customerService.findCustomerByEmail(customerEmail);
			if(customer!=null){
				String productWithAttributesId=transientProduct.getProductIdWithAttributes();
				CustomersBasket customersBasket = customersBasketRepository.findByCustomerAndProductId(customer,productWithAttributesId);
				if(customersBasket==null){
					customersBasket = new CustomersBasket();
					customersBasket.setCustomer(customer);
					customersBasket.setProductId(productWithAttributesId);
					customersBasket.setQuantity(1);
					Date now = new Date();
					customersBasket.setDateAdded(now);
					customersBasketRepository.save(customersBasket);
				} else {
					customersBasket.setQuantity(customersBasket.getQuantity()+1);
					customersBasketRepository.save(customersBasket);
				}
			}
		}
 		return transientBasket;
	}
	
	private TransientProduct getTransientProductFactory(long productId, Map<Long, Long> optionsAndValues, Language language){
		List<ProductOptionAttribute> productOptionAttributeList = new ArrayList<ProductOptionAttribute>();
		TransientProduct transientProduct = new TransientProduct();
		//fetch Product
		ProductDescription productDescription = productService.findProductById(productId, language);
		transientProduct.setProductDescription(productDescription);
		ProductAttributes productAttributes =catalogService.findProductOptionsByProduct(productDescription);
		Set<Long> options = optionsAndValues.keySet();
		for(ProductOption productOption:productAttributes.getMapProductOptionAttribute().keySet()){
			long option = productOption.getId().longValue();
			Long value = optionsAndValues.get(option);
			if(value==null){
				ProductOptionAttribute productOptionAttribute=productAttributes.getMapProductOptionAttribute().get(productOption).get(0);
				productOptionAttributeList.add(productOptionAttribute);	
			} else if(options.contains(option)){
				for(ProductOptionAttribute productOptionAttribute:productAttributes.getMapProductOptionAttribute().get(productOption)){
					if(value==productOptionAttribute.getProductOptionValue().getId()){
						productOptionAttributeList.add(productOptionAttribute);
					}
				}
			}
		}
		transientProduct.setProductOptionAttributeList(productOptionAttributeList);
		return transientProduct;
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public TransientBasket removeProductFromCart(
			TransientBasket transientBasket, long productId,
			Map<Long, Long> optionsAndValues, Language language) {
		TransientProduct transientProduct = getTransientProductFactory(productId, optionsAndValues, language);
		transientBasket.removeProduct(transientProduct);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null && auth.isAuthenticated()){
			String customerEmail = auth.getName();
			Customer customer = customerService.findCustomerByEmail(customerEmail);
			if(customer!=null){
				String productWithAttributesId=transientProduct.getProductIdWithAttributes();
				CustomersBasket customersBasket = customersBasketRepository.findByCustomerAndProductId(customer,productWithAttributesId);
				if(customersBasket!=null){
					customersBasketRepository.delete(customersBasket);
				}
			}
		}
		return transientBasket;
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void update(int[] cartQuantity, TransientBasket transientBasket) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null && auth.isAuthenticated()){
			String customerEmail = auth.getName();
			Customer customer = customerService.findCustomerByEmail(customerEmail);
			if(customer!=null){
				for(int i=0;i<cartQuantity.length;i++){
					String productWithAttributesId=transientBasket.getTransientProducts().get(i).getProductIdWithAttributes();
					CustomersBasket customersBasket = customersBasketRepository.findByCustomerAndProductId(customer,productWithAttributesId);
					if(cartQuantity[i]==0){
						customersBasketRepository.delete(customersBasket);
					} else {
						customersBasket.setQuantity(cartQuantity[i]);
						customersBasketRepository.save(customersBasket);
					}
				}
			}
		}
		transientBasket.update(cartQuantity);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public TransientBasket polulateByPersistentBasket(TransientBasket transientBasket,Language language,Authentication auth) {
		if(auth!=null && auth.isAuthenticated()){
			String customerEmail = auth.getName();
			Customer customer = customerService.findCustomerByEmail(customerEmail);
			if(customer!=null){
				List<CustomersBasket> customersBaskets = customersBasketRepository.findByCustomer(customer);
				TransientBasket newTransientBasket = new TransientBasket();
				for(CustomersBasket customersBasket:customersBaskets){
					long productId = customersBasket.getProductIdAsLong();
					int quantity = customersBasket.getQuantity();
					Map<Long,Long> optionsAndValues = customersBasket.getOptionsAndValues();
					TransientProduct transientProduct = this.getTransientProductFactory(productId, optionsAndValues, language);
					newTransientBasket.getTransientProducts().add(transientProduct);
					newTransientBasket.getNumberOfProducts().put(transientProduct, quantity);
				}
				for(TransientProduct transientProduct:transientBasket.getNumberOfProducts().keySet()){
					int quantity = transientBasket.getNumberOfProducts().get(transientProduct);
					newTransientBasket.addProduct(transientProduct,quantity);
					quantity = transientBasket.getNumberOfProducts().get(transientProduct);
					String productWithAttributesId = transientProduct.getProductIdWithAttributes();
					CustomersBasket customersBasket = customersBasketRepository.findByCustomerAndProductId(customer,productWithAttributesId);
					if(customersBasket==null){
						customersBasket = new CustomersBasket();
						customersBasket.setCustomer(customer);
						customersBasket.setProductId(productWithAttributesId);
						customersBasket.setQuantity(1);
						Date now = new Date();
						customersBasket.setDateAdded(now);
						customersBasketRepository.save(customersBasket);
					} else {
						customersBasket.setQuantity(quantity);
						customersBasketRepository.save(customersBasket);
					}
				}
				return newTransientBasket;
			}
		}
		return null;
	}
}
