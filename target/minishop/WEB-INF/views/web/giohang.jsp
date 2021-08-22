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
                    <th>Màu</th>
                    <th>Size</th>
                    <th>Số lượng</th>
                    <th>Giá</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listgiohang}">
                    <tr>
                        <td>${item.tenSp}</td>
                        <td>${item.mauSanPham}</td>
                        <td>${item.tenSize}</td>
                        <td style="width: 20%"><input class="soluong-giohang" min="1" type="number"
                                                      value="${item.soLuong}"/></td>
                        <td class="giatien" data-value="${item.giaTien}">${item.giaTien} VNĐ</td>
                        <td>
                            <button class="btn btn-danger">Xóa</button>
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
            <form action="" method="post">
                <label for="tennguoimua">Tên người mua/nhận</label><br>
                <input class="form-control" id="tennguoimua"/><br>
                <label for="dienthoai">Điện thoại nhận hàng</label><br>
                <input class="form-control" id="dienthoai"/><br>
                <div class="radio">
                    <label><input type="radio" name="rdhinhthuc" checked>Giao hàng tận nhà</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="rdhinhthuc">Giao hàng tại của hàng</label>
                </div>
                <br>
                <label for="diachi">Địa chỉ nhận hàng</label><br>
                <input class="form-control" id="diachi"/><br>
                <label for="ghichu">Ghi chú</label><br>
                <textarea class="form-control" id="ghichu" rows="5"></textarea><br>
                <input type="submit" class="btn btn-primary" value="Đặt hàng"/>
            </form>
        </div>
    </div>
</div>

