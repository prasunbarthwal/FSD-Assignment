<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring Boot Web Application Example</title>
</head>
<body>
    <h1>Operation</h1>
    <a href="/add_book">Add a Book</a> <br><br>
    <a href="/del_sub">Delete a Subject</a><br><br>
    <a href="/del_book">Delete a Book</a><br><br>
    <a href="/search_book">Search for a Book</a><br><br>
    <a href="/search_sub">Search for a Subject</a><br><br>
    <form action="search_title" method="post">
       Search For A Book By Title <br>
       <input type="text" name="title"> <input type="submit" value="Submit">
    </form>
    <br>
<form action="search_duration" method="post">
    Search For A Subject By Duration <br>
    <input type="text" name="durationInHours"> <input type="submit" value="Submit">
    </form>
   
 <a href="/search_duration">Search for a Subject</a><br>
    <a href="/exit">Exit</a><br>
</body>
</html>