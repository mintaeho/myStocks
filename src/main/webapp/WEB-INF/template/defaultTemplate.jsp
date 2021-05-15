<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

<!doctype html>
<html lang="en">
    <head>
        <tiles:insertAttribute name="headerDiv" />
    </head>

<body class="">
  <div class="wrapper ">
    <tiles:insertAttribute name="sidebarDiv" />

    <div class="main-panel">
      <tiles:insertAttribute name="topbarDiv" />

      <tiles:insertAttribute name="body" />

      <footer class="footer">
        <tiles:insertAttribute name="footerDiv" />
      </footer>
    </div>
  </div>

  <tiles:insertAttribute name="resourcesDiv" />
</body>
</html>