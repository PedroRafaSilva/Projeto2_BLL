package Comprimento;

import Main.EntityManagerFactorySingleton;
import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class ComprimentoRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public List<Comprimento> getAllComprimentos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Comprimento> cq = cb.createQuery(Comprimento.class);
        Root<Comprimento> root = cq.from(Comprimento.class);
        cq.select(root);
        cq.orderBy(cb.asc(root.get("descricao")));
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

    public Comprimento findComprimentoByName(String nome) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT c FROM Comprimento c WHERE c.descricao = :nome");
        query.setParameter("nome", nome);
        return (Comprimento) query.getSingleResult();
    }

}

