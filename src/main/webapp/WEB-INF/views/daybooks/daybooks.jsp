<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <!-- 목록 출력 영역 -->
    <div class="row">
        <div class="col">
          <h2>Trading daybooks</h2>
        </div>
        <div class="col-md-auto">

        </div>
        <div class="col col-lg-2">
          <a href="/daybooks/v1/save" role="button" class="btn btn-outline-primary btn-sm">매매일지 등록</a>
        </div>
    </div>

    <div class="table-responsive">
        <table class="table table-horizontal table-bordered table-sm">
            <thead class="thead-strong">
                <tr>
                    <th>거래일</th>
                    <th>티커</th>
                    <th>체결단가</th>
                    <th>주식수</th>
                    <th>매매구분</th>
                    <th>거래금액($)</th>
                    <th>수수료</th>
                    <th>환율</th>
                    <th>거래금액(원)</th>
                </tr>
            </thead>
            <tbody id="tbody">
                <c:forEach var="items" items="${daybooks}" varStatus="status">
                    <tr>
                        <td>${items.tradingDate}</td>
                        <td><a href="/daybooks/v1/update/${items.id}">${items.ticker}</a></td>
                        <td>${items.unitPrice}</td>
                        <td>${items.stockNum}</td>
                        <td>${items.tradingType}</td>
                        <td>${items.tradingAmount}</td>
                        <td>${items.fee}</td>
                        <td>${items.exchangeRate}</td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="/js/app/daybooks/daybooks.js"></script>
