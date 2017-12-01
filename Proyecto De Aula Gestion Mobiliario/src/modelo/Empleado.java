/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;




/**
 *

 */
public class Empleado extends Usuario implements Serializable{
 
   
 public  Empleado()
 {  
 }

    public Empleado(String Nombre, String Num_Identi, String Direccion, 
            String Telefono, String Correo, String Privilegio , String Sexo) {
       super(Nombre, Num_Identi, Direccion, Telefono, Correo, Privilegio, Sexo);
    }

}