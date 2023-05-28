function senhaVisivel() {
    const passwordInput = document.getElementById("inputSenha");
    if (passwordInput.type === "password") {
        passwordInput.type = "text";
    } else {
        passwordInput.type = "password";
    }
}