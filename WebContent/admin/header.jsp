<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">
	<div>
		<img alt="Image error" src="../images/BookstoreLogo.png">
	</div>
	<div align="center">
		Welcome, <c:out value="${sessionScope.useremail}"/>  &emsp; | &emsp; <a href="logout">Logout</a>
	</div>
	</br>
	<div id = "headermenu" >
			<div>
				<a href="list_users">
					<img src="../images/users.png"/><br/>Users
				</a> 
			</div>
			
			<div>
				<a href="list_category">
					<img src="../images/category.png"/><br/>Categories
				</a> 
			</div>
			
			<div >
				<a href="books">
					<img src="../images/bookstack.png"/><br/>Books
				</a> 
			</div>
			
			<div>
				<a href="customers">
					<img src="../images/customer.png"/><br/>Customers
				</a> 
			</div>
			
			<div>
				<a href="reviews">
					<img src="../images/review.png"/><br/>Reviews
				</a> 
			</div>
			
			<div" >
				<a href="orders">
					<img src="../images/order.png"/><br/>Orders
				</a> 
			</div>
	</div>
</div>