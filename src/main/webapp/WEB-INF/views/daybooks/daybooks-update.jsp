<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <div class="container-fluid">

        <div class="card ">
            <div class="card-header card-header-rose card-header-icon">
                <h4 class="card-title">매매일지 수정</h4>
            </div>
            <div class="card-body ">
                <form method="#" action="#">
                    <input type="hidden" id="id" value="${daybooks.id}" readonly>

                    <div class="form-group">
                        <div class="form-check">
                            <label class="form-check-label">
                                <input class="form-check-input" type="radio" id="tradingType" name="tradingType" value="매수" ${daybooks.tradingType=='매수'?'checked':''}> 매수
                                <span class="circle">
                                    <span class="check"></span>
                                </span>
                            </label>
                            <label class="form-check-label">
                                <input class="form-check-input" type="radio" id="tradingType" name="tradingType" value="매도" ${daybooks.tradingType=='매도'?'checked':''}> 매도
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
                                <input type="text" class="form-control datepicker" id="tradingDate" value="${daybooks.tradingDate}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="티커" class="bmd-label-floating">티커</label>
                        <input type="input" class="form-control" id="ticker" value="${daybooks.ticker}">
                    </div>
                    <div class="form-group">
                        <label for="체결단가" class="bmd-label-floating">체결단가</label>
                        <input type="input" class="form-control" id="unitPrice" value="${daybooks.unitPrice}">
                    </div>
                    <div class="form-group">
                        <label for="주식 수" class="bmd-label-floating">주식 수</label>
                        <input type="input" class="form-control" id="stockNum" value="${daybooks.stockNum}">
                    </div>
                    <div class="form-group">
                        <label for="수수료" class="bmd-label-floating">수수료</label>
                        <input type="input" class="form-control" id="fee" value="${daybooks.fee}">
                    </div>
                    <div class="form-group">
                        <label for="환율" class="bmd-label-floating">환율</label>
                        <input type="input" class="form-control" id="exchangeRate" value="${daybooks.exchangeRate}">
                    </div>
                </form>
            </div>
            <div class="card-footer ">
                <a href="javascript:window.close()" role="button" class="btn btn-info">취소</a>
                <button type="button" class="btn btn-danger" id="btn-delete">삭제</button>
                <button type="button" class="btn btn-primary" id="btn-update">수정 완료</button>
            </div>
        </div>

    </div>

    <script src="/js/app/daybooks/daybooks.js"></script>
