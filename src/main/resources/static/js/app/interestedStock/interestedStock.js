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

    },
    save : function () {
        var data = {
            ticker: $('#ticker').val(),
            stockNm: $('#stockNm').val(),
            businessCycle: $('#businessCycle').val(),
            nobilityStockYn: $('#nobilityStockYn').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/interestedStock',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('관심종목이 등록되었습니다.');
            window.location.href = '/interestedStock/v1';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            ticker: $('#ticker').val(),
            stockNm: $('#stockNm').val(),
            businessCycle: $('#businessCycle').val(),
            nobilityStockYn: $('#nobilityStockYn').val(),
        };

        var ticker = $('#ticker').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/interestedStock/'+ticker,
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('관심종목이 수정되었습니다.');
            window.location.href = '/interestedStock/v1';
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
            window.location.href = '/interestedStock/v1';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

};

interestedStock.init();