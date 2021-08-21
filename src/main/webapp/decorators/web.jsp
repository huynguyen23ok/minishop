<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8 ">
    <title><dec:title default="Trang chủ"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/animate.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>">
</head>
<body>
<div class="container-fluid" id="header">
    <%@ include file="/common/web/header.jsp" %>
</div>
<dec:body/>
<%@ include file="/common/web/footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/wow.min.js"/>"></script>
<script src="<c:url value="/common/web/js/custom.js"/>" type="text/javascript"></script>
<script>
    new WOW().init();
</script>
</body>
</html>
