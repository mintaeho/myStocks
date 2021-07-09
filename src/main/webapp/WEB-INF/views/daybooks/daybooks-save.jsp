<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <div class="container-fluid">

        <div class="card ">
            <div class="card-header card-header-rose card-header-icon">
                <h4 class="card-title">매매일지 등록</h4>
            </div>
            <div class="card-body ">
                <form method="#" action="#">
                    <div class="form-group">
                        <div class="form-check">
                            <label class="form-check-label">
                                <input class="form-check-input" type="radio" name="tradingType" value="매수" checked> 매수
                                <span class="circle">
                                    <span class="check"></span>
                                </span>
                            </label>
                            <label class="form-check-label">
                                <input class="form-check-input" type="radio" name="tradingType" value="매도"> 매도
                                <span class="circle">
                                    <span class="check"></span>
                                </span>
                            </label>
                        </div>
                    </div>
                    <div class="row">
                        <label class="col-md-3 col-form-label">거래일</label>
                        <div class="col-md-3">
                            <div class="form-group has-default">
                                <input type="text" class="form-control datepicker" id="tradingDate">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="티커" class="bmd-label-floating">티커</label>
                        <input type="input" class="form-control" id="ticker">
                    </div>
                    <div class="form-group">
                        <label for="체결단가" class="bmd-label-floating">체결단가</label>
                        <input type="input" class="form-control" id="unitPrice">
                    </div>
                    <div class="form-group">
                        <label for="주식 수" class="bmd-label-floating">주식 수</label>
                        <input type="input" class="form-control" id="stockNum">
                    </div>
                    <div class="form-group">
                        <label for="수수료" class="bmd-label-floating">수수료</label>
                        <input type="input" class="form-control" id="fee">
                    </div>
                    <div class="form-group">
                        <label for="환율" class="bmd-label-floating">환율</label>
                        <input type="input" class="form-control" id="exchangeRate">
                    </div>
                </form>
            </div>
            <div class="card-footer ">
                <a href="javascript:window.close()" role="button" class="btn btn-info">취소</a>
                <button type="button" class="btn btn-primary" id="btn-save">등록</button>
            </div>
        </div>

    </div>

    <script src="/js/app/daybooks/daybooks.js"></script>







