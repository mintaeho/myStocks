<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <div class="card ">
                    <div class="card-header card-header-rose card-header-icon">
                        <h4 class="card-title">업체정보 조회</h4>
                    </div>
                    <div class="card-body ">
                        <form method="#" action="#">
                            ${companyInfo.stockNm}(${companyInfo.ticker}), ${companyInfo.businessCycle},
                            배당귀족:${companyInfo.nobilityStockYn}
                            <div class="form-group">
                                <label>회사 정보</label>
                                <div class="form-group">
                                    <label class="bmd-label-floating">이 회사의 수익구조, 주요 이슈 및 향후 전망 등</label>
                                    <textarea class="form-control" rows="20" id="companyInfo" readonly>${companyInfo.companyInfo}</textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer ">
                        <a href="javascript:window.close()" role="button" class="btn btn-info">확인</a>
                    </div>
                </div>
            </div> <!-- end of col-md-6 -->
        </div>
    </div>

    <script src="/js/app/interestedStock/interestedStock.js"></script>
