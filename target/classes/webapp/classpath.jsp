<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		<%
			String classpath = application.getAttribute("org.apache.catalina.jsp_classpath").toString();
			if (classpath.indexOf(";") == -1) {
				classpath = classpath.replace(":", ";");
			}
			for (String c : classpath.split(";")) {
				out.println(c + "<br>");
			}
		%>
	</p>
</body>
</html>
