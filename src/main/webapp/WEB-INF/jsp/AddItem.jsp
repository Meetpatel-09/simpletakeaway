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
     <title>Add Items</title>

     <style>
          header {
               background-color: white;
               /* text-align: center; */
               padding: 10px 50px;
          }

          nav {
               /* max-width: 1280px; */
               display: flex;
               align-items: center;
               justify-content: space-between;
          }

          main {
               min-height: 80vh;
               padding: 20px;
               display: flex;
               justify-content: center;
               align-items: center;
               background-color: aliceblue;
               flex-direction: column;
          }

          .card {
               display: grid;
               padding: 50px;
               grid-template-columns: auto auto auto;
               grid-gap: 10px;
               border: 2px solid;
               border-radius: 20px;
               background-color: white;
          }

          .card-1 {
               display: block;
               padding: 25px;
               border: 2px solid;
               border-radius: 10px;
               background-color: white;
               margin-bottom: 10px;
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

          .c-p {
               cursor: pointer;
          }

          ul {
               list-style: none;
               display: flex;
          }

          ul>li {
               margin: 0px 10px;
          }

          ul>li>a, nav>div>a {
               text-decoration: none;
               color: #000;
          }

          th, td {
               padding: 10px;
          }
     </style>

</head>

<body>
     <header>
          <nav>

               <div>
                    <ul>
                         <li><a href="/viewItemList">View All Items</a></li>
                         <li><a href="/addItem">Add Item</a></li>
                         <li><a href="/addOrder">Add Order</a></li>
                         <li><a href="/viewAllOrders">View All Orders</a></li>
                         <!-- <li><a href="">View Orders Total</a></li> -->
                    </ul>
               </div>
               <div>
                    <a href="/">Log Out</a>
               </div>
          </nav>
     </header>
     <main>
          <h2>Add Item</h2>
          <div class="card">

                <form:form action="/saveItem" method="post" modelAttribute="item">

                    <div>
                         <label for="item_name">Item Name</label> <br>
                         <form:input type="text" path="item_name" id="item_name" />
                    </div>
                    <div>
                         <label for="item_price">Item Price</label> <br>
                         <form:input type="text" path="item_price" id="item_price"   />
                    </div>
                         <button type="submit">Add</button>
                </form:form>
          </div>
     </main>

     <script th:inline="javascript">

        window.onload = function() {

           var msg = "${message}";

           if (msg == "Save Failure") {
               alert("Something went wrong with the save");
           }

        }

     </script>
</body>

</html>