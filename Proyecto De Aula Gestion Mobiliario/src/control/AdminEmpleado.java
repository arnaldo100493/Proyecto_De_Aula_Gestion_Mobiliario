/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import vistas.Login;
import vistas.VentanaEmpleado;

/**
 *
 * @author FABAME
 */
public class AdminEmpleado implements Serializable {

    private static List<Empleado> listadoEmpleados = new ArrayList<>(1000);

    public AdminEmpleado() {
        listadoEmpleados = new ArrayList<>(1000);
    }

    public static List<Empleado> getListadoEmpleados() {
        return listadoEmpleados;
    }

    private static void inicializar() {
        try {
            listadoEmpleados = ControlArchivo.leerArchivo("Empleados");
            if (listadoEmpleados == null) {
                listadoEmpleados = new ArrayList<>(1000);
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void iniciarSesion(String contrasena) {

        try {
            Empleado empleado = buscar(contrasena);

            if (empleado.getNum_Identi().equals(contrasena)) {

                Login L = new Login();
                L.setVisible(false);
                VentanaEmpleado ve = new VentanaEmpleado();
                ve.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.. intente nuevamente");
            }

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void registrar(Object objeto) {
        try {
            if (objeto instanceof Empleado) {
                inicializar();
                Empleado empleado = (Empleado) objeto;
                if (!existe(empleado.getNum_Identi())) {
                    listadoEmpleados.add(empleado);
                    ControlArchivo.guardarArchivo(listadoEmpleados, "Empleados");
                     JOptionPane.showMessageDialog(null, "Se registro Empleado con nombre: " + empleado.getNombre(), "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Este empleado ya existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static Empleado buscar(String identificacion) {
        inicializar();
        Iterator<Empleado> iterator = listadoEmpleados.iterator();
        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();
            if (empleado.getNum_Identi().equals(identificacion)) {
                return empleado;
            }
        }
        return null;
    }

    private static boolean existe(String identificacion) {
        inicializar();
        boolean estado = false;
        Empleado empleado = buscar(identificacion);
        if (empleado != null) {
            estado = true;
        }
        return estado;
    }

    public static Empleado consultar(String identificacion) {
        Empleado empleado = null;
        try {
            inicializar();
            empleado = buscar(identificacion);
            for (int i = 0; i < listadoEmpleados.size(); i++) {
                if (listadoEmpleados.get(i).getNum_Identi().equals(identificacion) && empleado != null) {
                    empleado = listadoEmpleados.get(i);
                } else {
                    JOptionPane.showMessageDialog(null, "Empleado no encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return empleado;
    }

    public static void listar(String identificacion, JTable tabla) {
        try {
            inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);
            Empleado u = buscar(identificacion);

            if (u != null) {
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{
                    u.getNum_Identi(), u.getNombre(), u.getDireccion(),
                    u.getTelefono(), u.getCorreo(), u.getSexo()});
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado, Intente nuevamente");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void listar(JTable tabla) {
        try {
            inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);

            for (Empleado empleado : listadoEmpleados) {
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{empleado.getNombre(), empleado.getNum_Identi(), empleado.getDireccion(), empleado.getDireccion(), empleado.getTelefono(), empleado.getCorreo(), empleado.getPrivilegio(), empleado.getSexo()});
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<Empleado> listar() {
        return listadoEmpleados;
    }

    public static void modificar(Object objeto) {
        try {
            if (objeto instanceof Empleado) {
                inicializar();
                Empleado empleado = (Empleado) objeto;
                for (int i = 0; i < listadoEmpleados.size(); i++) {
                    if (listadoEmpleados.get(i).getNum_Identi().equals(empleado.getNum_Identi())) {
                        listadoEmpleados.remove(i);
                        listadoEmpleados.add(empleado);
                        ControlArchivo.guardarArchivo(listadoEmpleados, "Empleados");
                        JOptionPane.showMessageDialog(null, "Empleado modificado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Empleado no encontrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void eliminar(String identificacion) {
        Empleado empleado = null;
        try {
            inicializar();
            empleado = buscar(identificacion);
            for (int i = 0; i < listadoEmpleados.size(); i++) {
                if (listadoEmpleados.get(i).getNum_Identi().equals(identificacion) && empleado != null) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este empleado llamado " + empleado.getNombre() + " " + " ? ", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (opcion == 0) {
                        listadoEmpleados.remove(empleado);
                        ControlArchivo.guardarArchivo(listadoEmpleados, "Empleados");
                        JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Empleado no encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
