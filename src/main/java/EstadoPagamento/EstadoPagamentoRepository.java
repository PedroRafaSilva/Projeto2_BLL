package EstadoPagamento;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class EstadoPagamentoRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public List<EstadoPagamento> getAllEstadoPagamentos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EstadoPagamento> cq = cb.createQuery(EstadoPagamento.class);
        Root<EstadoPagamento> root = cq.from(EstadoPagamento.class);
        cq.select(root);
        TypedQuery<EstadoPagamento> query = em.createQuery(cq);
        List<EstadoPagamento> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createEstadoPagamento(EstadoPagamento estadoPagamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(estadoPagamento);
        em.getTransaction().commit();
        em.close();
    }

    public EstadoPagamento getEstadoPagamentoById(int id) {
        EntityManager em = emf.createEntityManager();
        EstadoPagamento estadoPagamento = em.find(EstadoPagamento.class, id);
        em.close();
        return estadoPagamento;
    }

    public void updateEstadoPagamento(EstadoPagamento estadoPagamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(estadoPagamento);
        em.getTransaction().commit();
        em.close();
    }
    public void deleteEstadoPagamento(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        EstadoPagamento estadoPagamento = em.find(EstadoPagamento.class, id);
        em.remove(estadoPagamento);
        em.getTransaction().commit();
        em.close();
    }
}


