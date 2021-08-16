/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityhotel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author שרשבסקי בת שבע
 */
@Entity
@Table(name="Room")
@NamedQuery(name="getNotActiveRoom",query="SELECT r FROM Room r WHERE r.numRoom=:numRoom")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numRoom;
    private int floor;
    private int level;
    public static int startPrice;
    private boolean isActiv;

   

    @Override
    public String toString() {
        return "Room{" + ", numRoom=" + numRoom + ", floor=" + floor + ", level=" + level + ", isActiv=" + isActiv + '}';
    }

    public Room() {
    }

    public Room( int floor, int level, boolean isActiv) {
        
        this.floor = floor;
        this.level = level;
        this.isActiv = isActiv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.numRoom;
        hash = 29 * hash + this.floor;
        hash = 29 * hash + this.level;
        hash = 29 * hash + (this.isActiv ? 1 : 0);
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
        final Room other = (Room) obj;
        if (this.numRoom != other.numRoom) {
            return false;
        }
        if (this.floor != other.floor) {
            return false;
        }
        if (this.level != other.level) {
            return false;
        }
        if (this.isActiv != other.isActiv) {
            return false;
        }
        return true;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static int getStartPrice() {
        return startPrice;
    }

    public static void setStartPrice(int startPrice) {
        Room.startPrice = startPrice;
    }

    public boolean isIsActiv() {
        return isActiv;
    }

    public void setIsActiv(boolean isActiv) {
        this.isActiv = isActiv;
    }

   

}
