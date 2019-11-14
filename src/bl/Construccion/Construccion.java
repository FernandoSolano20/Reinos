package bl.Construccion;

public abstract class Construccion implements IConstruccion {
	private int vida;
	private int id;
	private String Nombre;

	public Construccion() {
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getInfo() {
		return "Nombre: " + getNombre() + "\nVida: " + getVida();
	}
}
