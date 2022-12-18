<!--  CODE FOR COMMON HEADER -->
<%@ include file="common/header.jspf"%>
<!--  CODE FOR COMMON NAVIGATION BAR -->
<%@ include file="common/navigation.jspf"%>

<!--  CODE FOR ADDING NEW TODO -->
<div class="container">
	<h1>Enter Todo Details</h1>
	<!-- using modelAttribute="todo" we are tying todo with todo attribute which is present in addNewTodo method -->
	<form:form method="post" modelAttribute="todo">
		<!--  CODE FOR DESCRIPTION -->
		<fieldSet class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldSet>

		<!--  CODE FOR TARGET DATE -->
		<fieldSet class="mb-3">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" path="targetDate" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldSet>

		<form:input type="hidden" path="id" />

		<form:input type="hidden" path="done" />

		<input type="submit" class="btn btn-success" />
	</form:form>
</div>
<!--  CODE FOR COMMON FOOTER BAR -->
<%@ include file="common/footer.jspf"%>
<script type="text/javascript">
		$('#targetDate').datepicker({
		    format: 'yyyy-mm-dd'
		});
	</script>
