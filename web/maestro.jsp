<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>maestro</title>
</head>
<body>
<h1>Welcome maestro</h1>
<%if (session.getAttribute("userName").equals(null)) {%>
                <h1>No existe</h1>   
            <%}else{%>
                <h1>${session.userName}</h1>
            <%}%>
</body>
</html>