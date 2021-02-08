<div class="input-group mb-3">
	<div class="input-group-prepend">
		<label class="input-group-text" for="inputGroupSelect01">Tipo de Usuario</label>
	</div>
	<select class="custom-select" id="inputGroupSelect01" name="A_tipoUsuario" ${param.block}>
		<option selected>${param.lab}</option>
		<option value="Estudiante">Estudiante</option>
		<option value="Docente">Docente</option>
	</select>
</div>