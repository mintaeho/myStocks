<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/include/taglibInc.jsp" %>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <div class="card ">
                    <div class="card-header card-header-rose card-header-icon">
                        <h4 class="card-title">관심종목 등록</h4>
                    </div>
                    <div class="card-body ">
                        <form method="#" action="#">
                            <div class="form-group">
                                <label for="티커" class="bmd-label-floating">티커</label>
                                <input type="input" class="form-control" id="ticker">
                            </div>
                            <div class="form-group">
                                <label for="종목명" class="bmd-label-floating">종목명</label>
                                <input type="input" class="form-control" id="stockNm">
                            </div>
                            <div class="form-group">
                                <label for="배당월" class="bmd-label-floating">배당월</label>
                                <input type="input" class="form-control" id="dividendPayMonth">
                            </div>
                            <div class="form-group">
                                <select class="selectpicker" data-style="select-with-transition"
                                        title="경기순환" data-size="7"
                                        id="businessCycle">
                                    <option value="회복" selected>회복</option>
                                    <option value="호황">호황</option>
                                    <option value="후퇴">후퇴</option>
                                    <option value="불황">불황</option>
                                </select>
                            </div>
                            <div class="row">
                                <label class="col-md-3"></label>
                                <div class="col-md-9">
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="checkbox" id="nobilityStockYn" checked value=""> 배당귀족주
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
                                    <textarea class="form-control" rows="5" id="companyInfo"></textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer ">
                        <a href="javascript:window.close()" role="button" class="btn btn-info">취소</a>
                        <button type="button" class="btn btn-primary" id="btn-save">등록</button>
                    </div>
                </div>
            </div> <!-- end of col-md-6 -->
        </div>
    </div>

    <script src="/js/app/interestedStock/interestedStock.js"></script>
