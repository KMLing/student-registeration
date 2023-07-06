<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>


<script>
	$(document)
			.ready(
					function() {

						$('#supplier_list')
								.change(
										function() {
											var supplierID = $('#supplier_list')
													.val();

											$
													.ajax({
														type : "GET",
														url : "${pageContext.request.contextPath}/loaditem",
														data : {
															supplierid : supplierID
														},
														success : function(data) {
														
															var result = data;

															var selectitem = $('#item_list'), text = "";

															$("#item_list")
																	.empty();
															for (var i = 0; i < result.length; i++) {
																var id = result[i].itemID;
																var name = result[i].itemName;
																
															

																$("#item_list")
																		.append(
																				"<option value='"+id+"'>"
																						+ name
																						+ "</option>");

															}
														},
														error : function(result) {
															alert("Error");
															alert("request status="
																	+ data.status
																	+ "\n status text="
																	+ data.statusText
																	+ "\n Response text="
																	+ data.responseText);
														}

													});
										});

					});

	$(document)
			.ready(
					function() {

						$('#item_list')
								.change(
										function() {
											var supID = $('#supplier_list')
													.val();
											var itemID = $('#item_list').val();

											$
													.ajax({
														type : "GET",
														url : "${pageContext.request.contextPath}/loaddepit",
														data : {
															supplierID : supID,
															itemID : itemID,

														},
														success : function(data) {

															var result = data;
															alert(itemID);

															for (var i = 0; i < result.length; i++) {
																var dep = result[i].depit;
																$("#depit")
																		.val(
																				dep);

															}
															$('#item_list').val(itemID);

														},

														error : function(result) {
															alert("Error");
															alert("request status="
																	+ data.status
																	+ "\n status text="
																	+ data.statusText
																	+ "\n Response text="
																	+ data.responseText);
														}

													});
										});

					});

	
</script>


<h1>Add New Payment</h1>



<form:form method="post" action="loadSupplier">

	<table class="table">

		<tr>

			<td>Supplier Name</td>

			<td><form:select path="supplierID" class="select-width"
					id="supplier_list">
					<option value="" disabled selected>Select Supplier</option>
					<c:forEach var="sup" items="${depitSupplierList}">
						<form:option value="${sup.getSupplierID() }">${sup.getSupplierName()}</form:option>
					</c:forEach>
				</form:select></td>
		</tr>


		<tr>
			<td>Item Name</td>
			<td><form:select path="itemID" class="select-width"
					id="item_list">
					<option value="itemID" label="-Select Item-" />
				</form:select> 
				<!-- <td>
			<select id="item_list">
				<option value="0">- Select -</option>
			</select>
			</td> -->
		</tr>



		<tr>
			<td>Depit</td>
			<td><form:input id="depit" path="depit" placeholder="Depit" /></td>
		</tr>





		<tr>
			<td>Paid Amount</td>
			<td><form:input path="amount" placeholder="Paid Amount" /></td>
		</tr>

		<tr>
			<td>Date</td>
			<td><form:input type="date" path="date" placeholder="dd/MM/yy" /></td>
		</tr>


		<tr>
			<td><input col-span=2 type="submit" value="Submit" id="submit"
				class="btn btn-primary btn-lg float-left" /></td>
		</tr>

	</table>

	<br />
</form:form>

