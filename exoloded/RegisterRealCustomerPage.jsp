<html>
<head>
    <link rel="stylesheet" type="text/css" href="Theme.css" media="screen"/>
    <script>
        function validate() {
            var value = document.getElementById('nationalCode').value;
            if (value.toString().length < 10 || value.toString().length > 10) {
                document.getElementById("error").innerHTML = "The Lenght Of NationalCode Is Not Correct";
            }
        }
    </script>
</head>

<body>
<h1>Dotin Internet Bank</h1>

<h3>Add A New Real Customer</h3>

<p>Please Fill The Form And Click Submit Button </p>

<div class="container">
    <form action="/RegisterRealCustomerServlet" method="get" onsubmit="validate();">
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

</body>
</html>