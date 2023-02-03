package com.sofkau.qa.tiendaproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sofkau.qa.tiendaproductos.Factura;
import com.sofkau.qa.tiendaproductos.CasaMusical;
import com.sofkau.qa.tiendaproductos.Instrumento;
import com.sofkau.qa.tiendaproductos.Comprador;

import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class TiendaProductosApplication {

	public static void main(String[] args) {

		CasaMusical casaMusical=new CasaMusical();
		System.out.println("Aplicación para manejar el inventario de instrumentos de la casa musical,"+
				" comienza ingresando algunos instrumentos a la Casa Musical");
		casaMusical.agregarInstrumento("clarinete","vientos",1500000,"En tienda",95456);
		casaMusical.agregarInstrumento("violín","cuerdas frotadas",3800000,"En tienda",26456);
		casaMusical.agregarInstrumento("bombo","percusión",750000,"En tienda",26454);
		casaMusical.agregarInstrumento("bombo","percusión",750000,"En tienda",26454);

		//int opcion=0;
		//do{
			//Scanner entrada=new Scanner(System.in);


			//System.out.println("Elige la opción según tu requerimiento\n*"+
			//"1 Agregar Instrumento\n*"+
			//"2 Ver Los Instrumentos en inventario\n*"+
			//"3 Salir");

			//"opcion=entrada.nextInt();
			//Switch(1){
			//	Case 1:
			//		System.out.println("1:\n*");
			//		break;
			//	Case 2:
			//	System.out.println("2:\n*");
			//	break;
			//	Case 3:
			//	System.exit(0);
			//	break;
			//	default:
			//		System.out.println("Parametro no valido);
			//}
			//While(opcion != 3){
			//}
		//}
		casaMusical.darTodosLosInstrumentos();
		SpringApplication.run(TiendaProductosApplication.class, args);
	}

}
