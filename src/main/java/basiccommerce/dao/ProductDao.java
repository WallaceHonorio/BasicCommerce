package basiccommerce.dao;

import basiccommerce.model.Product;

import javax.persistence.EntityManager;

public class ProductDao {

    EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }

    public void register(Product product){
        this.em.persist(product);
    }

    public void update(Product product){
        this.em.merge(product);
    }
}
