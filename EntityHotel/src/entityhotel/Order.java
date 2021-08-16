/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityhotel;

import java.io.Serializable;
import static java.lang.reflect.Array.set;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.HashSet;

/**
 *
 * @author שרשבסקי בת שבע
 */
@Entity
@Table(name = "orders")
@NamedQuery(name="getOrderById",query="SELECT o FROM Order o WHERE o.id=:id")
public class Order implements Serializable {

    @Id

    private int id;
    @OneToMany
    private Set<Room> rooms;
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    private int numDays;
    @OneToOne(cascade = CascadeType.ALL)
    private Guest g;

    public Order(int id, Date orderDate, int numDays, Guest g) {
        this.id = id;
        this.rooms = rooms;
        this.orderDate = orderDate;
        this.numDays = numDays;
        this.g = g;
        this.rooms=new HashSet<Room>();
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.rooms);
        hash = 11 * hash + Objects.hashCode(this.orderDate);
        hash = 11 * hash + this.numDays;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.numDays != other.numDays) {
            return false;
        }
        if (!Objects.equals(this.rooms, other.rooms)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.g, other.g)) {
            return false;
        }
        return true;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order() {
          this.rooms=new HashSet<Room>();
    }

    public Guest getG() {
        return g;
    }

    public void setG(Guest g) {
        this.g = g;
    }

    public Set<Room> getR() {
        return rooms;
    }

    public void setR(Set<Room> r) {
        this.rooms = r;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(int numDays) {
        this.numDays = numDays;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", rooms=" + rooms + ", orderDate=" + orderDate + ", numDays=" + numDays + ", g=" + g + '}';
    }
public boolean addRoom(Room e)
{
    return rooms.add(e);
       
}
    

   

}
