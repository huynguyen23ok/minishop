<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="container-login">
    <div id="container-login-left">
        <div id="header-left" class="header-login">
            <span id="text-logo">Welcome</span></br>
            <span id="hinh-text-logo">Hãy tạo nên phong cách của bạn cùng minishop</span>
        </div>
        <div id="header-bottom">
            <p><span>Luôn cập nhật theo xu hướng</span></p>
            <p><span>Giảm hơn 50% tất cả các mặt hàng giành cho khách VIP</span></p>
            <p><span>Tận tình tư vấn để tạo nên phong cách của bạn</span></p>
        </div>
    </div>
    <div id="container-login-right">
        <div id="header-top-right" class="header-login">
            <span class="active">Đăng nhập</span>/<span>Đăng ký</span>
        </div>
        <div id="container-center-login-right">
            <form action="/login" method="post">
                <input class="meterial-textinput" type="text" placeholder="Tài khoản" name="user"/></br>
                <input class="meterial-textinput" type="password" placeholder="Mật khẩu" name="password"/></br>
                <input class="meterial-primary-buttom" type="submit" value="Đăng nhập">
            </form>
        </div>
        <div id="container-social-login">
        </div>
    </div>
</div>