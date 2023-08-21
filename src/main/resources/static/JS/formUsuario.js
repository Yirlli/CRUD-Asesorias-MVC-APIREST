
let selecTipoUsuario =document.getElementById('tipoUsuario');
console.log(selecTipoUsuario)
const datosCliente = document.querySelector('.campoCliente');
const datosProf = document.querySelector('.campoProfesional');
const datosAdmin = document.querySelector('.campoAdministrativo');
const btn = document.getElementById('btnCrearUsuario')



selecTipoUsuario.addEventListener('change', function() {
    // Obtener el valor seleccionado
    let tipoSeleccionado = selecTipoUsuario.value;

	
    // Mostrar el conjunto de datos correspondiente al tipo seleccionado
    if (tipoSeleccionado == 'CLIENTE'){
    	btn.classList.remove("d-none");
    	
      	datosCliente.innerHTML = "";
      	datosProf.innerHTML = "";
      	datosAdmin.innerHTML = "";
      	const div = document.createElement("div");
      	div.innerHTML = 
      	`	
      		<div class="razonSocial">
				<label class="form-label" for="razonSocial">Razon Social de la empresa:</label>
				<input class="form-control" placeholder="Ingresa la razon social de la empresa "type="text" name="razonSocial" th:field="*{razonSocial}" id="razonSocial">
				<p class="msjError text-danger"></p>
			</div>
			<div class="rutCliente">
					<label class="form-label" for="rutCliente">RUT de la empresa:</label>
					<input class="form-control" placeholder="Ingresa el RUT con guion y digito verificado" type="text" name="rutCliente" th:field="*{rutCliente}" id="rutCLiente">
					<p class="msjError text-danger"></p>
				</div>
      		<div class="tlfCliente">
      				<label class="form-label" for="tlfCliente">Telefono:</label>
					<input class="form-control" type="number" placeholder="Ingrese el numero de telefono (+56)" name="tlfCliente" th:field="*{telefono}" id="tlfCliente">
					<p class="msjError text-danger"></p> 
      			</div>
      			<div class="afp">
      				<label class="form-label" for="afp">AFP:</label>
					<input class="form-control" type="text" placeholder="Ingrese la AFP afiliada" name="afp"th:field="*{afp}"id="afp">
					<p class="msjError text-danger"></p>
      			</div>
      			<div class="sistemaSalud">
      				<label class="form-label" for="sistemaSalud">Sistema de salud:</label>
					<select id="tipoUsuario" name="sistemaSalud" th:field="*{sistemaSalud}" class="form-control" required>	
						<option th:value="despliegue" selected>Seleccione el sistema de salud</option>
						<option th:value="Fonasa" >Opcion 1 Fonasa</option>
						<option th:value="Isapre" >Opcion 2 Isapre</option>
					</select>
					<p class="msjError text-danger"></p> 
      			</div>
      			<div class="direccion">
      				<label class="form-label" for="direccion" >Direccion:</label>
					<input class="form-control" type="text" placeholder="Ingrese su direccion de domicilio" name="direccion" th:field="*{direccionCliente}"id="direccion">
					<p class="msjError text-danger"></p> 
      			</div>
      			<div class="comuna">
      				<label class="form-label" for="comuna" >Comuna:</label>
					<input class="form-control" type="text" placeholder="Ingrese la comuna" name="comuna" th:field="*{comunaCliente}"id="comuna">
					<p class="msjError text-danger"></p> 
      			</div>
      			<div class="edad">
      				<label class="form-label" for="edad">Edad:</label>
					<input class="form-control" type="number" placeholder="Ingrese su edad" name="edad" th:field="*{edad}" id="edad">
					<p class="msjError text-danger"></p> 
      			</div>`;
      	datosCliente.appendChild(div);  
    } else if(tipoSeleccionado == 'PROFESIONAL') {
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
      
    } else if (tipoSeleccionado == 'ADMINISTRADOR') {
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