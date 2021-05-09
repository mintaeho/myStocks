var sidebar = {
    init : function () {
        var _this = this;
        $('#btn-scraping').on('click', function () {
            _this.scraping();
        });
    },
    scraping : function () {
        $.ajax({
            type: 'POST',
            url: '/api/v1/scrap',
            contentType:'application/json; charset=utf-8',
        }).done(function() {
            alert('수집이 완료되었습니다.');
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
};

sidebar.init();