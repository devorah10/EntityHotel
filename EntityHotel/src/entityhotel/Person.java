/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityhotel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;




/**
 *
 * @author שרשבסקי בת שבע
 */
@Embeddable
public class Person implements Serializable {


  
    private int id;
    private String name;
    private int Tel;
 public Person() {
    }

    public Person(int id, String name, int Tel) {
        this.id = id;
        this.name = name;
        this.Tel = Tel;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTel() {
        return Tel;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }

   

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.Tel;
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
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.Tel != other.Tel) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

   

    
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", Tel=" + Tel + '}';
    }

   

}
