<%--
  Created by IntelliJ IDEA.
  User: DOTIN SCHOOL 4
  Date: 11/23/2015
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Theme.css" media="screen"/>
    <title></title>
</head>

<body>
<h1>Dotin Internet Bank</h1>

<h3>Real Customer</h3>

<p>Add A New Loan Type </p>

<form action="DefineNewGrantConditionPage.jsp" method="get">
    <input type="text" value="Type Name" name="typeName" onfocus="if(this.value == 'Type Name') { this.value = ''; }">
    <br>    `
    <input type="text" value="Interest Rate" name="interestRate"
           onfocus="if(this.value == 'Interest Rate') { this.value = ''; }">
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
