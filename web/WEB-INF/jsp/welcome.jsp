<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <h1>Welcome</h1>
        <br/>
        ${user}, hello!
        <br/>

    <form name="ParseForm" action="controller" method="POST">
        <table> <tr>
            <td>SAX</td>
            <td><input type="radio" name="command" value="SAX"></td></td>
            <td>StAX</td>
            <td><input type="radio" name="command" value="StAX"></td></td>
            <td>DOM</td>
            <td><input type="radio" name="command" value="DOM"></td></td>
        </tr></table>
        <input type="submit" value="Parse">
    </form>

    <form name="LogoutForm" action="controller" method="post">
        <input type="hidden" name="command" value="logout" />

        <input type="submit" value="Log out"/>
    </form>


    </body>
</html>
