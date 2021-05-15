var portfolio = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        $('#btn-reg-portfolio').on('click', function () {
            _this.popup_reg_portfolio();
        });
    },
    popup_reg_portfolio: function () {
        var url = "/portfolio/v1/save";
        window.open(url, "popup_reg_portfolio", "width=400, height=600, resizable=no, scrollbars=no, location=no");
    },
    popup_mod_portfolio: function(url) {
        window.open(url, "popup_mod_portfolio", "width=400, height=600, resizable=no, scrollbars=no, location=no");
    },
    save : function () {
        var data = {
            ticker: $('#ticker').val(),
            //stockNm: $('#stockNm').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/portfolio',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('종목이 등록되었습니다.');
            //window.location.href = '/portfolio/v1';
            opener.location.href = "/portfolio/v1";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var ticker = $('#ticker').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/portfolio/'+ticker,
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('종목이 삭제되었습니다.');
            //window.location.href = '/portfolio/v1';
            opener.location.href = "/portfolio/v1";
            window.close();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
};

portfolio.init();

