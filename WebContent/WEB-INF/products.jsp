<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${test}</p>

<table>
<c:forEach items="${products}" var="m">
						<tr>
							<td>${m.product.pName}</td> <td>${m.desc}</td> <td><img src="${m.product.imageFile}"/></td>
						</tr>
					</c:forEach>
</table>
</body>
</html>