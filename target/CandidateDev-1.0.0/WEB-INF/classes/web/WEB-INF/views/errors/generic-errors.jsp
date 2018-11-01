
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:head title="Dashboard">
    <jsp:body>
        <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <!-- page content -->
                <div class="col-md-12">
                    <div class="col-middle">
                        <div class="text-center text-center">
                            <h1 class="error-number">${requestScope.status}</h1>
                            <h2>${requestScope.title_error}</h2>
                            <p>${requestScope.message_error} <a href="#">Report this?</a>
                            </p>
                            <div class="mid_center">
                                <h3>Search</h3>
                                <form>
                                    <div class="col-xs-12 form-group pull-right top_search">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="Search for...">
                                            <span class="input-group-btn">
                              <button class="btn btn-default" type="button">Go!</button>
                          </span>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /page content -->
            </div>
        </div>


        <c:if test="${!empty error}">
            <div class=".error" role="errors">${error}</div>
        </c:if>

        <script src="${pageContext.request.contextPath}/assets/vendor/jquery/dist/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/jquery-sparkline/dist/jquery.sparkline.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/nprogress/nprogress.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/pnotify/dist/pnotify.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/notify_message"></script>
        <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
        </body>
    </jsp:body>
</t:head>
