$(function () {
    $('#decrypt').click(function () {
        var key = $('#key').val();
        var ciphertext = $('#ciphertext').val();
        if (null != key && key.length >= 8 && null != ciphertext) {
            var query = {};
            query.key = key;
            query.ciphertext = ciphertext;
            $.ajax({
                type: "POST",
                url: "/code-center/des/decrypt",
                data: JSON.stringify(query),
                contentType: "application/json",    // 发送给服务器的数据类型
                dataType: "json",  // 服务器返回的数据类型
                async: true,   // 异步设为true，在服务器返回数据前不会锁定浏览器
                cache: false,
                success: function(response) {
                    if (response.success) {
                        $('#plaintext').val(response.plaintext);
                    } else {
                        alert("解密失败");
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