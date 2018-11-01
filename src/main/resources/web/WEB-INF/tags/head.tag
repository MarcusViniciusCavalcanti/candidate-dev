<%@tag description="Header" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="title"%>

<html>
    <head>
        <title>${title}</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.css"/>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/nprogress/nprogress.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/pnotify/dist/pnotify.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/animate.css/animate.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.min.css"/>
    </head>

    <jsp:doBody />
</html>