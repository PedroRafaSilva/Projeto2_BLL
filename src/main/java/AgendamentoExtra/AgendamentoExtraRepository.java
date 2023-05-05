package AgendamentoExtra;

import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class AgendamentoExtraRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public List<AgendamentoExtra> getAllAgendamentoExtras() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AgendamentoExtra> cq = cb.createQuery(AgendamentoExtra.class);
        Root<AgendamentoExtra> root = cq.from(AgendamentoExtra.class);
        cq.select(root);
        TypedQuery<AgendamentoExtra> query = em.createQuery(cq);
        List<AgendamentoExtra> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createAgendamentoExtra(AgendamentoExtra agendamentoExtra) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(agendamentoExtra);
        em.getTransaction().commit();
        em.close();
    }

    public AgendamentoExtra getAgendamentoExtraById(int id, int id2) {
        EntityManager em = emf.createEntityManager();
        AgendamentoExtraPK pk = new AgendamentoExtraPK();
        pk.setIdagendamento(id);
        pk.setIdextra(id2);
        AgendamentoExtra agendamentoExtra = em.find(AgendamentoExtra.class, pk);
        em.close();
        return agendamentoExtra;
    }

    public void updateAgendamentoExtra(AgendamentoExtra agendamentoExtra) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(agendamentoExtra);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAgendamentoExtra(int id, int id2) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        AgendamentoExtra agendamentoExtra = em.find(AgendamentoExtra.class, new AgendamentoExtraPK(id, id2));
        em.remove(agendamentoExtra);
        em.getTransaction().commit();
        em.close();
    }

}

