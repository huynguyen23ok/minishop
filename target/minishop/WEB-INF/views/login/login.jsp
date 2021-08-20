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
            <span class="active" id="dangnhap1">Đăng nhập</span>/<span id="dangky">Đăng ký</span>
        </div>
        <div id="container-center-login-right" style="margin-bottom: 200px">
            <span id="ketqua"></span>
            ${kiemtra}
            <div id="container-login1" class="loginform">
                <input class="meterial-textinput" type="text" placeholder="Tài khoản" name="user" id="user"/></br>
                <input class="meterial-textinput" type="password" placeholder="Mật khẩu" name="password"
                       id="password"/></br>
                <input id="dangnhap" class="meterial-primary-buttom" type="submit" value="Đăng nhập">
            </div>
            </span>
            <div id="container-social-login">
            </div>
        </div>
    </div>
</div>