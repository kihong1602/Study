<%@include file="/layout/header.jsp" %>
<div class="container">
    <h1><%="hello"%>
        <hr>
        <button class="btn btn-outline-secondary d-inline-flex align-items-center" type="button">
            <a href="join/user-form.jsp">user join</a>
            <svg class="bi ms-1" width="20" height="20">
                <use xlink:href="#arrow-right-short"></use>
            </svg>
        </button>
        <hr>
        <button class="btn btn-outline-secondary d-inline-flex align-items-center" type="button">
            <a href="join/login.jsp">user login</a>
            <svg class="bi ms-1" width="20" height="20">
                <use xlink:href="#arrow-right-short"></use>
            </svg>
        </button>
        <br>
</div>
<%@include file="/layout/footer.jsp" %>