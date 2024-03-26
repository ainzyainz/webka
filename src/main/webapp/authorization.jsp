<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="stylesheet2.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>

<body>
<div class="container">
    <div class="signin-signup">
        <h1 class="via">VIA</h1>
        <form method="post" class="sign-up-form">
            <h2 class="title">Sign up</h2>
            <div class="input-field">
                <i class="fas fa-user"></i>
                <input type="text" name="name" placeholder="Name">
            </div>
            <div class="input-field">
                <i class="fas fa-user"></i>
                <input type="text" name="surname" placeholder="Surname">
            </div>
            <div class="input-field">
                <i class="fas fa-envelope"></i>
                <input type="text" name="email" placeholder="Email">
            </div>
            <% if (request.getAttribute("wrong") != null){%>
            <p style="color: #ec6767;">This email's already taken</p>
            <% } %>
            <div class="input-field">
                <i class="fa-solid fa-child-reaching"></i>
                <input type="text" name="age" placeholder="Age">
            </div>
            <div class="input-field">
                <i class="fas fa-lock"></i>
                <input type="password" name="password" placeholder="Password">
            </div>

            <input type="submit" value="Sign-up" class="btn">
            <a class="social-text" href="${pageContext.request.contextPath}/signUp">Already have an account?</a>
            <div class="social-media">
                <a href="https://web.telegram.org/" class="social-icon">
                    <i class="fa-brands fa-telegram"></i>
                </a>
                <a href="https://twitter.com/home?lang=en" class="social-icon">
                    <i class="fab fa-twitter"></i>
                </a>
                <a href="https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwj0hoHc4oqFAxWGh_0HHeyDAmcQPAgJ" class="social-icon">
                    <i class="fab fa-google"></i>
                </a>
            </div>
        </form>
    </div>
</div>
</body>