const button = document.getElementById("login-btn")

function login() {
    console.log("nice, well done");
    postChat();
}

function loginCheck() {
    console.log("halika")
    const username = document.getElementById("username").value
    const password = document.getElementById("password").value;

    if (password === "admin" && username === "admin") {
        login();
    } else {
        alert("wrong username or password")
    }
}

button.addEventListener("click", () => {
        loginCheck();
    }
)

function postChat() {
    let ajaxPostRequest = new XMLHttpRequest();
    ajaxPostRequest.open("POST", window.origin + "/admin");
    ajaxPostRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    let name = document.getElementById("username").value;
    let password = document.getElementById('password').value;
    ajaxPostRequest.send("name=" + name + "&password=" + password);
    redirectToOrders();
}

function redirectToOrders() {
    location.replace(window.origin + "/orders")

}

function delete_cookie() {
    document.cookie = "user" + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}