document.addEventListener('DOMContentLoaded', function() {
  const btnEnviar = document.getElementById('btnCrearUsuario');
  const form = document.getElementById('form');

  const nombreUsuario = document.getElementById('nombreUsuario');
 /* const fechaNacimiento = document.getElementById('fechaNacimiento');
  const run = document.getElementById('run');*/

  const nombreCliente = document.getElementById('nombreCliente');
  const apellidoCliente = document.getElementById('apellidoCliente');
  const tlfCliente = document.getElementById('tlfCliente');
  const afp = document.getElementById('afp');
  const sistemaSalud = document.getElementById('sistemaSalud');
  const direccion = document.getElementById('direccion');
  const comuna = document.getElementById('comuna');
  const edad = document.getElementById('edad');

  const titulo = document.getElementById('titulo');
  const fechaIngreso = document.getElementById('fechaIngreso');

  const area = document.getElementById('area');
  const experienciaPrevia = document.getElementById('experienciaPrevia');

  const listInputs = document.querySelectorAll('.form-control');

  // Función para validar el formulario y mostrar los mensajes de error
  function validarForm() {
    listInputs.forEach(element => {
      if (element && element.parentElement.querySelector('.msjError')) {
        element.parentElement.querySelector('.msjError').innerHTML = '';
      }
    });

    // Validar el nombre de usuario
    if (nombreUsuario.value.length < 10 || nombreUsuario.value.length > 50 || nombreUsuario.value.trim() === "") {
      mostrarMensajeError(nombreUsuario, "Nombre de usuario inválido, debe contener entre 10 y 50 caracteres");
      return false;
    }

   /* // Validar el RUN
    if (run.value < 99999999) {
      mostrarMensajeError(run, "RUN inválido, el número no puede ser menor a 99.999.999");
      return false;
    }*/

    // Validar campos del cliente si existen
    const nombreClienteDiv = document.querySelector('.nombreCliente');
    if (nombreClienteDiv) {
      const nombreClienteInput = nombreClienteDiv.querySelector('input');
      if (nombreClienteInput.value.length < 5 || nombreClienteInput.value.length > 30) {
        mostrarMensajeError(nombreClienteInput, "Nombre de cliente inválido, debe contener entre 5 y 30 caracteres");
        return false;
      }
    }

    // Validar campos del profesional si existen
    const tituloDiv = document.querySelector('.titulo');
    if (tituloDiv) {
      const tituloInput = tituloDiv.querySelector('input');
      if (tituloInput.value.length < 10 || tituloInput.value.length > 50 || tituloInput.value.trim() === "") {
        mostrarMensajeError(tituloInput, "Campo inválido, debe contener entre 10 y 50 caracteres");
        return false;
      }
    }

    // Validar campos del administrativo si existen
    const areaDiv = document.querySelector('.area');
    if (areaDiv) {
      const areaInput = areaDiv.querySelector('input');
      if (areaInput.value.length < 5 || areaInput.value.length > 20 || areaInput.value.trim() === "") {
        mostrarMensajeError(areaInput, "Campo inválido, debe contener entre 5 y 20 caracteres");
        return false;
      }
    }

    return true;
  }

  // Función para mostrar mensaje de error en un campo
  function mostrarMensajeError(elemento, mensaje) {
    const contenedor = elemento.parentElement;
    const mensajeError = contenedor.querySelector('.msjError');
    if (mensajeError) {
      mensajeError.innerHTML = mensaje;
    }
  }

  // Agregar evento submit al formulario
  form.addEventListener('submit', (e) => {
    e.preventDefault();

    if (validarForm()) {
	Swal.fire({
  		title: 'Esta seguro que los datos ingresadas son correctos?',
  		icon: 'success',
  		showCancelButton: true,
  		confirmButtonText: 'Si, enviar',
  		cancelButtonText: 'No',
		}).then((result) => {
  			if (result.isConfirmed) {

            form.submit(); 
        } else {
            Swal.fire({
                title: 'Operación cancelada',
                icon: 'info',
                confirmButtonText: 'Aceptar',
            })
      			}
    		});
    	}
  	});
});