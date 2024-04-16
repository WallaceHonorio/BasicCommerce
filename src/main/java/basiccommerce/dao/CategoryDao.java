package basiccommerce.dao;

import basiccommerce.model.Category;
import basiccommerce.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

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

    public Category searchID(Long id) {
        return em.find(Category.class, id);
    }

    public List<Category> searchAll(){
        String jpql = "SELECT c FROM Category c";
        return em.createQuery(jpql, Category.class).getResultList();
    }
}
