const paypalElement = document.getElementById("paypal-img");
const creditCardElement = document.getElementById("credit-card");
const content = document.getElementById("payment-content");



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
    // todo add event listener to build other payment option
}

