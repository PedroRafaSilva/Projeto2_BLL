package PedidoDescricao;

import Main.EntityManagerFactorySingleton;
import PedidoDescricao.PedidoDescricao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class PedidoDescricaoRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public List<PedidoDescricao> getAllPedidoDescricaos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PedidoDescricao> cq = cb.createQuery(PedidoDescricao.class);
        Root<PedidoDescricao> root = cq.from(PedidoDescricao.class);
        cq.select(root);
        TypedQuery<PedidoDescricao> query = em.createQuery(cq);
        List<PedidoDescricao> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createPedidoDescricao(PedidoDescricao pedidoDescricao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pedidoDescricao);
        em.getTransaction().commit();
        em.close();
    }

    public PedidoDescricao getPedidoDescricaoById(String id) {
        EntityManager em = emf.createEntityManager();
        PedidoDescricao pedidoDescricao = em.find(PedidoDescricao.class, id);
        em.close();
        return pedidoDescricao;
    }

    public void updatePedidoDescricao(PedidoDescricao pedidoDescricao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pedidoDescricao);
        em.getTransaction().commit();
        em.close();
    }

    public void deletePedidoDescricao(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PedidoDescricao pedidoDescricao = em.find(PedidoDescricao.class, id);
        em.remove(pedidoDescricao);
        em.getTransaction().commit();
        em.close();
    }

}
