<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <div class="row">
        <div>
            <c:if test="${userName ne null }">
                Logged in as: <span id="user">${userName}</span>
                <a href="/logout" class="btn btn-info active" role="button">Logout</a>

                <a href="/portfolio/v1" class="btn btn-success active" role="button">포트폴리오</a>
                <a href="/daybooks/v1" class="btn btn-secondary active" role="button">매매일지</a>
                <a href="/interestedStock/v1/" class="btn btn-secondary active" role="button">관심종목</a>
                <a href="/company-info/v1" class="btn btn-secondary active" role="button">업체정보</a>
                <a href="/posts/index" class="btn btn-secondary active" role="button">exercise</a>
            </c:if>
            <c:if test="${userName eq null }">
            </c:if>
        </div>
    </div>