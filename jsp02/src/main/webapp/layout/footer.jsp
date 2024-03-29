</main>
<div class="container">
    <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
        <div class="col-md-4 d-flex align-items-center">
            <a href="<c:url value="/"/>"
               class="mb-3 me-2 mb-md-0 text-body-secondary text-decoration-none lh-1">
                <svg class="bi" width="30" height="24">
                    <use xlink:href="#bootstrap"></use>
                </svg>
            </a>
            <span class="mb-3 mb-md-0 text-body-secondary">© 2023 Company, Inc</span>
        </div>

        <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
            <li class="ms-3"><a class="text-body-secondary" href="#">
                <svg class="bi" width="24" height="24">
                    <use xlink:href="#twitter"></use>
                </svg>
            </a></li>
            <li class="ms-3"><a class="text-body-secondary" href="#">
                <svg class="bi" width="24" height="24">
                    <use xlink:href="#instagram"></use>
                </svg>
            </a></li>
            <li class="ms-3"><a class="text-body-secondary" href="#">
                <svg class="bi" width="24" height="24">
                    <use xlink:href="#facebook"></use>
                </svg>
            </a></li>
        </ul>
    </footer>
</div>
<c:if test="${state eq 'show'|| param.state eq 'show'||requestScope.state eq 'show'}">
    <%--동적으로 include 하는 코드--%>
    <jsp:include page="/layout/modal.jsp"></jsp:include>
</c:if>
<script>
  const myModal = new bootstrap.Modal("#myModal");
  myModal.show();

  function viewProfile(id) {
    let form = document.createElement('form');
    let obj = document.createElement('input');
    obj.setAttribute('type', 'hidden');
    obj.setAttribute('name', 'id');
    obj.setAttribute('value', id);

    form.appendChild(obj);
    form.setAttribute('action', '/new-member/info');
    form.setAttribute('method', 'post');
    document.body.appendChild(form);
    form.submit();
  }
</script>
</body>
</html>
