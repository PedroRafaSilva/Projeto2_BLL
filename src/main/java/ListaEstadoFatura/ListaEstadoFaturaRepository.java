package ListaEstadoFatura;

import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class ListaEstadoFaturaRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

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
        ListaEstadoFatura listaEstadoFatura = em.find(ListaEstadoFatura.class, new ListaEstadoFaturaPK(id, id2));
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
        ListaEstadoFatura listaEstadoFatura = em.find(ListaEstadoFatura.class, new ListaEstadoFaturaPK(id, id2));
        em.remove(listaEstadoFatura);
        em.getTransaction().commit();
        em.close();
    }

}

