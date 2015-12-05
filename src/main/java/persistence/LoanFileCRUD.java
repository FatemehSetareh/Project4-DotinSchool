package persistence;

import business.GrantCondition;
import business.LoanFile;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class LoanFileCRUD {
    static Logger logger;

    public LoanFileCRUD() {
       // PropertyConfigurator.configure("log4j.properties");
        logger = Logger.getLogger(LoanFileCRUD.class.getName());
    }

    public static String insertGrantConditionToDatabase(ArrayList<GrantCondition> grantConditionObjectsArray) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = null;
        String Msg = "";
        for (GrantCondition grantCondition : grantConditionObjectsArray) {
            try {
                session = sessionFactory.openSession();
                Transaction transaction = session.beginTransaction();
                session.persist(grantCondition);
                transaction.commit();
                Msg += "grantCondition: " + grantCondition.getConditionName() + " Registered successfully" + "<br>";
            } finally {
                if (session != null) {
                    session.close();
                }
            }
        }
        return Msg;
    }

    public static String searchGrantCondition(Integer customerNumber, String typeName, String duration, String amount) {
        Long intDuration = Long.parseLong(duration);
        Long intAmount = Long.parseLong(amount);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println(typeName + " " + customerNumber + " " + duration + " " + amount);
        try {
            Query query = session.createQuery("FROM business.GrantCondition where typeName = :typeName");
            query.setParameter("typeName", typeName);
            List result = query.list();
            if (result.size() == 0) {
                return "This Loan Type Undefined";
            } else {
                for (Object aResult : result) {
                    GrantCondition grantCondition = (GrantCondition) aResult;
                    String conditionName = grantCondition.getConditionName();
                    System.out.println(conditionName);
                    Long minDuration = Long.parseLong((grantCondition.getMinDuration()));
                    System.out.println(minDuration);
                    Long maxDuration = Long.parseLong(grantCondition.getMaxDuration());
                    System.out.println(maxDuration);
                    Long minAmount = Long.parseLong(grantCondition.getMinAmount());
                    System.out.println(minAmount);
                    Long maxAmount = Long.parseLong(grantCondition.getMaxAmount());
                    System.out.println(maxAmount);

                    if (minDuration <= intDuration && intDuration <= maxDuration && minAmount <= intAmount && intAmount <= maxAmount) {
                        LoanFile loanFile = new LoanFile(customerNumber, typeName, duration, amount, null);
                        //logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Matched with this grant condition.");
                        return insertLoanFileToDatabase(loanFile);
                    }
                }
                logger.error("Does Not Match With Any Condition.");
                return "This Amount and Duration Are not Compatible With Any Condition Registered For Type Name: " + typeName + ".";
            }
        } finally {
            session.close();
        }
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
            //logger.info("Inserted to db");
            return "Loan File Registered Successfully For This Customer" + loanFile.getCustomerNumber();
        } finally {
            session.close();
        }
    }
}
