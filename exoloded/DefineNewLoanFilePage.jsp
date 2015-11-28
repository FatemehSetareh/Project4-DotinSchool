<%--
  Created by IntelliJ IDEA.
  User: DOTIN SCHOOL 4
  Date: 11/23/2015
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="Theme.css" media="screen"/>
    <title></title>
</head>

<body>

<%
    Session thisSession;
    List data;
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");

    SessionFactory sessionFactory = configuration.buildSessionFactory();
    thisSession = sessionFactory.openSession();
    Transaction transaction = thisSession.beginTransaction();
    try {
        String sql = ("SELECT typeName FROM loantype ");
        SQLQuery query = thisSession.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        data = query.list();
%>
<h1>Dotin Internet Bank</h1>

<h3>Real Customer</h3>

<p>Add A New Loan Type </p>

<form action="/DefineNewLoanFileServlet" method="get">
    <input type="text" value="Customer Number" name="customerNumber"
           onfocus="if(this.value == 'Customer Number') { this.value = ''; }">
    <br>
    <input type="submit" value="Retrieve">
    <br>
    <select>
        <% for (int i = 0; i < data.size(); i++) { %>
        <option><%= data.get(i)%>
        </option>
        <% } %>
        <% } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            thisSession.close();
        }%>
    </select>
    <br>
    <input type="text" value="Duration" name="duration" onfocus="if(this.value == 'Duration') { this.value = ''; }">
    <br>
    <input type="text" value="Amount" name="amount" onfocus="if(this.value == 'Amount') { this.value = ''; }">
    <br>
    <input type="submit" value="Enter">
</form>


</body>
</html>
