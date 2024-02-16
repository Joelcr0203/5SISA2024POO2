import java.io.*;
import java.util.*;
import javax.swing.*;

public class Funciones {
    ArrayList<Prendas> listaprPrendas = new ArrayList<>();
    String rep = "si";
   
    String modelo;

    Prendas pantalon  = new pantalon();
   

    void menu(){
        while (true){
            while (rep.equalsIgnoreCase("SI")){
                try{
                    String var =
                    JOptionPane.showInputDialog("Seleccione el modelo : \n " 
                    + " 1. Pantalon \n" 
                    +" 2. Chamarra \n" 
                    + "3.Salir");
                    if ( var == null){
                        System.exit(0);
    
                    }
                    int opcion = Integer.parseInt(var);
    
                    switch (opcion) {
                        case 1:
                            //METODO PARA PEDIR DATOS 
                            pedirDatospanto();
            
                            pantalon =  new pantalon ();
                            guardarpantalon();
    
                            break;
                    
                        default:
                        System.out.println("opcion no valida");
                            break;
                    }
                    rep= JOptionPane.showInputDialog("Decea repetir?")
    
    
                }catch(Exception e){
                    System.out.println("Error: "+ e.getMessage());
                    
    
                }
            }
        }
    }

    private void guardarpanto() {
        talla = Integer.parseInt(JOptionPane.showInputDialog("INGRESA LA TALLA "));
        modelo = JOptionPane.showInputDialog("INGRESA el modelo ");
       
    }

        

    private void pedirDatospanto() {
        listaprPrendas.add(pantalon);
    }
    private void leerprendas() throws EOFException{

        FileInputStream archivo = new FileInputStream("archivo.dat");
        ObjectInputStream entrada = new ObjectInputStream(archivo);
        listaprPrendas = (ArrayList)entrada.readObject();

for ( int i = 0; i<listaprPrendas.size(); i++){

    Pantalon obj = (pantalon)listaprPrendas.get(i);
    JOptionPane.showMessageDialog(null, "\n"
    + "Modelo" + (i+1)+ "\n"
    + " Talla" + obj.getBoleta()+ "\n");
}
private void guardar() throw Exception{
    FileOutputStream archivo = new FileOutputStream("archivo.dat");
    ObjectInputStream salida = new ObjectInputStream(archivo);
    salida.writeObject(listaprPrendas);
    salida.close();
}
    }

    
}