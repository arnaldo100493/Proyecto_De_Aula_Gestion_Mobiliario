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
import modelo.Mobiliario;

/**
 *
 * @author FABAME
 */
public class AdminMobiliario implements Serializable {

    private static List<Mobiliario> listadoMobiliarios = new ArrayList<>(1000);

    public AdminMobiliario() {
        listadoMobiliarios = new ArrayList<>(1000);
    }

    public static List<Mobiliario> getListadoMobiliarios() {
        return listadoMobiliarios;
    }

    private static void inicializar() {
        try {
            listadoMobiliarios = ControlArchivo.leerArchivo("Mobiliarios");
            if (listadoMobiliarios == null) {
                listadoMobiliarios = new ArrayList<>(1000);
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void registrar(Object objeto) {
        try {
            if (objeto instanceof Mobiliario) {
                inicializar();
                Mobiliario mobiliario = (Mobiliario) objeto;
                if (!existe(mobiliario.getNum_Identificacion())) {
                    listadoMobiliarios.add(mobiliario);
                    ControlArchivo.guardarArchivo(listadoMobiliarios, "Mobiliarios");
                    JOptionPane.showMessageDialog(null, "Se registro Mobiliario con nombre: " + mobiliario.getNombre(), "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Este mobiliario ya existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar el mobiliario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static Mobiliario buscar(String identificacion) {
        inicializar();
        Iterator<Mobiliario> iterator = listadoMobiliarios.iterator();
        while (iterator.hasNext()) {
            Mobiliario mobiliario = iterator.next();
            if (mobiliario.getNum_Identificacion().equals(identificacion)) {
                return mobiliario;
            }
        }
        return null;
    }

    private static boolean existe(String identificacion) {
        inicializar();
        boolean estado = false;
        Mobiliario mobiliario = buscar(identificacion);
        if (mobiliario != null) {
            estado = true;
        }
        return estado;
    }

    public static Mobiliario consultar(String identificacion) {
        Mobiliario mobiliario = null;
        try {
            inicializar();
            mobiliario = buscar(identificacion);
            for (int i = 0; i < listadoMobiliarios.size(); i++) {
                if (listadoMobiliarios.get(i).getNum_Identificacion().equals(identificacion) && mobiliario != null) {
                    mobiliario = listadoMobiliarios.get(i);
                } else {
                    JOptionPane.showMessageDialog(null, "Mobiliario no encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el mobiliario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return mobiliario;
    }

    public static void listar(String identificacion, JTable tabla) {
        try {
            inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);
            Mobiliario m = buscar(identificacion);

            if (m != null) {
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{
                    m.getNombre(), m.getNum_Identificacion(), m.getDescripcion(),
                    m.getEstado(), m.getValorUnitario()});
            } else {
                JOptionPane.showMessageDialog(null, "Mobiliario no encontrado, Intente nuevamente");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el mobiliario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void listar(JTable tabla) {
        try {
            inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);

            for (Mobiliario mobiliario : listadoMobiliarios) {
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{mobiliario.getNombre(), mobiliario.getNombre(), mobiliario.getNum_Identificacion(), mobiliario.getDescripcion(), mobiliario.getEstado(), mobiliario.getValorUnitario()});
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar el mobiliario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<Mobiliario> listar() {
        return listadoMobiliarios;
    }

    public static void modificar(Object objeto) {
        try {
            if (objeto instanceof Mobiliario) {
                inicializar();
                Mobiliario mobiliario = (Mobiliario) objeto;
                for (int i = 0; i < listadoMobiliarios.size(); i++) {
                    if (listadoMobiliarios.get(i).getNum_Identificacion().equals(mobiliario.getNum_Identificacion())) {
                        listadoMobiliarios.remove(i);
                        listadoMobiliarios.add(mobiliario);
                        ControlArchivo.guardarArchivo(listadoMobiliarios, "Mobiliarios");
                        JOptionPane.showMessageDialog(null, "Mobiliario modificado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mobiliario no encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el mobiliario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void eliminar(String identificacion) {
       Mobiliario mobiliario = null;
        try {
            inicializar();
            mobiliario = buscar(identificacion);
            for (int i = 0; i < listadoMobiliarios.size(); i++) {
                if (listadoMobiliarios.get(i).getNum_Identificacion().equals(identificacion) && mobiliario != null) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este mobiliario llamado " + mobiliario.getNombre() + " " + " ? ", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (opcion == 0) {
                        listadoMobiliarios.remove(mobiliario);
                        ControlArchivo.guardarArchivo(listadoMobiliarios, "Mobiliarios");
                        JOptionPane.showMessageDialog(null, "Mobiliario eliminado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Mobiliario no encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el mobiliario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
