package Sistema;

public class BarrioComplejosHabitacionales extends Barrio{
	
	public BarrioComplejosHabitacionales (String nombreBarrio, int superficieHectarea, int numeroBarrio) {
		super(nombreBarrio,superficieHectarea,numeroBarrio);
	}
	private int cantMonoblocks;
	private boolean consorcioMacroActivo;
	
	public densidad() {
	}
	
	public void criticidad() {
		if(consorcioMacroActivo == false) {
			System.out.println("El barrio se encuenta en estado c||||||||||rítico");
		} else System.out.println("El estado se encuentra fuera del estado crítico");
	}
}
