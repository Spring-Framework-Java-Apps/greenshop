package org.woehlke.greenshop.catalog.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.woehlke.greenshop.catalog.entities.Category;
import org.woehlke.greenshop.catalog.entities.Language;
import org.woehlke.greenshop.catalog.entities.Manufacturer;
import org.woehlke.greenshop.catalog.entities.ProductDescription;

@Repository
public class ProductDescriptionRepositoryDaoImpl implements ProductDescriptionRepositoryDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ProductDescription> findByLanguageOrderByDateAdded(Language language, int limitation){
		Query q = em.createQuery("select p from ProductDescription p where p.language=:language order by p.product.dateAdded desc");
		q.setParameter("language", language);
		q.setMaxResults(limitation);
		return q.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductDescription> findByManufacturer(
			Manufacturer manufacturer, Language language) {
		Query q = em.createQuery("select p from ProductDescription p where p.language=:language and p.product.manufacturer=:manufacturer order by p.name asc");
		q.setParameter("language", language);
		q.setParameter("manufacturer", manufacturer);
		return q.getResultList();
	}

	@Override
	public ProductDescription findByProductIdAndLanguage(long productId,
			Language language) {
		Query q = em.createQuery("select p from ProductDescription p where p.language=:language and p.product.id=:productId");
		q.setParameter("language", language);
		q.setParameter("productId", productId);
		return (ProductDescription) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDescription> findByCategory(Category thisCategory,
			Language language) {
		Query q = em.createQuery("select p from ProductDescription p Inner Join p.product.categories c where (:thisCategory) in c and p.language=:language order by p.name asc");
		q.setParameter("language", language);
		q.setParameter("thisCategory", thisCategory);
		return q.getResultList();
	}

	@Override
	public List<ProductDescription> findByCategoryAndManufacturer(
			Category category, Manufacturer manufacturer, Language language) {
		Query q = em.createQuery("select p from ProductDescription p Inner Join p.product.categories c where (:thisCategory) in c and p.language=:language and p.product.manufacturer=:manufacturer order by p.name asc");
		q.setParameter("language", language);
		q.setParameter("thisCategory", category);
		q.setParameter("manufacturer", manufacturer);
		return q.getResultList();
	}


}
