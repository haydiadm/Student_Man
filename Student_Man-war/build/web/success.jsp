<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFCell"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<style>
table, td, tr, thead, tbody {
border: 1px solid black;
}
</style>
</head>
<body>
	<h1>Student Data</h1>
	<table >
		<thead>
			<td>CODE</td>
			<td>MOYENNE L1</td>
			<td>MOYENNE L2</td>
			<td>MOYENNE L3</td>
			<td>REDOUBLEMENTS</td>
			<td>RATTRAPAGES</td>
			<td>PROGRESSION</td>
			<td>CLASSEMENT</td>			
		</thead>
		<tbody>
			<% ResultSet dataHolder = (ResultSet)request.getAttribute("data");
			while (dataHolder.next())
            {
				
			%>
			<tr>
			<%
                int i = 2;
				String s = "";
                while(i < 10)
                {
                    if(i < 9  && i > 5) s = dataHolder.getInt(i) + "";
                    if(i > 2 && i < 6) s = dataHolder.getDouble(i) + "";
                    if(i == 2)s = dataHolder.getString(i);
                    if(i == 9)s = dataHolder.getDouble(i) + "";
           			
                    
                    %>
                    <td><%= s %></td>
                    <%
					i += 1;
                }
               %> 
                </tr>
                <%
            }		
			%>
			
			
		</tbody>
	</table>
</body>
</html>