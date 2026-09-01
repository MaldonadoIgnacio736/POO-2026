package Modulo;

public class Comercial extends Vuelo {

	public Comercial(int capacidadPasajero, int consumoCombustible) {
		super(capacidadPasajero, consumoCombustible);
		// TODO Auto-generated constructor stub
	}
	
	public boolean esLowCost() {
		boolean salir = true;
		int i = 0;
		boolean lowCost = false;
		while(salir) {
			if( capacidadPasajero < 100 && pasajeros[i].estaEsperando()) {
				salir = false;
				lowCost= true;
			}
			i++;
		}
		return lowCost;
	}

}
