package Marina;

import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class MarinaRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public List<Marina> getAllMarinas() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Marina> cq = cb.createQuery(Marina.class);
        Root<Marina> root = cq.from(Marina.class);
        cq.select(root);
        TypedQuery<Marina> query = em.createQuery(cq);
        List<Marina> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createMarina(Marina marina) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(marina);
        em.getTransaction().commit();
        em.close();
    }

    public Marina getMarinaById(int id) {
        EntityManager em = emf.createEntityManager();
        Marina marina = em.find(Marina.class, id);
        em.close();
        return marina;
    }

    public void updateMarina(Marina marina) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(marina);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteMarina(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Marina marina = em.find(Marina.class, id);
        em.remove(marina);
        em.getTransaction().commit();
        em.close();
    }

}

