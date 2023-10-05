// Call the dataTables jQuery plugin
$(document).ready(function() {
	cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){
	
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json();
  	
	let listadoHTML = '';
	for(let user of usuarios){
		let botonEliminar= '<a href="#" onclick="eliminarUsuario(' + user.id +' )" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
		let telefonotxt = user.telefono == null ? '-' : user.telefono;
		let usuario = '<tr><td>'+user.id+'</td><td>'+user.nombre+' '+user.apellido+'</td><td>'+user.email+'</td><td>'+telefonotxt+'</td><td>'+botonEliminar+'</td></tr>';
		listadoHTML += usuario;
	}
  console.log(usuarios);
  
  document.querySelector('#usuarios tbody').outerHTML = listadoHTML;
  
}

 async function eliminarUsuario(id){
	 if(!confirm("desea eliminar este usario")){
		 return;
	 }
	 
	const request = await fetch('api/usuarios/' +id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  
  location.reload()
}