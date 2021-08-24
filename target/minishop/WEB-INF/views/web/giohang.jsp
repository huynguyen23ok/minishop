<%@ include file="/common/taglib/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Giỏ hàng</title>
<style>
    #header {
        background-image: none;
        height: 80px;
        background: black;
    }

    .container {
        width: 1200px;
    }

    img {
        height: 150px;
    }
</style>
<div class="row" style="margin-top: 20px">
    <div class="col-md-12 col-sm-12">
        <h3 class="text-center">Giỏ hàng</h3>
        <c:if test="${empty listgiohang}">
            <h1 class="text-center">Không có sản phẩm nào cả </h1>
        </c:if>
        <c:if test="${not empty listgiohang}">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Tên sản phẩm</th>
                    <th>Ảnh sản phẩm</th>
                    <th>Màu</th>
                    <th>Size</th>
                    <th>Số lượng</th>
                    <th>Giá</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listgiohang}">
                    <tr>
                        <td class="masp" data-masp="${item.maSP}">${item.tenSp}</td>
                        <td class="text-center"><img src="<c:url value="/resources/sanpham/${item.anhSanpham}.jpg"/>"/></td>
                        <td class="mausp" data-mausp="${item.maMau}">${item.mauSanPham}</td>
                        <td class="size" data-size="${item.maSize}">${item.tenSize}</td>
                        <td class="soluong"><input class="soluong-giohang" min="1" max="5"
                                                   type="number"
                                                   value="${item.soLuong}"/></td>
                        <td class="money" data-value="${item.giaTien}">${item.giaTien}</td>
                        <td>
                            <button class="btn btn-danger btxoa">Xóa</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <h4>Tổng tiền :<span id="tongtien"></span></h4>
        <a href="/">
            <button class="btn btn-primary">Tiếp tục mua sắm</button>
        </a>
    </div>
    <div class="col-md-12 col-sm-12">
        <h3 class="text-center">Thông tin người nhận người mua</h3>
        <div class="form-group">
            <form action="/giohang" method="post">
                <label for="tenkhachhang">Tên người mua/nhận</label><br>
                <input class="form-control" id="tenkhachhang" name="tenkhachhang"/><br>
                <label for="sdt">Điện thoại nhận hàng</label><br>
                <input class="form-control" id="sdt" name="sdt"/><br>
                <div class="radio">
                    <label><input type="radio" name="hinhthucgiaohang" checked="" value="Giao hàng tận nhà">Giao hàng tận nhà</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="hinhthucgiaohang" value="Giao hàng tại của hàng">Giao hàng tại của
                        hàng</label>
                </div>
                <br>
                <label for="diachigiaohang">Địa chỉ nhận hàng</label><br>
                <input class="form-control" id="diachigiaohang" name="diachigiaohang"/><br>
                <label for="ghichu">Ghi chú</label><br>
                <textarea class="form-control" id="ghichu" rows="5"></textarea><br>
                <input type="submit" class="btn btn-primary" value="Đặt hàng" name="ghichu"/>
            </form>
        </div>
    </div>
</div>

