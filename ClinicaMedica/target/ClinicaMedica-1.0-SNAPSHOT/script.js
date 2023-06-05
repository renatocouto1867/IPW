function senhaVisivel(xy) {
    const passwordInput = document.getElementById(xy);
    if (passwordInput.type === "password") {
        passwordInput.type = "text";
    } else {
        passwordInput.type = "password";
    }
}