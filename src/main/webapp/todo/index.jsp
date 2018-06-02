<%@ page import="pl.sda.poznan.model.TodoItem" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper>
    <table class="table table-bordered table-striped">
        <br><br>
        <h1>Moja lista todo</h1>
        <br><br>
        <thead>
        <tr>
            <th>Id</th>
            <th>Tytuł</th>
            <th>Opis</th>
            <th>Data</th>
            <th>Działanie</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="todo" items="${todos}">
            <tr>
                <td><c:out value="${todo.id}"/></td>
                <td><c:out value="${todo.title}"/></td>
                <td><c:out value="${todo.description}"/></td>
                <td><c:out value="${todo.startDate}"/></td>
                <td><a href="#">Edytuj</a> | <a href="#">Szczegóły</a> | <a href="#">Usuń</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br><br>

    <a href="/todo/create" class="btn btn-primary"/>Dodaj</a>

</t:wrapper>