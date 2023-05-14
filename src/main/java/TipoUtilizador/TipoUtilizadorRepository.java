package TipoUtilizador;

import Main.EntityManagerFactorySingleton;
import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class TipoUtilizadorRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public List<TipoUtilizador> getAllTipoUtilizadors() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TipoUtilizador> cq = cb.createQuery(TipoUtilizador.class);
        Root<TipoUtilizador> root = cq.from(TipoUtilizador.class);
        cq.select(root);
        TypedQuery<TipoUtilizador> query = em.createQuery(cq);
        List<TipoUtilizador> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createTipoUtilizador(TipoUtilizador tipoUtilizador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(tipoUtilizador);
        em.getTransaction().commit();
        em.close();
    }

    public TipoUtilizador getTipoUtilizadorById(int id) {
        EntityManager em = emf.createEntityManager();
        TipoUtilizador tipoUtilizador = em.find(TipoUtilizador.class, id);
        em.close();
        return tipoUtilizador;
    }

    public void updateTipoUtilizador(TipoUtilizador tipoUtilizador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(tipoUtilizador);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteTipoUtilizador(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TipoUtilizador tipoUtilizador = em.find(TipoUtilizador.class, id);
        em.remove(tipoUtilizador);
        em.getTransaction().commit();
        em.close();
    }

}

