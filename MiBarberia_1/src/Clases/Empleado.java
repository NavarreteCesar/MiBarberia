package Clases;

import java.util.*;

public class Empleado {
    //Un miembro estatico para llevar conteo de los usuarios que existen
    static public int IndiceId = 0;
    
    //Miembros o atributos de cada empleado
    public int Id;
    public String NombreCompleto;
    public String NombreUsuario;
    public String Contrasena;
    public int NumCortes;
    public Double SueldoBase;
    public Double SueldoTotal;
    
    public Empleado(String NombreC, String NombreU, String ContrasenaU) {
        NombreCompleto = NombreC;
        NombreUsuario = NombreU;
        Contrasena = ContrasenaU;
        SueldoBase = 200.0;
        NumCortes = 0;
        IndiceId++;
        Id = IndiceId;
    }
    
    public Double CalcularSueldoTotal(int NCortes) {
        NumCortes = NCortes;
        SueldoTotal = SueldoBase + (NumCortes*1);
        return SueldoTotal;
    }
    
}
