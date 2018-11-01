<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<h:head>
    <body class="login">
    <div>
        <a class="hiddenanchor" id="signup"></a>
        <a class="hiddenanchor" id="signin"></a>

        <div class="login_wrapper">
            <div class="animate form login_form">
                <section class="login_content">
                    <form action="${pageContext.request.contextPath}/login" method="POST">
                        <h1>
                            <span id="line_left"></span>
                            Login
                            <span id="line_right"></span>
                        </h1>
                        <div>
                            <input type="text" class="form-control" placeholder="Username" name="username">
                        </div>

                        <div>
                            <input type="password" class="form-control" placeholder="Password" name="password">
                        </div>

                        <div>
                            <button type="submit" class="btn btn-default submit">Acessar</button>
                            <a class="reset_pass" href="#">não lembra suas senha?</a>
                        </div>

                        <div class="clearfix"></div>

                        <div class="separator">
                            <p class="change_link">Novo no site?
                                <a href="#signup" class="to_register"> Criar uma conta </a>
                            </p>

                            <div class="clearfix"></div>
                            <br>

                            <div>
                                <h1><i class="fa fa-paw"></i> Exam Dev</h1>
                                <p>©2016 All Rights Reserved. ZoneWork!</p>
                            </div>
                        </div>
                    </form>
                </section>
            </div>

            <div id="register" class="animate form registration_form">
                <section class="login_content">
                    <form action="${pageContext.request.contextPath}/new_candidate" method="post">
                        <h1>Create Account</h1>
                        <div>
                            <input type="text" class="form-control" placeholder="Username" required="false" name="j_username_new"/>
                        </div>
                        <div>
                            <input type="email" class="form-control" placeholder="Email" required="true" name="j_email_new"/>
                        </div>
                        <div>
                            <input type="password" class="form-control" placeholder="Senha" required="true" name="j_password_new"/>
                        </div>
                        <div>
                            <input type="password" class="form-control" placeholder="Confirmar Senha" required="true" name="j_confirm_password_new"/>
                        </div>
                        <div>
                            <button class="btn btn-default submit" type="submit">Registrar</button>
                        </div>

                        <div class="clearfix"></div>

                        <div class="separator">
                            <p class="change_link">já é um Membro ?
                                <a href="#signin" class="to_register"> Login </a>
                            </p>

                            <div class="clearfix"></div>
                            <br/>

                            <div>
                                <h1><i class="fa fa-paw"></i> Exam Dev</h1>
                                <p>©2016 All Rights Reserved. ZoneWork!</p>

                            </div>
                        </div>
                    </form>
                </section>
            </div>
            <div class="login_form">
            </div>
        </div>
    </div>


    <c:if test="${!empty loginFailure}">
        <div class=".error" role="errors" hidden>${loginFailure}</div>
    </c:if>

    <c:if test="${!empty logoutSuccess}">
        <div class=".success" role="success" hidden>${logoutSuccess}</div>
    </c:if>

    <script src="${pageContext.request.contextPath}/assets/vendor/jquery/dist/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-sparkline/dist/jquery.sparkline.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/nprogress/nprogress.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/pnotify/dist/pnotify.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/notify_message.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/custom.js"></script>
    </body>
</h:head>