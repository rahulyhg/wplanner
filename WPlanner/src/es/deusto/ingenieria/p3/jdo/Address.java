/**
 * Created by Susana on 28/11/2014.
 */
package es.deusto.ingenieria.p3.jdo;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Join;

@PersistenceCapable
class Address {
    private String street;
    private String city;
    private String country;
    private String postcode;
    private Set<User> users = new HashSet();

    public Address(String street, String city, String country, String postcode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public Set<User> getUsers() {
        return users;
    }

    public int getNumberOfUsers() {
        return users.size();
    }

    public String toString() {
        return street + " - " + city + " (" + postcode + ") [" + country + "]";
    }
}