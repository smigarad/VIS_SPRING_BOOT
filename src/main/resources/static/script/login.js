function validateForm() {
    console.log("Validace formuláře");
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var usernameError = document.getElementById("usernameError");
    var passwordError = document.getElementById("passwordError");

    var canSubmit = true;

    if (username.trim() === "") {
        usernameError.innerHTML = "Prosím, vyplňte uživatelské jméno.";
        canSubmit = false;
    } else {
        usernameError.innerHTML = "";
    }


    if (password.trim() === "") {
        passwordError.innerHTML = "Prosím, vyplňte heslo.";
    } else {
        passwordError.innerHTML = "";
    }
    if (canSubmit){
        sessionStorage.setItem("username", username);
        sessionStorage.setItem("password", password);
        console.log("Odesílám formulář");
        return true;
    }
    console.log("Nelze odeslat formulář");
    return false;


}


function validateRegisterForm(){
    var firstname = document.getElementById("firstname").value;
    var lastname = document.getElementById("lastname").value;
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    var city = document.getElementById("city").value;
    var street = document.getElementById("street").value;
    var postalCode = document.getElementById("postalCode").value;
    var country = document.getElementById("country").value;
    var canSubmit = true;
    var firstnameError = document.getElementById("firstnameError");

    var lastnameError = document.getElementById("lastnameError");
    var passwordError = document.getElementById("passwordError");
    var emailError = document.getElementById("emailError");
    var cityError = document.getElementById("cityError");
    var streetError = document.getElementById("streetError");
    var postalCodeError = document.getElementById("postalCodeError");
    var countryError = document.getElementById("countryError");
    var objekt = {
        firstname: {value: firstname, error: firstnameError},
        lastname: {value: lastname, error: lastnameError},
        password: {value: password, error: passwordError},
        email: {value: email, error: emailError},
        city: {value: city, error: cityError},
        street: {value: street, error: streetError},
        postalCode: {value: postalCode, error: postalCodeError},
        country: {value: country, error: countryError}
    };

    for (var key in objekt) {
        if (objekt[key].value.trim() === "" || objekt[key].value.length > 50) {
            objekt[key].error.innerHTML = "Prosím, vyplňte správně " + key + ".";
            canSubmit = false;
        } else {
            objekt[key].error.innerHTML = "";
        }
    }

    if (firstname.match(/\d+/g) != null){
        firstnameError.innerHTML = "Prosím, vyplňte spravne jmeno.";
        canSubmit = false;
    } else {
        firstnameError.innerHTML = "";
    }

    if (lastname.match(/\d+/g) != null){
        lastnameError.innerHTML = "Prosím, vyplňte spravne prijmeni.";
        canSubmit = false;
    } else {
        lastnameError.innerHTML = "";
    }


    if (city.match(/\d+/g) != null){
        cityError.innerHTML = "Prosím, vyplňte spravne mesto.";
        canSubmit = false;
    } else {
        cityError.innerHTML = "";
    }

    var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
//
    if (!emailRegex.test(email)){
        emailError.innerHTML = "Prosím, vyplňte spravne email.";
        canSubmit = false;
    } else {
        emailError.innerHTML = "";
    }
    console.log("Validace formuláře");
    if(canSubmit){
        return true;
    }
    return false;


}

