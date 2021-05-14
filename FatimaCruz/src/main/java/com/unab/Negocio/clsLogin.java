package com.unab.Negocio;



import com.unab.ControllerDao.ClsLoguin;
import com.unab.entidades.usuario;

public class clsLogin {

   public int VerificarUsuario(usuario usuario) {
		
		int Acceso = 0;
		ClsLoguin validacion = new ClsLoguin();
		
		var validar = validacion.Login(usuario);
		
		if(validar == true) {
			Acceso = 1;
		}
		
		return Acceso;
	}
}
