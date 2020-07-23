const button = document.getElementById("login-btn")

function login() {
    console.log("nice, well done");
    location.replace(window.origin +"/orders")
}

function loginCheck() {
    const username = document.getElementById("username").value
    const password = document.getElementById("password").value;

    if (password === "admin" && username === "admin") {
        login();
    }
    else {
        alert("wrong username or password")
    }
}

button.addEventListener("click", ()=> {
    loginCheck();
    }
)
