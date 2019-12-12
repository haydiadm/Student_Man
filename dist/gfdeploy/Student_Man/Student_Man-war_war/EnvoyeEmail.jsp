<%--
  Created by IntelliJ IDEA.
  User: lenny
  Date: 12/1/19
  Time: 8:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Envoye un Email</title>
    <style>
		.container {
			width:50%;
			margin: 70px auto;
			padding: 10px 100px;
			color:#16163F;
			border-radius:5px;
			font-family: 'Comic Sans MS', Arial;
		}
		
		label {
			width: 100%;
			height: 2.5em;
			font-weight:bold;
		}
		input[type='text']:focus, input[type='email']:focus, textarea:focus {
			border: 1px solid #16163F;
		}
		
		input[type='text'], input[type='email'] {
			width: 100%;
			height: 40px;
			border: none;
			padding: 5px;
			border-radius: 5px;
			background-color:#DCDBE2;
			margin: 5px auto;
		}
		
		textarea {
			width: 100%;
			border: none;
			padding: 5px;
			border-radius: 5px;
			background-color:#DCDBE2;
			margin: 5px auto;
		}
		
		input[type='submit'] {
			width: 50%;
			height: 40px;
			border: none;
			padding: 5px;
			margin: 20px 25% 20px 25%;
			border-radius: 5px;
			background-color:#16163F;
			color: white;
		}
		
		
		row, h2{
			width:100%;
			text-align:center;
		}
    </style>
</head>
<body>
    <div class="container">
    	<h2>Envoye Un Email</h2>
        <form action="Email" method="post">
            <label>
                Mon Email
            </label>
            <input name="mon_email" type="email">
            <label>
                Envoye A
            </label>
            <input name="a_email" type="email">
            <label>
                Sujet
            </label>
            <input name="sujet" type="text">
            <label>Message</label>
            <textarea name="message" cols="20" rows="5">

            </textarea>
            <div class='row'>
            	<input type="submit" value="Envoye">
            </div>
            
        </form>
    </div>
</body>
</html>
