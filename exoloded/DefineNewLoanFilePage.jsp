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
<%@ page import="business.LoanType" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="Theme.css" media="screen"/>

    <script type="text/javascript">
        function showUser() {
            var customerNumber = document.getElementById("customerNumber").value;
            var xmlHttp;
            if (customerNumber == "") {
                document.getElementById("dvShowUser").innerHTML = "Please Enter A Customer Number...";
            } else {
                if (window.XMLHttpRequest) {
                    // code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlHttp = new XMLHttpRequest();
                } else {
                    // code for IE6, IE5
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                        document.getElementById("dvShowUser").innerHTML = xmlHttp.responseText;
                    }
                };
                xmlHttp.open("GET", "/SearchCustomerNumberServlet?customerNumber=" + customerNumber, true);
                xmlHttp.send();
            }
        }
    </script>

</head>

<body>

<%
    Session thisSession;
    List result;
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");

    SessionFactory sessionFactory = configuration.buildSessionFactory();
    thisSession = sessionFactory.openSession();
    Transaction transaction = thisSession.beginTransaction();
    try {
        SQLQuery query = thisSession.createSQLQuery("SELECT typeName FROM loantype ");
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        result = query.list();
        transaction.commit();
%>
<h1>Dotin Internet Bank</h1>

<h3>Real Customer</h3>

<p>Add A New Loan Type </p>

<form onsubmit="showUser()">
    <input type="text" value="Customer Number" name="customerNumber"
           onfocus="if(this.value == 'Customer Number') { this.value = ''; }" required>
    <br>
    <input type="submit" value="Retrieve">
</form>

<form action="/DefineNewLoanFileServlet" method="get">
    <select name="typeName" id="typeName" required>
        <option value=""></option>
        <% for (Object typeName : result) { %>
        <option>
            <%= typeName%>
        </option>
        <% } %>
        <%
         } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            thisSession.close();
        }
        %>
    </select>
    <br>
    <input type="text" value="Duration" name="duration" onfocus="if(this.value == 'Duration') { this.value = ''; }"
           required>
    <br>
    <input type="text" value="Amount" name="amount" onfocus="if(this.value == 'Amount') { this.value = ''; }"
           required>
    <br>
    <input type="submit" value="Enter">
</form>
<div id="dvShowUser"></div>

</body>
</html>
