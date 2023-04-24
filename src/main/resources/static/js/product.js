let main = {
    init : function () {
        let _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },

    save : function () {
        let data = {
            name: $('#Name').val(),
            category: $('#category').val(),
            date: $('#date').val(),
            time: $('#time').val(),
            description: $('#description').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/products',
            dataType: 'TEXT',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).then(function() {
            alert('예약 신청이 등록되었습니다.');
            location.href = "/";
        }).fail(function (error) {
            alert('예약 신청이 등록되었습니다.');
            location.href = "/";
        });
    }
};

main.init();