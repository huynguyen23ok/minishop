<%@ include file="/common/taglib/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="info" class="container-fluid">
    <div class="row">
        <div class="col-md-4 col-sm-4 col-12 wow fadeInLeft" data-wow-duration="3s">
            <img class="icon" src="<c:url value="/resources/image/quality.png"/>"/><br>
            <span style="font-size: 32px;font-weight: 500">CHẤT LƯỢNG</span><br>
            <span>Chúng tôi cam kết mang đến cho các bạn chất lượng sản phẩm tốt nhất</span>
        </div>
        <div class="col-md-4 col-sm-4 col-12 wow fadeInDown" data-wow-duration="3s" data-wow-delay="2s">
            <img class="icon" src="<c:url value="/resources/image/quality.png"/>"/><br>
            <span style="font-size: 32px;font-weight: 500">TIẾT KIỆM CHI PHÍ</span><br>
            <span>Cam kết giá rẻ nhất Việt Nam giúp các bạn tiết kiệm hơn 20% cho từng sản phẩm</span>
        </div>
        <div class="col-md-4 col-sm-4 col-12 wow fadeInUp" data-wow-duration="3s" data-wow-delay="2s">
            <img class="icon" src="<c:url value="/resources/image/quality.png"/>"/><br>
            <span style="font-size: 32px;font-weight: 500">GIAO HÀNG</span><br>
            <span>Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm đến cho khách hàng nhanh nhất</span>
        </div>
    </div>
    <div id="title-sanpham" class="container">
        <span>SẢN PHẨM HOT</span>
        <div class="row" style="margin-top: 42px">
            <c:forEach var="item" items="${listSanpham}">
                <a href="/chitiet/${item.masanpham}">
                    <div class="col-md-3 col-sm-6 wow swing">
                        <div class="product">
                            <img src="<c:url value="/resources/sanpham/${item.hinhsanpham}.jpg"/>"/><br>
                            <span>${item.tensanpham}</span><br>
                            <span class="price">${item.giatien}</span>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
</div>