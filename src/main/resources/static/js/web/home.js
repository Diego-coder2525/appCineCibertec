$(document).on("click","#btn_empezar",()=>{
	//alert("Hola mundo JavaScript")
	let usuario = $("#txtUsuario").val()
	let password = $("#txtPassword").val()
	
	$("#lbl_datos").text("Usuario: "+usuario+" - "+"Password: "+password)
	$("#modal_empezar").modal("show")
	
})