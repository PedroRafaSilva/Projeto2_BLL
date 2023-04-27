package Oficina;

import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class OficinaRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public List<Oficina> getAllOficinas() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Oficina> cq = cb.createQuery(Oficina.class);
        Root<Oficina> root = cq.from(Oficina.class);
        cq.select(root);
        TypedQuery<Oficina> query = em.createQuery(cq);
        List<Oficina> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createOficina(Oficina oficina) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(oficina);
        em.getTransaction().commit();
        em.close();
    }

    public Oficina getOficinaById(int id) {
        EntityManager em = emf.createEntityManager();
        Oficina oficina = em.find(Oficina.class, id);
        em.close();
        return oficina;
    }

    public void updateOficina(Oficina oficina) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(oficina);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteOficina(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Oficina oficina = em.find(Oficina.class, id);
        em.remove(oficina);
        em.getTransaction().commit();
        em.close();
    }

}

