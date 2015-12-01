<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script>
    var grantConditions = [];
    grantConditions.push(["conditionName", "minDuration", "maxDuration" , "minAmount", "maxAmount"]);
    function generateTable() {
        var conditionName = document.getElementById("conditionName").value;
        var minDuration = document.getElementById("minDuration").value;
        var maxDuration = document.getElementById("maxDuration").value;
        var minAmount = document.getElementById("minAmount").value;
        var maxAmount = document.getElementById("maxAmount").value;

        grantConditions.push([conditionName, minDuration, maxDuration , minAmount, maxAmount]);
        var tbl = document.createElement("table");
        tbl.setAttribute("id", "grantConditionsTable");

        var columnCount = 5;
        var row = tbl.insertRow(-1);
        for (var i = 0; i < columnCount; i++) {
            var headerCell = document.createElement("TH");
            headerCell.innerHTML = grantConditions[0][i];
            row.appendChild(headerCell);
        }
        for (var i = 1; i < grantConditions.length; i++) {
            row = tbl.insertRow(-1);
            for (var j = 0; j < columnCount; j++) {
                var cell = row.insertCell(-1);
                cell.innerHTML = grantConditions[i][j];

                var grant = document.createElement("input");
                grant.setAttribute("type", "hidden");
                grant.setAttribute("form", "form1");
                grant.setAttribute("name", "grant" + i + j);
                grant.setAttribute("value", grantConditions[i][j]);
                console.log(grant);
            }
        }
        var dvTable = document.getElementById("table");
        dvTable.innerHTML = "";
        dvTable.appendChild(tbl);
    }

    function generateGrantConditionArray() {
        var allGrantConditions = '';
        for (var i = 1; i < grantConditions.length; i++) {
            for (var j = 0; j < 5; j++) {
                var content = grantConditions[i][j];
                allGrantConditions += (content + '#');
            }
            allGrantConditions += '&';
        }
        document.getElementsByName("concatedGrantConditions")[0].value = allGrantConditions;
        document.forms[0].submit();
    }
</script>
<head>
    <link rel="stylesheet" type="text/css" href="theme.css" media="screen"/>
</head>

<body>
<h1>Dotin Internet Bank</h1>


<p>Define New Grant Conditions</p>
<%
    String typeName = request.getParameter("typeName");
    String interestRate = request.getParameter("interestRate");
%>


<form id="form1" action="/DefineNewGrantConditionServlet" method="post">
    <input type="hidden" name="concatedGrantConditions"/>
    <label for="conditionName">Condition Name</label>
    <br>
    <input type="text" name="conditionName" id="conditionName" required/>
    <br>
    <label for="minDuration">Minimum Duration</label>
    <br>
    <input type="text" name="minDuration" id="minDuration" required/>
    <br>
    <label for="maxDuration">Maximum Duration</label>
    <br>
    <input type="text" name="maxDuration" id="maxDuration" required/>
    <br>
    <label for="minAmount">Minimum Amount</label>
    <br>
    <input type="text" name="minAmount" id="minAmount" required/>
    <br>
    <label for="maxAmount">Maximum Amount</label>
    <br>
    <input type="text" name="maxAmount" id="maxAmount" required/>
    <br>
    <input type="hidden" name="typeName" value="<%=typeName%>">
    <input type="hidden" name="interestRate" value="<%=interestRate%>">
    <input type="button" value="Final Submit" onclick="generateGrantConditionArray()"/>
    <input type="button" value="Show All" onclick="generateTable()"/>

    <div id="table">
    </div>
</form>


</body>
</html>
