<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <div class="card ">
                    <div class="card-header card-header-rose card-header-icon">
                        <h4 class="card-title">포트폴리오 수정</h4>
                    </div>
                    <div class="card-body ">
                        <form method="#" action="#">
                            <div class="form-group">
                                <label for="티커" class="bmd-label-floating">티커</label>
                                <input type="input" class="form-control" id="ticker" value="${portfolio.ticker}" readonly>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer ">
                        <a href="javascript:window.close()" role="button" class="btn btn-info">취소</a>
                        <button type="button" class="btn btn-danger" id="btn-delete">삭제</button>
                    </div>
                </div>
            </div> <!-- end of col-md-6 -->
        </div>
    </div>

    <script src="/js/app/portfolio/portfolio.js"></script>
