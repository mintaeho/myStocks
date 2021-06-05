var interestedStock = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        $('#btn-reg-interestedStock').on('click', function () {
            _this.popup_reg_interestedStock();
        });

        $('#btn-get-currentInfo').on('click', function () {
            _this.getCurrentInfo();
        });

        $('#btn-scrap-currentInfo').on('click', function () {
            _this.applyCurrentInfo();
        });


    },
    popup_reg_interestedStock: function () {
        var url = "/interestedStock/v1/save";
        window.open(url, "popup_reg_interestedStock", "width=400, height=600, resizable=no, scrollbars=no, location=no");
    },
    popup_mod_interestedStock: function(url) {
        window.open(url, "popup_mod_interestedStock", "width=400, height=600, resizable=no, scrollbars=no, location=no");
    },
    popup_view_companyInfo: function(url) {
        window.open(url, "popup_view_companyInfo", "width=400, height=600, resizable=no, scrollbars=no, location=no");
    },
    popup_get_currentInfo: function(url) {
        window.open(url, "popup_get_currentInfo", "width=400, height=600, resizable=no, scrollbars=no, location=no");
    },
    getCurrentInfo: function() {
        var url = $("#requestUrl").val();
        popup2 = window.open(url, "popup_get_currentInfo_result", "width=400, height=600, resizable=no, scrollbars=no, location=no");
    },
    save : function () {
        var data = {
            ticker: $('#ticker').val(),
            stockNm: $('#stockNm').val(),
            divYield: $('#divYield').val(),
            annualPayout: $('#annualPayout').val(),
            payoutRatio: $('#payoutRatio').val(),
            fiveYearGrowthRate: $('#fiveYearGrowthRate').val(),
            dividendGrowth: $('#dividendGrowth').val(),
            businessCycle: $('#businessCycle').val(),
            sector: $('#sector').val(),
            nobilityStockYn: $('#nobilityStockYn').is(":checked")?"Y":"N",
            companyInfo: $('#companyInfo').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/interestedStock',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('관심종목이 등록되었습니다.');
            window.opener.location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            ticker: $('#ticker').val(),
            stockNm: $('#stockNm').val(),
            divYield: $('#divYield').val(),
            annualPayout: $('#annualPayout').val(),
            payoutRatio: $('#payoutRatio').val(),
            fiveYearGrowthRate: $('#fiveYearGrowthRate').val(),
            dividendGrowth: $('#dividendGrowth').val(),
            businessCycle: $('#businessCycle').val(),
            sector: $('#sector').val(),
            nobilityStockYn: $('#nobilityStockYn').is(":checked")?"Y":"N",
            companyInfo: $('#companyInfo').val(),
        };

        var ticker = $('#ticker').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/interestedStock/'+ticker,
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('관심종목이 수정되었습니다.');
            window.opener.location.reload();
            window.close();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var ticker = $('#ticker').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/interestedStock/'+ticker,
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('관심종목이 삭제되었습니다.');
            window.opener.location.reload();
            window.close();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    applyCurrentInfo: function() {
        var data = {
            result: $('#result').val()
        };

        $.ajax({
            type: 'POST',
            //url: '/api/v1/scrap/manual',
            url: '/api/v1/scrap',
            contentType:'application/json; charset=utf-8',
            //data: JSON.stringify($('#result').val())
            data: $('#result').val()
        }).done(function() {
            alert('최신정보로 반영되었습니다.');
            window.location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

interestedStock.init();