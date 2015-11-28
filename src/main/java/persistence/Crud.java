package persistence;

import business.GrantCondition;
import business.LoanType;
import business.RealCustomer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Crud {
    private static String loanTypeInsertionMsg;
    private static String grantConditionInsertionMsg;
    private static String searchCustomerNumberResult;

    public Crud() {
    }

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
            String sql = ("SELECT * FROM realcustomer WHERE nationalCode=" + nationalCode);
            SQLQuery query = session.createSQLQuery(sql);
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

    public static void insertLoanTypeToDatabase(LoanType loanType) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.persist(loanType);
            transaction.commit();
            setLoanTypeInsertionMsg("Loan Type "
                    + loanType.getTypeName()
                    + " Registered Successfully."
                    + "<br>"
                    + "<br>"
                    + "<form><input type=\"button\" value=\"Define A New Loan File\""
                    + " onclick=\"location.href='DefineNewGrantConditionPage.jsp';\"></form>");
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
            String sql = ("SELECT * FROM loantype WHERE typeName= '" + loanType.getTypeName() + "'");
            SQLQuery query = session.createSQLQuery(sql);
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
        Transaction transaction = session.beginTransaction();
        try {
            String sql = ("SELECT firstName,lastName FROM realcustomer WHERE customerNumber=" + customerNumber);
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List data = query.list();
            if (data.size() == 0) {
                return "This Customer Number Is Not In Our Database.";
            } else {
                return data.get(0).toString();
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

    public static String getLoanTypeInsertionMsg() {
        return loanTypeInsertionMsg;
    }

    public static void setLoanTypeInsertionMsg(String loanTypeInsertionMsg) {
        Crud.loanTypeInsertionMsg = loanTypeInsertionMsg;
    }

    public static String getGrantConditionInsertionMsg() {
        return grantConditionInsertionMsg;
    }

    public static void setGrantConditionInsertionMsg(String grantConditionInsertionMsg) {
        Crud.grantConditionInsertionMsg = grantConditionInsertionMsg;
    }

    public static String getSearchCustomerNumberResult() {
        return searchCustomerNumberResult;
    }

    public static void setSearchCustomerNumberResult(String searchCustomerNumberResult) {
        Crud.searchCustomerNumberResult = searchCustomerNumberResult;
    }
}
