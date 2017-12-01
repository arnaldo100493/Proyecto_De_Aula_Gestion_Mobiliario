
package modelo;

import java.io.Serializable;


public class Cliente extends Usuario implements Serializable { 
    public  Cliente()
 {  
 }
 
 	public Cliente(String Nombre, String Num_Identi, String Direccion, 
            String Telefono, String Correo, String Privilegio , String Sexo) {
       super(Nombre, Num_Identi, Direccion, Telefono, Correo, Privilegio, Sexo);
    }
}