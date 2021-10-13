<%-- 
    Document   : Principal
    Created on : 12/10/2021, 12:03:47 PM
    Author     : NORVEY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>




        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="collapse navbar-collapse container-fluid" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item-active">
                        <a class="btn btn-outline-light itemNavBar" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light itemNavBar" href="Controlador?menu=Producto" target="myFrame">Producto</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light itemNavBar" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light itemNavBar" href="Controlador?menu=Cliente" target="myFrame">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light itemNavBar" href="Controlador?menu=NuevaVenta" target="myFrame">Nueva venta</a>
                    </li>
                </ul>





                <div class="dropdown">
                    <button class="btn btn-outline-light dropdown-toggle " type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                        ${usuario.getNom()}
                    </button>
                    <ul class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
                        <li>
                            <a class="dropdown-item" href="#">
                                <img src="https://cdn-icons-png.flaticon.com/512/64/64572.png" alt="imagen usuario" width="60" height="60"/>
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">usuario@gmail.com</a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>

                        <form action="Validar" method="POST">

                            <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>


                        </form>
                    </ul>


                </div>


            </div>
        </nav>
        <div id="div-frame" class="m-4">
            <iframe name="myFrame" id="myFrame" width="100%" height="100%"></iframe>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
