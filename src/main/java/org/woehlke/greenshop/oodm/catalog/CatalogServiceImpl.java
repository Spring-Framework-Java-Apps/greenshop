package org.woehlke.greenshop.oodm.catalog;

import java.util.*;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.woehlke.greenshop.oodm.catalog.entities.*;
import org.woehlke.greenshop.oodm.catalog.model.*;
import org.woehlke.greenshop.oodm.catalog.repositories.*;

@Named
@Transactional(readOnly=true,propagation= Propagation.REQUIRED)
public class CatalogServiceImpl implements CatalogService {
	
	@Inject
	private ProductDescriptionRepositoryDao productDescriptionRepositoryDao;
	
	@Inject
	private ManufacturerRepository manufacturerRepository;

	@Inject
	private ManufacturerInfoRepository manufacturerInfoRepository;

	@Inject
	private ManufacturerInfoDao manufacturerInfoDao;
	
	@Inject
	private ProductAttributeRepository productAttributeRepository;
	
	@Inject
	private ProductOptionRepository productOptionRepository;
	
	@Inject
	private ProductOptionValueRepository productOptionValueRepository;

	@Inject
	private ProductImageRepository productImageRepository;

	@Inject
	private ReviewRepository reviewRepository;

	@Inject
	private SpecialRepository specialRepository;

	@Override
	public ProductAttributes findProductOptionsByProduct(
			ProductDescription product) {
		Language language = product.getLanguage();
		List<ProductAttribute> listProductAttribute = productAttributeRepository.findByProduct(product.getProduct());
		Map<ProductOption,List<ProductOptionAttribute>> mapProductOptionAttribute = new HashMap<ProductOption,List<ProductOptionAttribute>>();
		for(ProductAttribute pa :listProductAttribute){
			ProductOptionId oid = new ProductOptionId();
			oid.setId(pa.getOptionId());
			oid.setLanguage(language);
			ProductOption po = productOptionRepository.findOne(oid);
			ProductOptionValueId povid = new ProductOptionValueId();
			povid.setId(pa.getValueId());
			povid.setLanguage(language);
			ProductOptionValue pov = productOptionValueRepository.findOne(povid);
			ProductOptionAttribute poa = new ProductOptionAttribute();
			poa.setProductAttribute(pa);
			poa.setProductOption(po);
			poa.setProductOptionValue(pov);
			StringBuilder sb = new StringBuilder();
			sb.append(pov.getName());
			if(pa.getPrice()!=0.0){
				sb.append(" (");
				sb.append(pa.getPricePrefix());
				sb.append(pa.getPrice());
				sb.append(")");
			}
			poa.setOptionValue(sb.toString());
			if(mapProductOptionAttribute.containsKey(po)){
				List<ProductOptionAttribute> mapList = mapProductOptionAttribute.get(po);
				mapList.add(poa);
				mapProductOptionAttribute.remove(po);
				mapProductOptionAttribute.put(po, mapList);
			} else {
				List<ProductOptionAttribute> mapList = new ArrayList<ProductOptionAttribute>();
				mapList.add(poa);
				mapProductOptionAttribute.put(po, mapList);
			}
		}
		ProductAttributes productAttributes = new ProductAttributes();
		productAttributes.setProductDescription(product);
		productAttributes.setMapProductOptionAttribute(mapProductOptionAttribute);
		return productAttributes;
	}

	@Override
	public List<ProductImage> findProductImages(Product product) {
		return productImageRepository.findByProductOrderBySequenceAsc(product);
	}

	@Override
	public int getNumberOfReviewsForProduct(Product product) {
		List<Review> reviews = reviewRepository.findByProduct(product);
		return reviews.size();
	}


}
