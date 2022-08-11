<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<#list codes as code>
    <div class="container">
        <span id="load_date"><b>${code.getDate()}</b></span>
        <pre id="code_snippet"><code>${code.getCode()}</code></pre>
    </div>
    <br>
</#list>
</body>
</html>