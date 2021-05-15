<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <div class="sidebar" data-color="rose" data-background-color="black" data-image="../../assets/img/sidebar-1.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo">

        <a href="#" class="simple-text logo-mini">
          My
        </a>
        <a href="#" class="simple-text logo-normal">
          Stock Info
        </a>
      </div>
      <div class="sidebar-wrapper">
        <div class="user">
          <div class="photo">
            <!--
            <img src="../../assets/img/faces/avatar.jpg" />
            -->
          </div>
          <div class="user-info">
            <a data-toggle="collapse" href="#collapseExample" class="username">
              <span>
                <c:if test="${userName ne null }">${userName}</c:if>
                <b class="caret"></b>
              </span>
            </a>
            <div class="collapse" id="collapseExample">
              <ul class="nav">
                <li class="nav-item">
                  <a class="nav-link" href="/logout">
                    <span class="sidebar-mini"> LO </span>
                    <span class="sidebar-normal"> Log out </span>
                  </a>
                </li>
              </ul>
            </div>

          </div>
        </div>
        <ul class="nav">
          <sec:authorize access="isAuthenticated()">
              <li class="nav-item ">
                <a class="nav-link" href="/portfolio/v1">
                  <i class="material-icons">dashboard</i>
                  <p> 포트폴리오 </p>
                </a>
              </li>
              <li class="nav-item ">
                <a class="nav-link" href="/daybooks/v1">
                  <i class="material-icons">content_paste</i>
                  <p> 매매일지 </p>
                </a>
              </li>
              <li class="nav-item ">
                <a class="nav-link" href="/interestedStock/v1/">
                  <i class="material-icons">place</i>
                  <p> 관심종목 </p>
                </a>
              </li>
              <li class="nav-item ">
                <a class="nav-link" href="/company-info/v1">
                  <i class="material-icons">widgets</i>
                  <p> 업체정보 </p>
                </a>
              </li>
              <p>&nbsp;</p>
              <li class="nav-item text-center">
                <button type="button" class="btn btn-outline-primary btn-sm" id="btn-scraping">Scraping Command</button>
              </li>

          </sec:authorize>
        </ul>
      </div>
      <div class="sidebar-background"></div>
    </div>

    <script src="/js/app/sidebar.js"></script>