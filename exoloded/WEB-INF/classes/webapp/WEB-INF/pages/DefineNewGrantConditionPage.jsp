<%--
  Created by IntelliJ IDEA.
  User: DOTIN SCHOOL 4
  Date: 11/23/2015
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Theme.css" media="screen"/>
    <title></title>
</head>

<body>
<h1>Dotin Internet Bank</h1>

<h3>Real Customer</h3>

<p>Define New Grant Conditions</p>

<%--<%--%>
<%--request.getParameter("typeName");--%>
<%--%>--%>

<form action="DefineNewGrantConditionPage.jsp" method="post">
    <input type="text" value="Condition Name" name="conditionName"
                 onfocus="if(this.value == 'Condition Name') { this.value = ''; }">
    <br>
    <input type="text" value="Minimum Time" name="minTime"
           onfocus="if(this.value == 'Minimum Time') { this.value = ''; }">
    <br>
    <input type="text" value="Maximum Time" name="maxTime"
           onfocus="if(this.value == 'Maximum Time') { this.value = ''; }">
    <br>
    <input type="text" value="Minimum Amount" name="minAmount"
           onfocus="if(this.value == 'Minimum Amount') { this.value = ''; }">
    <br>
    <input type="text" value="Maximum Amount" name="maxAmount"
           onfocus="if(this.value == 'Maximum Amount') { this.value = ''; }">
    <br>
    <input type="submit" value="Register">
</form>

<table>
    <tr>
        <td>Condition Name</td>
        <td>Minimum Time</td>
        <td>Maximum Time</td>
        <td>Minimum Amount</td>
        <td>Maximum Amount</td>
    </tr>

    <tr>
    <td><%= request.getParameter("conditionName")%></td>
    <td><%= request.getParameter("minTime")%></td>
    <td><%= request.getParameter("maxTime")%></td>
    <td><%= request.getParameter("minAmount")%></td>
    <td><%= request.getParameter("maxAmount")%></td>
    </tr>

</table>

</body>
</html>
