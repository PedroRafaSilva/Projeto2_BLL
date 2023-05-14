package CodPostal;

import Main.EntityManagerFactorySingleton;
import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class CodPostalRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public List<CodPostal> getAllCodPostals() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CodPostal> cq = cb.createQuery(CodPostal.class);
        Root<CodPostal> root = cq.from(CodPostal.class);
        cq.select(root);
        TypedQuery<CodPostal> query = em.createQuery(cq);
        List<CodPostal> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createCodPostal(CodPostal codPostal) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(codPostal);
        em.getTransaction().commit();
        em.close();
    }

    public CodPostal getCodPostalById(String id) {
        EntityManager em = emf.createEntityManager();
        CodPostal codPostal = em.find(CodPostal.class, id);
        em.close();
        return codPostal;
    }

    public void updateCodPostal(CodPostal codPostal) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(codPostal);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteCodPostal(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CodPostal codPostal = em.find(CodPostal.class, id);
        em.remove(codPostal);
        em.getTransaction().commit();
        em.close();
    }

}

