<%--
  Created by IntelliJ IDEA.
  User: kks45
  Date: 2023-10-12
  Time: 오전 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="myModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                hello world
            </div>
            <div class="modal-footer">
                <%--                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
                <button type="button" class="btn btn-primary" id="goBack">확인</button>
            </div>
        </div>
    </div>
</div>
<script>
  document.getElementById('goBack').addEventListener("click", function () {
    history.back();
  })
</script>