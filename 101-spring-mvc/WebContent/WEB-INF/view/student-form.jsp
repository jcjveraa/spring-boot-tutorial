<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <!DOCTYPE html>
    <html>
        <head>
            <title>Student registation form</title>
        </head>
    <body>
        <form:form action="processForm" modelAttribute="student">
            First Name:
            <form:input path="firstName" />
            <br /><br />
            Last Name:
            <form:input path="lastName" />
            <br /><br />
            Country: 
            <form:select path = "country">
                <form:option value="Netherlands" label="Netherlands"/>
                <form:option value="France" label="France"/>
                <form:option value="Indonesia" label="Indonesia"/>
                <form:option value="Brazil" label="Brazil"/>
            </form:select>
            <br /><br />
            <input type="submit" value="Submit" />
        </form:form>
    </body>

    </html>