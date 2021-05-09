<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <!-- 입력 영역 -->
    <div class="col-md-4">
        <form>
            <div class="form-group">
                <label for="title">거래일</label>
                <input type="text" class="w-50 form-control" id="tradingDate" placeholder="거래일을 입력하세요">
            </div>
            <div class="form-group">
                <label for="title">티커</label>
                <input type="text" class="w-50 form-control" id="ticker" placeholder="티커를 입력하세요">
            </div>
            <div class="form-group">
                <label for="author">체결단가</label>
                <input type="text" class="w-50 form-control" id="unitPrice" placeholder="체결단가를 입력하세요">
            </div>
            <div class="form-group">
                <label for="author">주식수</label>
                <input type="text" class="w-50 form-control" id="stockNum" placeholder="주식수를 입력하세요">
            </div>
            <div class="form-group">
                <label for="author">매매구분</label>
                <input type="text" class="w-50 form-control" id="tradingType" placeholder="매매구분을 입력하세요">
            </div>
            <div class="form-group">
                <label for="author">수수료</label>
                <input type="text" class="w-50 form-control" id="fee" placeholder="수수료를 입력하세요">
            </div>
            <div class="form-group">
                <label for="author">환율</label>
                <input type="text" class="w-50 form-control" id="exchangeRate" placeholder="환율을 입력하세요">
            </div>
        </form>
        <a href="/daybooks/v1" role="button" class="btn btn-secondary">취소</a>
        <button type="button" class="btn btn-primary" id="btn-save">등록</button>
    </div>

    <script src="/js/app/daybooks/daybooks.js"></script>
