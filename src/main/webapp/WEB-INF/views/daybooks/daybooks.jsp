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
                            <h4 class="card-title">Daybooks</h4>
                        </div>
                        <div class="card-body">
                            <div class="toolbar">
                                <!--        Here you can write extra buttons/actions for the toolbar              -->
                                <button type="button" class="btn btn-outline-primary btn-sm" id="btn-reg-daybook">매매일지 등록</button>
                            </div>
                            <div class="material-datatables">
                                <table id="datatables" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                                    <thead>
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
                                    <tfoot>
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
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="items" items="${daybooks}" varStatus="status">
                                            <tr>
                                                <td class="text-center">
                                                    <fmt:parseDate value="${items.tradingDate}" var="tradingDate" pattern="yyyyMMdd"/>
                                                    <fmt:formatDate value="${tradingDate}" pattern="yyyy/MM/dd"/>
                                                </td>
                                                <td class="text-center"><a href="javascript:daybooks.popup_mod_daybook('/daybooks/v1/update/${items.id}')">${items.ticker}</a></td>
                                                <td class="text-right">${items.unitPrice}</td>
                                                <td class="text-right">${items.stockNum}</td>
                                                <td class="text-center">${items.tradingType}</td>
                                                <td class="text-right">${items.tradingAmount}</td>
                                                <td class="text-right">${items.fee}</td>
                                                <td class="text-right">${items.exchangeRate}</td>
                                                <td></td>
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

    <script src="/js/app/daybooks/daybooks.js?v=2.2.2"></script>


