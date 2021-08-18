<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid" id="header">
    <nav class="navbar navbar-inverse none-nav">
        <div class="container-fluid ">
            <div class="navbar-header ">
                <a class="navbar-brand" href="#"><img id="logo-toto"
                                                      src="<c:url value="/resources/image/iconlogo.jpg" />"></a>
            </div>
            <ul class="nav navbar-nav navbar-center">
                <li class="active"><a href="#" style="background: none">Trang chủ</a></li>
                <li class="active"><a class="dropdown-toggle" data-toggle="dropdown" style="background: none" href="#">Sản
                    phẩm <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Page 1-1</a></li>
                        <li><a href="#">Page 1-2</a></li>
                        <li><a href="#">Page 1-3</a></li>
                    </ul>
                </li>
                <li class="active"><a style="background: none" href="#">Dịch vụ</a></li>
                <li class="active"><a style="background: none" href="#">Liên hệ</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login"> Đăng nhập</a></li>
                <li><a href="#"> Đăng ký</a></li>
                <li><a href="#"><span class="glyphicon  glyphicon-shopping-cart"></span> Giỏ hàng</a></li>
            </ul>
        </div>
    </nav>
    <div class="event-header wow bounceIn ">
        <span>Ngày 17/10  - 23/10</span></br>
        <span style="font-size: 50px">Mua 1 tặng 1</span></br>
        <button>Xem ngay</button>
    </div>
</div>