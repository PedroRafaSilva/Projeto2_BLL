package Utilizador;

import Embarcacao.Embarcacao;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class UtilizadorRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public List<Utilizador> getAllUtilizadores() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilizador> cq = cb.createQuery(Utilizador.class);
        Root<Utilizador> root = cq.from(Utilizador.class);
        cq.select(root);
        TypedQuery<Utilizador> query = em.createQuery(cq);
        List<Utilizador> orders = query.getResultList();
        em.close();
        return orders;
    }

    public List<Utilizador> getAllUtilizadoresOrderByName() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilizador> cq = cb.createQuery(Utilizador.class);
        Root<Utilizador> root = cq.from(Utilizador.class);
        cq.select(root);
        cq.orderBy(cb.asc(root.get("nome")));
        TypedQuery<Utilizador> query = em.createQuery(cq);
        List<Utilizador> orders = query.getResultList();
        em.close();
        return orders;
    }

    public List<Utilizador> getAllClientes() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilizador> cq = cb.createQuery(Utilizador.class);
        Root<Utilizador> root = cq.from(Utilizador.class);
        cq.select(root);
        cq.where(cb.equal(root.get("idTipoUtilizador"), 3));
        cq.orderBy(cb.asc(root.get("nome")));
        TypedQuery<Utilizador> query = em.createQuery(cq);
        List<Utilizador> orders = query.getResultList();
        em.close();
        return orders;
    }

    public List<Utilizador> getAllFuncionarios() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilizador> cq = cb.createQuery(Utilizador.class);
        Root<Utilizador> root = cq.from(Utilizador.class);
        cq.select(root);
        cq.where(cb.equal(root.get("idTipoUtilizador"), 2));
        cq.orderBy(cb.asc(root.get("nome")));
        TypedQuery<Utilizador> query = em.createQuery(cq);
        List<Utilizador> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createUtilizador(Utilizador utilizador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(utilizador);
        em.getTransaction().commit();
        em.close();
    }

    public Utilizador getUtilizadorById(int id) {
        EntityManager em = emf.createEntityManager();
        Utilizador utilizador = em.find(Utilizador.class, id);
        em.close();
        return utilizador;
    }

    public void updateUtilizador(Utilizador utilizador) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(utilizador);
        em.getTransaction().commit();
        em.close();
    }
    public void deleteUtilizador(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Utilizador utilizador = em.find(Utilizador.class, id);
        em.remove(utilizador);
        em.getTransaction().commit();
        em.close();
    }

    public boolean isUserAlreadyRegistered(String username, String password) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT COUNT(u) FROM Utilizador u WHERE u.username = :username AND u.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }

    public Utilizador findByName(String nome) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Utilizador u WHERE u.nome = :nome");
        query.setParameter("nome", nome);
        return (Utilizador) query.getSingleResult();
    }

    public Utilizador findClienteByName(String nome) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT u FROM Utilizador u WHERE u.nome = :nome AND u.idTipoUtilizador = 3");
        query.setParameter("nome", nome);
        return (Utilizador) query.getSingleResult();
    }

    public List<Utilizador> getClientesComPrefix(String prefix) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Utilizador> query = em.createQuery("SELECT u FROM Utilizador u WHERE u.nome LIKE :prefix AND  u.idTipoUtilizador = 3", Utilizador.class);
        query.setParameter("prefix", prefix + "%");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilizador> cq = cb.createQuery(Utilizador.class);
        Root<Utilizador> root = cq.from(Utilizador.class);
        cq.select(root);
        List<Utilizador> utilizadores = query.getResultList();
        em.close();
        return utilizadores;
    }

    public List<Utilizador> getFuncionarioComPrefix(String prefix) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Utilizador> query = em.createQuery("SELECT u FROM Utilizador u WHERE u.nome LIKE :prefix AND  u.idTipoUtilizador = 2", Utilizador.class);
        query.setParameter("prefix", prefix + "%");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilizador> cq = cb.createQuery(Utilizador.class);
        Root<Utilizador> root = cq.from(Utilizador.class);
        cq.select(root);
        List<Utilizador> utilizadores = query.getResultList();
        em.close();
        return utilizadores;
    }

    public List<Utilizador> obterUtilizadoresComEmbarcacao() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilizador> cq = cb.createQuery(Utilizador.class);
        Root<Embarcacao> embarcacao = cq.from(Embarcacao.class);
        Join<Embarcacao, Utilizador> utilizador = embarcacao.join("idUtilizador");
        cq.select(utilizador).distinct(true);
        return em.createQuery(cq).getResultList();
    }
}

