package entityhotel;


import entityhotel.Order;
import entityhotel.Room;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author שרשבסקי בת שבע
 */
public class OrderControler {

    private String persistenceUnitName;
    private EntityManagerFactory emf;
    private EntityManager em;

    public OrderControler(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void create(Order o) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        em.close();
    }

    public Order read(int OrderNum) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Order o = em.find(Order.class, OrderNum);
        em.getTransaction().commit();
        em.close();
        return o;
    }
    

    public void update(Order o) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(o);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Order o) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Order foundOrder = em.getReference(Order.class, o.getId());
        em.remove(foundOrder);
        em.getTransaction().commit();
        em.close();
    }

    //Queries
    public List<Order> getAllOrders() {
        em.getTransaction().begin();
        List o = em.createQuery("SELECT o FROM Order o").getResultList();
        em.getTransaction().commit();
        em.close();
        return o;
    }

    public List<Order> getOrderById(int NumOrder) {
        em.getTransaction().begin();
        List OrdersById = em.createNamedQuery("getOrderById").setParameter("id", NumOrder).getResultList();
        em.getTransaction().commit();
        em.close();
        return OrdersById;
    }

   

}
