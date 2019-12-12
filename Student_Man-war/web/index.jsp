<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                padding: 0px;
                margin: 0px;
            }
            .title-container {
                width: 100%;
                margin: 0px;
                padding: 20px auto;
                background-color: #16163F;
            }
            .title {
                text-align: center;
                color: white;
                margin:0px;
                padding: 20px auto;
                font-family: 'Comic Sans', TSCu_Comic, Helvetica;
                font-size: 2.5em;
            }
            .container {
                width: 60%;
                margin:100px auto;  
                font-family: 'Comic Sans', TSCu_Comic, Helvetica;
            }
            
            .upload-form, .upload-form > form {
                width:95%;
                margin:auto;
                border-radius: 5px;
                padding: 15px;
                background-color: #E8F1F2;
            }
            input[type='file'], input[type='file'] * {
                width: 40%;
                margin: 20px 30%;
                color:green;
                height: 30px;
            }
            input[type='submit'] {
                width: 40%;
                margin: 20px 30%;
                border:none;
                border-radius: 5px;
                color:white;
                height: 30px;
                background-color: green;
                font-size: 1.2em;
            }
            .upload-form h3
            {
                color:green;
                text-align: center;
                font-size: 1.2em;
            }
        </style>
    </head>
    <body>
        <div class="title-container">
            <h1 class="title">Student Classification Calculator</h1>
        </div>
        <div class="container">
            <div class="upload-form">
                <form action="Upload" method="post" enctype="multipart/form-data">
                    <h3>Select an XLS File: </h3>
                    <br>
                    <input type="file" name="xls_file" /> 
                    <br>
                    <div>
                        
                        <input type="submit" value="submit" />
                        
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
