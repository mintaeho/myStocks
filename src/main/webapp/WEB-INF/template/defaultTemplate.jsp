<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

<!doctype html>
<html lang="en">
    <head>
        <tiles:insertAttribute name="headerDiv" />
    </head>
    <body>
        <tiles:insertAttribute name="topbarDiv" />

        <div class="container-fluid">
            <div class="row">
                <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                    <tiles:insertAttribute name="sidebarDiv" />
                </nav>

                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                    <p>
                    <tiles:insertAttribute name="body" />
                </main>

            </div>
        </div>
    </body>

    <tiles:insertAttribute name="footerDiv" />
</html>