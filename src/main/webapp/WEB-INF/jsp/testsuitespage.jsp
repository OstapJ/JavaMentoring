<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test Suites</h1>

<c:url var="addUrl" value="/main/testsuites" />
<table style="border: 1px solid; width: 800px; text-align:center">
	<thead style="background:#fcf">
		<tr>
			<th>ID</th>
			<th>Duration</th>
			<th>Class Name</th>
			<th>Result</th>
			<th>Tests Failed Amount</th>
			<th>Tests Passed Amount</th>
			<th>Tests Total Amount</th>
			<th colspan="3"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${testsuites}" var="testsuites">
		<tr>
			<td><c:out value="${testsuites.id}" /></td>
			<td><c:out value="${testsuites.duration}" /></td>
			<td><c:out value="${testsuites.name}" /></td>
			<td><c:out value="${testsuites.result}" /></td>
			<td><c:out value="${testsuites.testsFailed}" /></td>
			<td><c:out value="${testsuites.testsPassed}" /></td>
			<td><c:out value="${testsuites.testsTotal}" /></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty testsuites}">
	There aren't any launched Test Suites in the Report Portal.
</c:if>

</body>
</html>