<%@ include file="/common/taglib/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    #header {
        background-image: none;
        height: 80px;
        background: black;
    }
</style>
<div class="container">
    <div class="col-md-12">
        <c:if test="${empty listgiohang}">
            <h1 class="text-center">Không có sản phẩm nào cả </h1>
        </c:if>
        <c:if test="${not empty listgiohang}">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Màu sản phẩm</th>
                    <th scope="col">Size</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="item" items="${listgiohang}">
                    <tr>
                        <td>${item.tenSp}</td>
                        <td>${item.mauSanPham}</td>
                        <td>${item.tenSize}</td>
                        <td>${item.giaTien}</td>
                        <td>${item.soLuong}</td>
                        <td>
                            <button class="btn btn-danger">Xóa</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <a href="/">
            <button class="btn btn-primary">Tiếp tục mua sắm</button>
        </a>
    </div>
</div>