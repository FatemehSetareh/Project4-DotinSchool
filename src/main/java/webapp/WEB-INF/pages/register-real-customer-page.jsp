<html>
<head>
    <link rel="stylesheet" type="text/css" href="theme.css" media="screen"/>
</head>

<body>
<h1>Dotin Internet Bank</h1>

<h3>Add A New Real Customer</h3>

<p>Please Fill The Form And Click Submit Button </p>

<div class="container">
    <form action="/RegisterRealCustomerServlet" method="get"
          onsubmit=" return validate()">
        <input type="text" name="firstName" onfocus="if(this.value == 'First Name') { this.value = ''; }"
               value="First Name" required>
        <br>
        <input type="text" name="lastName" onfocus="if(this.value == 'Last Name') { this.value = ''; }"
               value="Last Name" required>
        <br>
        <input type="text" name="fatherName" onfocus="if(this.value == 'Father Name') { this.value = ''; }"
               value="Father Name" required>
        <br>
        <input type="number" id="nationalCode" name="nationalCode"
               onfocus="if(this.value == 'National Code') { this.value = ''; }"
               value="National Code" required>
        <br>
        <label>Birth Date :</label>
        <br>
        <input type="date" name="birthDate" value="Birthday Date: " required>
        <br>
        <input type="submit" value="Register">
    </form>
</div>

<script>

    function validate() {
        var nationalCode = document.getElementById("nationalCode").value;
        if (10 != nationalCode.toString().length) {
            alert("Number of digits is not correct.");
            return false;
        }
        if (checkDigits(nationalCode) == false) {
            alert("National Code is not correct!");
            return false;
        }
        return true;
    }
    function checkDigits(nationalCode) {
        var nationalCodeString = nationalCode.toString();
        var sum = (parseInt(nationalCodeString.charAt(0)) * 1000000000)
                + (parseInt(nationalCodeString.charAt(1)) * 100000000)
                + (parseInt(nationalCodeString.charAt(2)) * 10000000)
                + (parseInt(nationalCodeString.charAt(3)) * 1000000)
                + (parseInt(nationalCodeString.charAt(4)) * 100000)
                + (parseInt(nationalCodeString.charAt(5)) * 10000)
                + (parseInt(nationalCodeString.charAt(6)) * 1000)
                + (parseInt(nationalCodeString.charAt(7)) * 100)
                + (parseInt(nationalCodeString.charAt(8)) * 10)
                + (parseInt(nationalCodeString.charAt(9)));
        if (sum % 11 == parseInt(nationalCodeString.charAt(9))) {
            return true;
        } else return sum % 11 == (11 - parseInt(nationalCodeString.charAt(9)));
    }
</script>
</body>
</html>