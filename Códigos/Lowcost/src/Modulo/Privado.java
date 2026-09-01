package Modulo;

public class Privado extends Vuelo{
	private final int capacidadPasajero = 10;
	public Privado(int consumoCombustible) {
		super( consumoCombustible);
	}

	
	public boolean tieneVIP() {
		boolean salir = true;
		int i = 0;
		boolean hayVIP = false;
		while(salir) {
			if(true == pasajeros[i].getEsVIP()) {
				hayVIP = true;
				salir = false;
			}
			i++;
		}
		return hayVIP;
	}
	
	
}
