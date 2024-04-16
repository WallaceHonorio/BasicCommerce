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

    public Product update(Product product){
        return this.em.merge(product);
    }

    public void remove(Product product) {
        product = em.merge(product);
        this.em.remove(product);
    }

    public Product searchID(Long id) {
        return em.find(Product.class, id);
    }
}
