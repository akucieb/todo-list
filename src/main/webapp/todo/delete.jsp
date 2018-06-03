<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper>
    <h3>Czy na pewno chcesz usunąć to zadanie?</h3>
    <dl class="dl-horizontal">
        <dt>Nazwa:</dt>
        <dd><c:out value="${itemToDelete.title}"/></dd>
        <dt>Opis:</dt>
        <dd><c:out value="${itemToDelete.description}"/></dd>
    </dl>

    <form action="/todo/delete" method="post">
        <input type="hidden" name="id" value="<c:out value="${itemToDelete.id}"/>">
        <button class="btn btn-danger" type="submit">Tak, usuń</button>
        <a href="/todo" class="btn btn-default">Nie, wróć</a>
    </form>

</t:wrapper>