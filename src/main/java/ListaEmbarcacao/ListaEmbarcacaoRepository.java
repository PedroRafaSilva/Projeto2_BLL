package ListaEmbarcacao;

import Main.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ListaEmbarcacaoRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public List<ListaEmbarcacao> getAllListaEmbarcacaos() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ListaEmbarcacao> cq = cb.createQuery(ListaEmbarcacao.class);
        Root<ListaEmbarcacao> root = cq.from(ListaEmbarcacao.class);
        cq.select(root);
        TypedQuery<ListaEmbarcacao> query = em.createQuery(cq);
        List<ListaEmbarcacao> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createListaEmbarcacao(ListaEmbarcacao listaEmbarcacao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(listaEmbarcacao);
        em.getTransaction().commit();
        em.close();
    }

    public ListaEmbarcacao getListaEmbarcacaoById(int id, int id2) {
        EntityManager em = emf.createEntityManager();
        ListaEmbarcacaoPK pk = new ListaEmbarcacaoPK();
        pk.setIdembarcacao(id);
        pk.setIdfatura(id2);
        ListaEmbarcacao listaEmbarcacao = em.find(ListaEmbarcacao.class, pk);
        em.close();
        return listaEmbarcacao;
    }

    public void updateListaEmbarcacao(ListaEmbarcacao listaEmbarcacao) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(listaEmbarcacao);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteListaEmbarcacao(int id, int id2) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ListaEmbarcacaoPK pk = new ListaEmbarcacaoPK();
        pk.setIdembarcacao(id);
        pk.setIdfatura(id2);
        ListaEmbarcacao listaEmbarcacao = em.find(ListaEmbarcacao.class, pk);
        em.remove(listaEmbarcacao);
        em.getTransaction().commit();
        em.close();
    }

}

