<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<div class="container">
    <div>
        <span id="load_date"><b>${code.getDate()}</b></span>
        <#if (code.getViewsRestriction())>
            <p><span id="views_restriction">${code.getViews()} more views allowed</span></p>
        </#if>
        <#if (code.getTimeRestriction())>
            <p><span id="time_restriction">The code will be available for ${code.getTime()} seconds</span></p>
        </#if>
        <pre id="code_snippet"><code>${code.getCode()}</code></pre>
    </div>
</div>
</body>
</html>