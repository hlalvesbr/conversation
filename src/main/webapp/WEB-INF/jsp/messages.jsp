<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>BID Messages</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.2.1/css/bootstrap.min.css"/>

    <style>
        html {
            font-size: 14px;
        }

        @media (min-width: 768px) {
            html {
                font-size: 16px;
            }
        }

        .container {
            max-width: 960px;
        }

        .pricing-header {
            max-width: 700px;
        }
    </style>
</head>

<body>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal">BID Conversation</h5>

    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="#">Features</a>
        <a class="p-2 text-dark" href="#">Enterprise</a>
        <a class="p-2 text-dark" href="#">Support</a>
        <a class="p-2 text-dark" href="#">Pricing</a>
    </nav>
    <a class="btn btn-outline-primary" href="#">Sign up</a>
</div>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Messages</h1>
    <p class="lead">Search for Messages</p>
</div>

<div class="container">
    <form path="form" method="post">
        <div class="d-flex flex-row align-items-baseline">
            <label for="botIDInput">Bot&nbsp;ID</label>
            &nbsp;&nbsp;
            <form:input id="botIDInput" path="form.botID" class="form-control" placeholder="Bot ID" readonly="true"/>
            &nbsp;&nbsp;

            <label for="conversationIdInput">Conversation&nbsp;Id</label>
            &nbsp;&nbsp;
            <form:input id="conversationIdInput" path="form.conversationId" class="form-control" placeholder="Conversation Id"/>
            &nbsp;&nbsp;

            <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
        </div>

        <br><br>

        <div>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">From</th>
                    <th scope="col">Text</th>
                    <th scope="col">Created At</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${form.messages}" var="message">
                    <tr>
                        <th scope="row">${message.id}</th>
                        <td>${message.from}</td>
                        <td>${message.text}</td>
                        <td>${message.created_at}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>

<script type="text/javascript" src="webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>
