/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityhotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 *
 * 3.* @author שרשבסקי בת שבע
 */
public class EntityHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Room r1 = new Room(3, 5, true);
        Room r2 = new Room(3, 5, false);
        Room r3 = new Room(3, 5, true);
        RoomControler rm = new RoomControler("EntityHotelPU");
        rm.create(r1);
        rm.create(r2);
        rm.create(r3);

        Person p = new Person(123456, "Mosh", 025371662);
        Person p1 = new Person(222233, "Shimon", 0525371662);
        Guest g = new Guest(154, 3, p);
        Guest g1 = new Guest(200, 3, p1);
        Order o1 = new Order(123456789, new Date(), 4, g);
        Order o2 = new Order(123451111, new Date(), 6, g1);
        OrderControler oc = new OrderControler("EntityHotelPU");
        o1.addRoom(r3);
        o1.addRoom(r2);
        
        oc.create(o1);
        o2.addRoom(r1);
        oc.create(o2);
        System.out.println(rm.read(1));
        System.out.println(oc.read(123456789));
        rm.update( new Room(2, 8, true));
        oc.delete(o2);
        
         Room w= rm.getRoomById(1);
         System.out.println(w);
    }

}
