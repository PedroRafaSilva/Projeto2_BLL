package Fatura;

import Agendamento.Agendamento;
import Main.EntityManagerFactorySingleton;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.List;

public class FaturaRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public List<Fatura> getAllFaturas() {
        EntityManager em = emf.createEntityManager();
        int month = LocalDate.now().getMonthValue();
        int year = LocalDate.now().getYear();
        TypedQuery<Fatura> query = em.createQuery("SELECT f FROM Fatura f WHERE EXTRACT(MONTH FROM f.datacriacao) < :month AND EXTRACT(YEAR FROM f.datacriacao) <= :year", Fatura.class);
        query.setParameter("year", year);
        query.setParameter("month", month);
        List<Fatura> faturas = query.getResultList();
        em.close();
        return faturas;
    }

    public void createFatura(Fatura fatura) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(fatura);
        em.getTransaction().commit();
        em.close();
    }

    public Fatura getFaturaById(int id) {
        EntityManager em = emf.createEntityManager();
        Fatura fatura = em.find(Fatura.class, id);
        em.close();
        return fatura;
    }

    public void updateFatura(Fatura fatura) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(fatura);
        em.getTransaction().commit();
        em.close();
    }
    public void deleteFatura(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Fatura fatura = em.find(Fatura.class, id);
        em.remove(fatura);
        em.getTransaction().commit();
        em.close();
    }

    public Fatura getFaturaOfMothFromCliente(int idCliente, int month){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Fatura> query = em.createQuery("SELECT f FROM Fatura f WHERE EXTRACT(MONTH FROM f.datacriacao) = :month AND f.idutilizador = :idCliente", Fatura.class);
        query.setParameter("idCliente", idCliente);
        query.setParameter("month", month);
        Fatura fatura = query.getSingleResult();
        em.close();
        return fatura;
    }

    public boolean checkFaturaOfMothFromCliente(int idCliente, int month){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT COUNT(*) FROM Fatura f WHERE EXTRACT(MONTH FROM f.datacriacao) = :month AND f.idutilizador = :idCliente", Fatura.class);
        query.setParameter("idCliente", idCliente);
        query.setParameter("month", month);
        Long count = (Long) query.getSingleResult();
        em.close();
        return count > 0;
    }
}


