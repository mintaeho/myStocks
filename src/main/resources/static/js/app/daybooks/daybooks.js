var daybooks = {
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

        $('#btn-reg-daybook').on('click', function () {
            _this.popup_reg_daybook();
        });
    },
    popup_reg_daybook: function () {
        var url = "/daybooks/v1/save";
        window.open(url, "popup_reg_daybook", "width=400, height=600, resizable=no, scrollbars=no, location=no");
    },
    popup_mod_daybook: function(url) {
        window.open(url, "popup_mod_daybook", "width=400, height=600, resizable=no, scrollbars=no, location=no");
    },
    save : function () {

        var data = {
            tradingDate: $('#tradingDate').val().replace(/(\\|\/)/g,''),
            ticker: $('#ticker').val(),
            unitPrice: $('#unitPrice').val(),
            stockNum: $('#stockNum').val(),
            tradingType: $("input[name='tradingType']:checked").val(),
            fee: $('#fee').val(),
            exchangeRate: $('#exchangeRate').val(),
            tradingAmount: $('#unitPrice').val() * $('#stockNum').val(),
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/daybooks',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('매매내역이 등록되었습니다.');
            //window.location.href = '/daybooks/v1';
            opener.location.href = "/daybooks/v1";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {

        var data = {
            tradingDate: $('#tradingDate').val().replace(/(\\|\/)/g,''),
            ticker: $('#ticker').val(),
            unitPrice: $('#unitPrice').val(),
            stockNum: $('#stockNum').val(),
            tradingType: $('#tradingType').val(),
            fee: $('#fee').val(),
            exchangeRate: $('#exchangeRate').val(),
            tradingAmount: $('#unitPrice').val() * $('#stockNum').val(),

        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/daybooks/'+id,
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('매매내역이 수정되었습니다.');
            //window.location.href = '/daybooks/v1';
            opener.location.href = "/daybooks/v1";
            window.close();
        }).fail(function (error) {
            //alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/daybooks/'+id,
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('관심종목이 삭제되었습니다.');
            //window.location.href = '/daybooks/v1';
            opener.location.href = "/daybooks/v1";
            window.close();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

};

daybooks.init();