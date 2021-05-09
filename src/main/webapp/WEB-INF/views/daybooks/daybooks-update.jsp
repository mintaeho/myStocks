<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <!-- 입력 영역 -->
    <div class="col-md-4">
        <form>
            <div class="form-group">
                <label for="title">ID</label>
                <input type="text" class="w-50 form-control" id="id" value="${daybooks.id}" readonly>
            </div>
            <div class="form-group">
                <label for="title">거래일</label>
                <input type="text" class="w-50 form-control" id="tradingDate" value="${daybooks.tradingDate}">
            </div>
            <div class="form-group">
                <label for="title">티커</label>
                <input type="text" class="w-50 form-control" id="ticker" value="${daybooks.ticker}">
            </div>
            <div class="form-group">
                <label for="author">체결단가</label>
                <input type="text" class="w-50 form-control" id="unitPrice" value="${daybooks.unitPrice}">
            </div>
            <div class="form-group">
                <label for="author">주식수</label>
                <input type="text" class="w-50 form-control" id="stockNum" value="${daybooks.stockNum}">
            </div>
            <div class="form-group">
                <label for="author">매매구분</label>
                <input type="text" class="w-50 form-control" id="tradingType" value="${daybooks.tradingType}">
            </div>
            <div class="form-group">
                <label for="author">수수료</label>
                <input type="text" class="w-50 form-control" id="fee" value="${daybooks.fee}">
            </div>
            <div class="form-group">
                <label for="author">환율</label>
                <input type="text" class="w-50 form-control" id="exchangeRate" value="${daybooks.exchangeRate}">
            </div>
        </form>
        <a href="/daybooks/v1/" role="button" class="btn btn-secondary">취소</a>
        <button type="button" class="btn btn-primary" id="btn-update">수정 완료</button>
        <button type="button" class="btn btn-danger" id="btn-delete">삭제</button>

    </div>

    <script src="/js/app/daybooks/daybooks.js"></script>
