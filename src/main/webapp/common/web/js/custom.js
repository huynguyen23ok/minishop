$(document).ready(function () {
    /*Thêm sản phẩm vào giỏ hàng*/
    $(".btnGiohang").click(function () {
        var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
        var tenmau = $(this).closest("tr").find(".mau").text();
        var masize = $(this).closest("tr").find(".size").attr("data-size");
        var tensize = $(this).closest("tr").find(".size").text();
        var tensp = $("#tensanpham").text();
        var giatien = $('#giatien').attr("data-gia");
        var msp = $(this).attr("data-id");
        alert(anh);
        $.ajax({
            type: "GET",
            url: "/api/addSanpham",
            data: {
                maSP: msp,
                maSize: masize,
                maMau: mamau,
                tenSp: tensp,
                mauSanPham: tenmau,
                GiaTien: giatien,
                TenSize: tensize,
                SoLuong: 1
            }, success: function (value) {
                $('#giohang').find("div").addClass('circle-giohang');
                $('#giohang').find("div").html("<span>" + value + "</span>");
            }
        });
    });
});