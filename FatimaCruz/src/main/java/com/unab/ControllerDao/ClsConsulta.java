package com.unab.ControllerDao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.unab.conexion.conexionBD;
import com.unab.entidades.consulta;


public class ClsConsulta {

	conexionBD conexion = new conexionBD();
	Connection con = conexion.RetornarConexion();

	public ArrayList<consulta> ListadoUSUARIOS() {
		ArrayList<consulta> Lista = new ArrayList<>();

		try {

			CallableStatement consulta = con.prepareCall("call Sp_s_MostrarConsulta()");
			ResultSet rs = consulta.executeQuery();
			while (rs.next()) {
				consulta user = new consulta();
				user.setId(rs.getInt("Id"));
				user.setNombre(rs.getString("Nombre"));
				user.setApellido(rs.getString("Apellido"));
				Lista.add(user);
			}
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(null, "Ha ocurrido un error en: \n\n\n\n" + e);
		}

		return Lista;
	}
	
	public void EliminarConsulta(consulta consulta) {
		
		try {
			CallableStatement statement = con.prepareCall("call Sp_d_consulta(?)");
			statement.setInt("Pid", consulta.getId());
			statement.executeQuery();
			System.out.println("Eliminado Exitoso");
			con.close();
			
		} catch (Exception e) {
			System.out.println("Hubo un error en ConsultaDAO/EliminarConsulta " + e);
		}
	}
}
