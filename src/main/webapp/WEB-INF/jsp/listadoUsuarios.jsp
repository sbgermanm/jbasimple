<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/taglibs.jsp" %>

<table class="table table-bordered table-hover table-striped">
    <thead>
        <tr>
            <th>Nombre de Usuario</th>
            <th>operaciones</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach  items="${listaDeUsuarios}" var="usuario">
            <tr>
                <td>
                    <a href="<spring:url value="/users/${usuario.id}.html"/>"><c:out value="${usuario.name}"/></a>
                </td>
                <td>
                    <a href="<spring:url value="/users/borrar/${usuario.id}.html"/>" class="btn btn-danger lanzarConfirmacion">Borrar usuario</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@include file="confirmationDLG.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
      $(".lanzarConfirmacion").click(function (e){
          e.preventDefault();
          $("#confirmationDLG .confirmationDLGOK").attr("href", $(this).attr("href"));
          $("#confirmationDLG #myModalLabel").html("Eliminar Usuario");
          $("#confirmationDLG .modal-body").html("¿esta seguro de eliminar el usuario?");
          $("#confirmationDLG").modal();
      })

});
</script>
