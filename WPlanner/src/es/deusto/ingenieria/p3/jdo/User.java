package es.deusto.ingenieria.p3.jdo;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
class User {
    private String login;
    private String password;
    private String fullName;
    //private Set<Account> accounts = new HashSet<>();
    private Set<Address> addresses;

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        addresses = new HashSet();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    //public void addAccount(Account account) {
      //  accounts.add(account);
    //}

    //public void removeAccount(Account account) {
      //  accounts.remove(account);
    //}

    //public Set<Account> getAccounts() {
      //  return accounts;
    //}

    //public int getNumberOfAccounts() {
        //return accounts.size();
    //}

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
    }

    public void removeUserFromAddresses() {
        for (Address a: addresses){
            a.removeUser(this);
        }
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public int getNumberOfAddresses() {
        return addresses.size();
    }

    public String getFullName() {
        return this.fullName;
    }
}