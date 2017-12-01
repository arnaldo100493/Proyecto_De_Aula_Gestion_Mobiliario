
package modelo;

import java.io.Serializable;


public class Usuario  implements Serializable{
    
    
    public String Nombre, Num_Identi,Direccion, Telefono, 
           Correo, Privilegio , Sexo;
     
     public  Usuario()
 {  
 }
 
 	public Usuario(String Nombre, String NumeroIdentificacion,
                String Direccion,String Telefono, String Correo, String Privilegio, String Sexo){

		 this.Nombre= Nombre;
		 this.Num_Identi=NumeroIdentificacion;
                 this.Direccion=Direccion;
                  this.Telefono=Telefono;
                  this.Correo= Correo;
                  this.Privilegio= Privilegio;
                  this.Sexo = Sexo;
	     }

  
    //Anilizadores .........................................................................

   public String getNombre() {
        return Nombre;
    }
 
    public String getNum_Identi() {
        return Num_Identi;
    }


    public String getDireccion() {
        return Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getPrivilegio() {
        return Privilegio;
    }

    public String getSexo() {
        return Sexo;
    }
    
   
    //Modificadores..........................................................................

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setPrivilegio(String Privilegio) {
        this.Privilegio = Privilegio;
    }

    public void setNum_Identi(String Num_Identi) {
        this.Num_Identi = Num_Identi;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

 
    
}