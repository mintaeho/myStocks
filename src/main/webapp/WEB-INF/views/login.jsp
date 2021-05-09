<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <p>&nbsp;</p>
    <div class="d-grid gap-2 col-6 mx-auto">
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
            <p>&nbsp;</p>
            <c:if test="${userName eq null }">
                <a href="/oauth2/authorization/google" class="w-50 btn btn-info btn-sm active" role="button">Google Login</a>
                <p>&nbsp;</p>
                <a href="/oauth2/authorization/naver" class="w-50 btn btn-secondary btn-sm active" role="button">Naver Login</a>
            </c:if>
            <c:if test="${userName ne null }">
                Logged in as: <span id="user">${userName}</span>
                <a href="/logout" class="w-40  btn btn-info btn-sm active" role="button">Logout</a>
            </c:if>
    </div>


    <!--index.js 추가-->
    <script src="/js/app/index.js"></script>
