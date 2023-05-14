package ListaEstadoAgendamento;

import AgendamentoExtra.AgendamentoExtra;
import ListaEmbarcacao.ListaEmbarcacao;
import ListaEmbarcacao.ListaEmbarcacaoPK;
import Main.EntityManagerFactorySingleton;
import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class ListaEstadoAgendamentoRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

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
        ListaEstadoAgendamentoPK pk = new ListaEstadoAgendamentoPK();
        pk.setIdagendamento(id);
        pk.setIdestado(id2);
        ListaEstadoAgendamento listaEstadoAgendamento = em.find(ListaEstadoAgendamento.class, pk);
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
        ListaEstadoAgendamentoPK pk = new ListaEstadoAgendamentoPK();
        pk.setIdagendamento(id);
        pk.setIdestado(id2);
        ListaEstadoAgendamento listaEstadoAgendamento = em.find(ListaEstadoAgendamento.class, pk);
        em.remove(listaEstadoAgendamento);
        em.getTransaction().commit();
        em.close();
    }

    public ListaEstadoAgendamento findEstadoByAgendamento(int idAgendamento) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<ListaEstadoAgendamento> query = em.createQuery(
                "SELECT la FROM ListaEstadoAgendamento la WHERE la.idagendamento = :idAgendamento ORDER BY la.data DESC", ListaEstadoAgendamento.class);
        query.setParameter("idAgendamento", idAgendamento);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

}

