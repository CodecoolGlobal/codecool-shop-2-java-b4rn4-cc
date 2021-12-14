const paypalElement = document.getElementById("paypal-img");
const creditCardElement = document.getElementById("credit-card");
const content = document.getElementById("payment-content");

paypalElement.addEventListener("click", getPaypalPayment);
creditCardElement.addEventListener("click", getCardPayment);

function getCardPayment() {
    let paymentContainer = document.getElementById("payment-options");
    paymentContainer.style.display = "none";
    buildCardPayment();
}
function getPaypalPayment() {
    let paymentContainer = document.getElementById("payment-options");
    paymentContainer.style.display = "none";
    buildPaypalPayment();
}

function buildPaypalPayment() {
    content.innerHTML = "";
    let imgDiv = document.createElement("div");
    let msgDiv = document.createElement("div");
    let emailInput = document.createElement("input");
    let passwordInput = document.createElement("input");
    let payButton = document.createElement("button");
    let otherPaymentDiv = document.createElement("div");

    imgDiv.setAttribute("id", "paypalImg");
    imgDiv.innerHTML = "<img src=\"https://www.paypalobjects.com/webstatic/mktg/Logo/pp-logo-150px.png\" alt=\"PayPal Logo\">";

    msgDiv.setAttribute("id", "info");
    msgDiv.innerText = "Pay with PayPal";

    emailInput.setAttribute("id", "email-field");
    emailInput.autocomplete = "off";
    emailInput.required = true;
    emailInput.placeholder = "Email";
    emailInput.type = "email";

    passwordInput.id = "pw-field";
    passwordInput.required = true;
    passwordInput.placeholder = "Password";
    passwordInput.type = "password";

    payButton.id = "pay-button";
    payButton.innerText = "Pay";

    otherPaymentDiv.id = "other-payment-option";
    otherPaymentDiv.innerText = "Pay with Credit Card";

    content.append(imgDiv, msgDiv, emailInput, passwordInput, payButton, otherPaymentDiv);
    otherPaymentDiv.addEventListener("click", getCardPayment);
}

function buildCardPayment() {
    content.innerHTML = "";
    let emailDiv = document.createElement("div");
    let cardNumberDiv = document.createElement("div");
    let cardHolderDiv = document.createElement("div");
    let CCVDiv = document.createElement("div");
    let expireDiv = document.createElement("div");
    let payButton = document.createElement("button");
    let otherPaymentDiv = document.createElement("div");

    otherPaymentDiv.addEventListener("click", getPaypalPayment);

    let emailField = document.createElement("input");
    let cardNumberField = document.createElement("input");
    let holderField = document.createElement("input");
    let CCVField = document.createElement("input");
    let expireField = document.createElement("input");

    emailField.id = "email-field";
    emailField.autocomplete = "off";
    emailField.required = true;
    emailField.placeholder = "Email";
    emailField.type = "email";
    emailDiv.append(emailField);

    cardNumberField.required = true;
    cardNumberField.placeholder = "XXXXXXX-XXXXXXXX";
    cardNumberField.autocomplete = "off";
    cardNumberDiv.append(cardNumberField);

    holderField.required = true;
    holderField.placeholder = "MasterCard";
    holderField.autocomplete = "off";
    cardHolderDiv.append(holderField);

    CCVField.placeholder = "123";
    CCVField.size = 3;
    CCVField.required = true;
    CCVDiv.append(CCVField);

    expireField.required = true;
    expireField.placeholder = "01/26";
    expireDiv.append(expireField);

    payButton.innerText = "Pay";

    otherPaymentDiv.innerText = "Pay with PayPal";

    content.append(emailDiv, cardHolderDiv, cardNumberDiv, expireDiv, CCVDiv, payButton, otherPaymentDiv);
}