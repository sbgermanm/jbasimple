<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../layout/taglibs.jsp" %>

<h1><c:out value="${usuario.name}" /></h1>

<%@include file="detalleUsuario-addBlog.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
      $('.nav-tabs a:first').tab('show'); // Select first tab
//      $('#BlogsTabs a:first').tab('show'); // Select first tab
      $(".lanzarConfirmacion").click(function (e){
          e.preventDefault();
          $("#confirmationDLG .confirmationDLGOK").attr("href", $(this).attr("href"));
          $("#confirmationDLG #myModalLabel").html("Eliminar Blog");
          $("#confirmationDLG .modal-body").html("¿esta seguro de eliminar el blog?");
          $("#confirmationDLG").modal();
      })

});
</script>

<br /><br />

<!-- Nav tabs --> 

<ul class="nav nav-tabs" role="tablist" id="BlogsTabs"> 
    <c:forEach items="${usuario.blogs}" var ="blog">
        <li><a href="#blog_${blog.id}" role="tab" data-toggle="tab"><c:out value="${blog.name}" /></a></li>
    </c:forEach>
</ul> 

<!-- Tab panes --> 

<div class="tab-content"> 
    <c:forEach items="${usuario.blogs}" var ="blog">
          <div class="tab-pane" id="blog_${blog.id}">
            <h2><c:out value="${blog.name}" /></h2>
            <a href="<spring:url value="/blog/remove/${blog.id}.html"  />" class="btn btn-danger lanzarConfirmacion" >Borrar Blog</a>
            <br /><br />
            <p><c:out value="${blog.url}" /></p>
            
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
                            <td><c:out value="${articulo.title}" /></td>
                            <td><c:out value="${articulo.link}"/></td>
                            <td><c:out value="${articulo.publishDate}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>



        </div> 
    </c:forEach>         
</div>

<%@include file="confirmationDLG.jsp" %>