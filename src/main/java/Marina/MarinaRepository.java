package Marina;

import Utilizador.Utilizador;
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
        cq.orderBy(cb.asc(root.get("nome")));
        TypedQuery<Marina> query = em.createQuery(cq);
        List<Marina> orders = query.getResultList();
        em.close();
        return orders;
    }

    public List<Marina> getMarinasComPrefix(String prefix) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Marina> query = em.createQuery("SELECT m FROM Marina m WHERE m.nome LIKE :prefix", Marina.class);
        query.setParameter("prefix", prefix + "%");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Marina> cq = cb.createQuery(Marina.class);
        Root<Marina> root = cq.from(Marina.class);
        cq.select(root);
        List<Marina> marinas = query.getResultList();
        em.close();
        return marinas;
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

    public Marina findMarinaByName(String nome) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT m FROM Marina m WHERE m.nome = :nome");
        query.setParameter("nome", nome);
        return (Marina) query.getSingleResult();
    }

}

