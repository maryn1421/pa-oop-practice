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
        let split = item.split(" ");
        let name;
        let price;
        switch (split.length) {
            case 12:
                name = split[3].slice(0, -1);
                price = split[5].slice(0, -1)
                break;
            case 13:
                name = split[3] + " " + split[4].slice(0, -1);
                price = split[6].slice(0, -1)

                break;
            case 14:
                name = split[3] + " " + split[4] + " " + split[5].slice(0, -1);
                price = split[7].slice(0, -1)
                break;
        }
         let obj = {
             id: split[1].slice(0, -1),
             name: name,
             price: parseInt(price)
        }
        if (id == (obj.id)) {
            totalPrice += obj.price;
            const htmlString = `<div class="cart-item-container"><p>${obj.name}</p><p>${obj.price}</p></div>`;
            cartHolder.insertAdjacentHTML("beforeend", htmlString);
        }
    })
    document.getElementById("cart-total").textContent = totalPrice.toString() + " $";
}