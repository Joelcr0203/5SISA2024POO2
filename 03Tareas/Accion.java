import java.util.ArrayList ArrayList;
public class Acciones {

    public ArrayList <Registro>
    listaRegistros = new
    ArrayList<Registro>();

    //lista a las personas

    public ArrayList<Registro>
    mostrarRegistros(){
        
        return listaRegistros;

    }
    //registrar
    public void agregarRegistro(Registro R){
        listaRegistros.add(R);

    
    }
    //BUSCAR
    public Registro buscarRegistro(int id){
        //necesito un registro para saber si la encontre ny otra para buscarla
        Registro encontrada = new Registro();
        Registro objeto1 = new Registro(01,"Saul",24);
        Registro objeto2 = new Registro(02,"Brayan",29);
        Registro objeto3 = new Registro(03,"Antonio",22);
        Registro objeto4 = new Registro(04,"Cristian",15);
        Registro objeto5 = new Registro(05,"aline",27);
        Registro objeto6 = new Registro(06,"joel",45);
        Registro objeto7 = new Registro(07,"Roberto",30);
        
        

  

//actualizar datos 
public void actualizarRegistro(int id){
Registro actualizar = buscarRegistro(actualizar.getId());
listaRegistros.remove(actualizar);
listaRegistros.add(actualizar);

}
// borrar personas 
public void eliminarPersona(Persona
eliminar){
    listaRegistros.remove(eliminar);

}  
}