package Clases;

import java.util.HashMap;
import javax.swing.JOptionPane;

public class Admin {
    //Miembros statico para ingresar como admin desde donde se desee
    static public String Username = "ADMIN";
    static public String Contrasena = "admin";
    
    //Un hashMap statico con los nombres de usuario y los usuarios(Para buscarlos mas facil) para ingresar de donde sea
    static public HashMap<String, Empleado> Empleados = new HashMap<String, Empleado>();
    
    public static void CrearEmpleado(String NombreC, String NombreU, String ContrasenaU) {
        Empleado NuevoEmpleado = new Empleado(NombreC, NombreU, ContrasenaU);
        Empleados.put(NuevoEmpleado.NombreUsuario, NuevoEmpleado);
    }
    
    public static void AsignarCortes(int NCortes, int Id) {
        if(Empleados.containsKey(Id)) {
            (Empleados.get(Id)).NumCortes = NCortes;
            Inventario.NumCortesTotal += NCortes;
        }
        else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario");
        }
    }
    
    public static void RegistrarCompra(String Insumo, int Cantidad, int CostoU, Inventario Administracion) {
        Administracion.AgregarGastosVariables(Insumo, Cantidad, CostoU);
    }
    
}
