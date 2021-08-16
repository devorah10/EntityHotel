package entityhotel;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RoomControler {

    private String persistenceUnitName;
    private EntityManagerFactory emf;
    private EntityManager em;

    public RoomControler(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public void create(Room r) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
    }

    public Room read(int roomNum) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Room r = em.find(Room.class, roomNum);
        em.getTransaction().commit();
        em.close();
        return r;
    }

    public void update(Room r) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(r);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Room r) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Room foundRoom = em.getReference(Room.class, r.getNumRoom());
        em.remove(foundRoom);
        em.getTransaction().commit();
        em.close();
    }

    //Queries
    public List<Room> getAllRooms() {
        em.getTransaction().begin();
        List r = em.createQuery("SELECT r FROM Room r").getResultList();
        em.getTransaction().commit();
        em.close();
        return r;
    }

    public List<Room> getNotActiveRoom() {
        em.getTransaction().begin();
        List RoomNorActive=em.createQuery("SELECT r FROM Room r WHERE r.isActiv=:statuse").setParameter("statuse", false).getResultList();
         em.getTransaction().commit();
        em.close();
        return RoomNorActive;
    }
    public Room getRoomById(int NumRoom) {
        em = emf.createEntityManager();
     em.getTransaction().begin();
    Room roomsById=(Room)em.createQuery("SELECT r FROM Room r WHERE r.numRoom=:NumRoom").setParameter("NumRoom", NumRoom).getSingleResult();
    em.getTransaction().commit();
    em.close();
        return roomsById;
    }
    
}
