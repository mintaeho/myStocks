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
                            <h4 class="card-title">Interested Stocks</h4>
                        </div>
                        <div class="card-body">
                            <div class="toolbar">
                                <!--        Here you can write extra buttons/actions for the toolbar              -->
                                <button type="button" class="btn btn-outline-primary btn-sm" id="btn-reg-interestedStock">관심종목 등록</button>
                                <button type="button" class="btn btn-outline-primary btn-sm" id="btn-scrap-currentInfo">현행화</button>
                                <div class="text-right">* : 보유종목 &nbsp;&nbsp;&nbsp;&nbsp; ** : 배당귀족주</div>
                            </div>
                            <div class="material-datatables">
                                <table id="datatables" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                                    <thead>
                                        <tr>
                                            <th>경기순환</th>
                                            <th>섹터</th>
                                            <th>티커</th>
                                            <th>종목명</th>
                                            <th>표시</th>
                                            <th>현재가</th>
                                            <th>배당성향</th>
                                            <th>배당수익률</th>
                                            <th>배당금</th>
                                            <th>배당월</th>
                                            <th>52W Range</th>
                                            <th>최저가</th>
                                            <th>최고가</th>
                                            <th>평균가</th>
                                            <th>-10%하락</th>
                                            <th>-20%하락</th>
                                            <th>-30%하락</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>경기순환</th>
                                            <th>섹터</th>
                                            <th>티커</th>
                                            <th>종목명</th>
                                            <th>표시</th>
                                            <th>현재가</th>
                                            <th>배당성향</th>
                                            <th>배당수익률</th>
                                            <th>배당금</th>
                                            <th>배당월</th>
                                            <th>52W Range</th>
                                            <th>최저가</th>
                                            <th>최고가</th>
                                            <th>평균가</th>
                                            <th>-10%하락</th>
                                            <th>-20%하락</th>
                                            <th>-30%하락</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="items" items="${interestedStocks}" varStatus="status">
                                            <tr>
                                                <td class="text-center">${items.businessCycle}</td>
                                                <td class="text-center">${items.sector}</td>

                                                <td class="text-center">
                                                    <a href="javascript:interestedStock.popup_mod_interestedStock('/interestedStock/v1/update/${items.ticker}')">${items.ticker}</a>
                                                </td>
                                                <td class="text-center">
                                                    <a href="javascript:interestedStock.popup_view_companyInfo('/companyInfo/v1/view/${items.ticker}')">${items.stockNm}</a>
                                                </td>
                                                <td class="text-center">
                                                    ${items.buyingYn=='Y'?'*':''} /
                                                    ${items.nobilityStockYn=='Y'?'**':''}
                                                </td>

                                                <td class="text-right"><fmt:formatNumber value="${items.currentPrice}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.payoutRatio}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.divYield}" pattern="#,###.##"/></td>

                                                <td class="text-right"><fmt:formatNumber value="${items.annualPayout}" pattern="#,###.##"/></td>
                                                <td class="text-center">${items.dividendPayMonth}</td>
                                                <td class="text-center">
                                                    <div class="form-group">
                                                        <div class="slider" value="${items.currentPrice}" min="${items.lowerPrice}" max="${items.highestPrice}"></div>
                                                    </div>
                                                </td>
                                                <td class="text-center"><fmt:formatNumber value="${items.lowerPrice}" pattern="#,###.##"/></td>
                                                <td class="text-center"><fmt:formatNumber value="${items.highestPrice}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.avgPrice}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.under10Price}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.under20Price}" pattern="#,###.##"/></td>
                                                <td class="text-right"><fmt:formatNumber value="${items.under30Price}" pattern="#,###.##"/></td>
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
                <!-- end col-md-12 -->
            </div>
            <!-- end row -->
        </div>
    </div>

    <script src="/js/app/interestedStock/interestedStock.js?v=2.2.2"></script>
