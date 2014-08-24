<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../layout/taglibs.jsp" %>

<h1>${usuario.name}</h1>

<%@include file="detalleUsuario-addBlog.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
      $('.nav-tabs a:first').tab('show'); // Select first tab
//      $('#BlogsTabs a:first').tab('show'); // Select first tab




});
</script>

<br /><br />

<!-- Nav tabs --> 

<ul class="nav nav-tabs" role="tablist" id="BlogsTabs"> 
    <c:forEach items="${usuario.blogs}" var ="blog">
        <li><a href="#blog_${blog.id}" role="tab" data-toggle="tab">${blog.name}</a></li>
    </c:forEach>
</ul> 

<!-- Tab panes --> 

<div class="tab-content"> 
    <c:forEach items="${usuario.blogs}" var ="blog">
          <div class="tab-pane" id="blog_${blog.id}">

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



        </div> 
    </c:forEach>         
</div>

