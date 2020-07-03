package logica;
//Variables
public class Libro {
	//Atributos
	private String titulo;
	private String autor;
	private String fecha;
	private int paginas;
	private String editorial;
	private int disponibles;
	private int id;
	private String imagen;
	private int prestamos;
	
	public Libro(String titulo, String autor, String fecha, int paginas, String editorial, int disponbles, int id, String imagen, int prestamos) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
		this.paginas = paginas;
		this.editorial = editorial;
		this.disponibles = disponbles;
		this.id = id;
		this.imagen = imagen;
		this.prestamos = prestamos;
		
	}

	//Setters y Getters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(int prestamos) {
		this.prestamos = prestamos;
	}
	
	
}
