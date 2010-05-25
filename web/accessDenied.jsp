<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="org.acegisecurity.context.SecurityContextHolder" %>
<%@ page import="org.acegisecurity.Authentication" %>
<%@ page import="org.acegisecurity.ui.AccessDeniedHandlerImpl" %>
<html>
<head>
    <title>Access is denied</title>
  </head>
<body>
<h1>Sorry, access is denied</h1>


<p>
<%= request.getAttribute(AccessDeniedHandlerImpl.ACEGI_SECURITY_ACCESS_DENIED_EXCEPTION_KEY)%>

<p>

<%		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) { %>
			Authentication object as a String: <%= auth.toString() %><BR><BR>
<%      } %>
</body>
</html>