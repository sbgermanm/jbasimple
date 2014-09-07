<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../layout/taglibs.jsp" %>

<h1>Latest news from thw world of java:</h1>

<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>fecha</th>
            <th>articulo</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${items}" var="articulo">
            <tr>
                <td>
                    <c:out value="${articulo.publishDate}" />
                    <br/>
                    <strong><em><mark><c:out value="${articulo.blog.name}" /></mark></em></strong>
                </td>
                <td>
                    <strong><a href="<c:out value="${articulo.link}" />" target="_blank" > <c:out value="${articulo.title}" /></a></strong>
                    <br/>
                    ${articulo.descripcion}
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
