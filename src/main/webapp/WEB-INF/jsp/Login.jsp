<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Login</title>

     <style>
          main {
               min-height: 100vh;
               padding: 20px;
               display: flex;
               justify-content: center;
               align-items: center;
               background-color: aliceblue;
          }

          .card {
               display: inline-block;
               padding: 50px;
               border: 2px solid;
               border-radius: 20px;
               background-color: white;
          }

          input {
               padding: 8px;
               font-size: medium;
               border-radius: 10px;
               margin: 5px 0px 15px 0px;
          }

          label {
               font-size: large;
          }

          button {
               padding: 5px 15px;
               font-size: medium;
               border-radius: 10px;
               background-color: dodgerblue;
               cursor: pointer;
          }

     </style>

</head>

<body>
          <main>
               <div class="card">
                    <form >
                        <h2>Login</h2>
                        <div>
                             <label for="email">Email</label> <br>
                             <input type="email" name="email" id="email">
                        </div>
                        <div>
                             <label for="password">Password</label> <br>
                             <input type="password" name="password" id="password">
                        </div>
                        <button onclick="login()" type="button">Login</button>
                   </form>
               </div>
          </main>

          <script>
               function login() {
                    let email = document.getElementById("email").value
                    let password = document.getElementById("password").value

                    console.log(email)
                    console.log(password)
                    if (email === "admin@test.com") {
                         if (password === "123456") {
                                window.location.href = "/viewItemList"
                              // alert("Login Successful")
                         } else {
                              alert("Invalid Password")
                         }
                    } else {
                         alert("Account Not Found")
                    }
               }
          </script>
</body>

</html>