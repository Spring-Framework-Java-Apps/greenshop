package org.woehlke.greenshop.catalog;

import java.util.List;


import org.woehlke.greenshop.catalog.entities.*;
import org.woehlke.greenshop.catalog.model.*;
import org.woehlke.greenshop.customer.entities.Customer;


public interface CatalogService {
	
	ProductAttributes findProductOptionsByProduct(ProductDescription product);

	List<ProductImage> findProductImages(Product product);

	int getNumberOfReviewsForProduct(Product product);

}
