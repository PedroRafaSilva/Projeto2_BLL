package Pagamento;

import Main.EntityManagerFactorySingleton;
import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class PagamentoRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public List<Pagamento> getAllPagamentos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Pagamento> cq = cb.createQuery(Pagamento.class);
        Root<Pagamento> root = cq.from(Pagamento.class);
        cq.select(root);
        TypedQuery<Pagamento> query = em.createQuery(cq);
        List<Pagamento> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createPagamento(Pagamento pagamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pagamento);
        em.getTransaction().commit();
        em.close();
    }

    public Pagamento getPagamentoById(int id) {
        EntityManager em = emf.createEntityManager();
        Pagamento pagamento = em.find(Pagamento.class, id);
        em.close();
        return pagamento;
    }

    public void updatePagamento(Pagamento pagamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pagamento);
        em.getTransaction().commit();
        em.close();
    }

    public void deletePagamento(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Pagamento pagamento = em.find(Pagamento.class, id);
        em.remove(pagamento);
        em.getTransaction().commit();
        em.close();
    }

}

