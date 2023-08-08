
let selecTipoUsuario =document.getElementById('tipoUsuario');
const datosCliente = document.querySelector('.campoCliente');
const datosProf = document.querySelector('.campoProfesional');
const datosAdmin = document.querySelector('.campoAdministrativo');
const btn = document.getElementById('btnCrearUsuario')



selecTipoUsuario.addEventListener('change', function() {
    // Obtener el valor seleccionado
    let tipoSeleccionado = selecTipoUsuario.value;

	
    // Mostrar el conjunto de datos correspondiente al tipo seleccionado
    if (tipoSeleccionado == 'Cliente'){
    	btn.classList.remove("d-none");
    	
      	datosCliente.innerHTML = "";
      	datosProf.innerHTML = "";
      	datosAdmin.innerHTML = "";
      	const div = document.createElement("div");
      	div.innerHTML = 
      	`	<div class="nombreCliente">
      			<label class="form-label" for="nombreCliente">Nombres:</label>
				<input class="form-control" type="text" placeholder="Ingresa sus nombres"name="nombreCliente" th:field="*{nombreCliente}" id="nombreCliente">
				<p class="msjError text-danger"></p>
      		</div>
      		<div class="apellidoCliente">
      			<label class="form-label" for="apellidoCliente">Apellidos:</label>
				<input class="form-control" type="text" placeholder="Ingresa sus apellidos" name="apellidoCliente" th:field="*{nombreApellido}" id="apellidoCliente">
				<p class="msjError text-danger"></p>	
      		</div>
      		<div class="tlfCliente">
      			<label class="form-label" for="tlfCliente">Telefono:</label>
				<input class="form-control" type="number" placeholder="Ingrese el numero de telefono (+56)" name="tlfCliente" th:field="*{tlfCliente}" id="tlfCliente">
				<p class="msjError text-danger"></p> 
      		</div>
      		<div class="afp">
      			<label class="form-label" for="afp">AFP:</label>
				<input class="form-control" type="text" placeholder="Ingrese la AFP afiliada" name="afp"th:field="*{afp}"id="afp">
				<p class="msjError text-danger"></p>
      		</div>
      		<div class="sistemaSalud">
      			<label class="form-label" for="sistemaSalud">Sistema de salud:</label>
				<select id="tipoUsuario" name="sistemaSalud" class="form-control" required>	
						<option value="despliegue" selected></option>
						<option value="Fonasa" th:field="*{Fonasa}" selected>Opcion 1 Fonasa</option>
						<option value="Isapre" th:field="*{Isapre}">Opcion 2 Isapre</option>
				</select>
				<p class="msjError text-danger"></p> 
      		</div>
      		<div class="direccion">
      			<label class="form-label" for="direccion" >Direccion:</label>
				<input class="form-control" type="text" placeholder="Ingrese su direccion de domicilio" name="direccion" th:field="*{direccion}"id="direccion">
				<p class="msjError text-danger"></p> 
      		</div>
      		<div class="comuna">
      			<label class="form-label" for="comuna" >Comuna:</label>
				<input class="form-control" type="text" placeholder="Ingrese la comuna" name="comuna" th:field="*{comuna}"id="comuna">
				<p class="msjError text-danger"></p> 
      		</div>
      		<div class="edad">
      			<label class="form-label" for="edad">Edad:</label>
				<input class="form-control" type="number" placeholder="Ingrese su edad" name="edad" th:field="*{edad}" id="edad">
				<p class="msjError text-danger"></p> 
      		</div>`;
      	datosCliente.appendChild(div);  
    } else if(tipoSeleccionado == 'Profesional') {
    	 btn.classList.remove("d-none");
         datosProf.innerHTML = "";
         datosCliente.innerHTML = "";
         datosAdmin.innerHTML = "";
         const div = document.createElement("div");
         div.innerHTML = 
         `
         	<div class="titulo">
         		<label class="form-label" for="titulo">Titulo:</label>
				<input class="form-control" type="text" placeholder="Ingrese su titulo profesional" name="titulo" th:field="*{titulo}"id="titulo">
				<p class="msjError"></p> 
      		</div>
      		<div class="fechaIngreso">
      			<label class="form-label" for="fechaIngreso">Fecha de ingreso:</label>
				<input class="form-control" type="date" placeholder="Ingrese la fecha de ingreso" name="fechaIngreso" th:field="*{fechaIngreso}"id="fechaIngreso">
				<p class="msjError"></p> 
      		</div> `;
         datosProf.appendChild(div);
      
    } else if (tipoSeleccionado == 'Administrativo') {
    	 btn.classList.remove("d-none");
         datosProf.innerHTML = "";
         datosCliente.innerHTML = "";
         datosAdmin.innerHTML = "";
         const div = document.createElement("div");
         div.innerHTML = 
         `
         	<div class="area">
         		<label class="form-label" for="area">Area:</label>
         		<input class="form-control" type="text" placeholder="Ingrese el area al que corresponde" name="area" th:field="*{administrativo.area}" id="area">
         		<p class="msjError"></p>
      		</div>
      		<div class="experienciaPrevia">
      			<label class="form-label" for="experienciaPrevia">Experiencia Previa:</label>
		 		<input class="form-control" type="text" placeholder="Ingrese su experiencia previa" name="experienciaPrevia" th:field="*{administrativo.experienciaPrevia}" id="experienciaPrevia">
		 		<p class="msjError"></p> 
      		</div>
      	
		 `;
		 datosAdmin.appendChild(div);
        
    }else if (tipoSeleccionado == 'despliegue') {
    	 btn.classList.add("d-none");
         datosProf.innerHTML = "";
         datosCliente.innerHTML = "";
         datosAdmin.innerHTML = "";
         }
     
});