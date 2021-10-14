/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NORVEY
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente cl = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto pr = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    Venta v = new Venta();
    VentaDAO vdao = new VentaDAO();
    List<Venta> lista = new ArrayList<>();
    int item = 0;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    String numeroserie;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");

        if (menu.equalsIgnoreCase("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("Producto")) {
            switch (accion) {
                case "Listar": {
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=default").forward(request, response);
                    break;
                }
                case "Agregar": {
                    String nom = request.getParameter("txtNombres");
                    Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String est = request.getParameter("txtEstado");
                    pr.setNom(nom);
                    pr.setPrecio(precio);
                    pr.setStock(stock);
                    pr.setEstado(est);
                    pdao.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                }
                case "Editar": {
                    ide = Integer.parseInt(request.getParameter("id"));
                    Producto p = pdao.listarId(ide);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                }
                case "Actualizar": {
                    String nom = request.getParameter("txtNombres");
                    Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String est = request.getParameter("txtEstado");
                    pr.setNom(nom);
                    pr.setPrecio(precio);
                    pr.setStock(stock);
                    pr.setEstado(est);
                    pr.setId(ide);
                    pdao.actualizar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                }
                case "Delete": {
                    ide = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                }
                default: {
                    request.getRequestDispatcher("Producto.jsp").forward(request, response);
                }
            }

        }
        if (menu.equalsIgnoreCase("Cliente")) {
            switch (accion) {
                case "Listar": {
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=default").forward(request, response);
                    break;
                }
                case "Agregar": {
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String dir = request.getParameter("txtDir");
                    String est = request.getParameter("txtEstado");
                    cl.setDni(dni);
                    cl.setNom(nom);
                    cl.setDir(dir);
                    cl.setEstado(est);
                    cdao.agregar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                }
                case "Editar": {
                    ide = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cdao.listarId(ide);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                }
                case "Actualizar": {
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String dir = request.getParameter("txtDir");
                    String est = request.getParameter("txtEstado");
                    cl.setDni(dni);
                    cl.setNom(nom);
                    cl.setDir(dir);
                    cl.setEstado(est);
                    cl.setId(ide);
                    cdao.actualizar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                }
                case "Delete": {
                    ide = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                }
                default: {
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                }
            }

        }
        if (menu.equalsIgnoreCase("Empleado")) {
            switch (accion) {
                case "Listar": {
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=default").forward(request, response);
                    break;
                }
                case "Agregar": {
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                }
                case "Editar": {
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                }
                case "Actualizar": {
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                }
                case "Delete": {
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                }
                default: {
                    request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                }
            }

        }
        if (menu.equalsIgnoreCase("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente": {
                    String dni = request.getParameter("codigocliente");
                    cl.setDni(dni);
                    cl = cdao.buscar(dni);
                    request.setAttribute("c", cl);
                    request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=default").forward(request, response);
                    break;
                }
                case "BuscarProducto": {
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pr = pdao.listarId(id);
                    request.setAttribute("producto", pr);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("c", cl);
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=default").forward(request, response);
                    break;
                }
                case "Agregar": {
                    totalPagar = 0;
                    item++;
                    cod = pr.getId();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar += lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("c", cl);
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=default").forward(request, response);
                    break;
                }
                case "GenerarVenta": {
                    //adtualizacion stock
                    for(int i=0; i<lista.size();i++){
                        Producto  p = new Producto();
                        int cant = lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        ProductoDAO objPDAO = new ProductoDAO();
                        p = objPDAO.buscar(idproducto);
                        int sac=p.getStock()-cant;
                        objPDAO.actualizarstock(idproducto, sac);
                    }
                    //guardar venta
                    v.setIdcliente(cl.getId());
                    v.setIdempleado(2);
                    v.setNumserie(numeroserie);
                    v.setFecha("2019-06-14");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    //guaradar detalle ventas
                    int idv ;
                    if(vdao.idVentas()==null){
                        idv = 1;
                    }else{
                        idv= Integer.parseInt(vdao.idVentas());
                    }
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalventas(v);
                    }
                    request.getRequestDispatcher("Controlador?menu=NuevaVenta&accion=default").forward(request, response);
                    break;
                }
                default: {
                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.numeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                }
            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
