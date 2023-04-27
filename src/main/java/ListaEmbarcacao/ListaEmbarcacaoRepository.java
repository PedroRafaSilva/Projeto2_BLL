package ListaEmbarcacao;

import jakarta.persistence .*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class ListaEmbarcacaoRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

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
        ListaEmbarcacao listaEmbarcacao = em.find(ListaEmbarcacao.class, new ListaEmbarcacaoPK(id, id2));
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
        ListaEmbarcacao listaEmbarcacao = em.find(ListaEmbarcacao.class, new ListaEmbarcacaoPK(id, id2));
        em.remove(listaEmbarcacao);
        em.getTransaction().commit();
        em.close();
    }

}

