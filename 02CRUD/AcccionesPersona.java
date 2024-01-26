import java.util.*;

public class AccionesPersona {

/**Vamos hacer un crud */
//Mostrar personas

public ArrayList<Persona> 
ListaPersonas = new
ArrayList<Persona>();


//Listar a las personas 
public ArrayList<Persona>
mostar personas (){
    return ListaPersonas;

}

//registrar
public void agregarPersonas(Persona 
p){

    listaPersonas.add(p);
}

//buscar persona
public persona buscarPersona(int id)
{

Persona encontrada = new persona
();
for (persona p: listaPersonas){
    if(id == p.getId()){
        encontrada = p;

    }else{
        system.out.printl
        (x:"Persona no encontrada")

    }

}
return encontrada
}

//actualizar
public void actualizarPersona
(persona actualizada){
    persona actualizar =
    buscarPersona (actualizada.getId
    ());
    listaPersona.add(actualizar);
}
public void eliminarPersona (Personaeliminar){

    listaPersona.remove(eliminar);
}

}


