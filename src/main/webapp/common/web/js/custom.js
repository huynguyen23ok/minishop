$(document).ready(function () {
    /*Thêm sản phẩm vào giỏ hàng*/
    $(".btnGiohang").click(function () {
        var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
        var tenmau = $(this).closest("tr").find(".mau").text();
        var masize = $(this).closest("tr").find(".size").attr("data-size");
        var chitiet = $(this).closest("tr").find(".chitiet").attr("data-chitiet");
        var tensize = $(this).closest("tr").find(".size").text();
        var tensp = $("#tensanpham").text();
        var anh = $(this).closest("tr").find(".anh").attr("data-anh");
        var giatien = $('#giatien').attr("data-gia");
        var msp = $(this).attr("data-id");
        $.ajax({
            type: "GET",
            url: "/api/addSanpham",
            data: {
                machitiet: chitiet,
                maSP: msp,
                maSize: masize,
                maMau: mamau,
                tenSp: tensp,
                mauSanPham: tenmau,
                anhSanpham: anh,
                GiaTien: giatien,
                TenSize: tensize,
                SoLuong: 1
            }, success: function (value) {
                $('#giohang').find("div").addClass('circle-giohang');
                $('#giohang').find("div").html("<span>" + value + "</span>");
            }
        });
    });
    /*end*/

    ganTongtien();

    function formatt(val) {
        fm = val.toFixed(3).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.").toString() + " VNĐ";
        return fm;
    }

    function ganTongtien() {
        var tongtiensanpham = 0;
        $(".money").each(function (e) {
            var giatien = $(this).text();
            var soluong = $(this).closest("tr").find(".soluong-giohang").val();
            var tongtien = parseInt(giatien) * soluong;
            var format = formatt(parseFloat(tongtien));
            tongtiensanpham = tongtiensanpham + tongtien;
            if (!e) {
                $(this).html(format);
            }
            var formattt = formatt(tongtiensanpham);
            $(this).html(formatt(tongtien) + "");
            $('#tongtien').html(formattt + "");
        });
    }

    /*cap nhat gia tien*/
    $('.soluong-giohang').change(function () {
        var soluong = $(this).val();
        var giatien = $(this).closest("tr").find(".giatien").attr("data-value");
        var tongtien = soluong * parseInt(giatien);
        var format = formatt(tongtien);
        $(this).closest("tr").find(".giatien").html(format);
        ganTongtien(true);

        var sp = $(this).closest("tr").find(".masp").attr("data-masp");
        var size = $(this).closest("tr").find(".size").attr("data-size");
        var mau = $(this).closest("tr").find(".mausp").attr("data-mausp");
        $.ajax({
            url: "api/updateGioHang",
            type: "get",
            data: {
                masp: sp,
                masize: size,
                mamau: mau,
                soluong: soluong
            }, success: function () {
                window.location = window.location.href;
            }
        });

    });
    /*end */

    /*xoa san pham*/
    $('.btxoa').click(function () {
        var me = $(this);
        var sp = $(this).closest("tr").find(".masp").attr("data-masp");
        var size = $(this).closest("tr").find(".size").attr("data-size");
        var mau = $(this).closest("tr").find(".mausp").attr("data-mausp");
        $.ajax({
            url: "api/delete",
            type: "get",
            data: {
                masp: sp,
                masize: size,
                mamau: mau
            }, success: function () {
                me.closest("tr").remove();
                window.location = window.location.href;
            }
        });
    });

});