import java.util.GregorianCalendar;


public class Tareas {
	private int codigo;
	private String descripcion;
	private Tareas tareas;
	private Estados state;
	private GregorianCalendar fecha;
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tareas [codigo=" + codigo + ", descripcion=" + descripcion
				+ ", tareas=" + tareas + ", state=" + state + ", fecha="
				+ fecha + ", getCodigo()=" + getCodigo()
				+ ", getDescripcion()=" + getDescripcion() + ", getTareas()="
				+ getTareas() + ", getState()=" + getState() + ", getFecha()="
				+ getFecha() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}



	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}



	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}



	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	/**
	 * @return the tareas
	 */
	public Tareas getTareas() {
		return tareas;
	}



	/**
	 * @param tareas the tareas to set
	 */
	public void setTareas(Tareas tareas) {
		this.tareas = tareas;
	}



	/**
	 * @return the state
	 */
	public Estados getState() {
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(Estados state) {
		this.state = state;
	}



	/**
	 * @return the fecha
	 */
	public GregorianCalendar getFecha() {
		return fecha;
	}



	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Prueba de comit");
		
	}

}
