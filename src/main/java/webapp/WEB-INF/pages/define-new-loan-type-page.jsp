<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="theme.css" media="screen"/>
    <title></title>
</head>

<body>
<h1>Dotin Internet Bank</h1>


<p>Add A New Loan Type</p>

<form action="define-new-grant-condition-page.jsp" method="post">
    <input type="text" value="Type Name" name="typeName" onfocus="if(this.value == 'Type Name') { this.value = ''; }">
    <br>
    <input type="text" value="Interest Rate" name="interestRate"
           onfocus="if(this.value == 'Interest Rate') { this.value = ''; }">
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
