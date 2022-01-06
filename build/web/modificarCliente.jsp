<%-- 
    Document   : modificarCliente
    Created on : 20/12/2021, 18:53:36
    Author     : ivanc
--%>

<%@page import="logica.Cliente"%>
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
        <link rel="stylesheet" href="CSS/style-main.css">
        <link rel="stylesheet" href="CSS/confirmaciones.css">
        <link rel="stylesheet" href="CSS/styleModificaciones.css">


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
                    <div class="login-box" style="width: 65%; height: 70%;margin: 0 auto;">

                        <h1 class="subtitulo">Editar Cliente</h1>

                        <form class="formCliente" action="SvModificarClienteConfirm" method="post" style="margin-top: 50px;">
                            
                            <%
                            Cliente cliente = (Cliente) miSesion.getAttribute("cliente");
                            
                            
                            %>
                            <div>
                                <p>
                                    <label for="nombre">Nombre :</label>
                                    <input class="input" name="nombre" type="text" value="<%=cliente.getNombre()%>">
                                </p>
                                <p>
                                    <label for="apellido">Apellido :</label>
                                    <input class="input" name="apellido" type="text" value="<%=cliente.getApellido()%>">
                                </p>
                                <p>
                                    <label for="dni">Dni :</label>
                                    <input class="input" name="dni" type="text" value="<%=cliente.getDni()%>">
                                </p>
                                <p>
                                    <label for="fechaNac">Fecha de nacimiento :</label>
                                    <input class="input" name="fechaNac" type="text" value="<%=cliente.getFechaNac()%>">
                                </p>
                                <p>
                                    <label for="direccion">Direccion :</label>
                                    <input class="input" name="domicilio" type="text" value="<%=cliente.getDireccion()%>">
                                </p>
                                <p>
                                    <label for="localidad">Localidad :</label>
                                    <input class="input" name="localidad" type="text" value="<%=cliente.getLocalidad()%>">
                                </p>
                                <p>
                                    <label for="provincia">Provincia :</label>
                                    <input class="input" name="provincia" type="text" value="<%=cliente.getProvincia()%>">
                                </p>
                                <p>
                                    <label for="nacionalidad">Nacionalidad :</label>
                                    <input class="input" name="nacionalidad" type="text" value="<%=cliente.getNacionalidad()%>">
                                </p>
                                <p>
                                    <label for="telefono">Telefono :</label>
                                    <input class="input" name="telefono" type="text" value="<%=cliente.getNumTelefono()%>">
                                </p>
                                <p>
                                    <label for="email">Email :</label>
                                    <input class="input" name="email" type="email" value="<%=cliente.getEmail()%>">
                                </p>
                                <input type="text" name="id" style="visibility: hidden;" value="<%=cliente.getId()%>">
                            </div>
                            <input class="boton" type="submit" value="Registrar cliente editado">
                        </form>
                        
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
