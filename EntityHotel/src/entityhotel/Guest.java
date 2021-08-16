/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityhotel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author שרשבסקי בת שבע
 */
@Entity
@Table(name="guest")

public class Guest  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numGust;
    private int NumVisit;
    @Embedded
     private Person p;

    public Guest() {
    }

    public Guest(int numGust, int NumVisit, Person p) {
        this.numGust = numGust;
        this.NumVisit = NumVisit;
        this.p = p;
    }

   

    public int getNumVisit() {
        return NumVisit;
    }

    public void setNumVisit(int NumVisit) {
        this.NumVisit = NumVisit;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public int getId() {
        return numGust;
    }

    

   
    

    @Override
    public String toString() {
        return "Guest{" + "id=" + numGust + ", NumVisit=" + NumVisit + ", p=" + p + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.numGust;
        hash = 29 * hash + this.NumVisit;
        hash = 29 * hash + Objects.hashCode(this.p);
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
        final Guest other = (Guest) obj;
        if (this.numGust != other.numGust) {
            return false;
        }
        if (this.NumVisit != other.NumVisit) {
            return false;
        }
        if (!Objects.equals(this.p, other.p)) {
            return false;
        }
        return true;
    }

   
   
    
}
