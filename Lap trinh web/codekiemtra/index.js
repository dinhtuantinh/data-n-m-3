function ValidateEmail(inputText) {
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var firstpassword = document.form1.password1.value;
    var secondpassword = document.form1.password2.value;

    if (inputText.value.match(mailformat) && firstpassword === secondpassword) {
        alert("OK");
        document.form1.email.focus();
        return true;
    } else {
        alert("Not OK");
        document.form1.email.focus();
        return false;
    }
}