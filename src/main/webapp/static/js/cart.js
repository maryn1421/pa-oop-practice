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
    let cartSize = document.getElementById("cart-size");
    let currentSize = parseInt(cartSize.textContent);
    cartSet.add(productID);
    cartSize.textContent = cartSet.size.toString();
    console.log(currentSize);
    postChat(productID);
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