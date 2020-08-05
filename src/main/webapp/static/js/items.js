function loadItems(itemSet) {
    let url = window.origin + "/products";
    let newRequest = new XMLHttpRequest();
    newRequest.open('GET', url);
    newRequest.onload = function () {
        let ourData = JSON.parse(newRequest.responseText);
        refreshCart(itemSet, ourData);
    };
    newRequest.onerror = function () {
        console.log("Connection error");
    };
    newRequest.send();
}

function refreshCart(id, items) {
    let totalPrice = parseInt(document.getElementById("cart-total").textContent)
    const cartHolder = document.getElementById("cart-holder");
    //cartHolder.innerHTML = "";
    items.forEach(item => {

        if (id == item.id) {
            totalPrice += parseInt(item.defaultPrice);
            const htmlString = `<div class="cart-item-container"><img id="cart-image" src="/static/img/product_${item.id}.jpg" alt=""/><p>${item.name}</p><p>${item.defaultPrice}</p></div>`;
            cartHolder.insertAdjacentHTML("beforeend", htmlString);
        }
    })
    document.getElementById("cart-total").textContent = totalPrice.toString() + " $";
}