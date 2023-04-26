package Agendamento;

import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class AgendamentoRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public List<Agendamento> getAllAgendamentos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Agendamento> cq = cb.createQuery(Agendamento.class);
        Root<Agendamento> root = cq.from(Agendamento.class);
        cq.select(root);
        TypedQuery<Agendamento> query = em.createQuery(cq);
        List<Agendamento> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createAgendamento(Agendamento agendamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(agendamento);
        em.getTransaction().commit();
        em.close();
    }

    public Agendamento getAgendamentoById(int id) {
        EntityManager em = emf.createEntityManager();
        Agendamento agendamento = em.find(Agendamento.class, id);
        em.close();
        return agendamento;
    }

    public void updateAgendamento(Agendamento agendamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(agendamento);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAgendamento(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Agendamento agendamento = em.find(Agendamento.class, id);
        em.remove(agendamento);
        em.getTransaction().commit();
        em.close();
    }

}

