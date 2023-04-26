package Embarcacao;

import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class EmbarcacaoRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public List<Embarcacao> getAllEmbarcacaos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Embarcacao> cq = cb.createQuery(Embarcacao.class);
        Root<Embarcacao> root = cq.from(Embarcacao.class);
        cq.select(root);
        TypedQuery<Embarcacao> query = em.createQuery(cq);
        List<Embarcacao> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createEmbarcacao(Embarcacao embarcacao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(embarcacao);
        em.getTransaction().commit();
        em.close();
    }

    public Embarcacao getEmbarcacaoById(int id) {
        EntityManager em = emf.createEntityManager();
        Embarcacao embarcacao = em.find(Embarcacao.class, id);
        em.close();
        return embarcacao;
    }

    public void updateEmbarcacao(Embarcacao embarcacao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(embarcacao);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteEmbarcacao(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Embarcacao embarcacao = em.find(Embarcacao.class, id);
        em.remove(embarcacao);
        em.getTransaction().commit();
        em.close();
    }

}

