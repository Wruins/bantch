<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // /ssm
    String path = request.getContextPath();
    // http://localhost:8080/ssm
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href=<%=path%>/css/style.css>
</head>

<body>
<main>
    <form class="form">
        <div class="form__cover"></div>
        <div class="form__loader">
            <div class="spinner active">
                <svg class="spinner__circular" viewBox="25 25 50 50">
                    <circle class="spinner__path" cx="50" cy="50" r="20" fill="none" stroke-width="4"
                            stroke-miterlimit="10"></circle>
                </svg>
            </div>
        </div>
        <div></div>
        <div class="form__content">
            <h1>用户登录</h1>
            <div class="styled-input">
                <input type="text" class="styled-input__input" id="username" name="nickname">
                <div class="styled-input__placeholder"><span class="styled-input__placeholder-text">UserName</span>
                </div>
                <div class="styled-input__circle"></div>
            </div>
            <div class="styled-input">
                <input type="password" class="styled-input__input" id="password">
                <div class="styled-input__placeholder"><span class="styled-input__placeholder-text">PassWord</span>
                </div>
                <div class="styled-input__circle"></div>
            </div>
            <button type="button" onclick="login()" class="styled-button"><span class="styled-button__real-text-holder"> <span
                    class="styled-button__real-text">Submit</span> <span class="styled-button__moving-block face"> <span
                    class="styled-button__text-holder"> <span
                    class="styled-button__text">Submit</span> </span> </span><span
                    class="styled-button__moving-block back"> <span class="styled-button__text-holder"> <span
                    class="styled-button__text">Submit</span> </span> </span> </span></button>
        </div>
    </form>
</main>
<script src=<%=path%>/js/jquery-1.8.3.min.js></script>
<script src=<%=path%>/js/index.js></script>
<script>

    function login() {
        let username = $('#username').val();
        let pass = $('#password').val();
        $.ajax({
            url: '<%=basePath%>' + '/user/login',
            type: 'post',
            data: {
                username: username,
                pass: window.btoa(pass),
            },
            success: function (data) {
                console.log(data);
                if (data.code == 0) {
                    location.href = '<%=basePath%>' + '/user/loginSuccess'
                }
            },
            error: function (data) {

            }
        })
    }
</script>
</body>
</html>
