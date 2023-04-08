package modeloOkumuraHata;


import com.iavl.controlador.*;
import com.iavl.modelo.*;
import com.iavl.vista.*;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		@SuppressWarnings("unused")
		Controlador controlador = new Controlador(vista, modelo);
		vista.setVisible(true);
		
        
	}
	
	

}
