<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <div class="position-sticky pt-3">

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Menu</span>
        </h6>

        <ul class="nav flex-column">
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/portfolio/v1">포트폴리오</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/daybooks/v1">매매일지</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/interestedStock/v1/">관심종목</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/company-info/v1">업체정보</a>
                </li>
            </sec:authorize>
            <li class="nav-item">
                <a class="nav-link" href="/posts/index">exercise(posts)</a>
            </li>
            <li class="nav-item">
                <button type="button" class="btn btn-outline-primary btn-sm" id="btn-scraping">Scraping Command</button>
            </li>
        </ul>
    </div>

    <script src="/js/app/sidebar.js"></script>
