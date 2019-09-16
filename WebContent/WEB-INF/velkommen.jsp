<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="dat152" tagdir="/WEB-INF/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Velg Språk</title>
</head>
<body>
<p><jsp:include page="chooseLanguage.jsp" /></p>
<fmt:bundle basename="siteText">
<h1><fmt:message key="velkommen"/></h1>
<p><fmt:message key="velgSprak"/></p>
<form method="post">
<button type="submit" name="sprak" value="norsk">norsk</button>

<button type="submit" name="sprak" value="engelsk">engelsk</button>

<button type="submit" name="sprak" value="fransk">fransk</button>
</form>
</fmt:bundle>
<p> &#169; MMVIII-MMXIX Høgskolen på Vestlandet</p>
</body>
</html>