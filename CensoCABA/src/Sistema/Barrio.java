package Sistema;

public class Barrio {
	public Barrio(String nombreBarrio, int superficieHectarea, int numerroBarrio) {
		this.nombreBarrio = nombreBarrio;
		this.superficieHectarea = superficieHectarea;
		this.numeroBarrio = numeroBarrio;
	}
	private String nombreBarrio;
	private int superficieHectarea, numeroBarrio;
	public String getNombreBarrio() {
		return nombreBarrio;
	}
	public void setNombreBarrio(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}
	public int getSuperficieHectarea() {
		return superficieHectarea;
	}
	public void setSuperficieHectarea(int superficieHectarea) {
		this.superficieHectarea = superficieHectarea;
	}
	public int getNumeroBarrio() {
		return numeroBarrio;
	}
	public void setNumeroBarrio(int numeroBarrio) {
		this.numeroBarrio = numeroBarrio;
	}
}
