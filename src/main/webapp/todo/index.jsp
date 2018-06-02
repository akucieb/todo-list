<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
    #todoheader {
        margin-bottom: 25px;
    }

    #todocontainer {
        margin-top: 20px;
    }
</style>

<t:wrapper>
    <div id="todocontainer" class="container">
        <h1 id="todoheader"> Moje zadania </h1>

        <c:if test="${sessionScope.todo_created eq true}">
            <div class="alert alert-success">
                Udało się dodać nowe zadanie!
            </div>
            <c:remove var="todo_created"/>
        </c:if>

        <c:if test="${fn:length(todos) eq 0}">
            <div class="alert alert-warning">
                Nie masz jeszcze zadań. Kliknij <a href="/todo/create">tutaj</a>, aby dodać
            </div>
        </c:if>

        <c:if test="${fn:length(todos) gt 0}">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Tytuł</th>
                    <th>Opis</th>
                    <th>Data</th>
                    <th>Opcje</th>
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
            <a href="/todo/create" class="btn btn-primary">Dodaj</a>
        </c:if>
    </div>

</t:wrapper>