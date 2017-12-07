package edu.nelson.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HibernateRun {
    private List<User> users;
    private HibernateConfig theHibernateUtility;

    public HibernateRun(){
        theHibernateUtility = new HibernateConfig();
    }

    public static void main(String[] args){

        HibernateRun TestRun = new HibernateRun();
        TestRun.addNewDrivers();
        TestRun.showAllDrivers();
        TestRun.modifyDriver();
        TestRun.addVehicle();
        TestRun.deleteAddedDrivers();

    }

    /*
     * show how to add records to the database
     */
    private void addNewDrivers() {
        Session session = theHibernateUtility.getCurrentSession();
        /*
         * all database interactions in Hibernate are required to be inside a transaction.
         */
        Transaction transaction = session.beginTransaction();
        /*
         * create some Driver instances.
         */
        Driver genericDriver = new Driver();
        genericDriver.setDname("aName");
        genericDriver.setDstate("aState");

        Driver morganFreeman = new Driver();
        morganFreeman.setDname("Morgan Freeman");
        morganFreeman.setDstate("California");
        
        Driver willNelson = new Driver();
        willNelson.setDname("Will Nelson");
        willNelson.setDstate("California");

        /*
         * save each instance as a record in the database
         */
        session.save(genericDriver);
        session.save(morganFreeman);
        session.save(willNelson);
        transaction.commit();
        /*
         * prove that the User instances were added to the database and that
         * the instances were each updated with a database generated id.
         */
        System.out.println("genericDriver generated ID is: " + genericDriver.getId());
        System.out.println("morganFreeman generated ID is: " + morganFreeman.getId());
        System.out.println("willNelson generated ID is: " + willNelson.getID());
    }

    /*
     * show how to get a collection of type List containing all of the records in the app_user table
     */
    private void showAllDrivers() {
        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        /*
         * execute a HQL query against the database.  HQL is NOT SQL.  It is object based.
         */
        Query allDriversQuery = session.createQuery("select u from Driver as u order by u.id");
        /*
         * get a list of User instances based on what was found in the database tables.
         */
        drivers = allDriversQuery.list();
        System.out.println("num drivers: "+drivers.size());
        /*
         * iterate over each User instance returned by the query and found in the list.
         */
        Iterator<Driver> iter = drivers.iterator();;
        while(iter.hasNext()) {
            Driver element = iter.next();
            System.out.println(element.toString());
            System.out.println("num of phone numbers: "+element.getVehicles().size());
        }
        transaction.commit();
    }

    /*
     * show how to modify a database record
     */
    private void modifyDriver() {

        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        /*
         * get a single User instance from the database.
         */
        Query singleDriverQuery = session.createQuery("select u from Driver as u where u.dname='Morgan Freeman'");
        Driver morganFreemanr = (Driver)singleDriverQuery.uniqueResult();
        /*
         * change the user name for the Java instance
         */
        morganFreeman.setUname("theNarrator");
        /*
         * call the session merge method for the User instance in question.  This tells the database that the instance is ready to be permanently stored.
         */
        session.merge(morganFreeman);

        /*
         * call the transaction commit method.  This tells the database that the changes are ready to be permanently stored.
         */
        transaction.commit();
        /*
         * permanently store the changes into the database tables.
         */
        showAllDrivers();
    }

    private void addVehicle() {
        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        /*
         * get two User instances from the database using HQL.  This is NOT SQL.  It is object based.
         */
        Query narratorQuery = session.createQuery("select u from Driver as u where u.dname='theNarrator'");
        Driver narratorDriver = (Driver)narratorQuery.uniqueResult();

        Query aNameQuery = session.createQuery("select u from Driver as u where u.dname='aName'");
        Driver aNameDriver = (Driver)aNameQuery.uniqueResult();

        /*
         * create a PhoneNumber instance
         */
        Vehicle car1 = new Vehicle();
        car1.setVehicle(1995,"Toyota","Tercel");

       /*
        * add the vehicle to the narratorDriver
        */

        Set<Vehicles> narratorVehicles = narratorDriver.getVehicles();
        narratorVehicles.add(car1);
       /*
        * set the single vehicle to be used by more than one Driver
        */
        Set<Vehicles> aNameVehicles = aNameDriver.getVehicles();
        aNameVehicles.add(car1);
       /*
        * inform the database that the vehicle should be ready for permanent storage.
        */
        session.save(car1);
       /*
        * inform the database that the modified Driver instances should be ready for permanent storage.
        */
        session.merge(narratorDriver);
        session.merge(aNameDriver);
       /*
        * permanently store the changes into the database tables.
        */
        transaction.commit();
       /*
        * show that the database was updated by printing out all of the Driver instances created by a HQL query
        */
        showAllDrivers();
    }
    private void deleteAddedDrivers() {
        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        int numDrivers = drivers.size();
        System.out.println("number of drivers is: " + numDrivers);
        for(int i = 0; i < numDrivers; i++){
            System.out.println("deleting driver "+drivers.get(i).getDname());
            session.delete(drivers.get(i));
        }
        transaction.commit();
        /*
          * at this point the records have been removed from the database but still exist in our class list attribute.
          * Do not store lists retrieved from the database since they will be out of synch with the database table from which they come.
          * This example shows that you should not store retrieved lists.
          */
        System.out.println(drivers);
        drivers.clear();
        /*
          * now the Java instances are also gone and the database is back to its original state so the example application can be run again.
          */
        System.out.println(drivers);
    }
}
