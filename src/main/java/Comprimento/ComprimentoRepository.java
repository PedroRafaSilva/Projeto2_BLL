package Comprimento;

import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class ComprimentoRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public List<Comprimento> getAllComprimentos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Comprimento> cq = cb.createQuery(Comprimento.class);
        Root<Comprimento> root = cq.from(Comprimento.class);
        cq.select(root);
        TypedQuery<Comprimento> query = em.createQuery(cq);
        List<Comprimento> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createComprimento(Comprimento comprimento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(comprimento);
        em.getTransaction().commit();
        em.close();
    }

    public Comprimento getComprimentoById(String id) {
        EntityManager em = emf.createEntityManager();
        Comprimento comprimento = em.find(Comprimento.class, id);
        em.close();
        return comprimento;
    }

    public void updateComprimento(Comprimento comprimento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(comprimento);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteComprimento(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Comprimento comprimento = em.find(Comprimento.class, id);
        em.remove(comprimento);
        em.getTransaction().commit();
        em.close();
    }

}

