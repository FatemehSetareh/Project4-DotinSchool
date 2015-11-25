package persistence;

import business.LoanType;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Crud {
    private static String loanTypeInsertionMsg;

    public Crud() {
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
                    +"<br>"
                    +"<br>"
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

    public static String getLoanTypeInsertionMsg() {
        return loanTypeInsertionMsg;
    }

    public static void setLoanTypeInsertionMsg(String loanTypeInsertionMsg) {
        Crud.loanTypeInsertionMsg = loanTypeInsertionMsg;
    }
}
