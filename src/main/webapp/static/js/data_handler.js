function api_post (url, data) {
    // it is not called from outside
    // sends the data to the API, and calls callback function
    fetch(url, {
        method: "POST",
        credentials: "include",
        body: JSON.stringify(data),
        cache: "no-cache",
        headers: new Headers({
            "content-type": "application/json"
        })
    })
        .then(function (response) {
            if (response.status !== 200) {
                console.log(`Looks like there was a problem. Status code: ${response.status}`);
                return;
            }
            const jsonResponse = response.json();
            //  callback(jsonResponse);
        })
        .catch(function (error) {
            console.log("Fetch error: " + error);
        });
}

function postChat(){
    console.log("posting chat");
    let ajaxPostRequest = new XMLHttpRequest();
    ajaxPostRequest.open("POST", window.origin + "/order");
    ajaxPostRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    let name = document.getElementById('test').value;
    if (!validateEmail(name)){
        alert("invalid email address")
    }
    else {
        console.log(name);
        ajaxPostRequest.send("name=" + name);
    }
}


console.log("its working")

function validateEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}