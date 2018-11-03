
<%@tag description="Header" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="credentials" type="br.com.zonework.candidatedevs.security.domain.entity.Credential" %>
<%@attribute name="candidate" type="br.com.zonework.candidatedevs.candidate.domain.entity.Candidate" %>

<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <img src="${pageContext.request.contextPath}/assets/images/members/images.jpeg" alt="">${candidate.name}
                        <span class=" fa fa-angle-down"></span>
                    </a>

                    <ul class="dropdown-menu dropdown-usermenu pull-right">

                        <c:if test="${credentials.roles.contains('admin')}">
                            <li><a href="${pageContext.request.contextPath}/members/profile"> Profile</a></li>
                        </c:if>
                        <li>
                            <a href="javascript:;">
                                <span class="badge bg-red pull-right">50%</span>
                                <span>Settings</span>
                            </a>
                        </li>
                        <li><a href="javascript:;">Help</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>

<jsp:doBody />