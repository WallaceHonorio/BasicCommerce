package basiccommerce.dao;

import basiccommerce.model.Category;
import basiccommerce.model.Product;

import javax.persistence.EntityManager;

public class CategoryDao {

    EntityManager em;
    public CategoryDao(EntityManager em) {
        this.em = em;
    }

    public void register(Category category){
        this.em.persist(category);
    }
    public void update(Category category){
        this.em.merge(category);
    }


}
