package Agendamento;

import Main.EntityManagerFactorySingleton;
import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.sql.Date;
import java.util.List;

@Transactional
public class AgendamentoRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

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

    public Agendamento findMostRecentAgendamento() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Agendamento> query = em.createQuery("SELECT a FROM Agendamento a ORDER BY a.idagendamento DESC", Agendamento.class);
        query.setMaxResults(1);
        List<Agendamento> agendamentos = query.getResultList();
        em.close();
        if (agendamentos.isEmpty()) {
            return null;
        } else {
            return agendamentos.get(0);
        }
    }


    public List<Agendamento> findAllAgendamentosByDate(int day, int month, int year) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Agendamento> query = em.createQuery("SELECT a FROM Agendamento a WHERE EXTRACT(year from a.data) = :year AND EXTRACT(month from a.data) = :month AND EXTRACT(day from a.data) = :day ORDER BY a.horainicio", Agendamento.class);
        query.setParameter("year", year);
        query.setParameter("month", month);
        query.setParameter("day", day);
        List<Agendamento> agendamentos = query.getResultList();
        em.close();
        return agendamentos;
    }

    public boolean checkClienteAgendamentoAt(int idCliente, Date data){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT COUNT(*) FROM Agendamento a WHERE a.data = :data AND a.idutilizador = :idCliente", Agendamento.class);
        query.setParameter("data", data);
        query.setParameter("idCliente", idCliente);
        Long count = (Long) query.getSingleResult();
        em.close();
        return count > 0;
    }


}

