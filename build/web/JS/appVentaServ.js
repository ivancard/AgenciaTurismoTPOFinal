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
