<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../css/from.css"/>
    <script src="../../js/bootstrap.bundle.min.js"></script>
    <script src="../../js/jquery-3.7.1.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <a href="/"
           class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
            <svg class="bi me-2" width="40" height="32">
                <use xlink:href="#bootstrap"></use>
            </svg>
            <span class="fs-4">Simple header</span>
        </a>
        <ul class="nav nav-pills">
            <li class="nav-item"><a href="../index.jsp" class="nav-link active"
                                    aria-current="page">Home</a>
            </li>
            <li class="nav-item"><a href="user-form.jsp" class="nav-link">회원가입</a></li>
            <li class="nav-item"><a href="login.jsp" class="nav-link">로그인</a></li>
            <li class="nav-item"><a href="board.jsp" class="nav-link">게시판</a></li>
        </ul>
        <ul class="nav nav-pills">
            <li class="nav-item"><a href="logout.jsp" class="nav-link">로그아웃</a></li>
            <li class="nav-item"><a href="info.jsp" class="nav-link">마이페이지</a></li>
            <li class="nav-item"><a href="withdrawal.jsp" class="nav-link">회원탈퇴</a></li>
        </ul>
    </header>
</div>
