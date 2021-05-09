var portfolio = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
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
            window.location.href = '/portfolio/v1';
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
            window.location.href = '/portfolio/v1';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

};

portfolio.init();