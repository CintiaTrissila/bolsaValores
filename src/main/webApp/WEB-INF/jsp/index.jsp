<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
      <link rel="stylesheet" type="text/css"
                href="${pageContext.request.contextPath}/css/style.css"/>
   </head>
   <body>
      <h1>Welcome</h1>
      <h2>${message}</h2>
       
     
         
      <a href="${pageContext.request.contextPath}/empresa/list">Empresas</a>  
      <p/>
      <a href="${pageContext.request.contextPath}/conta/list">Contas</a>
      <p/> 
      <a href="${pageContext.request.contextPath}/monitoramento/list">Monitoramentos</a>   
      
      <p/>
      <p/>
      <c:url var="startProcesso" value="/start"/>
	  <a href="${startProcesso}">Iniciar Processo</a>
       
   </body>
   
</html>