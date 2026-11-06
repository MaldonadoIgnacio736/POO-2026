package Sistema;

public class BarrioPlanUrbanizacion extends Barrio {
	public BarrioPlanUrbanizacion (String nombreBarrio, int superficieHectarea, int numeroBarrio) {
		super(nombreBarrio,superficieHectarea,numeroBarrio);
	}
	private int numLeyLegisladorCABA;
	private boolean conexionAgua;
	Persona p;
	
	public int densidad() {
	}
	
	public void criticidad() {
		if(conexionAgua == false) {
			System.out.println("El barrio se encuenta en estado crítico");
		} else System.out.println("El estado se encuentra fuera del estado crítico");
	}
}
