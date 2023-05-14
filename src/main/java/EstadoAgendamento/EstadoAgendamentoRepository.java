package EstadoAgendamento;


import Main.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class EstadoAgendamentoRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public List<EstadoAgendamento> getAllEstadoAgendamentos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EstadoAgendamento> cq = cb.createQuery(EstadoAgendamento.class);
        Root<EstadoAgendamento> root = cq.from(EstadoAgendamento.class);
        cq.select(root);
        TypedQuery<EstadoAgendamento> query = em.createQuery(cq);
        List<EstadoAgendamento> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createEstadoAgendamento(EstadoAgendamento estadoAgendamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(estadoAgendamento);
        em.getTransaction().commit();
        em.close();
    }

    public EstadoAgendamento getEstadoAgendamentoById(int id) {
        EntityManager em = emf.createEntityManager();
        EstadoAgendamento estadoAgendamento = em.find(EstadoAgendamento.class, id);
        em.close();
        return estadoAgendamento;
    }

    public void updateEstadoAgendamento(EstadoAgendamento estadoAgendamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(estadoAgendamento);
        em.getTransaction().commit();
        em.close();
    }
    public void deleteEstadoAgendamento(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        EstadoAgendamento estadoAgendamento = em.find(EstadoAgendamento.class, id);
        em.remove(estadoAgendamento);
        em.getTransaction().commit();
        em.close();
    }
}


