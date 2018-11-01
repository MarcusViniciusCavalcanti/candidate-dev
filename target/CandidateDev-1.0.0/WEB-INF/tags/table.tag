<jsp:useBean id="content" scope="request" type="br.com.zonework.structure.utils.TableContent"/>

<%@ tag description="Template" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>

<%@ attribute name="title" type="java.lang.String" %>

<p>${title}</p>

<jsp:doBody/>

<table id="datatable-buttons" class="table table-striped table-bordered">
    <thead>
    <c:forEach items="${content.headers}" var="item">
        <th>${item}</th>
    </c:forEach>
    </thead>

    <tbody>
        <c:forEach items="${content}"
    </tbody>
</table>


