<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header card-header-primary card-header-icon">
                            <div class="card-icon">
                                <i class="material-icons">assignment</i>
                            </div>
                            <h4 class="card-title">Portfolio</h4>
                        </div>

                        <div class="card-body">
                            <div class="toolbar">
                                <!--        Here you can write extra buttons/actions for the toolbar              -->
                                <button type="button" class="btn btn-outline-primary btn-sm" id="btn-reg-portfolio">포트폴리오 등록</button>
                            </div>

                            <div class="material-datatables">
                                <table id="datatables" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                                    <thead>
                                        <tr>
                                            <th class="disabled-sorting text-right">No</th>
                                            <th>경기<br/>순환</th>
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
                                    <tfoot>
                                        <tr>
                                            <th>No</th>
                                            <th>경기<br/>순환</th>
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
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="items" items="${portfolio}" varStatus="status">
                                            <tr>
                                                <td>${status.count}</td>
                                                <td>${items.businessCycle}</td>
                                                <td>${items.sector}</td>
                                                <td>
                                                <a href="javascript:portfolio.popup_mod_portfolio('/portfolio/v1/update/${items.ticker}')">${items.ticker}</a></td>
                                                <td>${items.stockNm}</td>
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
                                                <td class="text-center">${items.dividendPayMonth}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- end card body-->
                    </div>
                    <!--  end card  -->
                </div>
                <!-- end col-md-12 -->
            </div>
            <!-- end row -->

            <div class="row">
                <c:forEach var="items" items="${portfolioSum}" varStatus="status">
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-header card-header-primary card-header-icon">
                              <div class="card-icon">
                                <i class="material-icons">assignment</i>
                              </div>
                              <h4 class="card-title">Sum</h4>
                            </div>
                            <div class="card-body">
                                <div class="toolbar">
                                    <!--        Here you can write extra buttons/actions for the toolbar              -->
                                    ※ 적용환율 : 1,116원 적용
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th>총 배당금</th>
                                                <th>총 투자금액($)</th>
                                                <th>총 평가금액($)</th>
                                                <th>수익금($)</th>
                                                <th>수익률(%)</th>
                                                <th>총 배당금(원)</th>
                                                <th>총 투자금액(원)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td class="text-right"><fmt:formatNumber value="${items.totalPayout}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.totalTradingAmount}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.totalEvalAmount}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.earningAmount}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.earningRate}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.totalPayout*1116}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.totalTradingAmount*1116}" pattern="#,###.##"/></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- end content-->
                        </div>
                        <!--  end card  -->
                    </div>
                    <!-- end col-md-6 -->
                </c:forEach>

                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header card-header-primary card-header-icon">
                          <div class="card-icon">
                            <i class="material-icons">assignment</i>
                          </div>
                          <h4 class="card-title">배당금 요약</h4>
                        </div>
                        <div class="card-body">
                            <div class="toolbar">
                                <!--        Here you can write extra buttons/actions for the toolbar              -->
                                ※ 적용환율 : 1,116원 적용
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                                    <thead>
                                        <tr>
                                            <th>배당지급월</th>
                                            <th>배당금($)</th>
                                            <th>월별 배당금($)</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="items" items="${summaryPayout}" varStatus="status">
                                            <tr>
                                                <td class="text-center">${items.dividendPayMonth}</td>
                                                <td class="text-right"><fmt:formatNumber value="${items.totalPayout}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.payoutMonth}" pattern="#,###.##"/></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- end content-->
                    </div>
                    <!--  end card  -->
                </div>
                <!-- end col-md-6 -->

          </div>
          <!-- end row -->

        </div>
    </div>

    <script src="/js/app/portfolio/portfolio.js"></script>







