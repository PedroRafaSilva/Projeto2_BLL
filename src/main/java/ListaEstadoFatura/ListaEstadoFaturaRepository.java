package ListaEstadoFatura;

import ListaEstadoAgendamento.ListaEstadoAgendamento;
import Main.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class ListaEstadoFaturaRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public List<ListaEstadoFatura> getAllListaEstadoFaturas() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ListaEstadoFatura> cq = cb.createQuery(ListaEstadoFatura.class);
        Root<ListaEstadoFatura> root = cq.from(ListaEstadoFatura.class);
        cq.select(root);
        TypedQuery<ListaEstadoFatura> query = em.createQuery(cq);
        List<ListaEstadoFatura> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createListaEstadoFatura(ListaEstadoFatura listaEstadoFatura) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(listaEstadoFatura);
        em.getTransaction().commit();
        em.close();
    }

    public ListaEstadoFatura getListaEstadoFaturaById(int id, int id2) {
        EntityManager em = emf.createEntityManager();
        ListaEstadoFaturaPK pk = new ListaEstadoFaturaPK();
        pk.setIdfatura(id);
        pk.setIdestado(id2);
        ListaEstadoFatura listaEstadoFatura = em.find(ListaEstadoFatura.class, pk);
        em.close();
        return listaEstadoFatura;
    }

    public void updateListaEstadoFatura(ListaEstadoFatura listaEstadoFatura) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(listaEstadoFatura);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteListaEstadoFatura(int id, int id2) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ListaEstadoFaturaPK pk = new ListaEstadoFaturaPK();
        pk.setIdfatura(id);
        pk.setIdestado(id2);
        ListaEstadoFatura listaEstadoFatura = em.find(ListaEstadoFatura.class, pk);
        em.remove(listaEstadoFatura);
        em.getTransaction().commit();
        em.close();
    }

    public ListaEstadoFatura findEstadoByFatura(int idFatura) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<ListaEstadoFatura> query = em.createQuery(
                "SELECT lf FROM ListaEstadoFatura lf WHERE lf.idfatura = :idfatura ORDER BY lf.data DESC", ListaEstadoFatura.class);
        query.setParameter("idfatura", idFatura);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

}

