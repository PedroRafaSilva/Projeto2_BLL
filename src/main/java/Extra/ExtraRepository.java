package Extra;

import Main.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class ExtraRepository {

    EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

    public List<Extra> getAllExtras() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Extra> cq = cb.createQuery(Extra.class);
        Root<Extra> root = cq.from(Extra.class);
        cq.select(root);
        TypedQuery<Extra> query = em.createQuery(cq);
        List<Extra> orders = query.getResultList();
        em.close();
        return orders;
    }

    public void createExtra(Extra extra) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(extra);
        em.getTransaction().commit();
        em.close();
    }

    public Extra getExtraById(int id) {
        EntityManager em = emf.createEntityManager();
        Extra extra = em.find(Extra.class, id);
        em.close();
        return extra;
    }

    public void updateExtra(Extra extra) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(extra);
        em.getTransaction().commit();
        em.close();
    }
    public void deleteExtra(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Extra extra = em.find(Extra.class, id);
        em.remove(extra);
        em.getTransaction().commit();
        em.close();
    }
}


