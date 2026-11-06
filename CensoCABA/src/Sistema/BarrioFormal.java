package Sistema;

public class BarrioFormal extends Barrio {
	public BarrioFormal (String nombreBarrio, int superficieHectarea, int numeroBarrio) {
		super(nombreBarrio,superficieHectarea,numeroBarrio);
	}
	private int cantEdificiosPropiedadHorizontal;
	private float porcentajeAsfalto;
	
	public int densidad() {
	}
	
	public void criticidad() {
		if (porcentajeAsfalto > 95.00) {
			System.out.println("El barrio se encuentra en estado crítico");
		} else System.out.println("El estado se encuentra fuera del estado crítico");
	}
}
