package persistence;

import business.GrantCondition;
import business.LoanFile;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LoanFileCRUD {
    public static void insertGrantConditionToDatabase(GrantCondition grantCondition) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.persist(grantCondition);
            transaction.commit();
            System.out.println("grantCondition" + grantCondition.getTypeName() + "Registered successfully");
        } finally {
            session.close();
        }
    }

    public static String searchGrantCondition(Integer customerNumber, String typeName, String duration, String amount) {
        int intDuration = Integer.parseInt(duration);
        int intAmount = Integer.parseInt(amount);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //SQLQuery query = session.createSQLQuery("SELECT * FROM grantcondition WHERE typeName= :typeName");
            Query query = session.createQuery("from grantcondition where typeName = :typeName");
            query.setParameter("typeName", typeName);
            System.out.println(query);
            List<?> result = query.list();
            if (result.size() == 0) {
                return "This Loan Type Undefined";
            } else {

                for (int i = 0; i < result.size(); i++) {
                    GrantCondition grantCondition = (GrantCondition) result.get(i);
                    int minDuration = Integer.parseInt(grantCondition.getMinDuration());
                    int maxDuration = Integer.parseInt(grantCondition.getMaxDuration());
                    int minAmount = Integer.parseInt(grantCondition.getMinAmount());
                    int maxAmount = Integer.parseInt(grantCondition.getMaxAmount());

                    if (minDuration <= intDuration && intDuration <= maxDuration && minAmount <= intAmount && intAmount <= maxAmount) {
                        LoanFile loanFile = new LoanFile(customerNumber, typeName, duration, amount, null);
                        return insertLoanFileToDatabase(loanFile);
                    }
                }
                return "This Amount and Duration Are not Compatible With Any Condition Registered For Type Name" + typeName + ".";
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return "error";
    }

    public static String insertLoanFileToDatabase(LoanFile loanFile) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.persist(loanFile);
            transaction.commit();
            return "Loan File Registered Successfully For This Customer" + loanFile.getCustomerNumber();
        } finally {
            session.close();
        }
    }
}
