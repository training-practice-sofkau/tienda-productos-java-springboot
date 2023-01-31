package com.sofkau.qa.tiendaproductos;

public class CasaMusical {
    private arrayList<Instrumento> instrumentos;

    public CasaMusical(){
        instrumentos=new arrayList<Instrumento>;
    }
    /**
     * Agrega un nuevo instrumento a la lista
     */
    public boolean agregarInstrumento(String nombre, String clase, int valor, String estado) {
        Instrumento con=buscarInstrumento(nombre);
        boolean exito=false;
        con=null;
        if(con==null)//se puede agregar el instrumento
        {
            Instrumento nuevo=new Instrumento(nombre,clase,valor,estado);
            instrumentos.add(nuevo);
            exito=true;
        }
        return exito;
    }
}
