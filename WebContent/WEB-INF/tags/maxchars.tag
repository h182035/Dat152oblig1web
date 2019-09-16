<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<jsp:doBody var="theBody" />

<%
    String bc = (String) jspContext.getAttribute("theBody");
    bc = bc.trim();
    String result;
    if (bc.length() > 20) {
        result = bc.substring(0, 20) + "...";
    } else {
        result = bc;
    }
%>

<%=result%>
