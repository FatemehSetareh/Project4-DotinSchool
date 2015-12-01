<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="java.util.List" %>
<%@ page import="presentation.SearchForDefinedLoanTypeServlet" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="theme.css" media="screen"/>

</head>

<body>
<%
    List result = SearchForDefinedLoanTypeServlet.searchLoanTypes();
%>
<h1>Dotin Internet Bank</h1>

<p>Add A New Loan Type </p>


<form action="/DefineNewLoanFileServlet" method="get">
    <input type="text" value="Customer Number" name="customerNumber" id="customerNumber"
           onfocus="if(this.value == 'Customer Number') { this.value = ''; }" required/>
    <br>
    <input type="submit" value="Retrieve"/>
    <br>
    Type Name
    <br>
    <select name="typeName" id="typeName" required>
        <option value=""></option>
        <% for (Object typeName : result) { %>
        <option>
            <%= typeName%>
        </option>
        <% } %>
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
