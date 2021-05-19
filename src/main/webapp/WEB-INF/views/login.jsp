<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

      <!-- Navbar -->
      <!-- End Navbar -->
      <div class="wrapper wrapper-full-page">
        <div class="page-header login-page header-filter" filter-color="black" style="background-size: cover; background-position: top center;">
          <!--   you can change the color of the filter page using: data-color="blue | purple | green | orange | red | rose " -->
          <div class="container">
            <div class="row">
              <div class="col-lg-4 col-md-6 col-sm-8 ml-auto mr-auto">
                <form class="form" method="" action="">
                  <div class="card card-login">
                    <div class="card-header card-header-rose text-center">
                      <h4 class="card-title">Login v0.1</h4>
                      <div class="social-line">
                        <!-- 영역삭제 -->
                      </div>
                    </div>
                    <div class="card-body text-center">
                        <a class="btn btn-primary" href="/oauth2/authorization/google">Google</a>
                        <a class="btn btn-success" href="/oauth2/authorization/naver">Naver</a>
                      <!-- 영역삭제 -->
                    </div>
                    <div class="card-footer justify-content-center">
                      <!-- 영역삭제 -->
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <footer class="footer">
            <div class="container">
              <nav class="float-left">
                <!-- 영역 삭제 -->
              </nav>
              <div class="copyright float-right">
                <!-- 영역 삭제 -->
              </div>
            </div>
          </footer>
        </div>
      </div>

    <!--index.js 추가-->
    <script src="/js/app/index.js"></script>
