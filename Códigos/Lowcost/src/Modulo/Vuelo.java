package Modulo;

public class Vuelo {
	protected int capacidadPasajero;
	protected int consumoCombustible;
	protected final double IVA = 1.21;
	
	Pasajero[] pasajeros;
	
	public Vuelo(int capacidadPasajero, int consumoCombustible) {
		this.capacidadPasajero = capacidadPasajero;
		this.consumoCombustible = consumoCombustible;
		
		pasajeros = new Pasajero[capacidadPasajero];
	}
	
	public Vuelo(int consumoCombustible) {
		this.consumoCombustible = consumoCombustible;
		
		pasajeros = new Pasajero[capacidadPasajero];
	}
	
	public boolean estaDemorado() {
		boolean salir =true;
		int i = 0;
		boolean demorado = false;
		while(salir) {
			if(pasajeros[i].estaEsperando() == true) {
				salir = false;
				demorado = true;
			}
		}
		return demorado;
	}
	
	public Pasajero masEsperando() {
		boolean salir =true;
		int i = 0;
		Pasajero furioso = null;
		int minutosMax = 0;
		while(salir) {
			if(pasajeros[i].getMinutosEsperados() > minutosMax) {
				salir = false;
				minutosMax = pasajeros[i].getMinutosEsperados();
				furioso = pasajeros[i];
			}
		}
		return furioso;
	}
	
	public int minutosMasEsperando() {
		return masEsperando().getMinutosEsperados();
	}
}
