package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sofkau.qa.tiendaproductos.Factura;
import com.sofkau.qa.tiendaproductos.CasaMusical;
import com.sofkau.qa.tiendaproductos.Instrumento;

import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class TiendaProductosApplication {

	public static void main(String[] args) {

		System.out.println("Aplicación para manejar el inventario de instrumentos de la casa musical");

		CasaMusical casaMusical=new CasaMusical();

		casaMusical.agregarInstrumento("clarinete","vientos",1500000,"En tienda",95456);
		casaMusical.agregarInstrumento("violín","cuerdas frotadas",3800000,"En tienda",26456);
		casaMusical.agregarInstrumento("bombo","percusión",750000,"En tienda",26454);
		casaMusical.agregarInstrumento("bombo","percusión",750000,"En tienda",26454);

		casaMusical.darTodosLosInstrumentos();

		SpringApplication.run(TiendaProductosApplication.class, args);
	}

}
