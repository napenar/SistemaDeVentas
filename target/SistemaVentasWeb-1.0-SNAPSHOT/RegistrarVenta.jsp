<%-- 
    Document   : RegistrarVenta
    Created on : 12/10/2021, 6:14:29 p. m.
    Author     : NORVEY
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <style>
            @media print{
                .parte1,btn,accion{
                    display: none;
                }
            }
        </style>
        <title>VENTAS</title>
    </head>
    <body>

        <div class="container-fluid">
            <div class="row">

                <div class="col-sm-4 parte1">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Datos del cliente</label>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 d-flex">
                                            <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="Codigo">
                                            <button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-dark ">Buscar</button>
                                        </div>

                                        <div class="col-sm-6">
                                            <input type="text" name="nombrescliente" value="${c.getNom()}" class="form-control" placeholder="Datos Cliente">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Datos Producto</label>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 d-flex">
                                            <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo" >
                                            <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-dark " >Buscar</button>
                                        </div>

                                        <div class="col-sm-6">
                                            <input type="text" name="nomproducto" value="${producto.getNom()}" class="form-control" placeholder="Datos Producto">
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 d-flex">
                                            <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="$">
                                        </div>

                                        <div class="col-sm-3">
                                            <input type="number" name="cant" value="1" class="form-control">
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="stock">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group"></div>
                                <br>
                                <div class="form-group">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-danger">Agregar Producto</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="col-sm-8">
                    <div class="card">
                        <div class="card-body">
                            <div class="col-sm-6 d-flex justify-content-end">
                                <label >Nro Serie</label>
                                <input type="text" name="NroSerie" value="${nserie}" class="form-control ">

                            </div>
                            <table border="1" class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Nro</th>
                                        <th>Codigo</th>
                                        <th>Descripcion</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>Subtotal</th>
                                        <th class="accion">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="list" items="${lista}">
                                        <tr>
                                            <td>${list.getItem()}</td>
                                            <td>${list.getIdproducto()}</td>
                                            <td>${list.getDescripcionP()}</td>
                                            <td>${list.getPrecio()}</td>
                                            <td>${list.getCantidad()}</td>
                                            <td>${list.getSubtotal()}</td>
                                            <td class="d-flex">
                                                <a class="btn btn-warning"  href="#" >Editar</a>
                                                <a class="btn btn-danger "  href="#" style="margin-left: 20px">Eliminar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                        <div class="card-footer d-flex">
                            <div class="col-sm-6">
                                <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" class="btn btn-warning" onclick="print()">Generar Venta</a>
                                
                                <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                            </div>
                            <div class="col-sm-4 ml-auto">
                                <input type="text" name="txtTotal" value="$ ${totalpagar}" class="form-control">
                            </div>

                        </div>
                    </div>

                </div>
            </div>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
