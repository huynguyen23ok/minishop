<%@ include file="/common/taglib/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Danh sách sản phẩm</title>
<style>
    #header {
        background-image: none;
        height: 80px;
        background: black;
    }

    #dahmuc {
        margin-left: 245px;
        font-size: 51px;
        color: rebeccapurple;
    }

    img {
        margin-left: 27px;
    }
</style>
<div class="container">
    <div class="col-sm-2 col-md-2">
        <h3>Danh mục</h3>
        <ul class="mymenu">
            <c:forEach var="item" items="${listDanhmuc}">
                <li><a href="/list/${item.madanhmuc}/${item.tendanhmuc}">${item.tendanhmuc}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-sm-8 col-md-8">
        <div class="row">
            <span id="dahmuc"> ${danhmuc}</span>
            <div class="row">
                <c:forEach var="item" items="${list}">
                    <a href="/chitiet/${item.masanpham}">
                        <div class="col-md-4 col-sm-6 wow swing">
                            <div class="product">
                                <img src="<c:url value="/resources/sanpham/${item.hinhsanpham}.jpg"/>"/><br>
                                <span style="margin-left: 24px;margin-top: 11px">${item.tensanpham}</span><br>
                                <span style="margin-left: 88px" class="price">${item.giatien}</span>
                            </div>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="col-sm-2 col-md-2">
    </div>
</div>