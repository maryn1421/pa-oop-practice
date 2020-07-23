let cartSet = new Set()


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
    cartSet.add(productID);
    let cartSize = document.getElementById("cart-size");
    cartSize.textContent = cartSet.size.toString();
    postChat(productID);
}




function removeFromCart(d) {
    const id = d.getAttribute("data-id");
    console.log(cartSet);
    //cartSet.delete(id);
    console.log(cartSet);
    let cartSize = document.getElementById("cart-size-1");
    const current = cartSize.textContent;
    let currentInt = parseInt(current);
    if (currentInt >= 1) {
        currentInt--;
    }
    cartSize.textContent = currentInt.toString();
    let ajaxPostRequest = new XMLHttpRequest();
    ajaxPostRequest.open("POST", window.origin + "/remove-item");
    ajaxPostRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    ajaxPostRequest.send("id=" + id);
}


function postChat(id) {
    console.log("posting chat");
    let ajaxPostRequest = new XMLHttpRequest();
    ajaxPostRequest.open("POST", window.origin + "/shoppingcart");
    ajaxPostRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    ajaxPostRequest.send("id=" + id);
    // console.log(currentSelection);
}

//document.getElementById("checkout").addEventListener("click", () => {
//  console.log("megy")
// redirect();
//})


function redirect() {
    location.replace(window.origin + "/order")
}