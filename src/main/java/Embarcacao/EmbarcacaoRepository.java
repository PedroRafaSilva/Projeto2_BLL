package Embarcacao;

import Main.EntityManagerFactorySingleton;
import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class EmbarcacaoRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public List<Embarcacao> getAllEmbarcacaos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Embarcacao> cq = cb.createQuery(Embarcacao.class);
        Root<Embarcacao> root = cq.from(Embarcacao.class);
        cq.select(root);
        cq.orderBy(cb.asc(root.get("nome")));
        TypedQuery<Embarcacao> query = em.createQuery(cq);
        List<Embarcacao> orders = query.getResultList();
        em.close();
        return orders;
    }

    public List<Embarcacao> getEmbarcacoesComPrefix(String prefix) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Embarcacao> query = em.createQuery("SELECT e FROM Embarcacao e WHERE e.nome LIKE :prefix", Embarcacao.class);
        query.setParameter("prefix", prefix + "%");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Embarcacao> cq = cb.createQuery(Embarcacao.class);
        Root<Embarcacao> root = cq.from(Embarcacao.class);
        cq.select(root);
        cq.orderBy(cb.asc(root.get("nome")));
        List<Embarcacao> embarcacaos = query.getResultList();
        em.close();
        return embarcacaos;
    }

    public Embarcacao findByName(String nome) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Embarcacao e WHERE e.nome = :nome");
        query.setParameter("nome", nome);
        return (Embarcacao) query.getSingleResult();
    }



    public void createEmbarcacao(Embarcacao embarcacao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(embarcacao);
        em.getTransaction().commit();
        em.close();
        emf.close();
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

