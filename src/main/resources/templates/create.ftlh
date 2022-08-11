<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <title>Create</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<div class="container2">
    <div class="content">
        <div>
            <h2>Create and upload your code</h2>
        </div>
        <div>
            <textarea id=code_snippet placeholder="// Write your code here ..."></textarea>
        </div>
        <div  class="item">
            <label>Time that the code will be available (in seconds):</label>
            <input id="time_restriction" type="text" value="0"/>
        </div>
        <div class="item">
            <label>Number of times that the code can be viewed:</label>
            <input id="views_restriction" type="text" value="0"/>
        </div>
        <div>
            <button id=send_snippet class="button-secondary" type=submit onclick=send()>Submit</button>
        </div>
    </div>
</div>
<script>
    function send() {
        let object = {
            "code": document.getElementById("code_snippet").value,
            "time": document.getElementById("time_restriction").value,
            "views": document.getElementById("views_restriction").value
        };

        let json = JSON.stringify(object);

        let xhr = new XMLHttpRequest();
        xhr.open("POST", '/api/code/new', false)
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(json);

        if (xhr.status == 200) {
            alert("Success!");
        }
    }
</script>
</body>
</html>