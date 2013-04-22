package org.woehlke.greenshop.catalog.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.woehlke.greenshop.catalog.entities.CategoryDescription;
import org.woehlke.greenshop.catalog.entities.Language;

@Repository
public class CategoryDescriptionRepositoryDaoImpl implements CategoryDescriptionRepositoryDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<CategoryDescription> findRootCategories(Language language){
		return findCategoriesByParentId(0L,language);
	}
	
	@SuppressWarnings("unchecked")
	public List<CategoryDescription> findCategoriesByParentId(long parentId,Language language){
		String qlString = "select c from CategoryDescription c where c.category.parentId=:parentId and c.language=:language order by c.category.sortOrder";
		Query q = em.createQuery(qlString);
		q.setParameter("parentId", parentId);
		q.setParameter("language", language);
		return q.getResultList();
	}

	@Override
	public CategoryDescription findByCategoryId(long categoryId,
			Language language) {
		String qlString = "select c from CategoryDescription c where c.category.id=:categoryId and c.language=:language";
		Query q = em.createQuery(qlString);
		q.setParameter("categoryId", categoryId);
		q.setParameter("language", language);
		return (CategoryDescription) q.getSingleResult();
	}
	
}
