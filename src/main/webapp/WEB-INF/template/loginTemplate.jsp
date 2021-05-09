<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <tiles:insertAttribute name="headerDiv" />
    </head>
    <body class="text-center">
        <tiles:insertAttribute name="body" />
    </body>

    <tiles:insertAttribute name="footerDiv" />
</html>