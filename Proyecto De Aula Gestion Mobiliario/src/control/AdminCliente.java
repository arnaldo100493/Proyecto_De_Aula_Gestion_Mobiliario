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
import modelo.Cliente;

/**
 *
 * @author FABAME
 */
public class AdminCliente implements Serializable {

    private static List<Cliente> listadoClientes = new ArrayList<>(1000);

    public AdminCliente() {
        listadoClientes = new ArrayList<>(1000);
    }

    public static List<Cliente> getListadoClientes() {
        return listadoClientes;
    }

    private static void inicializar() {
        try {
            listadoClientes = ControlArchivo.leerArchivo("Clientes");
            if (listadoClientes == null) {
                listadoClientes = new ArrayList<>(1000);
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void registrar(Object objeto) {
        try {
            if (objeto instanceof Cliente) {
                inicializar();
                Cliente cliente = (Cliente) objeto;
                if (!existe(cliente.getNum_Identi())) {
                    listadoClientes.add(cliente);
                    ControlArchivo.guardarArchivo(listadoClientes, "Clientes");
                    JOptionPane.showMessageDialog(null, "Se registro Cliente con nombre: " + cliente.getNombre(), "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Este cliente ya existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static Cliente buscar(String identificacion) {
        inicializar();
        Iterator<Cliente> iterator = listadoClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getNum_Identi().equals(identificacion)) {
                return cliente;
            }
        }
        return null;
    }

    private static boolean existe(String identificacion) {
        inicializar();
        boolean estado = false;
        Cliente cliente = buscar(identificacion);
        if (cliente != null) {
            estado = true;
        }
        return estado;
    }

    public static Cliente consultar(String identificacion) {
        Cliente cliente = null;
        try {
            inicializar();
            cliente = buscar(identificacion);
            for (int i = 0; i < listadoClientes.size(); i++) {
                if (listadoClientes.get(i).getNum_Identi().equals(identificacion) && cliente != null) {
                    cliente = listadoClientes.get(i);
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return cliente;
    }

    public static void listar(String identificacion, JTable tabla) {
        try {
            inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);
            Cliente u = buscar(identificacion);

            if (u != null) {
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{
                    u.getNum_Identi(), u.getNombre(), u.getDireccion(),
                    u.getTelefono(), u.getCorreo(), u.getSexo()});
            } else {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado, Intente nuevamente");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void listar(JTable tabla) {
        try {
            inicializar();
            ((DefaultTableModel) tabla.getModel()).setNumRows(0);

            for (Cliente cliente : listadoClientes) {
                ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{cliente.getNombre(), cliente.getNum_Identi(), cliente.getDireccion(), cliente.getDireccion(), cliente.getTelefono(), cliente.getCorreo(), cliente.getPrivilegio(), cliente.getSexo()});
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<Cliente> listar() {
        return listadoClientes;
    }

    public static void modificar(Object objeto) {
        try {
            if (objeto instanceof Cliente) {
                inicializar();
                Cliente cliente = (Cliente) objeto;
                for (int i = 0; i < listadoClientes.size(); i++) {
                    if (listadoClientes.get(i).getNum_Identi().equals(cliente.getNum_Identi())) {
                        listadoClientes.remove(i);
                        listadoClientes.add(cliente);
                        ControlArchivo.guardarArchivo(listadoClientes, "Clientes");
                        JOptionPane.showMessageDialog(null, "Cliente modificado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void eliminar(String identificacion) {
        Cliente cliente = null;
        try {
            inicializar();
            cliente = buscar(identificacion);
            for (int i = 0; i < listadoClientes.size(); i++) {
                if (listadoClientes.get(i).getNum_Identi().equals(identificacion) && cliente != null) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este cliente llamado " + cliente.getNombre() + " " + " ? ", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (opcion == 0) {
                        listadoClientes.remove(cliente);
                        ControlArchivo.guardarArchivo(listadoClientes, "Clientes");
                        JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
