<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <!-- 목록 출력 영역 -->
    <div class="row">
        <div class="col">
          <h2>Interested Stocks</h2>
        </div>
        <div class="col-md-auto">

        </div>
        <div class="col col-lg-2">
          <a href="/interestedStock/v1/save" role="button" class="btn btn-outline-primary btn-sm">관심종목 등록</a>
        </div>
    </div>

    <!-- 목록 출력 영역 -->
    <div class="table-responsive">
        <table class="table table-bordered table-sm">
            <thead>
                <tr>
                    <th>No</th>
                    <th>티커</th>
                    <th>종목명</th>
                    <th>보유/귀족</th>
                    <th>경기순환</th>
                    <th>섹터</th>
                    <th>현재가</th>
                    <th>배당성향</th>
                    <th>배당금</th>
                    <th>배당수익률</th>
                    <th>배당월</th>
                    <th>52주최고가</th>
                    <th>52주최저가</th>
                    <th>평균가</th>
                    <th>-10%하락</th>
                    <th>-20%하락</th>
                    <th>-30%하락</th>
                </tr>
            </thead>
            <tbody id="tbody">
                <c:forEach var="items" items="${interestedStocks}" varStatus="status">
                    <tr>
                        <td class="text-center">${status.count}</td>
                        <td class="text-center">${items.ticker}</td>
                        <td class="text-center">
                            <a href="/interestedStock/v1/update/${items.ticker}">${items.stockNm}</a>
                        </td>
                        <td class="text-center">
                            ${items.buyingYn=='Y'?'*':''} /
                            ${items.nobilityStockYn=='Y'?'**':''}
                        </td>
                        <td class="text-center">${items.businessCycle}</td>
                        <td class="text-center">${items.sector}</td>
                        <td class="text-right">${items.currentPrice}</td>
                        <td class="text-right">${items.payoutRatio}</td>
                        <td class="text-right">${items.annualPayout}</td>
                        <td class="text-right">${items.divYield}</td>
                        <td class="text-center">${items.dividendPayMonth}</td>
                        <td class="text-right">${items.highestPrice}</td>
                        <td class="text-right">${items.lowerPrice}</td>
                        <td class="text-right"><fmt:formatNumber value="${items.avgPrice}" pattern="#,###.##"/></td>
                        <td class="text-right"><fmt:formatNumber value="${items.under10Price}" pattern="#,###.##"/></td>
                        <td class="text-right"><fmt:formatNumber value="${items.under20Price}" pattern="#,###.##"/></td>
                        <td class="text-right"><fmt:formatNumber value="${items.under30Price}" pattern="#,###.##"/></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
        * : 보유종목<br/>
        ** : 배당귀족주
    </div>
    <script src="/js/app/interestedStock/interestedStock.js"></script>
