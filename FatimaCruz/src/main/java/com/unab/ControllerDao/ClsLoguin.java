package com.unab.ControllerDao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.unab.conexion.conexionBD;
import com.unab.entidades.usuario;


public class ClsLoguin {

	conexionBD conexion = new conexionBD();
	Connection con = conexion.RetornarConexion();
	
	public boolean Login(usuario usu) {
		
		boolean verificar = false;
		
		try {
			CallableStatement consulta = con.prepareCall("call Sp_s_Login(?,?)");
			consulta.setString("PNombre", usu.getNombre());
			consulta.setString("PContrasena", usu.getContrasena());
			ResultSet resultado = consulta.executeQuery();
			
			if(resultado.next()) {
				verificar = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return verificar;
	}
}
