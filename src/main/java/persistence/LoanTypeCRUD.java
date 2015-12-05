package persistence;

import business.LoanType;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LoanTypeCRUD {

    public static String insertLoanTypeToDatabase(LoanType loanType) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.persist(loanType);
            transaction.commit();
            return "Ok";
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

    public static List searchDefinedLoanTypes() {
        Session session = null;
        List result;
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        try {
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();

            SQLQuery query = session.createSQLQuery("SELECT typeName FROM loantype ");
            result = query.list();
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
