<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/taglibs.jsp" %>

<h1>${usuario.name}</h1>
<c:forEach items="${usuario.blogs}" var ="blog">
    <h2>${blog.name}</h2>
    
    <table class="table table-bordered table-hover table-striped">
        <thead>
            <tr>
                <th>titulo</th>
                <th>link</th>
                <th>publishDate</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${blog.items}" var="articulo">
            <tr>
                <td>${articulo.title}</td>
                <td>${articulo.link}</td>
                <td>${articulo.publishDate}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

       
   
</c:forEach>