package Sistema;

public class Comuna {
	private String numSedeComunal;
	private String nombreComuna;
	
	public String getNombreComuna() {
		return nombreComuna;
	}

	public void setNombreComuna(String nombreComuna) {
		this.nombreComuna = nombreComuna;
	}

	public Comuna(String nombre,String numeroComuna){
		this.numSedeComunal = numeroComuna;
	}

	public String getNumSedeComunal() {
		return numSedeComunal;
	}

	public void setNumSedeComunal(String numSedeComunal) {
		this.numSedeComunal = numSedeComunal;
	}
	
	
}
