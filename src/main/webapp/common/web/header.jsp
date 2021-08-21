<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .circle-giohang {
        text-align: center;
        position: absolute;
        width: 20px;
        height: 20px;
        font-size: 11px;
        border-radius: 40px;
        background: red;
        line-height: 22px;
        margin-top: -26px;
        margin-left: 10px;
        color: white;
    }
</style>
<nav class="navbar navbar-inverse none-nav">
    <div class="container-fluid ">
        <div class="navbar-header ">
            <a class="navbar-brand" href="/"><img id="logo-toto"
                                                  src="<c:url value="/resources/image/iconlogo.jpg" />"></a>
        </div>
        <ul class="nav navbar-nav navbar-center">
            <li class="active"><a href="/" style="background: none">Trang chủ</a></li>
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
            <li id="giohang"><a href="#"><span class="glyphicon  glyphicon-shopping-cart">
            <c:if test="${soluong >0}">
                <div class="circle-giohang">
                        ${soluong}
                </div>
            </c:if>
                <c:if test="${soluong <=0 || soluong== null}">
                <div class="circle-giohang">
                       0
                </div>
                </c:if>
            </span></a></li>
            <c:if test="${taikhoan != null}">
                <li><a>${taikhoan}</a></li>
                <li><a href="/logout"> Thoát</a></li>
            </c:if>
            <c:if test="${taikhoan == null}">
                <li><a href="/login"> Đăng nhập</a></li>
            </c:if>
        </ul>
    </div>
    <div class="event-header wow bounceIn ">
        <span>Ngày 17/10  - 23/10</span></br>
        <span style="sfont-size: 50px">Mua 1 tặng 1</span></br>
        <button>Xem ngay</button>
    </div>
</nav>
