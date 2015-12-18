package org.woehlke.greenshop.oodm.catalog;

import java.util.List;


import org.woehlke.greenshop.oodm.catalog.entities.*;
import org.woehlke.greenshop.oodm.catalog.model.*;


public interface CatalogService {
	
	ProductAttributes findProductOptionsByProduct(ProductDescription product);

	List<ProductImage> findProductImages(Product product);

	int getNumberOfReviewsForProduct(Product product);

}
