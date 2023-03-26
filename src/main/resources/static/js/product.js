let main = {
    init : function () {
        let _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },

    save : function () {
        let data = {
            name: $('#name').val(),
            category: $('#category').val(),
            day: $('#day').val(),
            time: $('#time').val(),
            description: $('#description').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/products',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('예약 신청이 등록되었습니다.');
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();