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
