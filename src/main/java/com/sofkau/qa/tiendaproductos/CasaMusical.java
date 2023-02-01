package com.sofkau.qa.tiendaproductos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class CasaMusical {
    private ArrayList<Instrumento> instrumentos;

    public CasaMusical(){
      instrumentos=new ArrayList<Instrumento>();
    }
    //public CasaMusical(ArrayList<Instrumento> instrumentos){
       // this.instrumentos=instrumentos;
    //}
    /**
     * Busca un instrumento dado su referencia.
     */
    public Instrumento buscarInstrumento(int referencia) {
        int contador=0;
        Instrumento inst=null;
        boolean encontrado=false;
        while(contador<instrumentos.size() && !encontrado) {
            inst=instrumentos.get(contador);
            if(referencia==(inst.darReferencia())) {
                encontrado=true;
            }
            contador++;
        }
        if(!encontrado) {
            inst=null;
        }
        return inst;
    }

    /**
     * Agrega un nuevo instrumento a la casa musical
     */
    public boolean agregarInstrumento(String nombre, String familia, int valor, String estado, int referencia) {
        Instrumento inst=buscarInstrumento(referencia);
        boolean exito=false;
        if(inst==null){
        //se puede agregar el instrumento
            Instrumento nuevo=new Instrumento(nombre,familia,valor,estado,referencia);
            instrumentos.add(nuevo);
            exito=true;
            System.out.println("El instrumento con referencia "+referencia+" ha sido ingresado");
        }
        else if(inst!=null){
            System.out.println("El instrumento con referencia "+referencia+" ya existe");
        }
        return exito;
    }
    /**
     * Retorna una lista con el nombre de todos los instrumentos. <br>
     * <b>pre:</b> La lista de instrumentos está inicializada.
     * @return La lista de instrumentos. Si no hay instrumentos la lista se retorna vacía.
     */
    public ArrayList<String> darTodosLosInstrumentos() {
        ArrayList<String> lista=new ArrayList<String>();
        for(int i=0;i<instrumentos.size();i++) {
            Instrumento inst=instrumentos.get(i);
            lista.add(inst.darNombre());
            System.out.println("instrumento "+(i+1)+" "+inst.darNombre()+" "+"con referencia "+inst.darReferencia());
        }
        return lista;
        //System.out.println(lista.toString());
    }


    public void vender(Instrumento instrumento, Comprador comprador){
        //cambiar de estado del instrumento

        Instrumento instrumentoAVender;



    }

    //public List<String> darVientos(){
        //List<String> vientos= new ArrayList<String>();
        //ArrayList<String> vientos
    //}
}
