<%--
  Created by IntelliJ IDEA.
  User: DOTIN SCHOOL 4
  Date: 11/23/2015
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Theme.css" media="screen"/>
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
            var table = document.createElement("TABLE");

            var columnCount = 5;
            var row = table.insertRow(-1);
            for (var i = 0; i < columnCount; i++) {
                var headerCell = document.createElement("TH");
                headerCell.innerHTML = grantConditions[0][i];
                row.appendChild(headerCell);
            }
            for (var i = 1; i < grantConditions.length; i++) {
                row = table.insertRow(-1);
                for (var j = 0; j < columnCount; j++) {
                    var cell = row.insertCell(-1);

                    cell.innerHTML = grantConditions[i][j];
                }
            }
            var dvTable = document.getElementById("dvTable");
            dvTable.innerHTML = "";
            dvTable.appendChild(table);
        }
        var grant; // declared as a global variable out side the functions

        function createPriceIdArray() {
            var rows = document.getElementsByTagName("TR");
            var i = 0;
            var value = "";
            while (i < rows.length) {
                var j = 0;
                while (j < 5) {
                    value += rows[i].cells[j].innerHTML;
                    j++;
                }
                grant = document.createElement("input");
                grant.setAttribute("type", "hidden");
                grant.setAttribute("name", "grant" + i);
                grant.setAttribute("value", value);
                document.getElementById("form1").appendChild(grant);
                i++;
            }
            grant = document.createElement("input");
            grant.setAttribute("type", "hidden");
            grant.setAttribute("name", "counter");
            grant.setAttribute("value", i);
            document.getElementById("form1").appendChild(grant);
        }

    </script>
</head>

<body>
<h1>Dotin Internet Bank</h1>

<h3>Real Customer</h3>

<p>Define New Grant Conditions</p>

<form id="form1" action="/DefineNewGrantConditionServlet" method="post">
    <input type="text" value="Condition Name" name="conditionName" id="conditionName"
           onfocus="if(this.value == 'Condition Name') { this.value = ''; }">
    <input type="hidden" name="conditionName">
    <br>
    <input type="text" value="Minimum Duration" name="minDuration" id="minDuration"
           onfocus="if(this.value == 'Minimum Duration') { this.value = ''; }">
    <input type="hidden" name="minDuration">
    <br>
    <input type="text" value="Maximum Duration" name="maxDuration" id="maxDuration"
           onfocus="if(this.value == 'Maximum Duration') { this.value = ''; }">
    <input type="hidden" name="maxDuration">
    <br>
    <input type="text" value="Minimum Amount" name="minAmount" id="minAmount"
           onfocus="if(this.value == 'Minimum Amount') { this.value = ''; }">
    <input type="hidden" name="minAmount">
    <br>
    <input type="text" value="Maximum Amount" name="maxAmount" id="maxAmount"
           onfocus="if(this.value == 'Maximum Amount') { this.value = ''; }">
    <input type="hidden" name="maxAmount">
    <br>
    <input type="submit" value="Final Submit"/>
    <input type="button" value="Show All" onclick="generateTable()"/>

    <div id="dvTable">
    </div>
</form>


</body>
</html>
