package Modulo;

public class Pasajero {
	private boolean tieneCompromiso;
	private int minutosEsperados;
	private boolean esVIP;
	private int pasaje;
	
	public Pasajero() {
		
	}
	
	public boolean estaEsperando() {
		boolean demorado = false;
		if(minutosEsperados > 60) {
			demorado = true;
		}
		
		return demorado;
	}

	public boolean getTieneCompromiso() {
		return tieneCompromiso;
	}

	public void setTieneCompromiso(boolean tieneCompromiso) {
		this.tieneCompromiso = tieneCompromiso;
	}

	public int getMinutosEsperados() {
		return minutosEsperados;
	}

	public void setMinutosEsperados(int minutosEsperados) {
		this.minutosEsperados = minutosEsperados;
	}

	public boolean getEsVIP() {
		return esVIP;
	}

	public void setEsVIP(boolean esVIP) {
		this.esVIP = esVIP;
	}

	public int getPasaje() {
		return pasaje;
	}

	public void setPasaje(int pasaje) {
		this.pasaje = pasaje;
	}
	
	
}
