<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="presentation.SearchForDefinedLoanTypeServlet" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="theme.css" media="screen"/>
</head>

<body>
<%
    List result = SearchForDefinedLoanTypeServlet.searchLoanTypes();
%>
<h1>Dotin Internet Bank</h1>

<%
    String output = (String) request.getAttribute("output");
    if (output != null) {
%>
<h3><%= output %>
</h3>
<%
} else {
%>
<%= ""%>
<%
    }
%>

<%
    String customerProperties = (String) request.getAttribute("customerProperties");
    String customerNumber = "";
    if (customerProperties != null) {
        if (!customerProperties.equals("is not here")) {
            String[] splitCustomerProperties = customerProperties.split(",");
            if (splitCustomerProperties[0] != null) {
%><b>Fist Name: <%=splitCustomerProperties[0]%>
</b>
<% }
    if (splitCustomerProperties[1] != null) {
%><b>Last Name: <%= splitCustomerProperties[1]%>
</b>
<% }
    if (splitCustomerProperties[2] != null) {
        customerNumber = splitCustomerProperties[2];
    }
} else {
%> <b>This Customer Number Is Not In Our Database.</b> <%
        }
    }
%>

<p>Add A New Loan File </p>

<form action="/SearchCustomerNumberServlet" method="get">
    <input type="text" value="Customer Number" name="customerNumber" id="customerNumber"
           onfocus="if(this.value == 'Customer Number') { this.value = '<%=customerNumber%>'; }" required/>
    <br>
    <input type="submit" value="Retrieve"/>
</form>
<form action="/DefineNewLoanFileServlet" method="get">
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
    <input type="hidden" name="customerNumber1" id="customerNumber1" value="<%= customerNumber%>">
    <br>
    <input type="submit" value="Enter">
</form>
<div id="dvShowUser"></div>

</body>
</html>
