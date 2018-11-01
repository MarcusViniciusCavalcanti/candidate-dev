<%@tag description="Header" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="credentials" type="br.com.zonework.security.domain.entity.Credential" %>
<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
    <div class="menu_section">
        <h3>General</h3>
        <ul class="nav side-menu">
            <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
                </ul>
            </li>
        </ul>

        <ul class="nav side-menu">
            <li><a><i class="fa fa fa-briefcase"></i> Vagas <span class="fa fa-chevron-down"></span></a>
                <ul class="nav child_menu">
                    <li><a href="${pageContext.request.contextPath}/jobs">Todas</a></li>
                </ul>
            </li>
        </ul>
    </div>

</div>

<div class="sidebar-footer hidden-small">
    <a data-toggle="tooltip" data-placement="top" title="Settings">
        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
    </a>
    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
    </a>
    <a data-toggle="tooltip" data-placement="top" title="Lock" href="${pageContext.request.contextPath}/lock">
        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
    </a>
    <a data-toggle="tooltip" data-placement="top" title="Logout" href="${pageContext.request.contextPath}/logout">
        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
    </a>
</div>
