<%-- Document : main Created on : 19/12/2021, 16:46:50 Author : ivanc --%>

    <%@page import="logica.Empleado"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.NavigableSet"%>
<%@page import="java.util.SortedSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Venta"%>
<%@page import="logica.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

        <!doctype html>
        <html lang="es">

        <head>

            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Silicon Travel</title>
            <link rel="shortcut icon" href="img/faviconSilicon.svg" type="image/x-icon">

            <script src="https://cdn.jsdelivr.net/npm/chart.js@3.6.2/dist/chart.min.js"></script>

            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                crossorigin="anonymous">
            <!-- GoogleFonts -->
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Lato:wght@100;400;700&display=swap" rel="stylesheet">
            <!-- CSS propio -->
            <link rel="stylesheet" href="CSS/style-main.css">


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
                        <circle id="Elipse_2" data-name="Elipse 2" cx="167" cy="167" r="167"
                            transform="translate(722 835)" fill="#24a6e0" />
                        <circle id="Elipse_7" data-name="Elipse 7" cx="281" cy="281" r="281"
                            transform="translate(1130 51)" fill="#24a6e0" />
                        <circle id="Elipse_5" data-name="Elipse 5" cx="167" cy="167" r="167"
                            transform="translate(678 406)" fill="#afcc4e" />
                        <circle id="Elipse_9" data-name="Elipse 9" cx="319" cy="319" r="319"
                            transform="translate(1231 893)" fill="#afcc4e" />
                        <circle id="Elipse_4" data-name="Elipse 4" cx="167" cy="167" r="167"
                            transform="translate(1077 701)" fill="#e95b2b" />
                        <circle id="Elipse_8" data-name="Elipse 8" cx="250" cy="250" r="250" fill="#e95b2b" />
                    </svg>

                    <div class="glass-fondo"></div>

                </div>
                <div class="caja-pp">

                    <div class="sidebar">
                        <div class="logo">
                            <svg class="logo-completo" id="Capa_1" data-name="Capa 1" xmlns="http://www.w3.org/2000/svg"
                                xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 40 360 250">
                                <defs>
                                    <style>
                                        .cls-1 {
                                            fill: url(#Degradado_sin_nombre_2);
                                            filter: drop-shadow(1px 1px 4px rgba(0, 0, 0, .5));
                                        }

                                        .cls-2 {
                                            fill: url(#Degradado_sin_nombre_4);
                                        }

                                        .cls-3 {
                                            fill: url(#Degradado_sin_nombre_11);
                                        }

                                        .cls-4 {
                                            fill: url(#Degradado_sin_nombre_8);
                                        }

                                        .cls-5 {
                                            fill: url(#Degradado_sin_nombre_6);
                                        }

                                        .cls-6 {
                                            fill: url(#Degradado_sin_nombre_12);
                                        }

                                        .cls-7 {
                                            fill: #fff;
                                            filter: drop-shadow(3px 3px 4px rgba(0, 0, 0, .5));
                                        }

                                        .cls-8 {
                                            fill: #fcfcfc;
                                            filter: drop-shadow(3px 3px 2px rgba(0, 0, 0, .5));
                                        }
                                    </style>
                                    <linearGradient id="Degradado_sin_nombre_2" x1="206.68" y1="90.67" x2="169.71"
                                        y2="179.33" gradientTransform="matrix(0, -1, -1, 0, 371.68, 371.68)"
                                        gradientUnits="userSpaceOnUse">
                                        <stop offset="0" stop-color="#24a6e0" />
                                        <stop offset="1" stop-color="#2474e0" />
                                    </linearGradient>
                                    <linearGradient id="Degradado_sin_nombre_4" x1="235.45" y1="81.19" x2="237.25"
                                        y2="93.39" xlink:href="#Degradado_sin_nombre_2" />
                                    <linearGradient id="Degradado_sin_nombre_11" x1="174" y1="187.79" x2="207.89"
                                        y2="112.82" gradientTransform="matrix(0, -1, -1, 0, 371.68, 371.68)"
                                        gradientUnits="userSpaceOnUse">
                                        <stop offset="0" stop-color="#24a6e0" />
                                        <stop offset="1" stop-color="#24a6e0" stop-opacity="0" />
                                    </linearGradient>
                                    <linearGradient id="Degradado_sin_nombre_8" x1="243.07" y1="102.42" x2="262.45"
                                        y2="95.23" gradientTransform="matrix(0, -1, -1, 0, 371.68, 371.68)"
                                        gradientUnits="userSpaceOnUse">
                                        <stop offset="0" stop-color="#2474e0" />
                                        <stop offset="1" stop-color="#24a6e0" />
                                    </linearGradient>
                                    <linearGradient id="Degradado_sin_nombre_6" x1="236.9" y1="114.61" x2="236.9"
                                        y2="100.89" xlink:href="#Degradado_sin_nombre_2" />
                                    <linearGradient id="Degradado_sin_nombre_12" x1="124.33" y1="178.74" x2="203.66"
                                        y2="106.6" xlink:href="#Degradado_sin_nombre_11" />
                                </defs>
                                <path class="cls-1"
                                    d="M275,107.67c-4.11,0-7,6.15-6.45,12.71l.59,7.5-18.8,6.55a4.7,4.7,0,0,0-3.15,4.37l0,2.62,22.37.26c-8.16,34.69-42.71,58.88-67.7,60.75-27.47,2-27.47-25.93-27.47-25.93-22.59,24.13-1.8,67.52,47.86,38.76C255.44,196,267.8,165.72,272,149h0a0,0,0,0,1,0,0,.56.56,0,0,1,.65-.4.55.55,0,0,1,.43.64v0a0,0,0,0,1,0,0,144.29,144.29,0,0,1-11.18,34.73,145.88,145.88,0,0,0,12.86-34.38.43.43,0,0,1,0-.05.5.5,0,0,1,1,.16.43.43,0,0,1,0,.05c-5.44,36.15-26,77.74-52.71,90.73-30.16,14.64-51.17-6.44-51.17-6.44,13.15,20.28,53.1,32.86,83.22-12.84,21.75-33,23.65-58.89,24.76-76.71l0-2.67,23.71.27,0-2.63a4.67,4.67,0,0,0-3-4.43l-19.59-7.33.57-7.29q.06-.76.06-1.53C281.53,112.9,278.81,107.67,275,107.67Z" />
                                <path class="cls-2"
                                    d="M280.9,127.67,300.49,135a4.67,4.67,0,0,1,3,4.43l0,2.63-23.71-.27S280.61,135.33,280.9,127.67Z" />
                                <path class="cls-3"
                                    d="M201.85,202.43c25-1.87,59.54-26.06,67.7-60.75,0,0-5.29,46.86-56.12,68.08-19.71,8.23-36.74,2.42-47.61-16.72a33.29,33.29,0,0,1,8.56-16.54S174.38,204.48,201.85,202.43Z" />
                                <path class="cls-4"
                                    d="M275,107.67c-4.11,0-7,6.15-6.45,12.71l.59,7.5c0,4,.27,10.39.36,12.82,0,.05,0,.1,0,.14a5.74,5.74,0,0,1,0,.84c.44-8,2.59-33.9,11.06-28.59C279.5,109.9,277.49,107.67,275,107.67Z" />
                                <path class="cls-5"
                                    d="M269.55,141.68l-22.37-.26,0-2.62a4.7,4.7,0,0,1,3.15-4.37l18.8-6.55C269.2,132.94,269.55,141.68,269.55,141.68Z" />
                                <path class="cls-6"
                                    d="M171.86,234s21,21.08,51.17,6.44c26.72-13,47.27-54.58,52.71-90.73a.43.43,0,0,0,0-.05S272.34,192.22,251.4,219s-36.2,28.88-54.43,28.5c-9.13-.2-18.12-6.67-24.83-13.08Z" />
                                <path class="cls-7"
                                    d="M57.28,181.53a2.18,2.18,0,0,1-.48-2.85l3.42-5.89a2.17,2.17,0,0,1,1.61-1.09,1.84,1.84,0,0,1,1.62.43l.47.28a9.86,9.86,0,0,0,1.09.76c.41.26.93.57,1.57,1s1.26.75,1.9,1.09a23.62,23.62,0,0,0,2.18,1q1.23.53,2.37.9a19.27,19.27,0,0,0,2.38.62,13.19,13.19,0,0,0,2.37.23A9.11,9.11,0,0,0,84,175.88a6.64,6.64,0,0,0,2.47-5.18,8.2,8.2,0,0,0-3-6.21,30.19,30.19,0,0,0-9.11-5.18,39.15,39.15,0,0,1-12.91-8.07,16.64,16.64,0,0,1-4.93-12.43A17.57,17.57,0,0,1,62,126.09q5.46-5.5,15.9-5.5a30.83,30.83,0,0,1,19,6.35,1.92,1.92,0,0,1,.85,1.43,2.19,2.19,0,0,1-.28,1.71l-3.61,5.41q-1.51,2.28-3.32,1.14-8.35-5.22-13.2-5.22a8.6,8.6,0,0,0-6.07,2.09A6.12,6.12,0,0,0,69,138.05a7.66,7.66,0,0,0,2.66,5.79,28.31,28.31,0,0,0,8.54,4.84A60.37,60.37,0,0,1,87.22,152a46.58,46.58,0,0,1,6.17,4.17,17.1,17.1,0,0,1,4.89,6.08,18.07,18.07,0,0,1,1.71,7.92,17.36,17.36,0,0,1-6.07,13.25q-6.08,5.55-15.76,5.55a32.8,32.8,0,0,1-10.3-1.61,32.45,32.45,0,0,1-7-3A27.82,27.82,0,0,1,57.28,181.53Z" />
                                <path class="cls-7"
                                    d="M108.06,186.18V123.34a1.7,1.7,0,0,1,.57-1.23,1.68,1.68,0,0,1,1.23-.57h8a1.68,1.68,0,0,1,1.23.57,1.7,1.7,0,0,1,.57,1.23v62.84a2,2,0,0,1-1.8,1.8h-8a2,2,0,0,1-1.8-1.8Z" />
                                <path class="cls-7"
                                    d="M136.63,136.53a6.2,6.2,0,0,1-4.56-1.9,6.64,6.64,0,0,1,0-9.3,6.24,6.24,0,0,1,4.56-1.9,6.52,6.52,0,0,1,4.7,1.9,6.54,6.54,0,0,1,0,9.3A6.48,6.48,0,0,1,136.63,136.53ZM131,186.18V151.81a1.74,1.74,0,0,1,.52-1.28,1.77,1.77,0,0,1,1.28-.52h7.88a1.77,1.77,0,0,1,1.28.52,1.74,1.74,0,0,1,.52,1.28v34.37a1.78,1.78,0,0,1-.52,1.23,1.66,1.66,0,0,1-1.28.57h-7.88a2,2,0,0,1-1.8-1.8Z" />
                                <path class="cls-7"
                                    d="M151,169A18.84,18.84,0,0,1,157,154.9a19.78,19.78,0,0,1,14.14-5.84,17.55,17.55,0,0,1,14,6.74,1.66,1.66,0,0,1-.48,2.66l-4.36,4.17c-.7.57-1.49.48-2.38-.28a8.38,8.38,0,0,0-6.55-3,8.77,8.77,0,0,0-6.54,2.85,9.48,9.48,0,0,0-2.76,6.84,9.63,9.63,0,0,0,2.66,6.88,8.69,8.69,0,0,0,6.55,2.8,9,9,0,0,0,3.51-.67,8.71,8.71,0,0,0,2.18-1.14c.38-.31,1-.91,1.9-1.8a1.69,1.69,0,0,1,2.38-.28l4.08,3.51c1.07.89,1.29,1.77.66,2.66q-5.13,8-15,8a19.73,19.73,0,0,1-14.15-5.74A18.92,18.92,0,0,1,151,169Z" />
                                <path class="cls-7"
                                    d="M191.39,168.9a19.29,19.29,0,0,1,5.75-14,18.91,18.91,0,0,1,27.43,0,19.28,19.28,0,0,1,5.74,14,19.7,19.7,0,0,1-5.69,14.1,18.94,18.94,0,0,1-27.53,0A19.67,19.67,0,0,1,191.39,168.9Zm10.35,0a9.8,9.8,0,0,0,2.66,6.93,8.74,8.74,0,0,0,12.91,0A9.8,9.8,0,0,0,220,168.9a9.52,9.52,0,0,0-2.66-6.79,8.84,8.84,0,0,0-12.91,0A9.52,9.52,0,0,0,201.74,168.9Z" />
                                <path class="cls-7"
                                    d="M238.76,186.18V151.81a1.74,1.74,0,0,1,.52-1.28,1.78,1.78,0,0,1,1.28-.52h3.61a1.64,1.64,0,0,1,1.61,1.14l1.33,3.51a17.5,17.5,0,0,1,13.39-5.6q8.53,0,12.71,5.41A21.38,21.38,0,0,1,277.39,168v18.23a1.78,1.78,0,0,1-.52,1.23,1.66,1.66,0,0,1-1.28.57h-7.78a1.75,1.75,0,0,1-1.29-.52,1.78,1.78,0,0,1-.52-1.28v-18.8a8.8,8.8,0,0,0-1.85-5.88,6.51,6.51,0,0,0-5.27-2.19,8.91,8.91,0,0,0-5.74,1.86,9.63,9.63,0,0,0-3.18,4.12v20.89q0,1.8-2.37,1.8h-7a2,2,0,0,1-1.8-1.8Z" />
                                <path class="cls-8"
                                    d="M158,228.87V214.64h-3a1.06,1.06,0,0,1-.8-.33,1.08,1.08,0,0,1-.33-.8V212.2a1,1,0,0,1,1.13-1.12h3v-6.59a1.13,1.13,0,0,1,.33-.77,1,1,0,0,1,.8-.36l1.9-.11a1,1,0,0,1,.74.32,1.09,1.09,0,0,1,.33.8v6.71H169a1,1,0,0,1,1.13,1.12v1.31a1.13,1.13,0,0,1-1.13,1.13h-6.88v13.88a4,4,0,0,0,.44,2.28,1.81,1.81,0,0,0,1.51.57,9.45,9.45,0,0,0,4.34-1.31,1,1,0,0,1,1.42.36l.89,1.48a1,1,0,0,1-.42,1.48,15.94,15.94,0,0,1-3,1.31,11.72,11.72,0,0,1-3.86.71c-2.17,0-3.63-.55-4.36-1.66A8.89,8.89,0,0,1,158,228.87Z" />
                                <path class="cls-8"
                                    d="M176.74,233.68V212.2a1.13,1.13,0,0,1,.33-.77,1,1,0,0,1,.8-.35H179a.93.93,0,0,1,1,.83l.48,1.72a4,4,0,0,0,.27-.33,6.43,6.43,0,0,1,.79-.77,8.23,8.23,0,0,1,1.43-1,9.76,9.76,0,0,1,2-.74,10.15,10.15,0,0,1,2.61-.33,11.77,11.77,0,0,1,1.48.09,13.28,13.28,0,0,1,1.46.27,2.07,2.07,0,0,1,1.09.59.92.92,0,0,1,.12,1l-.71,2c-.24.63-.71.81-1.43.53a5.71,5.71,0,0,0-2.31-.47,7.69,7.69,0,0,0-3.62.83,6.67,6.67,0,0,0-2.25,1.66l-.6.83v15.84a1.22,1.22,0,0,1-1.12,1.13h-1.84a1,1,0,0,1-.8-.36A1.11,1.11,0,0,1,176.74,233.68Z" />
                                <path class="cls-8"
                                    d="M196.91,233.26a7.74,7.74,0,0,1-2.07-5.63,7.19,7.19,0,0,1,2.52-5.7,10.27,10.27,0,0,1,7-2.19,17.21,17.21,0,0,1,2.4.18,11.9,11.9,0,0,1,2,.41l.65.18a11.42,11.42,0,0,0-.68-5c-.5-.95-1.56-1.43-3.18-1.43a19.64,19.64,0,0,0-7.12,1.31c-.55.23-.92,0-1.12-.6l-.48-1.48a1,1,0,0,1,.66-1.3,9.87,9.87,0,0,1,1.27-.48,27.12,27.12,0,0,1,2.94-.68,21.16,21.16,0,0,1,4-.39q4.4,0,6,2.29t1.57,7.74v13.17a1.06,1.06,0,0,1-.35.77,1.09,1.09,0,0,1-.77.36H211c-.47,0-.81-.3-1-.89l-.47-1.6a10.07,10.07,0,0,1-7.36,3.08A7,7,0,0,1,196.91,233.26Zm1.72-5.63a4.22,4.22,0,0,0,1.13,3,3.94,3.94,0,0,0,3,1.19,7.55,7.55,0,0,0,3.86-1,8.33,8.33,0,0,0,2.67-2.28v-4.69a10.12,10.12,0,0,0-5-1,6.47,6.47,0,0,0-4.13,1.25A4.23,4.23,0,0,0,198.63,227.63Z" />
                                <path class="cls-8"
                                    d="M228.23,234.81l-10-22.37a.91.91,0,0,1,0-1,1.05,1.05,0,0,1,.92-.38h1.84a1.15,1.15,0,0,1,1.07.65l7.35,17h.06l7.83-17a1,1,0,0,1,1-.65h1.54a1,1,0,0,1,.92.38.91.91,0,0,1,0,1l-10.14,22.37a1,1,0,0,1-1,.59h-.3A1,1,0,0,1,228.23,234.81Z" />
                                <path class="cls-8"
                                    d="M244.13,222.94a12.85,12.85,0,0,1,3.21-8.84,10.7,10.7,0,0,1,8.42-3.62,10.32,10.32,0,0,1,7.71,3.09,10.63,10.63,0,0,1,3,7.77,11.19,11.19,0,0,1-.12,1.6,1,1,0,0,1-1.07,1H248.23a8.06,8.06,0,0,0,2.52,5.37,7.45,7.45,0,0,0,5.43,2.34,11.13,11.13,0,0,0,5.87-1.78c.52-.27.83-.43.95-.47s.36.08.71.35c.12.16.29.39.5.69l.51.68a1.43,1.43,0,0,1,.36.77c0,.2-.2.45-.6.77a13.59,13.59,0,0,1-8.72,2.73,10.74,10.74,0,0,1-8.42-3.59A12.82,12.82,0,0,1,244.13,222.94Zm4.16-2.31h14.12a6.8,6.8,0,0,0-2.05-4.57,6.26,6.26,0,0,0-4.6-2,7.34,7.34,0,0,0-5.07,1.87A7,7,0,0,0,248.29,220.63Z" />
                                <path class="cls-8"
                                    d="M273,233.68V194.41a1.22,1.22,0,0,1,1.13-1.13H276a1.06,1.06,0,0,1,.8.35,1.13,1.13,0,0,1,.33.78v39.27a1.11,1.11,0,0,1-.33.77,1,1,0,0,1-.8.36h-1.84a1.25,1.25,0,0,1-1.13-1.13Z" />
                            </svg>
                        </div>
                        <hr>
                        <ul>
                            <li class="list active" id="liVentas">
                                <svg xmlns="http://www.w3.org/2000/svg" width="48.155" height="50.647"
                                    viewBox="0 0 48.155 50.647">
                                    <path id="Trazado_21" data-name="Trazado 21"
                                        d="M32.1,1.586,20.058,13.625V52.233L32.1,40.195ZM7.138,6.724A3.01,3.01,0,0,0,2,8.851v30.1a3.009,3.009,0,0,0,.881,2.127L14.039,52.233V13.625Zm42.136,6.019L38.116,1.586V40.195l6.9,6.9a3.01,3.01,0,0,0,5.138-2.128v-30.1a3.009,3.009,0,0,0-.881-2.127Z"
                                        transform="translate(-2 -1.586)" fill-rule="evenodd" />
                                </svg>
                                <h3>Ventas</h3>
                            </li>
                            <li class=" list " id="liClientes">
                                <svg xmlns="http://www.w3.org/2000/svg" width="56.4" height="47" viewBox="0 0 56.4 47">
                                    <path id="Trazado_22" data-name="Trazado 22"
                                        d="M38.6,12.4A9.4,9.4,0,1,1,29.2,3,9.4,9.4,0,0,1,38.6,12.4Zm15.667,6.267A6.267,6.267,0,1,1,48,12.4,6.267,6.267,0,0,1,54.267,18.667ZM41.733,40.6a12.533,12.533,0,1,0-25.067,0V50H41.733ZM16.667,18.667A6.267,6.267,0,1,1,10.4,12.4,6.267,6.267,0,0,1,16.667,18.667ZM48,50V40.6a18.712,18.712,0,0,0-2.35-9.105A9.416,9.416,0,0,1,57.4,40.6V50ZM12.75,31.495A18.715,18.715,0,0,0,10.4,40.6V50H1V40.6a9.4,9.4,0,0,1,11.75-9.105Z"
                                        transform="translate(-1 -3)" />
                                </svg>
                                <h3>Clientes</h3>
                            </li>
                            <li class="list" id="liEmpleados"">
                    <svg xmlns=" http://www.w3.org/2000/svg" width="43.867" height="47" viewBox="0 0 43.867 47">
                                <path id="Trazado_23" data-name="Trazado 23"
                                    d="M24.933,21.8a9.4,9.4,0,1,0-9.4-9.4A9.4,9.4,0,0,0,24.933,21.8ZM3,50a21.933,21.933,0,0,1,43.867,0Z"
                                    transform="translate(-3 -3)" fill-rule="evenodd" />
                                </svg>

                                <h3>Empleados</h3>
                            </li>
                            <li class="list" id="liServicios">
                                <svg xmlns="http://www.w3.org/2000/svg" width="39.049" height="44.625"
                                    viewBox="0 0 39.049 44.625">
                                    <path id="Trazado_28" data-name="Trazado 28"
                                        d="M25.314,43.838a2.789,2.789,0,0,0,4.036,2.494l11.157-5.578a2.789,2.789,0,0,0,1.542-2.494V22.182a2.789,2.789,0,0,0-4.036-2.494L26.856,25.267a2.789,2.789,0,0,0-1.542,2.494ZM37.059,13.926a2.789,2.789,0,0,0,0-4.987L23.772,2.295a2.789,2.789,0,0,0-2.494,0L7.99,8.939a2.789,2.789,0,0,0,0,4.987L21.278,20.57a2.789,2.789,0,0,0,2.494,0ZM7.036,19.688A2.789,2.789,0,0,0,3,22.182V38.259a2.789,2.789,0,0,0,1.542,2.494L15.7,46.331a2.789,2.789,0,0,0,4.036-2.494V27.761a2.789,2.789,0,0,0-1.542-2.494L7.036,19.688Z"
                                        transform="translate(-3 -2.001)" />
                                </svg>

                                <h3>Servicios</h3>
                            </li>
                            <li class="list" id="liGanancias">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                                    <path d="M2 11a1 1 0 011-1h2a1 1 0 011 1v5a1 1 0 01-1 1H3a1 1 0 01-1-1v-5zM8 7a1 1 0 011-1h2a1 1 0 011 1v9a1 1 0 01-1 1H9a1 1 0 01-1-1V7zM14 4a1 1 0 011-1h2a1 1 0 011 1v12a1 1 0 01-1 1h-2a1 1 0 01-1-1V4z" />
                                </svg>

                                <h3>Estadisticas</h3>
                            </li>
                            
                        </ul>
                        <div class="user">
                            <svg class="ico-user" xmlns="http://www.w3.org/2000/svg" width="57.843" height="57.843"
                                viewBox="0 0 57.843 57.843">
                                <path id="Trazado_26" data-name="Trazado 26"
                                    d="M59.843,30.921A28.921,28.921,0,1,1,30.921,2,28.921,28.921,0,0,1,59.843,30.921ZM38.152,20.076a7.23,7.23,0,1,1-7.23-7.23A7.23,7.23,0,0,1,38.152,20.076Zm-7.23,14.461A18.077,18.077,0,0,0,14.485,45.082a21.7,21.7,0,0,0,32.871,0A18.076,18.076,0,0,0,30.921,34.537Z"
                                    transform="translate(-2 -2)" fill-rule="evenodd" />
                            </svg>
                            <div>
                                <p><%=nombreEmple%></p>
                                <p><%=cargoEmple%></p>
                            </div>
                            
                            <form action="SvLogOut" method="post">
                                <button type="submit">
                                    <svg xmlns=  "http://www.w3.org/2000/svg" class="h-6 w-6 logout"  viewBox="0 0 24 24" stroke="currentColor">
                                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1" />
                                    </svg>
                                </button>
                            </form>


                        </div>
                    </div>
                    <div class="main">
                        <div class="panel venta  " id="venta">
                            <header>
                                <h1>Ventas</h1>
                                
                                
                                <p >
                                    <button class="boton" style="margin: 15px 0; margin-right:50px ;" > 
                                            <a href="listaVentas.jsp"> Gestionar Ventas</a> 
                                    </button>
                                    
                                </p>
                            </header>
                            <hr>
                            <h2 class="subtitulo">Nueva Venta</h2>
                            <div class="panelVentaBotones">
                                <button id="btnPaquetes">Paquete</button>
                                <button id="btnServicios">Servicio</button>
                            </div>

                            <div class="divPaquete oculto" id="divPaquete">
                                <form class="formPaquete" action="SvPaqueteVenta" method="post">
                                    <div class="ventaDatosPersonales">
                                        <p class="dni">
                                            <label for="dni">Dni del cliente:</label>
                                            <input type="text" name="dni">
                                        </p>
                                        <p class="pago">
                                            <label for="metodoDePago">Metodo de Pago:</label>
                                            <select name="metodoDePago" id="metodoDePagoPaquete" onchange="obtenerValorPaquete()">
                                                <option value="-">-</option>
                                                <option value="efectivo">Efectivo</option>
                                                <option value="tarjetaDebito">Tarjeta de Debito</option>
                                                <option value="tarjetaCredito">Tarjeta de Credito</option>
                                                <option value="monederoVirtual">Monedero Virtual</option>
                                                <option value="transferencia">transferencia</option>
                                            </select>
                                        </p>
                                    </div>
                                    <p>
                                        <label for="fechaVenta">Fecha de Venta:</label>
                                        <input class="input" type="text" name="fechaVenta">
                                    </p>
                                    <p>
                                        <label for="serviciosDelPaquete">Servicios del Paquete:</label>
                                    <div class="serviciosContainer" style="display: flex; flex-direction: column; flex-wrap: wrap;" >
                                        
                                        <%
                                            List<Servicio> listServ = control.obtenerServicios();
                                            
                                            for (Servicio servicio : listServ) {
                                                String servicioName = servicio.getDescripcion();
                                                String servicioNameL = servicio.getNombreServ();
                                                   %> 
                                                    <p >
                                                        <input value="<%=servicioNameL%>" type="checkbox" name="<%=servicioNameL%>"  class="checkboxServ">
                                                        <label  class="sombra" style="margin-left: 10px;" ><%=servicioName%></label>
                                                    </p>
                                                   
                                            <%}%>
                                        
                                    </div>
                                    <input type="text" name="inputPagoHiddenPaquete" id="inputMetodoPagoPaquete"  class="input" style="visibility: hidden;">
                                    <input name="serviciosCheckedList" type="text" class="input" id="serviciosChecked" style="visibility: hidden;">
                                    <input type="submit" value="Procesar Venta">
                                    </p>
                                </form>
                            </div>
                            <div class="divServicio oculto" id="divServicio">
                                <form class="formServicio" action="SvServicioVenta" method="post">
                                    <div class="ventaDatosPersonales">
                                        <p class="dni">
                                            <label for="dni">Dni del cliente:</label>
                                            <input type="text" name="dni">
                                        </p>
                                        <p class="pago">
                                            <label for="metodoDePago">Metodo de Pago:</label>
                                            <select id="metodoDePagoServicio" onchange="obtenerValor()">
                                                <option value="-">-</option>
                                                <option value="efectivo">Efectivo</option>
                                                <option value="tarjetaDebito">Tarjeta de Debito</option>
                                                <option value="tarjetaCredito">Tarjeta de Credito</option>
                                                <option value="monederoVirtual">Monedero Virtual</option>
                                                <option value="transferencia">transferencia</option>
                                            </select>
                                        </p>
                                    </div>
                                    <p class="serviciosLista">
                                        <label for="servicioLista">Servicio:</label>
                                        <select id="servicioListaServicio" onchange="obtenerValorServicio()">
                                            <option value="-">-</option>
                                            <%
                                                for (Servicio servicio : listServ) {
                                                    String servicioName = servicio.getDescripcion();
                                                    String servicioNameL = servicio.getNombreServ();
                                                    
                                            %>
                                            <option value="<%=servicioNameL%>"> <%=servicioName%> </option>
                                            <%}%>
                                        </select>
                                    </p>
                                    
                                    <p>
                                        <label for="fechaVenta">Fecha de Venta:</label>
                                        <input class="input" type="text" name="fechaVenta">
                                    </p>
                                    <input id="inputPagoHidden" type="text" name="metodoDePago"
                                        style="visibility: hidden">
                                    <input id="inputServicopHidden" type="text" name="servicioListaHidden"
                                        style="visibility: hidden;">
                                    <input type="submit" value="Procesar Venta">
                                </form>
                            </div>
                        </div>
                        <div class="panel cliente oculto" id="cliente">
                            <header>
                                <h1>Clientes</h1>
                                <p >
                                    
                                        
                                        <button class="boton" style="margin: 15px 0; margin-right:50px ;"> 
                                            <a href="listaClientes.jsp"> Gestionar Clientes</a> 
                                        </button>
                                        
                                        
                                </p>
                            </header>
                            <hr>
                            <h2 class="subtitulo">Nuevo Cliente</h2>
                            <form class="formCliente" action="SvCliente" method="post">
                                <div>
                                    <p>
                                        <label for="nombre">Nombre :</label>
                                        <input class="input" name="nombre" type="text">
                                    </p>
                                    <p>
                                        <label for="apellido">Apellido :</label>
                                        <input class="input" name="apellido" type="text">
                                    </p>
                                    <p>
                                        <label for="dni">Dni :</label>
                                        <input class="input" name="dni" type="text">
                                    </p>
                                    <p>
                                        <label for="fechaNac">Fecha de nacimiento :</label>
                                        <input class="input" name="fechaNac" type="text">
                                    </p>
                                    <p>
                                        <label for="direccion">Direccion :</label>
                                        <input class="input" name="domicilio" type="text">
                                    </p>
                                    <p>
                                        <label for="localidad">Localidad :</label>
                                        <input class="input" name="localidad" type="text">
                                    </p>
                                    <p>
                                        <label for="provincia">Provincia :</label>
                                        <input class="input" name="provincia" type="text">
                                    </p>
                                    <p>
                                        <label for="nacionalidad">Nacionalidad :</label>
                                        <input class="input" name="nacionalidad" type="text">
                                    </p>
                                    <p>
                                        <label for="telefono">Telefono :</label>
                                        <input class="input" name="telefono" type="text">
                                    </p>
                                    <p>
                                        <label for="email">Email :</label>
                                        <input class="input" name="email" type="email">
                                    </p>
                                </div>
                                <input class="boton" type="submit" value="Registrar cliente">
                            </form>
                        </div>
                        <div class="panel empleado oculto" id="empleado">
                            <header>
                                <h1>empleado</h1>
                                <p >
                                    <button class="boton" style="margin: 15px 0; margin-right:50px ;" type="submit"> 
                                            <a href="listaEmpleados.jsp"> Gestionar Empleados</a> 
                                    </button>
                                    
                                </p>
                            </header>
                            <hr>
                            <h2 class="subtitulo">Nuevo Empleado</h2>
                            <form class="formEmpleado" action="SvEmpleado" method="post">
                                <div>
                                    <p>
                                        <label for="nombre">Nombre :</label>
                                        <input class="input" name="nombre" type="text">
                                    </p>
                                    <p>
                                        <label for="apellido">Apellido :</label>
                                        <input class="input" name="apellido" type="text">
                                    </p>
                                    <p>
                                        <label for="dni">Dni :</label>
                                        <input class="input" name="dni" type="text">
                                    </p>
                                    <p>
                                        <label for="fechaNac">Fecha de nacimiento :</label>
                                        <input class="input" name="fechaNac" type="text">
                                    </p>
                                    <p>
                                        <label for="direccion">Direccion :</label>
                                        <input class="input" name="domicilio" type="text">
                                    </p>
                                    <p>
                                        <label for="localidad">Localidad :</label>
                                        <input class="input" name="localidad" type="text">
                                    </p>
                                    <p>
                                        <label for="provincia">Provincia :</label>
                                        <input class="input" name="provincia" type="text">
                                    </p>
                                    <p>
                                        <label for="nacionalidad">Nacionalidad :</label>
                                        <input class="input" name="nacionalidad" type="text">
                                    </p>
                                    <p>
                                        <label for="telefono">Telefono :</label>
                                        <input class="input" name="telefono" type="text">
                                    </p>
                                    <p>
                                        <label for="email">Email :</label>
                                        <input class="input" name="email" type="email">
                                    </p>
                                    <p>
                                        <label for="cargo">Cargo :</label>
                                        <input class="input" name="cargo" type="text">
                                    </p>
                                    <p>
                                        <label for="sueldo">Sueldo :</label>
                                        <input class="input" name="sueldo" type="text">
                                    </p>
                                    <p>
                                        <label for="user">Usuario :</label>
                                        <input class="input" name="user" type="text">
                                    </p>
                                    <p>
                                        <label for="pass">Contraseña :</label>
                                        <input class="input" name="pass" type="password">
                                    </p>
                                </div>
                                <input class="boton" type="submit" value="Registrar Empleado">
                            </form>
                        </div>
                        <div class="panel servicio oculto" id="servicio">
                            <header>
                                <h1>Servicios</h1>
                                
                                
                                <p >
                                    <button class="boton" style="margin: 15px 0; margin-right:50px ;" > 
                                            <a href="listServicios.jsp"> Gestionar Servicios</a> 
                                    </button>
                                    
                                </p>
                                
                                
                               
                            </header>
                            <hr>
                            <h2 class="subtitulo">Nuevo Servicio</h2>
                            <form class="formServicioAlta" action="SvServicio" method="post">
                                <div>
                                    <p>
                                        <label for="nombre">Nombre :</label>
                                        <input class="input" name="nombre" type="text">
                                    </p>
                                    <p>
                                        <label for="apellido">Descripcion :</label>
                                        <input class="input" name="descripcion" type="text">
                                    </p>
                                    <p>
                                        <label for="destino">Destino :</label>
                                        <input class="input" name="destino" type="text">
                                    </p>
                                    <p>
                                        <label for="costo">Costo :</label>
                                        <input class="input" name="costo" type="text">
                                    </p>
                                    <p>
                                        <label for="fecha">Fecha :</label>
                                        <input class="input" name="fecha" type="text">
                                    </p>

                                </div>
                                <input class="boton" type="submit" value="Registrar Servicio">
                            </form>
                        </div>
                        <div class="panel ganancias oculto" id="ganancias">

                            <h1>Estadisticas</h1>
                            <hr>
                            <div class="contenedor-ganancias">
                                <div class="chart-1 sombra">
                                    <canvas id="myChart" width="400" height="400"></canvas>
                                    <%
                                    List <Venta> ventalist = control.obtenerVentas();
                                    
                                    int eneroCant=0;
                                    int febreroCant=0;
                                    int marzoCant=0;
                                    int abrilCant=0;
                                    int mayoCant=0;
                                    int junioCant=0;
                                    int julioCant=0;
                                    int agostoCant=0;
                                    int septiembreCant=0;
                                    int octubreCant=0;
                                    int noviembreCant=0;
                                    int diciembreCant=0;
                                    
                                    for (Venta venta : ventalist) {
                                        
                                            
                                            int mes = venta.getFechaVenta().getMonth();
                                        
                                            switch( mes ){
                                                case 0: 
                                                    eneroCant++;
                                                    break;
                                                case 1:
                                                    febreroCant++;
                                                    break;
                                                case 2:
                                                    marzoCant++;
                                                    break;
                                                case 3:
                                                    abrilCant++;
                                                    break;
                                                case 4:
                                                    mayoCant++;
                                                    break;
                                                case 5:
                                                    junioCant++;
                                                    break;
                                                case 6:
                                                    julioCant++;
                                                    break;
                                                case 7:
                                                    agostoCant++;
                                                    break;
                                                case 8:
                                                    septiembreCant++;
                                                    break;
                                                case 9:
                                                    octubreCant++;
                                                    break;
                                                case 10:
                                                    noviembreCant++;
                                                    break;
                                                case 11:
                                                    diciembreCant++;
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }

                                    %>
                                    <script>
                                        const ctx = document.getElementById('myChart').getContext('2d');
                                        const myChart = new Chart(ctx, {
                                            type: 'line',
                                            data: {
                                                labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto','Septiembre', 'Octubre', 'Nomviembre', 'Diciembre'],
                                                datasets: [{
                                                    label: 'Ventas por mes',
                                                    data: [<%=eneroCant%>, <%=febreroCant%>, <%=marzoCant%>, <%=abrilCant%>, <%=mayoCant%>, <%=junioCant%>, <%=julioCant%>
                                                        , <%=agostoCant%>, <%=septiembreCant%>, <%=octubreCant%>, <%=noviembreCant%>, <%=diciembreCant%>],
                                                    backgroundColor: [
                                                        'rgba(255, 99, 132, 0.2)',
                                                        'rgba(54, 162, 235, 0.2)',
                                                        'rgba(255, 206, 86, 0.2)',
                                                        'rgba(75, 192, 192, 0.2)',
                                                        'rgba(153, 102, 255, 0.2)',
                                                        'rgba(255, 159, 64, 0.2)'
                                                    ],
                                                    borderColor: [
                                                        'rgba(255, 99, 132, 1)',
                                                        'rgba(54, 162, 235, 1)',
                                                        'rgba(255, 206, 86, 1)',
                                                        'rgba(75, 192, 192, 1)',
                                                        'rgba(153, 102, 255, 1)',
                                                        'rgba(255, 159, 64, 1)'
                                                    ],
                                                    borderWidth: 1
                                                }]
                                            },
                                            options: {
                                                responsive: true,
                                                
                                                scales: {
                                                    y: {
                                                        beginAtZero: true
                                                    }
                                                }
                                            }
                                        });
                                    </script>
                                </div>
                                <div class="chart-1 sombra">
                                    <canvas id="myChart2" width="400" height="400"></canvas>
                                    
                                   <%
                                       
                                        List<String>  nyaList      = new ArrayList<String>();
                                        List<Integer> cantVentList = new ArrayList<Integer>();
                                       
                                      List<Empleado> listEmple = control.obtenerEmpleados();
                                      
                                       
                                       for (Empleado emple : listEmple) {
                                               String nameyape = "\"" + emple.getNombre() +" "+ emple.getApellido()+"\"";
                                               
                                               nyaList.add(nameyape);
                                               
                                               cantVentList.add(emple.getVentasRealizadas());
                                               
                                        }
                                       
                                        
                                       
                                   %>
                                    
                                    
                                    <script>
                                        const ctx2 = document.getElementById('myChart2').getContext('2d');
                                        const myChart2 = new Chart(ctx2, {
                                            type: 'bar',
                                            data: {
                                                labels: <%=nyaList.toString()%>,
                                                datasets: [{
                                                    label: 'Empleados con mas ventas',
                                                    data: <%=cantVentList.toString()%>,
                                                    backgroundColor: [
                                                        'rgba(255, 99, 132, 0.2)',
                                                        'rgba(54, 162, 235, 0.2)',
                                                        'rgba(255, 206, 86, 0.2)',
                                                        'rgba(75, 192, 192, 0.2)',
                                                        'rgba(153, 102, 255, 0.2)',
                                                        'rgba(255, 159, 64, 0.2)'
                                                    ],
                                                    borderColor: [
                                                        'rgba(255, 99, 132, 1)',
                                                        'rgba(54, 162, 235, 1)',
                                                        'rgba(255, 206, 86, 1)',
                                                        'rgba(75, 192, 192, 1)',
                                                        'rgba(153, 102, 255, 1)',
                                                        'rgba(255, 159, 64, 1)'
                                                    ],
                                                    borderWidth: 1
                                                }]
                                            },
                                            options: {
                                                scales: {
                                                    y: {
                                                        beginAtZero: true
                                                    }
                                                }
                                            }
                                        });
                                    </script>

                                </div>
                            </div>
                            

                        </div>
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