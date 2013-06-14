<#-- @ftlvariable name="" type="com.build.something.view.HomeView" -->
<html>
    <body>
        <!-- calls getPerson().getName() and sanitizes it -->
        <h1>Hello, ${content?html}!</h1>
    </body>
</html>