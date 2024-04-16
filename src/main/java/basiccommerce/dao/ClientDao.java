package basiccommerce.dao;

import basiccommerce.model.Client;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDao {

    EntityManager em;
    public ClientDao(EntityManager em) {
        this.em = em;
    }

    public void register(Client category){
        this.em.persist(category);
    }
    public Client update(Client category){
        return this.em.merge(category);
    }

    public void remove(Client category) {
        category = em.merge(category);
        this.em.remove(category);
    }

    public Client searchID(Long id) {
        return em.find(Client.class, id);
    }

    public List<Client> searchAll(){
        String jpql = "SELECT c FROM Client c";
        return em.createQuery(jpql, Client.class).getResultList();
    }
}
