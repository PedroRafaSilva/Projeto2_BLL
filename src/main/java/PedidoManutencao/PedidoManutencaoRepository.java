package PedidoManutencao;

import Agendamento.Agendamento;
import Main.EntityManagerFactorySingleton;
import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.sql.Date;
import java.util.List;

public class PedidoManutencaoRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

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

    public List<PedidoManutencao> findAllPedidossByDate(int day, int month, int year) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<PedidoManutencao> query = em.createQuery("SELECT p FROM PedidoManutencao p WHERE EXTRACT(year from p.data) = :year AND EXTRACT(month from p.data) = :month AND EXTRACT(day from p.data) = :day", PedidoManutencao.class);
        query.setParameter("year", year);
        query.setParameter("month", month);
        query.setParameter("day", day);
        List<PedidoManutencao> pedidoManutencaos = query.getResultList();
        em.close();
        return pedidoManutencaos;
    }

    public boolean checkPedidoEmbarcacaooAt(int idEmbarcacao, Date data){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT COUNT(*) FROM PedidoManutencao p WHERE p.data = :data AND p.idembarcacao = :idEmbarcacao", PedidoManutencao.class);
        query.setParameter("data", data);
        query.setParameter("idEmbarcacao", idEmbarcacao);
        Long count = (Long) query.getSingleResult();
        em.close();
        return count > 0;
    }

}

