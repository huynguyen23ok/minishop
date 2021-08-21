$(document).ready(function () {
    $(".btnGiohang").click(function () {

        var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
        var tenmau = $(this).closest("tr").find(".mau").text();
        var masize = $(this).closest("tr").find(".size").attr("data-size");
        var tensize = $(this).closest("tr").find(".size").text();
        var tensp = $("#tensanpham").text();
        var giatien = $('#giatien').attr("data-gia");
        var soluong = $('.soluong').attr("data-soluong");
        var msp = $(".id-sp").attr("data-sp");

        $.ajax({
            url: "/api/addSanpham",
            type: "get",
            data: {
                masp: msp,
                masize: masize,
                tensp: tensp,
                mausanpham: tenmau,
                giatien: giatien,
                tensize: tensize,
                soluong: soluong
            },
            success() {

            }
        })
    });
})