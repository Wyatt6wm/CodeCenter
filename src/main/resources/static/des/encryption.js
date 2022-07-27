$(function () {
    $('#encrypt').click(function () {
        var key = $('#key').val();
        var plaintext = $('#plaintext').val();
        if (null != key && key.length >= 8 && null != plaintext) {
            var query = {};
            query.key = key;
            query.plaintext = plaintext;
            $.ajax({
                type: "POST",
                url: "/code-center/des/encrypt",
                data: JSON.stringify(query),
                contentType: "application/json",    // 发送给服务器的数据类型
                dataType: "json",  // 服务器返回的数据类型
                async: true,   // 异步设为true，在服务器返回数据前不会锁定浏览器
                cache: false,
                success: function(response) {
                    if (response.success) {
                        $('#ciphertext').val(response.ciphertext);
                    } else {
                        alert("加密失败");
                    }
                },
                error: function() {
                    alert("提交失败")
                }
            });
        } else {
            alert("输入错误");
        }
    });
});