function validateContactForm() {
    let issueTypes = document.querySelectorAll('input[name="issueType"]');
    let description = document.getElementById('description').value;
    let isIssueTypeSelected = false;

    for (let i = 0; i < issueTypes.length; i++) {
        if (issueTypes[i].checked) {
            isIssueTypeSelected = true;
            break;
        }
    }

    if (!isIssueTypeSelected) {
        alert('Please select a type of issue.');
        return false;
    } else if (description.trim() === '') {
        alert('Please enter a description of the problem.');
        return false;
    }
    showSuccessNotification();
    setTimeout(() => {
        document.getElementById("yourFormId").submit();
    }, 5000);
    return false;
}

function showSuccessNotification() {
    var successMessage = document.getElementById("successMessage");
    successMessage.style.display = "block";

    // Remove the notification after a few seconds
    setTimeout(() => {
        successMessage.style.display = "none";
    }, 4000);
}


function validateDelivery() {
    var street = document.getElementById("street").value;
    var city = document.getElementById("city").value;
    var postalCode = document.getElementById("postalCode").value;
    var country = document.getElementById("country").value;

    if (street.trim() === "" || city.trim() === "" || postalCode.trim() === "" || country.trim() === "") {
        alert("Please fill in all address fields.");
        return;
    }

    document.getElementById("deliverySection").style.display = "none";
    document.getElementById("paymentSection").style.display = "block";
}

function validateCardDetails() {
    var cardNumber = document.getElementById("cardNumber").value;
    if (cardNumber.trim() === "") {
        alert("Please enter the card number.");
        return false;
    }

    var cardNumberPattern = /^[0-9]{16}$/;
    if (!cardNumberPattern.test(cardNumber)) {
        alert("Please enter a valid 16-digit card number.");
        return false;
    }

    return true;
}

document.getElementById("orderForm").onsubmit = function() {
    return validateDelivery() && validateCardDetails();
};
