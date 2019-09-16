<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ tag import="no.hvl.dat152.util.Utils"%>
<%@ tag import="java.util.Map" %>
<%@ tag import="java.util.LinkedHashMap" %>

<%
    int date = Integer.parseInt(Utils.getDate());
    String form = "MMVIII";

    LinkedHashMap<Integer, String> basicRomanNumbers = new LinkedHashMap<Integer, String>();
    String romanNumber = "";

    basicRomanNumbers.put(1000 , "M");
    basicRomanNumbers.put(900  , "CM");
    basicRomanNumbers.put(500  , "D");
    basicRomanNumbers.put(400  , "CD");
    basicRomanNumbers.put(100  , "C");
    basicRomanNumbers.put(90   , "XC");
    basicRomanNumbers.put(50   , "L");
    basicRomanNumbers.put(40   , "XL");
    basicRomanNumbers.put(10   , "X");
    basicRomanNumbers.put(9    , "IX");
    basicRomanNumbers.put(5    , "V");
    basicRomanNumbers.put(4    , "IV");
    basicRomanNumbers.put(1    , "I");

    for (Map.Entry<Integer, String> entry : basicRomanNumbers.entrySet()) {
        int enterKey = entry.getKey();
        int divisionResult = date / enterKey;

        if(divisionResult > 0 ){
            for (int i = 0; i < divisionResult; i++) {
                romanNumber = romanNumber + basicRomanNumbers.get(enterKey);
            }
            // Euclidean division
            date = date % enterKey;
        }
    }
    String copyString = "&copy; " + "MMVIII" + "-" + romanNumber + " HVL";
    jspContext.setAttribute("copyright", copyString);
%>
<p class="italic">${copyright}</p>