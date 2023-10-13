<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="xlink" uri="jakarta.tags.core" %>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/css/layout.css"/>"/>
    <script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
    <script src="<c:url value="/js/jquery-3.7.1.min.js"/>"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="<c:url value="/js/cookieManager.js"/>"></script>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <title>Title</title>
</head>
<body>
<div class="container">

    <header class="p-3 mb-3 border-bottom">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="<c:url value="/"/>"
                   class="d-flex align-items-center mb-2 mb-lg-0 link-body-emphasis text-decoration-none">
                    <%--<svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                        <use xlink:href="#bootstrap"></use>
                    </svg>--%>
                    <img src="<c:url value="/icons/browser-chrome.svg"/>" alt="">
                </a>
                <c:choose>
                    <c:when test="${sessionScope.loggedName == null}">
                        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            <li><a href="<c:url value="/join/user-form.jsp"/>"
                                   class="nav-link px-2 link-secondary">join</a></li>
                            <li><a href="<c:url value="/join/login.jsp"/>"
                                   class="nav-link px-2 link-body-emphasis">sign up</a></li>
                            <li><a href="<c:url value="/new-member/login-process"/>"
                                   class="nav-link px-2 link-body-emphasis">Login</a></li>
                            <li><a href="<c:url value="/new-member/sign-process"/>"
                                   class="nav-link px-2 link-body-emphasis">New Sign</a></li>
                            <li><a href="<c:url value="/board/progress/board"/>"
                                   class="nav-link px-2 link-body-emphasis">Normal Board</a>
                            </li>
                            <li><a href="<c:url value="/board/write.jsp"/>"
                                   class="nav-link px-2 link-body-emphasis">Normal Board write</a>
                            </li>
                            <li><a href="<c:url value="/reply/board"/>"
                                   class="nav-link px-2 link-body-emphasis">Reply Board</a>
                            </li>
                            <li><a href="<c:url value="/reply-board/write.jsp"/>"
                                   class="nav-link px-2 link-body-emphasis">Reply Board write</a>
                            </li>
                            <li><a href="<c:url value="/new/list"/>"
                                   class="nav-link px-2 link-body-emphasis">New Board</a>
                            </li>
                        </ul>

                        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                            <input type="search" class="form-control" placeholder="Search..."
                                   aria-label="Search">
                        </form>
                    </c:when>
                    <c:otherwise>
                        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            <li><a href="<c:url value="/board/progress/board"/>"
                                   class="nav-link px-2 link-body-emphasis">Normal Board</a>
                            </li>
                            <li><a href="<c:url value="/board/write.jsp"/>"
                                   class="nav-link px-2 link-body-emphasis">Normal Board write</a>
                            </li>
                            <li><a href="<c:url value="/reply/board"/>"
                                   class="nav-link px-2 link-body-emphasis">Reply Board</a>
                            </li>
                            <li><a href="<c:url value="/reply-board/write.jsp"/>"
                                   class="nav-link px-2 link-body-emphasis">Reply Board write</a>
                            </li>
                            <li><a href="<c:url value="/new/list"/>"
                                   class="nav-link px-2 link-body-emphasis">New Board</a>
                            </li>
                        </ul>

                        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                            <input type="search" class="form-control" placeholder="Search..."
                                   aria-label="Search">
                        </form>

                        <div class="dropdown text-end">
                            <a href="#"
                               class="d-block link-body-emphasis text-decoration-none dropdown-toggle"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                <img src="${pageContext.request.contextPath}/upload/${sessionScope.filePath}"
                                     alt="mdo" width="32" height="32" class="rounded-circle">
                            </a>
                            <ul class="dropdown-menu text-small">
                                <li><a class="dropdown-item" href="<c:url value="/join/info.jsp"/>">Profile</a>
                                </li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item"
                                       href="<c:url value="/new-member/logout"/>">로그아웃</a></li>
                                <li><a class="dropdown-item"
                                       href="<c:url value="/new-member/withdrawal-process"/>">회원탈퇴</a>
                                </li>
                            </ul>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </header>
</div>
<main class="main">