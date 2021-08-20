$(document).ready(function () {
    /*đăng nhập*/
    $("#dangnhap").click(function () {
        var user = $("#user").val();
        var password = $("#password").val();
        $.ajax({
            url: "/api/checklogin",
            type: "get",
            data: {
                user: user,
                password: password
            },
            success: function (value) {
                if (value == "true") {
                    duongdanhientai = window.location.href;
                    duongdan = duongdanhientai.replace("/login", "");
                    window.location = duongdan;
                } else {
                    $("#ketqua").text("Tài khoản hoặc mật khẩu không đúng");
                }
            }

        })
    });



    /*active dk or dn*/
    $("#dangnhap1").click(function () {
        $(this).addClass("active");
        $("#dangky").removeClass("active");
        $("#container-login1").show();
        $("#container-singup").hide();
    })
    $("#dangky").click(function () {
        $(this).addClass("active");
        $("#dangnhap1").removeClass("active");
        $("#container-login1").hide();
        $("#container-singup").show();
    })

})