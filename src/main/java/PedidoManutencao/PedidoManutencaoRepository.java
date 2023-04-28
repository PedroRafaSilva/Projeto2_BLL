package PedidoManutencao;

import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class PedidoManutencaoRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public List<PedidoManutencao> getAllPedidoManutencaos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PedidoManutencao> cq = cb.createQuery(PedidoManutencao.class);
        Root<PedidoManutencao> root = cq.from(PedidoManutencao.class);
        cq.select(root);
        TypedQuery<PedidoManutencao> query = em.createQuery(cq);
        List<PedidoManutencao> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createPedidoManutencao(PedidoManutencao pedidoManutencao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pedidoManutencao);
        em.getTransaction().commit();
        em.close();
    }

    public PedidoManutencao getPedidoManutencaoById(int id) {
        EntityManager em = emf.createEntityManager();
        PedidoManutencao pedidoManutencao = em.find(PedidoManutencao.class, id);
        em.close();
        return pedidoManutencao;
    }

    public void updatePedidoManutencao(PedidoManutencao pedidoManutencao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pedidoManutencao);
        em.getTransaction().commit();
        em.close();
    }

    public void deletePedidoManutencao(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PedidoManutencao pedidoManutencao = em.find(PedidoManutencao.class, id);
        em.remove(pedidoManutencao);
        em.getTransaction().commit();
        em.close();
    }

}

