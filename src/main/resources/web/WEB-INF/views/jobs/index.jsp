<jsp:useBean id="credentials" scope="session" class="br.com.zonework.security.domain.entity.Credential"/>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template title="Vagas">
    <table id="datatable-buttons" class="table table-striped table-bordered">
        <thead>
            <td>Titulo</td>
            <td>Descrição</td>
            <td></td>
        </thead>

        <tbody>
            <c:forEach items="${jobs}" var="job">
                <tr>
                    <td>${job.title}</td>
                    <td>${job.description}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</t:template>
