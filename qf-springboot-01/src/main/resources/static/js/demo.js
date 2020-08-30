function toAjax() {
    xml = new XMLHttpRequest();
    xml.onreadystatechange = callBack;
    let username = document.getElementsByName("username")[0];
    let password = document.getElementsByName("password")[0];
    let body = {
        username: username.value,
        password: password.value
    };
    xml.open("POST", "index/test", true);
    xml.setRequestHeader("Content-type", "application/json;charset=utf-8");

    xml.send(JSON.stringify(body));
}

function callBack() {
    if (xml.readyState == 4 && xml.status == 200) {
        alert(xml.responseText);
    }
}