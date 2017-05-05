<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Devices</title>
    <link href="<c:url value="/resources/css/jquery.dataTables.min.css"/>" rel="stylesheet">
</head>
<body>
<table id="employees" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Type</th>
        <th>Name</th>
        <th>Size</th>
        <th>Color</th>
        <th>Power</th>
        <th>Feature</th>
        <th>Button</th>
        <th>State</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>Type</th>
        <th>Name</th>
        <th>Size</th>
        <th>Color</th>
        <th>Power</th>
        <th>Feature</th>
        <th>Button</th>
        <th>State</th>
    </tr>
    </tfoot>

    <tbody>
    <c:forEach items="${Phone}" var="Phone">
        <tr>
            <td data-name="type">${Phone.type}</td>
            <td data-name="name">${Phone.name}</td>
            <td data-name="size">${Phone.size}</td>
            <td data-name="color">${Phone.color}</td>
            <td data-name="power">${Phone.power}</td>
            <td>Battery Life Time ${Phone.batteryLifeTime}</td>
            <td>
                <button class="js-action-reset-salary" data-employee-key="${Phone.id}">Switch</button>
            </td>
            <td data-name="state">${Phone.state}</td>
        </tr>
    </c:forEach>
    <c:forEach items="${Computer}" var="Computer">
        <tr>
            <td>${Computer.type}</td>
            <td>${Computer.name}</td>
            <td>${Computer.size}</td>
            <td>${Computer.color}</td>
            <td>${Computer.power}</td>
            <td>Size HDD ${Computer.sizeHDD}</td>
            <td>
                <button class="js-action-reset-salary" data-employee-key="${Computer.id}">Switch</button>
            </td>
            <td data-name="state">${Computer.state}</td>
        </tr>
    </c:forEach>
    <c:forEach items="${TV}" var="TV">
        <tr>
            <td>${TV.type}</td>
            <td>${TV.name}</td>
            <td>${TV.size}</td>
            <td>${TV.color}</td>
            <td>${TV.power}</td>
            <td>Number Of Channels ${TV.numberOfChannels}</td>
            <td>
                <button class="js-action-reset-salary" data-employee-key="${TV.id}">Switch</button>
            </td>
            <td data-name="state">${TV.state}</td>
        </tr>
    </c:forEach>
    </tbody>
    <c:forEach items="${Result}" var="Result">
        <tr>
            <td>
                <button class="resultPower" data-employee-key="${Result.id}">General power
                </button>
            </td>
            <td data-name="id">${Result.value}</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </c:forEach>
        <tr>
            <td><input type="text" id="min" placeholder="min"></td>
            <td><input type="text" id="max" placeholder="max"></td>
            <td>
                <button class="resultSearch">Search
                </button>
            </td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
</table>

<a>Made by Alexandr Domenikan</a>
<script src="<c:url value="/resources/js/lib/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/resources/js/lib/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/js/employees.js"/>"></script>
</body>
</html>