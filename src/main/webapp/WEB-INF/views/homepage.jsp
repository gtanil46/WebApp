<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${username}</H1>


	<table class="table table-striped">
		<caption>The list of Cars in the inventory</caption>
		<thead>
			<th>VIN</th>
			<th>Make</th>
			<th>Model</th>
			<th>Year</th>
		</thead>
		<tbody>
			<c:forEach items="${cars}" var="car">
				<tr>
					<td>${car.vin}</td>
					<td>${car.make}</td>
					<td>${car.model}</td>
					<td>${car.year}</td>
					<td>&nbsp;&nbsp;<a class="btn btn-danger"
						href="/delete-todo.do?todo=${todo.name}&category=${todo.category}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="/add-todo.do">Add New Car</a>
</div>

<%@ include file="../common/footer.jspf"%>