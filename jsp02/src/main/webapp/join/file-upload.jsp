<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="java.util.List" %>
<%--
Created by IntelliJ IDEA.
User: kks45
Date: 2023-09-27
Time: 오후 1:59
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/layout/header.jsp" %>

<form action="/profile-upload" method="post" name="member" enctype="multipart/form-data">
    <div class="row d-flex justify-content-center">
        <div class="col-6">
            <div class="mb-3">
                <input type="file" class="form-control"
                       id="profile" placeholder="png,jpg" name="profile"
                       accept="image/gif, image/jpeg,image/png"/>
            </div>
        </div>
    </div>
    <div class="row d-flex justify-content-center">
        <div class="col-6">
            <div class="mb-3">
                <input type="text" class="form-control"
                       id="userID" placeholder="ID" name="userID" value="${sessionScope.loggedID}"
                       readonly/>
            </div>
        </div>
    </div>
    <div class="mt-5 mb-5 d-flex justify-content-center">
        <div>
            <button type="submit" class="btn btn-primary">파일전송</button>
            <button type="reset" class="btn btn-secondary">취소</button>
        </div>
    </div>
</form>

<%@include file="/layout/footer.jsp" %>
