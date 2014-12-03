/**
 * Created by Susana on 28/11/2014.
 */
package es.deusto.ingenieria.p3.jdo;

import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

class main {
    public static void main(String args[]) {
        System.out.println("Datanucleus + JDO example");
        System.out.println("=========================");

        //Create objects
        User user1= new User("cortazar", "sd22222", "Rebeca Cortazar");
        User user2 = new User("carballedo", "sd11111", "Roberto Carballedo");

        Address address1 = new Address("Avenida de las Universidades", "Bilbao", "SPAIN", "48007");
        Address address2 = new Address("Antonio Trueba", "Sestao", "SPAIN", "48910");
        Address address3 = new Address("Lehendakari Aguirre", "Bilbao",	"SPAIN", "48014");

        //Account account1 = new Account("KutxaBank", 153.19d, address1);
        //Account account2 = new Account("Banco Santander", 47.25d, address2);
        //Account account3 = new Account("Caja Laboral", 295.32d, address1);
        //Account account4 = new Account("La Caixa", 300.00d, address3);

        //user1.addAccount(account1);
        //account1.setUser(user1);
        //user1.addAccount(account2);
        //account2.setUser(user1);
        //user1.addAccount(account3);
        //account3.setUser(user1);

        user1.addAddress(address1);
        address1.addUser(user1);
        user1.addAddress(address2);
        address2.addUser(user1);

        //user2.addAccount(account4);
        //account4.setUser(user2);

        user2.addAddress(address1);
        address1.addUser(user2);
        user2.addAddress(address3);
        address3.addUser(user2);

        // Load Persistence Manager Factory
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("exampleJDO");
        // Persistence Manager
        PersistenceManager pm = null;
        //Transaction to group DB opertaions
        Transaction tx = null;

        try {
            System.out.println("- Store objects in the DB");
            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();
            //Obtain the current transaction
            tx = pm.currentTransaction();
            //Start the transaction
            tx.begin();

            pm.makePersistent(user1);
            pm.makePersistent(user2);

            //End the transaction
            tx.commit();
            System.out.println("  * Objects has been stored!");
            System.out.println("- Transferring $100");
            //System.out.println("    - " + account1.getBankName() + "($ " + account1.getBalance() + ")");
            //System.out.println("    + " + account2.getBankName() + "($ " + account2.getBalance() + ")");
            //account1.debit(100);
            //account2.credit(100);
            System.out.println("  * Money transferred!");
            //System.out.println("    - " + account1.getBankName() + "($ " + account1.getBalance() + ")");
            //System.out.println("    + " + account2.getBankName() + "($ " + account2.getBalance() + ")");
        } catch (Exception ex) {
            System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            if (pm != null && !pm.isClosed()) {
                pm.close();
            }
        }

        try {
            System.out.println("- Retreiving all the accounts using an 'Extent'...");
            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();
            //Obtain the current transaction
            tx = pm.currentTransaction();
            //Start the transaction
            tx.begin();

            //Extent<Account> extent = pm.getExtent(Account.class, true);

            //for (Account account : extent) {
            //    System.out.println("  -> " + account);
            //}

            //End the transaction
            tx.commit();
        } catch (Exception ex) {
            System.err.println(" $ Error retreiving accounts using an 'Extent': " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            if (pm != null && !pm.isClosed()) {
                pm.close();
            }
        }

        try {
            System.out.println("- Retreiving accounts with balace > 200.0 using a 'Query'...");
            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();
            //Obtain the current transaction
            tx = pm.currentTransaction();
            //Start the transaction
            tx.begin();

            //Query query = pm.newQuery(Account.class);
            //query.setFilter("balance > 200.0");

            //@SuppressWarnings("unchecked")
            //List<Account> accounts = (List<Account>) query.execute();

            //for (Account account : accounts) {
              //  System.out.println("  -> " + account.getUser().getFullName() + " - " + account.getBankName());
            //}

            //End the transaction
            tx.commit();
        } catch (Exception ex) {
            System.err.println(" $ Error retreiving accounts using a 'Query': " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            if (pm != null && !pm.isClosed()) {
                pm.close();
            }
        }

        try {
            System.out.println("- Deleting 'User->Address' relation...");
            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();
            //Obtain the current transaction
            tx = pm.currentTransaction();
            //Start the transaction
            tx.begin();

            Query query = pm.newQuery(User.class);
            @SuppressWarnings("unchecked")
            List<User> users = (List<User>) query.execute();

            for (User user : users) {
                System.out.println("  -> Retrieved user: " + user.getFullName());
                System.out.println("     + Removing user from the addresses ... ");
                user.removeUserFromAddresses();
            }

            //End the transaction
            tx.commit();
        } catch (Exception ex) {
            System.err.println(" $ Error deleting 'User->Address' relation: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            if (pm != null && !pm.isClosed()) {
                pm.close();
            }
        }

        try {
            System.out.println("- Cleaning the DB...");
            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();
            //Obtain the current transaction
            tx = pm.currentTransaction();
            //Start the transaction
            tx.begin();

            //Delete accounts from DB
           // Query query1 = pm.newQuery(Account.class);
            //System.out.println(" * '" + query1.deletePersistentAll() + "' accounts deleted from the DB.");
            //Delete users from DB
            Query query2 = pm.newQuery(User.class);
            System.out.println(" * '" + query2.deletePersistentAll() + "' users deleted from the DB.");
            //Delete addresses from DB
            Query query3 = pm.newQuery(Address.class);
            System.out.println(" * '" + query3.deletePersistentAll() + "' addresses deleted from the DB.");

            //End the transaction
            tx.commit();
        } catch (Exception ex) {
            System.err.println(" $ Error cleaning the DB: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            if (pm != null && !pm.isClosed()) {
                pm.close();
            }
        }

        System.out.println("End of the Datanucleus + JDO example");
        System.out.println("====================================");
    }
}