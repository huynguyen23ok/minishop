<%@ include file="/common/taglib/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>Chi tiết sản phẩm</title>
<style>
    #header {
        background-image: none;
        height: 80px;
        background: black;
    }
</style>
<div class="container">
    <div class="col-sm-2 col-md-2">
        <h3>Danh mục</h3>
        <ul class="mymenu">
            <c:forEach var="item" items="${listDanhmuc}">
                <li><a>${item.tendanhmuc}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-sm-8 col-md-8">
        <div class="row">
            <div class="col-sm-4 col-md-4">
                <img src="<c:url value="/resources/sanpham/${chitietsanpham.hinhsanpham}"/>" id="hinhchitiet"/>
            </div>
            <div class="col-ms-8 col-md-8">
                <span data-tensp="${chitietsanpham.masanpham}" class="id-sp" style="display: none"></span>
                <h3 id="tensanpham">${chitietsanpham.tensanpham}</h3>
                <h3 style="color: red" id="giatien" data-gia="${chitietsanpham.giatien}">${chitietsanpham.giatien}
                    VNĐ</h3>
                <table class="table" style="width: 100%">
                    <thead>
                    <tr>
                        <td><h4>Màu sản phẩm</h4></td>
                        <td><h4>Size</h4></td>
                        <td><h4>Số lượng</h4></td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${chitietsanpham.chiTietSanPhamSet}">
                        <tr>
                            <td class="chitiet" data-chitiet="${item.machitietsanpham}" style="display: none"></td>
                            <td class="anh" data-anh="${item.sanPham.hinhsanpham}" style="display: none"></td>
                            <td class="mau" data-mamau="${item.mauSanPham.mamau}">${item.mauSanPham.tenmau}</td>
                            <td class="size" data-size="${item.sizeSanPham.masize}">${item.sizeSanPham.size}</td>
                            <td class="soluong" data-soluong="${item.soluong}">${item.soluong}</td>
                            <td>
                                <button class="btn btn-success btnGiohang" data-id="${chitietsanpham.masanpham}">Thêm
                                    giỏ hàng
                                </button>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-sm-2 col-md-2">
        <span> ${chitietsanpham.mota}</span>
    </div>

</div>