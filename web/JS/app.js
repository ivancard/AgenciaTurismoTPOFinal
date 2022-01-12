const list = document.querySelectorAll(".list");

for (let i = 0; i < list.length; i++) {
  list[i].onclick = () => {
    let j = 0;
    while (j < list.length) {
      list[j++].className = "list";
    }
    list[i].className = "list active";
  };
}

const liVentas = document.querySelector("#liVentas");
const divVentas = document.querySelector("#venta");

const liCliente = document.querySelector("#liClientes");
const divClientes = document.querySelector("#cliente");

const liEmpleado = document.querySelector("#liEmpleados");
const divEmpleado = document.querySelector("#empleado");

const liServicio = document.querySelector("#liServicios");
const divServicio = document.querySelector("#servicio");

const liGanancia = document.querySelector("#liGanancias");
const divGanancia = document.querySelector("#ganancias");

const paneles = document.querySelectorAll(".panel");

liVentas.addEventListener("click", (e) => {
  mostrarPaneles(divVentas);
});

liCliente.addEventListener("click", (e) => {
  mostrarPaneles(divClientes);
});

liEmpleado.addEventListener("click", (e) => {
  mostrarPaneles(divEmpleado);
});

liServicio.addEventListener("click", (e) => {
  mostrarPaneles(divServicio);
});

liGanancia.addEventListener("click", (e) => {
  mostrarPaneles(divGanancia);
});



function mostrarPaneles(div) {
  paneles.forEach((panel) => {
    panel.classList.add("oculto");
  });
  if (div.classList.contains("oculto")) {
    div.classList.remove("oculto");
  }
}

const btnPaquete = document.querySelector("#btnPaquetes");
const btnServicio = document.querySelector("#btnServicios");
const divPaqueteForm = document.querySelector(".divPaquete");
const divservicioForm = document.querySelector(".divServicio");

btnPaquete.addEventListener("click", () => {
  if (!divservicioForm.classList.contains("oculto")) {
    divservicioForm.classList.add("oculto");
  }
  if (divPaqueteForm.classList.contains("oculto")) {
    divPaqueteForm.classList.remove("oculto");
  }
});
btnServicio.addEventListener("click", () => {
  if (!divPaqueteForm.classList.contains("oculto")) {
    divPaqueteForm.classList.add("oculto");
  }
  if (divservicioForm.classList.contains("oculto")) {
    divservicioForm.classList.remove("oculto");
  }
});
const inputPagoHidden = document.querySelector("#inputPagoHidden");

function obtenerValor() {
  var selectedValue = document.querySelector("#metodoDePagoServicio").value;
  inputPagoHidden.value = selectedValue;
  
}

const inputServicopHidden = document.querySelector("#inputServicopHidden");

function obtenerValorServicio() {
  var selectedValue = document.querySelector("#servicioListaServicio").value;
  inputServicopHidden.value = selectedValue;
  
}

const inputPagoHiddenPaquete = document.querySelector("#inputMetodoPagoPaquete");

function obtenerValorPaquete() {
  var selectedValue = document.querySelector("#metodoDePagoPaquete").value;
  inputPagoHiddenPaquete.value = selectedValue;
}

const inputServiciosChecked = document.querySelector("#serviciosChecked");

const chekedServicios = document.querySelectorAll(".checkboxServ");

chekedServicios.forEach(checkBox => {
  checkBox.addEventListener("click", () => {
    if (checkBox.checked) {
      
        inputServiciosChecked.value +=" "+ checkBox.value;
    }
  })
});


