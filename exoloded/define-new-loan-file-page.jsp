<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="theme.css" media="screen"/>

    <script>
        //    function showUser() {
        //        var customerNumber = document.getElementById("customerNumber").value;
        //        var xmlHttp;
        //        if (customerNumber == "") {
        //            document.getElementById("dvShowUser").innerHTML = "Please Enter A Customer Number...";
        //        } else {
        //            if (window.XMLHttpRequest) {
        //                // code for IE7+, Firefox, Chrome, Opera, Safari
        //                xmlHttp = new XMLHttpRequest();
        //            } else {
        //                // code for IE6, IE5
        //                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        //            }
        //            xmlHttp.onreadystatechange = function () {
        //                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
        //                    document.getElementById("dvShowUser").innerHTML = xmlHttp.responseText;
        //                }
        //            };
        //            xmlHttp.open("GET", "/SearchCustomerNumberServlet?customerNumber=" + customerNumber, true);
        //            xmlHttp.send();
        //        }
        //    }
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
        result = query.list();
        transaction.commit();
%>
<h1>Dotin Internet Bank</h1>


<p>Add A New Loan Type </p>


<form action="/DefineNewLoanFileServlet" method="get">
    <input type="text" value="Customer Number" name="customerNumber"
           onfocus="if(this.value == 'Customer Number') { this.value = ''; }" required>
    <br>
    <input type="submit" value="Retrieve">
    Type Name
    <br>
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
