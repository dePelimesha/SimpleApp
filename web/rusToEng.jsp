<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body bgcolor="#aaccff">
<form action="rusToEng" method="post">
    <Font color="green" size="10">
        Work with dictionary
    </Font>
    <br>
    <br>
    <Font color="blue" size="6"> Enter russian word:</Font><input type="Text" name=rus value=
        "<%if (request.getAttribute("rus")!= null) {
            out.print(request.getAttribute("rus").toString());
        } else out.print("");%>"/>
    <br>
    <br>
    <Font color="blue" size="6">Translate: </Font><input type="text" name=eng value=
        "<%if (request.getAttribute("eng")!= null) {
            out.print(request.getAttribute("eng").toString());
        } else out.print("");%>"/>
    <br>
    <h4>
        <input type="submit" name = "translate" value="Translate" />
        <input type="submit" name = "engButton" value="Eng to Rus" />
    </h4>
</form>
</body>