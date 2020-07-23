let currentSelection;


document.getElementById("card-method").addEventListener("click", function () {
    currentSelection = "card"
})

document.getElementById("paypal-method").addEventListener("click", function () {
    currentSelection = "paypal"
})



function api_post(url, data) {
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

function postChat() {
    console.log("posting chat");
    let ajaxPostRequest = new XMLHttpRequest();
    ajaxPostRequest.open("POST", window.origin + "/order");
    ajaxPostRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    let email = document.getElementById('email').value;
    let name = document.getElementById("name").value;
    let zipCode = document.getElementById("zip-code").value;
    let phoneNumber = document.getElementById("phone-number").value;
    let address = document.getElementById("address").value;
    if (!validateEmail(email)) {
        alert("invalid email address")
    } else if (!validLength(name)) {
        alert("Invalid name, please try again!!")
    }else if (!zipCodeTest(zipCode)) {
        alert("Invalid Zip code, please try again!!")
        }
    else if (!phoneNumberTest(phoneNumber)) {
        alert("invalid phone number, please try again!!")
    }
    else if (!validLength(address)){
        alert("invalid address, please try again!!")
    }
     else {
      //  console.log(email);
       ajaxPostRequest.send("email=" + email + "&name="+ name + "&zipcode=" + zipCode + "&phonenumber=" + phoneNumber +"&" +
            "address=" + address + "&paymethod=" + currentSelection);
       orderCompleted();
       // console.log(currentSelection);
    }
}

//			ajaxPostRequest.send("name=" + name + "&message=" + message);

console.log("its working")


function orderCompleted() {
    document.getElementById("checkout-panel").innerHTML = "";

}

function validLength(info) {
    return info.length > 1;

}

function phoneNumberTest(number) {
    if (number.length === 11) {
        const re = /^\d+$/;
        return re.test(String(number));
    }
    else {
        return false;
    }

}

function zipCodeTest(zipCode) {
    const re = /^\d+$/;
    return re.test(String(zipCode));
}

function validateEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}