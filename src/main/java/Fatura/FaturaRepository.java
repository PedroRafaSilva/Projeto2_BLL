package Fatura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class FaturaRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public List<Fatura> getAllFaturas() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Fatura> cq = cb.createQuery(Fatura.class);
        Root<Fatura> root = cq.from(Fatura.class);
        cq.select(root);
        TypedQuery<Fatura> query = em.createQuery(cq);
        List<Fatura> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createFatura(Fatura fatura) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(fatura);
        em.getTransaction().commit();
        em.close();
    }

    public Fatura getFaturaById(int id) {
        EntityManager em = emf.createEntityManager();
        Fatura fatura = em.find(Fatura.class, id);
        em.close();
        return fatura;
    }

    public void updateFatura(Fatura fatura) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(fatura);
        em.getTransaction().commit();
        em.close();
    }
    public void deleteFatura(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Fatura fatura = em.find(Fatura.class, id);
        em.remove(fatura);
        em.getTransaction().commit();
        em.close();
    }
}


