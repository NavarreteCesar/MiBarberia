package Clases;
import Clases.Admin;
import java.util.*;

public class Inventario {
    //Miembro estatic para llevar conteo de los cortes que se realizan
    static public int NumCortesTotal = 0;
    
    //Miembros estaticos para administrar todos los conteos de el inventario de la barberia
    static String[] NombreGastosFijos;
    static int[] MontoGastosFijos;
    static String[] NombreGastosVariables;
    static public int[][] MontoGastosVariables;
    static public int GastosVariablesTotal;
    static public int GastosFijosTotal;
    static public int GastosSueldosTotal;
    static public int GananciasBruta;
    static public int GananciasNeta;
    
    
    public Inventario() {
        NombreGastosFijos = new String[4];
        MontoGastosFijos = new int[4];
        NombreGastosVariables = new String[5];
        MontoGastosVariables = new int[5][2];
        GastosVariablesTotal = 0;
        GastosFijosTotal = 0;
        GastosSueldosTotal = 0;
        GananciasBruta = 0;
        GananciasNeta = 0;
        
        NombreGastosFijos[0] = "Luz";
        NombreGastosFijos[1] = "Agua";
        NombreGastosFijos[2] = "Internet";
        NombreGastosFijos[3] = "Otros";
        
        MontoGastosFijos[0] = 50;
        MontoGastosFijos[1] = 30;
        MontoGastosFijos[2] = 20;
        MontoGastosFijos[3]= 10;
        
        NombreGastosVariables[0] = "Gelatina(bote)";
        NombreGastosVariables[1] = "Talco(bote)";
        NombreGastosVariables[2] = "Alcohol(bote)";
        NombreGastosVariables[3] = "Crema(bote)";
        NombreGastosVariables[4] = "Gillete(unidad)";
    }
    
    public static void AgregarGastosVariables(String Insumo, int Cantidad, int CostoU) {
        GastosVariablesTotal += Cantidad*CostoU;
        switch(Insumo) {
            case "Gelatina(bote)":
                MontoGastosVariables[0][0] = Cantidad;
                MontoGastosVariables[0][1] = CostoU;
                
                break;
                
            case "Talco(bote)":
                MontoGastosVariables[1][0] = Cantidad;
                MontoGastosVariables[1][1] = CostoU;
                break;
                
            case "Alcohol(bote)":
                MontoGastosVariables[2][0] = Cantidad;
                MontoGastosVariables[2][1] = CostoU;
                break;
                
            case "Crema(bote)":
                MontoGastosVariables[3][0] = Cantidad;
                MontoGastosVariables[3][1] = CostoU;
                break;
                
            case "Gillete(unidad)":
                MontoGastosVariables[4][0] = Cantidad;
                MontoGastosVariables[4][1] = CostoU;
                break;
        }
    }
    
    public static void AgregarGastosSueldos() {
        GastosSueldosTotal = (Admin.Empleados.size()*200) + NumCortesTotal;
    }
    
    public static void AgregarGastosInsumos() {
        GastosVariablesTotal = 0;
        //Se recorre el array con datos de gastos variables para obtener un toal de los gastos
        for(int i = 0; i<MontoGastosVariables.length; i++){
            for(int j = 0; j < MontoGastosVariables[i].length; j++) {
                if(j == 1) {
                    GastosVariablesTotal += MontoGastosVariables[i][j];
                }
            }
        }
    }
        
    public static void AgregarGastosFijos() {
        for(int i = 0;i<MontoGastosFijos.length;i++) {
            GastosFijosTotal += MontoGastosFijos[i];
        }
    }
        
    public static void CalcularGanaciasBruta() {
        GananciasBruta = NumCortesTotal*5;
    }
    
    public static void CalcularGananciasNeta() {
        GananciasNeta = (NumCortesTotal*5) - (GastosSueldosTotal + GastosFijosTotal + GastosVariablesTotal);
    }
}
