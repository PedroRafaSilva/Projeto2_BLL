package ListaEstadoAgendamento;

import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class ListaEstadoAgendamentoRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public List<ListaEstadoAgendamento> getAllListaEstadoAgendamentos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ListaEstadoAgendamento> cq = cb.createQuery(ListaEstadoAgendamento.class);
        Root<ListaEstadoAgendamento> root = cq.from(ListaEstadoAgendamento.class);
        cq.select(root);
        TypedQuery<ListaEstadoAgendamento> query = em.createQuery(cq);
        List<ListaEstadoAgendamento> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createListaEstadoAgendamento(ListaEstadoAgendamento listaEstadoAgendamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(listaEstadoAgendamento);
        em.getTransaction().commit();
        em.close();
    }

    public ListaEstadoAgendamento getListaEstadoAgendamentoById(int id, int id2) {
        EntityManager em = emf.createEntityManager();
        ListaEstadoAgendamento listaEstadoAgendamento = em.find(ListaEstadoAgendamento.class, new ListaEstadoAgendamentoPK(id, id2));
        em.close();
        return listaEstadoAgendamento;
    }

    public void updateListaEstadoAgendamento(ListaEstadoAgendamento listaEstadoAgendamento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(listaEstadoAgendamento);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteListaEstadoAgendamento(int id, int id2) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ListaEstadoAgendamento listaEstadoAgendamento = em.find(ListaEstadoAgendamento.class, new ListaEstadoAgendamentoPK(id, id2));
        em.remove(listaEstadoAgendamento);
        em.getTransaction().commit();
        em.close();
    }

}

