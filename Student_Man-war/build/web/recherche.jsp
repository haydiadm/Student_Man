<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche</title>
    </head>
    <body>
        <h1>Recherche</h1>
        <div>
            <div>
                <form action="Recherche" method="post">
                    <label>Code Etudiant</label>
                    <input name="query" type="text" />
                    <input type="submit" value="rechercher" />
                </form>
            </div>
            <div>
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
			<% 
                            if(request.getMethod().toUpperCase() == "POST"){
                            ResultSet dataHolder = (ResultSet)request.getAttribute("data");
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
            }		}
			%>
			
			
		</tbody>
	</table>
            </div>
        </div>
    </body>
</html>
