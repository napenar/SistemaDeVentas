<%-- 
    Document   : Clientes
    Created on : 12/10/2021, 6:13:43 p. m.
    Author     : NORVEY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-5 card">
                    <div class="card-body">
                        <form action="Controlador?menu=Cliente" method="POST">
                            <div class="form-group">
                                <label>Dni</label>
                                <input type="text" value="${cliente.getDni()}" name="txtDni" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Nombres</label>
                                <input type="text" value="${cliente.getNom()}" name="txtNombres" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Direccion</label>
                                <input type="text" value="${cliente.getDir()}" name="txtDir" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Estado</label>
                                <input type="text" value="${cliente.getEstado()}" name="txtEstado" class="form-control">
                            </div>
                            <input type="submit" name="accion" value="Agregar" class="btn btn-primary">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        </form>
                    </div>
                </div>

                <div class="col-sm-7">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>DNI</th>
                                <th>NOMBRES</th>
                                <th>DIRECCION</th>
                                <th>ESTADO</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${clientes}" var="cl" >
                                <tr>
                                    <td>${cl.getId()}</td>
                                    <td>${cl.getDni()}</td>
                                    <td>${cl.getNom()}</td>
                                    <td>${cl.getDir()}</td>
                                    <td>${cl.getEstado()}</td>
                                    <td>
                                        <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${cl.getId()}">Editar</a>
                                        <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&id=${cl.getId()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>





        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>