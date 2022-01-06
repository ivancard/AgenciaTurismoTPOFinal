<%-- 
    Document   : listaVentas
    Created on : 20/12/2021, 18:11:52
    Author     : ivanc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="logica.Venta"%>
<%@page import="logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        
        <!-- GoogleFonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lato:wght@100;400;700&display=swap" rel="stylesheet">
        
        <!-- CSS propio -->
        <link rel="stylesheet" href="CSS/style.css">
        <link rel="stylesheet" href="CSS/confirmaciones.css">
        <link rel="stylesheet" href="CSS/styleListas.css">


    <title>Silicon Travel</title>
    </head>
    <body>
        <% //Validacion de usario 
                Controladora control = new Controladora();
                
                
                HttpSession miSesion=request.getSession(); 
                String usu=(String)miSesion.getAttribute("user"); 
                String pass =(String) miSesion.getAttribute("pass");
                
                String nombreEmple = control.obtenerNombreEmpleado(usu, pass);
                String cargoEmple = control.obtenerCargoEmpleado(usu, pass);
                
                if (usu==null) { 
                    response.sendRedirect("index.jsp");
                } else{ %>
                <div class="fondo">
                    <svg xmlns="http://www.w3.org/2000/svg" width="1900" viewBox="0 0 1920 1080">
                        <circle id="Elipse_1" data-name="Elipse 1" cx="75" cy="75" r="75" transform="translate(54 538)"
                            fill="#24a6e0" />
                        <circle id="Elipse_6" data-name="Elipse 6" cx="75" cy="75" r="75" transform="translate(142 852)"
                            fill="#afcc4e" />
                        <circle id="Elipse_3" data-name="Elipse 3" cx="75" cy="75" r="75" transform="translate(521 793)"
                            fill="#e95b2b" />
                        <circle id="Elipse_2" data-name="Elipse 2" cx="167" cy="167" r="167" transform="translate(722 835)"
                            fill="#24a6e0" />
                        <circle id="Elipse_7" data-name="Elipse 7" cx="281" cy="281" r="281" transform="translate(1130 51)"
                            fill="#24a6e0" />
                        <circle id="Elipse_5" data-name="Elipse 5" cx="167" cy="167" r="167" transform="translate(678 406)"
                            fill="#afcc4e" />
                        <circle id="Elipse_9" data-name="Elipse 9" cx="319" cy="319" r="319" transform="translate(1231 893)"
                            fill="#afcc4e" />
                        <circle id="Elipse_4" data-name="Elipse 4" cx="167" cy="167" r="167" transform="translate(1077 701)"
                            fill="#e95b2b" />
                        <circle id="Elipse_8" data-name="Elipse 8" cx="250" cy="250" r="250" fill="#e95b2b" />
                    </svg>

                    <div class="glass-fondo"></div>

                </div>
                <div class="caja-pp">
                    <div class="login-box" style="width: 85%; height: 70%;">
                        
                        <h1>Ventas</h1>
                        
                        <div class="contenedor-tabla">
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Empleado</th>
                                        <th scope="col">Cliente</th>
                                        <th scope="col">Fecha</th>
                                        <th scope="col">Metodo de Pago</th>
                                        <th scope="col">Monto final</th>
                                        <th scope="col">Monto inicial</th>
                                        <th scope="col">tipo de Venta</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>

                                
                            <%
                                List<Venta> listaVentas= control.obtenerVentas();
                                
                                for (Venta venta : listaVentas) {
                                        
                                   
                                        String id = venta.getId()+"";
                                        String empleado = venta.getEmpleado().getNombre() + " "+ venta.getEmpleado().getApellido();
                                        String cliente = venta.getCliente().getNombre() + " "+ venta.getCliente().getApellido();
                                        
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
                                        String fechaComoCadena = sdf.format(venta.getFechaVenta());
                                        String fecha = fechaComoCadena;
                                        
                                        String metodoP = venta.getMetodoDePago();
                                        String montoFinal = venta.getMontoFinal()+"";
                                        String montoInicial = venta.getMontoInicial()+"";
                                        String tipo = venta.getPaquete() == null ? "Servicio":"Paquete";
                                        
                                        
                                        
                                        
                            %>
                                <tr>
                                    <th scope="row"><%=id%></th>
                                    <td><%=empleado%></td>
                                    <td><%=cliente%></td>
                                    <td><%=fecha%></td>
                                    <td><%=metodoP%></td>
                                    <td><%=montoFinal%></td>
                                    <td><%=montoInicial%></td>
                                    <td><%=tipo%></td>
                                    
                                    <td>
                                        <form class="formEditar" action="SvEditarVenta" method="post">
                                            <input type="text" style="visibility: hidden; display: none;" name="idAEditarVenta" value="<%=id%>">
                                            <button class="botonEditar" type="submit">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 16 16">
                                                    <g id="Grupo_2" data-name="Grupo 2" transform="translate(-2 -2)">
                                                      <path id="Trazado_30" data-name="Trazado 30" d="M17.414,2.586a2,2,0,0,0-2.828,0L7,10.172V13H9.828l7.586-7.586A2,2,0,0,0,17.414,2.586Z" fill="#fff"/>
                                                      <path id="Trazado_31" data-name="Trazado 31" d="M2,6A2,2,0,0,1,4,4H8A1,1,0,0,1,8,6H4V16H14V12a1,1,0,0,1,2,0v4a2,2,0,0,1-2,2H4a2,2,0,0,1-2-2Z" fill="#fff" fill-rule="evenodd"/>
                                                    </g>
                                                  </svg>
                                                  
                                            </button>
                                        </form>
                                    </td>

                                    <td>
                                        <form action="SvEliminarVenta" method="post">
                                            <input type="text" style="visibility: hidden; display: none;" name="idABorrarVenta" value="<%=id%>">
                                            <button class="botonEliminar" type="submit">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="18" height="20" viewBox="0 0 18 20">
                                                    <path id="Trazado_32" data-name="Trazado 32" d="M19,7l-.867,12.142A2,2,0,0,1,16.138,21H7.862a2,2,0,0,1-2-1.858L5,7m5,4v6m4-6v6M15,7V4a1,1,0,0,0-1-1H10A1,1,0,0,0,9,4V7M4,7H20" transform="translate(-3 -2)" fill="none" stroke="#fff" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"/>
                                                </svg>
                                            </button>
                                        </form>
                                    </td>
                                    
                                    
                                </tr>
                            <%}%>
                                </tbody>


                            </table>
                            
                        </div> 
                        

                        <button class="boton" style="margin-top: 50px;"> <a href="main.jsp" > Volver a inicio</a> </button>
                    </div>
                </div>



    <!-- Bootstrap JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

    <!-- JavaScript propio -->
    <script src="JS/app.js"></script>
                <%}%>
    </body>
</html>