package basiccommerce.dao;

import basiccommerce.model.Category;

import javax.persistence.EntityManager;

public class CategoryDao {

    EntityManager em;
    public CategoryDao(EntityManager em) {
        this.em = em;
    }

    public void register(Category category){
        this.em.persist(category);
    }
    public Category update(Category category){
        return this.em.merge(category);
    }

    public void remove(Category category) {
        category = em.merge(category);
        this.em.remove(category);
    }
}
