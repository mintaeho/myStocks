<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <div class="card ">
                    <div class="card-header card-header-rose card-header-icon">
                        <h4 class="card-title">관심종목 수정</h4>
                    </div>
                    <div class="card-body ">
                        <form method="#" action="#">
                            <div class="form-group">
                                <label for="티커" class="bmd-label-floating">티커</label>
                                <input type="input" class="form-control" id="ticker" value="${interestedStock.ticker}" readonly>
                            </div>
                            <div class="form-group">
                                <label for="종목명" class="bmd-label-floating">종목명</label>
                                <input type="input" class="form-control" id="stockNm" value="${interestedStock.stockNm}">
                            </div>
                            <div class="form-group">
                                <label for="배당월" class="bmd-label-floating">배당수익률</label>
                                <input type="input" class="form-control" id="divYield" value="${interestedStock.divYield}">
                            </div>
                            <div class="form-group">
                                <label for="배당월" class="bmd-label-floating">주당배당금</label>
                                <input type="input" class="form-control" id="annualPayout" value="${interestedStock.annualPayout}">
                            </div>
                            <div class="form-group">
                                <label for="배당월" class="bmd-label-floating">배당성향</label>
                                <input type="input" class="form-control" id="payoutRatio" value="${interestedStock.payoutRatio}">
                            </div>
                            <div class="form-group">
                                <label for="배당월" class="bmd-label-floating">5년배당성장률</label>
                                <input type="input" class="form-control" id="fiveYearGrowthRate" value="${interestedStock.fiveYearGrowthRate}">
                            </div>
                            <div class="form-group">
                                <label for="배당월" class="bmd-label-floating">배당성장년수</label>
                                <input type="input" class="form-control" id="dividendGrowth" value="${interestedStock.dividendGrowth}">
                            </div>
                            <div class="form-group">
                                <select class="selectpicker" data-style="select-with-transition"
                                        title="섹터" data-size="7"
                                        id="sector">
                                    <option value="금융" ${interestedStock.sector=='금융'?'selected':''}>금융</option>
                                    <option value="부동산" ${interestedStock.sector=='부동산'?'selected':''}>부동산</option>
                                    <option value="자유소비재" ${interestedStock.sector=='자유소비재'?'selected':''}>자유소비재</option>
                                    <option value="산업재" ${interestedStock.sector=='산업재'?'selected':''}>산업재</option>
                                    <option value="정보기술" ${interestedStock.sector=='정보기술'?'selected':''}>정보기술</option>
                                    <option value="커뮤니케이션" ${interestedStock.sector=='커뮤니케이션'?'selected':''}>커뮤니케이션</option>
                                    <option value="소재" ${interestedStock.sector=='소재'?'selected':''}>소재</option>
                                    <option value="에너지" ${interestedStock.sector=='에너지'?'selected':''}>에너지</option>
                                    <option value="필수소비재" ${interestedStock.sector=='필수소비재'?'selected':''}>필수소비재</option>
                                    <option value="헬스케어" ${interestedStock.sector=='헬스케어'?'selected':''}>헬스케어</option>
                                    <option value="유틸리티" ${interestedStock.sector=='유틸리티'?'selected':''}>유틸리티</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <select class="selectpicker" data-style="select-with-transition"
                                        title="경기순환" data-size="7"
                                        id="businessCycle">
                                    <option value="회복" ${interestedStock.businessCycle=='회복'?'selected':''}>회복</option>
                                    <option value="호황" ${interestedStock.businessCycle=='호황'?'selected':''}>호황</option>
                                    <option value="후퇴" ${interestedStock.businessCycle=='후퇴'?'selected':''}>후퇴</option>
                                    <option value="불황" ${interestedStock.businessCycle=='불황'?'selected':''}>불황</option>
                                </select>
                            </div>
                            <div class="row">
                                <label class="col-md-3"></label>
                                <div class="col-md-9">
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="checkbox" id="nobilityStockYn" ${interestedStock.nobilityStockYn=='Y'?'checked':''} value=""> 배당귀족주
                                            <span class="form-check-sign">
                                                <span class="check"></span>
                                            </span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>회사 정보</label>
                                <div class="form-group">
                                    <label class="bmd-label-floating">이 회사의 수익구조, 주요 이슈 및 향후 전망 등</label>
                                    <textarea class="form-control" rows="5" id="companyInfo">${interestedStock.companyInfo}</textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer ">
                        <a href="javascript:window.close()" role="button" class="btn btn-info">취소</a>
                        <button type="button" class="btn btn-danger" id="btn-delete">삭제</button>
                        <button type="button" class="btn btn-primary" id="btn-update">수정 완료</button>
                    </div>
                </div>
            </div> <!-- end of col-md-6 -->
        </div>
    </div>

    <script src="/js/app/interestedStock/interestedStock.js"></script>