<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <div class="container-fluid">

        <div class="card ">
            <div class="card-header card-header-rose card-header-icon">
                <h4 class="card-title">최신정보 수집(수동)</h4>
            </div>
            <div class="card-body ">
                <form method="#" action="#">
                    <a href="javascript:interestedStock.getCurrentInfo()">정보가져오기</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="javascript:interestedStock.applyCurrentInfo()">적용하기</a>
                    <input type="hidden" id="requestUrl" value="${requestUrl}"/>
                    <div class="form-group">
                        <label>결과</label>
                        <div class="form-group">
                            <textarea class="form-control" rows="20" id="result"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="card-footer ">
                <a href="javascript:window.close()" role="button" class="btn btn-info">확인</a>
            </div>
        </div>

    </div>

    <script src="/js/app/interestedStock/interestedStock.js"></script>
