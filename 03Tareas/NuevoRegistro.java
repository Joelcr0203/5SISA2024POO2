import java.util.*;
public class NuevaPersona {
    public void menu(){
        Scanner entrada = new Scanner
        (System.in);

        AccionesPersona control = new AccionesPersona();
    
    System.out.println(" Bienvenido al registro de persnas jiji");
    System.out.println("Elija una istancia");
    System.out.println("1.-registro de personas");
    System.out.println("2.-Editar datos de la persona");
    System.out.println("3.-Mostarar Personas Registradas");
    System.out.println("4.-eliminar persona");
    int opcion = entrada.nextInt();
     switch (opcion ) {
        case 1:
            System.out.println("PERSONAS REGISTRADAS");
            ArrayList<Registro> listaRegistros = 
            control.registrado();

             for ( Registro objeto : listaRegistros){
                System.out.println("El ID ES:" + objeto.getId() + "\n" 
                + " El nombre es :" +  objeto.getNombre() + "\n"
                + " la edad es " + objeto.getEdad() + "\n");

             }
             menu();


            break;
             case 2:
             System.out.println("ingresa tus datos para registrar");
             int idregistro = Integer.parseInt(entrada.nextLine());
             System.out.println(" ingresa tu nombre ");
             String nombre = entrada.nextLine();
             System.out.println(" ingresa tu edad ");
             int edad = Integer.parseInt(entrada.nextLine());
             // instancia 
             Registro registrate = new Registro(idregistro,nombre,edad );
             control.registro(registrate);
             menu();

             break;
             
     case 3:

     break;
        default:
            break;
     }

}
 }