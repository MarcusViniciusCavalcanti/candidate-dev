<jsp:useBean id="credentials" scope="session" class="br.com.zonework.security.domain.entity.Credential"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:head title="Sessão bloqueada">
    <jsp:body>
        <body>
            <h1>Sessão bloqueado pelo usuário</h1>

            <form action="${pageContext.request.contextPath}/lock" method="post">
                <input name="pass" type="password">
                <button type="submit">Desbloquear</button>
            </form>

            <c:if test="${!empty error}">
                <div class=".error" role="errors">${error}</div>
            </c:if>

            <script src="${pageContext.request.contextPath}/assets/vendor/jquery/dist/jquery.js"></script>
            <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/assets/vendor/jquery-sparkline/dist/jquery.sparkline.js"></script>
            <script src="${pageContext.request.contextPath}/assets/vendor/nprogress/nprogress.js"></script>
            <script src="${pageContext.request.contextPath}/assets/vendor/pnotify/dist/pnotify.js"></script>
            <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
            <script src="${pageContext.request.contextPath}/assets/js/notify_message"></script>
        </body>
    </jsp:body>
</t:head>
