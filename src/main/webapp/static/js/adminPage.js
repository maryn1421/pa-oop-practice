console.log("haligali")


let button = document.getElementById("login-btn")

function login() {
    console.log("nice, well done");
    const container = document.getElementById("limiter");
    container.innerHTML = "";
    let url = window.origin + "/orders";
    let newRequest = new XMLHttpRequest();
    newRequest.open('GET', url);
    newRequest.onload = function () {
        let ourData = JSON.parse(newRequest.responseText);
        console.log(ourData);
        renderHTML(ourData);
    };
    newRequest.onerror = function () {
        console.log("Connection error");
    };
    newRequest.send();

    function renderHTML(result) {
        result.forEach(res => {
            let htmlString = `<div id="main-content" class="main-content"><p class="title-2">${res.name}</p><p class="timeAgo">${res.date}</p><p class="author">${res.address}</p></div>`;
            container.insertAdjacentHTML("beforeend", htmlString);

        })
}

function loginCheck() {
    const username = document.getElementById("username").value
    const password = document.getElementById("password").value;

    if (password === "admin" && username === "admin") {
        login();
    }
    else {
        alert("nice try, bro")
    }
}

button.addEventListener("click", ()=> {
    loginCheck();
    }
)

function displayNews() {
    currentSelection = "topnews"
    newPage = 1;
    setBold(topNews);
    console.log("in the function")

        buttonHandler();
    }
}