<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="dat152" tagdir="/WEB-INF/tags"%>

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
<c:forEach items="${products}" var="m">
						<tr>
							<td>${m.product.pName}</td> <dat152:maxchars><td>${m.desc}</td></dat152:maxchars>
							 <td><img src="bilder/${m.product.imageFile}" height="150"/></td>
							<td><button type="submit" name="add" value="${m.product.pno}">${addToCart}</button></td>
						</tr>
					</c:forEach>
</table>

<button type="submit" name="toCart" value="1">${goToCart}</button>
</form>

<dat152:roman/>
</body>
</html>