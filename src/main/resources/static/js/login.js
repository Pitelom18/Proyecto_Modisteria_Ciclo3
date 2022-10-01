const login = () => {
    const username = document.getElementById("user").value;
    const password = document.getElementById("password").value;

    if (username == "") {
        showError("Username is required");
        return;
    }
    if (password == "") {
        showError("Password is required");
        return;
    }

    const body = {
        "username": username,
        "password": password
    };
    postToLogin(body);


};

const showError = (message) => {
    alert(message, "danger");
}

const alert = (message, type) => {
    document.getElementById("errorBox").innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '</div>'
    ].join('')
}