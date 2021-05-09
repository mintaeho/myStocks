<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <tiles:insertAttribute name="headerDiv" />
    </head>
    <body>
        <h2>나의 포트폴리오</h2>
        <div class="col-md-12">
            <tiles:insertAttribute name="naviDiv" />
        </div>
        <br>
        <div class="content">
            <tiles:insertAttribute name="body" />
        </div>


    </body>

    <tiles:insertAttribute name="footerDiv" />
</html>