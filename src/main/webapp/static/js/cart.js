function myFunction() {
    let x = document.getElementById("shopping-cart");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}


function addToCart(d) {
    let productID = d.getAttribute("data-id");
    console.log(productID);
    postChat(productID);

}


function postChat(id) {
    console.log("posting chat");
    let ajaxPostRequest = new XMLHttpRequest();
    ajaxPostRequest.open("POST", window.origin + "/cart");
    ajaxPostRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    ajaxPostRequest.send("id=" + id);
    // console.log(currentSelection);
}

