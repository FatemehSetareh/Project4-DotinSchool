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
    <link rel="stylesheet" type="text/css" href="theme.css" media="screen"/>
    <title></title>
</head>

<body>
<h1>Dotin Internet Bank</h1>

<p>Please choose one these options </p>

<form>
    <input type="button" value="Add A New Customer" onclick="location.href='register-real-customer-page.jsp';">
    <input type="button" value="Search For Existing Customer" onclick="location.href='SearchRealCustomerPage.html';">
    <input type="button" value="Define A New Loan Type" onclick="location.href='define-new-loan-type-page.jsp';">
    <input type="button" value="Define A New Loan File" onclick="location.href='define-new-loan-file-page.jsp';">
</form>

</body>
</html>
