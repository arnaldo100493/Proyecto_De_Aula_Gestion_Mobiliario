
package control;

import modelo.Usuario;
import vistas.Login;
import vistas.VentanaEmpleado;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class AdminUsuario {
    
    
    public static ArrayList <Usuario> listadoCliente= new ArrayList();
    public static ArrayList <Usuario> listadoEmpleado= new ArrayList();
    
    
    
    //////////////////////////REGISTRAR EMPLEADO/////////////////////////////////////////
    public static void registrarEmpleado(Usuario x)
    {
       listadoEmpleado.add(x); 
    }
    /////////////////////////////REGISTRAR CLIENTE///////////////////////////////////////7
    public static void registrarCliente(Usuario x)
    {
       listadoCliente.add(x); 
    }
    
    
    //////////////////////////CONSULTAR EMPLEADO//////////////////////////////////////////
    public static Usuario buscarEmpleado(String cod) {
        for(int i = 0 ; i < listadoEmpleado.size();i++) {
            if(listadoEmpleado.get(i).Num_Identi != null) {
               return listadoEmpleado.get(i);
            } else {
                JOptionPane.showMessageDialog(null,"Empleado no encontrado");    
            }
        }
        return null;
    }
    //////////////////////////CONSULTAR CLIENTE//////////////////////////////////////////
    public static Usuario buscarCliente(String cod) {
        for(int i = 0 ; i < listadoCliente.size();i++) {
            if(listadoCliente.get(i).Num_Identi != null) {
                return listadoCliente.get(i);
            } else {
                 JOptionPane.showMessageDialog(null,"Cliente no encontrado");    
            }
        }
        return null;
    }
    ///////////////////////////MODIFICAR EMPLEADO///////////////////////////////////////////////
    public static void modificarEmpleado(String id ,Usuario u){
   for(int i = 0 ; i < listadoEmpleado.size(); i++){
    if(listadoEmpleado.get(i).Num_Identi.equalsIgnoreCase(u.Num_Identi)){
     listadoEmpleado.set(i, u);
     }

   }

}
     ///////////////////////////MODIFICAR CLIENTE///////////////////////////////////////////////
    public static void modificarCliente(String id ,Usuario u){
   for(int i = 0 ; i < listadoCliente.size(); i++){
    if(listadoCliente.get(i).Num_Identi.equalsIgnoreCase(u.Num_Identi)){
     listadoCliente.set(i, u);
     }

   }

}
    ////////////////////////////ELIMINAR EMPLEADO////////////////////////////////////////////////
    public static void eliminarEmpleado(String codigo) {
        listadoEmpleado.remove(codigo);
    }
    ////////////////////////////ELIMINAR CLIENTE////////////////////////////////////////////////
    public static void eliminarCliente(String codigo) {
        listadoEmpleado.remove(codigo);
    }
   ///////////////////////////INICIAR EMPLEADO////n//////////////////////////////////////////////
    public static void iniciarSesionEmpleado(String contrasena) 
    {
           
        try 
        {
            for(int i = 0; i < listadoEmpleado.size(); i++)
            {
                buscarEmpleado(contrasena);
                if (listadoEmpleado.get(i).Num_Identi.equals(contrasena))
                {
                    
                  Login L = new Login ();
                  L.setVisible(false);
                  VentanaEmpleado ve = new VentanaEmpleado();
                  ve.setVisible(true);
                }else{
                JOptionPane.showMessageDialog(null,"Contraseña incorrecta.. intente nuevamente");
                }
                 
            }

        }catch (NullPointerException ex) 
            {
                JOptionPane.showMessageDialog(null, "Error al listar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } 
    }
    ///////////////////LISTAR CLIENTE
   
     public static Usuario listarCliente()
     {
         for (int i = 0; i < listadoCliente.size(); i++) {
             Iterator recorrido = listadoEmpleado.iterator();
             
         }
         return null;
     }
}