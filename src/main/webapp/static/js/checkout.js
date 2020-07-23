let htmlString = `<div class="column-1">
                <label for="cardholder">Cardholder's Name</label>
                <input type="text" id="cardholder"/>

                <div class="small-inputs">
                    <div>
                        <label for="date">Valid thru</label>
                        <input type="text" id="date" placeholder="MM / YY"/>
                    </div>

                    <div>
                        <label for="verification">CVV / CVC *</label>
                        <input type="password" id="verification"/>
                    </div>
                </div>

            </div>
            <div class="column-2">
                <label for="cardnumber">Card Number</label>
                <input id="cardnumber" type="tel" inputmode="numeric" pattern="[0-9\s]{13,19}" autocomplete="cc-number"
                       maxlength="19" placeholder="xxxx xxxx xxxx xxxx">
                <span class="info">* CVV or CVC is the card security code, unique three digits number on the back of your card separate from its number.</span>
            </div>
        </div>
`;

console.log("halika")
const payPal = document.getElementById("paypal");

payPal.addEventListener("change", function () {
    document.getElementById("input-fields").innerHTML = "";
})
const card = document.getElementById("card");


card.addEventListener("change", function () {
    document.getElementById("input-fields").insertAdjacentHTML("beforeend", htmlString);
})
