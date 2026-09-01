package Modulo;

import java.util.ArrayList;

public class Aeropuerto {
	ArrayList<Vuelo> vuelos = new ArrayList<>();
	
	public Pasajero laMasFuriosa() {
		boolean salir = true;
		int i = 0;
		int minutosMax = 0;
		Pasajero furioso = null;
		while(salir) {
			if(vuelos.get(i).minutosMasEsperando() > minutosMax) {
				
			}
			i++;
		} 
	}
}
