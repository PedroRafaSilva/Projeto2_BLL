package AgendamentoExtra;

import Main.EntityManagerFactorySingleton;
import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class AgendamentoExtraRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

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

    public List<AgendamentoExtra> findAgendamentoExtraByIdAgendamento(int idAgendamento) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<AgendamentoExtra> query = em.createQuery(
                "SELECT ae FROM AgendamentoExtra ae WHERE ae.idagendamento = :idAgendamento", AgendamentoExtra.class);
        query.setParameter("idAgendamento", idAgendamento);
        return query.getResultList();
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
        AgendamentoExtraPK pk = new AgendamentoExtraPK();
        pk.setIdagendamento(id);
        pk.setIdextra(id2);
        AgendamentoExtra agendamentoExtra = em.find(AgendamentoExtra.class, pk);
        em.remove(agendamentoExtra);
        em.getTransaction().commit();
        em.close();
    }

}

