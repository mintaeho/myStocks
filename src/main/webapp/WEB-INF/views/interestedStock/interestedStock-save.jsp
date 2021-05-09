<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <!-- 입력 영역 -->
    <div class="col-md-4">
        <form>
            <div class="form-group">
                <label for="title">티커</label>
                <input type="text" class="w-50 form-control" id="ticker" placeholder="티커를 입력하세요">
            </div>
            <div class="form-group">
                <label for="author">종목명</label>
                <input type="text" class="w-50 form-control" id="stockNm" placeholder="종목명을 입력하세요">
            </div>
            <div class="form-group">
                <label for="author">경기순환</label>
                <input type="text" class="w-50 form-control" id="businessCycle" placeholder="회복/호황/후퇴/불황 중 입력하세요">
            </div>
            <div class="form-group">
                <label for="author">배당귀족주 여부</label>
                <select class="w-50 form-control" id="nobilityStockYn" data-style="btn-inverse">
                    <option value='Y'>Y</option>
                    <option value='N'>N</option>
                  </select>
            </div>
        </form>
        <a href="/interestedStock/v1" role="button" class="btn btn-secondary">취소</a>
        <button type="button" class="btn btn-primary" id="btn-save">등록</button>
    </div>

    <script src="/js/app/interestedStock/interestedStock.js"></script>
