<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <!-- 목록 출력 영역 -->
    <div class="row">
        <div class="col">
          <h2>Portfolio</h2>
        </div>
        <div class="col-md-auto">

        </div>
        <div class="col col-lg-2">
          <a href="/portfolio/v1/save" role="button" class="btn btn-outline-primary btn-sm">포트폴리오 등록</a>
        </div>
    </div>

    <div class="table-responsive">
        <table class="table table-bordered table-sm">
            <thead>
                <tr>
                    <th>No</th>
                    <th>경기순환</th>
                    <th>섹터</th>
                    <th>티커</th>
                    <th>종목명</th>
                    <th>현재가</th>
                    <th>평균매입단가</th>
                    <th>주식수</th>
                    <th>주당배당금</th>
                    <th>배당금</th>
                    <th>투자배당률</th>
                    <th>매입금액</th>
                    <th>평가금액</th>
                    <th>수익금액</th>
                    <th>수익률</th>
                    <th>비중</th>
                    <th>배당월</th>
                </tr>
            </thead>
            <tbody id="tbody">
                <c:forEach var="items" items="${portfolio}" varStatus="status">
                    <tr>
                        <td class="text-center">${status.count}</td>
                        <td class="text-center">${items.businessCycle}</td>
                        <td class="text-center">${items.sector}</td>
                        <td class="text-center"><a href="/portfolio/v1/update/${items.ticker}">${items.ticker}</a></td>
                        <td class="text-center">${items.stockNm}</td>
                        <td class="text-right">${items.currentPrice}</td>
                        <td class="text-right"><fmt:formatNumber value="${items.avgUnitPrice}" pattern="#,###.##"/></td>
                        <td class="text-right">${items.totalStockNum}</td>
                        <td class="text-right">${items.annualPayout}</td>
                        <td class="text-right">${items.totalPayout}</td>
                        <td class="text-right"><fmt:formatNumber value="${items.investmentDivYield}" pattern="#,###.##"/></td>
                        <td class="text-right">${items.totalTradingAmount}</td>
                        <td class="text-right">${items.evalAmount}</td>
                        <td class="text-right">${items.earningAmount}</td>
                        <td class="text-right"><fmt:formatNumber value="${items.earningRate}" pattern="#,###.##"/></td>
                        <td class="text-right"><fmt:formatNumber value="${items.portion}" pattern="#,###.##"/></td>
                        <td class="text-right"></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <c:forEach var="items" items="${portfolioSum}" varStatus="status">
        ※ 적용환율 : 1,116원 적용
        <div class="table-responsive">
            <table class="table table-bordered table-sm">
                <thead class="thead-strong">
                    <tr>
                        <th>총 배당금</th>
                        <th>총 배당금(원)</th>
                        <th>총 투자금액($)</th>
                        <th>총 투자금액(원)</th>
                        <th>총 평가금액($)</th>
                        <th>수익금($)</th>
                        <th>수익률(%)</th>
                    </tr>
                </thead>
                <tbody id="tbody">
                    <tr>
                        <td class="text-right"><fmt:formatNumber value="${items.totalPayout}" pattern="#,###.##"/></td>
                        <td class="text-right"><fmt:formatNumber value="${items.totalPayout*1116}" pattern="#,###.##"/></td>
                        <td class="text-right"><fmt:formatNumber value="${items.totalTradingAmount}" pattern="#,###.##"/></td>
                        <td class="text-right"><fmt:formatNumber value="${items.totalTradingAmount*1116}" pattern="#,###.##"/></td>
                        <td class="text-right"><fmt:formatNumber value="${items.totalEvalAmount}" pattern="#,###.##"/></td>
                        <td class="text-right"><fmt:formatNumber value="${items.earningAmount}" pattern="#,###.##"/></td>
                        <td class="text-right"><fmt:formatNumber value="${items.earningRate}" pattern="#,###.##"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </c:forEach>

    <script src="/js/app/portfolio/portfolio.js"></script>
