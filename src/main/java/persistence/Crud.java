package persistence;

import business.GrantCondition;
import business.LoanFile;
import business.LoanType;
import business.RealCustomer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Crud {

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
            List result = query.list();
            transaction.commit();
            if (result.size() == 0) {
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

    public static String insertLoanTypeToDatabase(LoanType loanType) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.persist(loanType);
            transaction.commit();
            return ("Loan Type "
                    + loanType.getTypeName()
                    + " Registered Successfully."
                    + "<br>"
                    + "<br>"
                    + "<form>"
//                    + "<input type=\"hidden\" value=\"" + loanType + "\"\" name=\"typeName\">"
                    + "<input type=\"button\" value=\"Define A New Loan File\""
                    + " onclick=\"location.href='DefineNewGrantConditionPage.jsp?typeName=" + loanType.getTypeName() + "';\">"
                    + "</form>");
        } finally {
            session.close();
        }
    }

    public static boolean loanTypeCheckExistence(LoanType loanType) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            SQLQuery query = session.createSQLQuery("SELECT * FROM loantype WHERE typeName= :typeName");
            query.setParameter("typeName", loanType.getTypeName());
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List result = query.list();
            transaction.commit();
            if (result.size() == 0) {
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
        Transaction transaction = session.beginTransaction();
        try {
            SQLQuery query = session.createSQLQuery("SELECT firstName,lastName FROM realcustomer WHERE customerNumber= :customerNumber");
            query.setParameter("customerNumber", customerNumber);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List result = query.list();

            if (result.size() == 0) {
                return "This Customer Number Is Not In Our Database.";
            } else {
                return result.get(0).toString();
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return "error";
    }

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
        Transaction transaction = session.beginTransaction();
        try {
            SQLQuery query = session.createSQLQuery("SELECT * FROM grantcondition WHERE typeName= :typeName");
            query.setParameter("typeName", typeName);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List<GrantCondition> result = query.list();
            if (result.size() == 0) {
                return "This Loan Type Undefined";
            } else {
                for (GrantCondition grantCondition : result) {
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
