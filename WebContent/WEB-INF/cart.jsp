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
<p><jsp:include page="chooseLanguage.jsp" /></p>
<p>${test}</p>
<form method="post">
<table border="1" >
<c:forEach items="${cart.products}" var="m">
						<tr>
							<td>${m.pName}</td> <td>${m.imageFile}</td>
						</tr>
					</c:forEach>
</table>

<button type="submit" name="toCart" value="1">${goToCart}</button>
</form>
<p> &#169; MMVIII-MMXIX Høgskolen på Vestlandet</p>
</body>
</html>