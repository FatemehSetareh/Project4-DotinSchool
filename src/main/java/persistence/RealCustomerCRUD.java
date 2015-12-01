package persistence;

import business.RealCustomer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RealCustomerCRUD {
    public static String insertRealCustomerToDatabase(RealCustomer realCustomer) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.persist(realCustomer);
            transaction.commit();
            return ("Real Customer "
                    + realCustomer.getFirstName()
                    + " "
                    + realCustomer.getLastName()
                    + " Registered Successfully."
                    + "<br>"
                    + "<br>");
        } finally {
            session.close();
        }
    }

    public static boolean realCustomerCheckExistence(Integer nationalCode) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            SQLQuery query = session.createSQLQuery("SELECT * FROM realcustomer WHERE nationalCode= :nationalCode");
            query.setParameter("nationalCode", nationalCode);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List data = query.list();
            transaction.commit();
            if (data.size() == 0) {
                return true;
            } else {
                return false;
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    public static String searchCustomerNumber(Integer customerNumber) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM business.RealCustomer WHERE customerNumber= :customerNumber");
            query.setParameter("customerNumber", customerNumber);
            List result = query.list();

            if (result.size() == 0) {
                return "This Customer Number Is Not In Our Database.";
            } else {
                for (Object aResult : result) {
                    RealCustomer realCustomer = (RealCustomer) aResult;
                    return realCustomer.getFirstName() + "," + realCustomer.getLastName() + "," + customerNumber.toString();
                }
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return "error";
    }
}
