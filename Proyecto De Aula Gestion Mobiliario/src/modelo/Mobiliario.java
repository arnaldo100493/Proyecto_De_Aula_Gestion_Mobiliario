
package modelo;

import java.io.Serializable;


public class Mobiliario  implements Serializable {


public String Nombre,Num_Identificacion, Descripcion, Estado;
      public String valorUnitario;
    
    

    public Mobiliario(String Nombre, String Num_Identificacion, String Descripcion, 
            String Estado,String valorUnitario) {
        this.Nombre = Nombre;
        this.Num_Identificacion = Num_Identificacion;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
         this.valorUnitario = valorUnitario;
    }

    public Mobiliario()
    {
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNum_Identificacion() {
        return Num_Identificacion;
    }

    public void setNum_Identificacion(String Num_Identificacion) {
        this.Num_Identificacion = Num_Identificacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

   

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
   
    
}