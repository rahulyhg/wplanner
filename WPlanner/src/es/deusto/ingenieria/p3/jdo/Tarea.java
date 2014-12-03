package es.deusto.ingenieria.p3.jdo;

import java.util.GregorianCalendar;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
class Tarea {
	private int codigo;
	private String descripcion;
	private Categoria categoria;
	private Estado state;
	private GregorianCalendar fecha;
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "es.deusto.ingenieria.p3.jdo.Tareas [codigo=" + codigo + ", descripcion=" + descripcion
				+ ", categoria=" + categoria + ", state=" + state + ", fecha="
				+ fecha + ", getCodigo()=" + getCodigo()
				+ ", getDescripcion()=" + getDescripcion() + ", " +
                "getState()=" + getState() + ", getFecha()="
				+ getFecha() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}



	/** Devuelve el codigo de la tarea
	 * @return the codigo
	 */
    int getCodigo() {
		return codigo;
	}


	/** Establece el codigo de la tarea, es un autonumérico que será automático
	 * @param codigo the codigo to set
	 */
	//public void setCodigo(int codigo) {
		//this.codigo = codigo;
	//}


	/** Establece la descripción de la tarea
	 * @return the descripcion
	 */
    String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/** ELIMINAR ESTE METODO, NO SENSE
	 * @return the tareas
	 */
	//public Tareas getTareas() {
//		return tareas;
//	}



	/** ELIMINAR ESTE METODO, NO SENSE
	 * @param tareas the tareas to set
	 */
	//public void setTareas(Tareas tareas) {
//		this.tareas = tareas;
//	}



	/** Devuelve el estado actual de la tarea
	 * @return the state
	 */
    Estado getState() {
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(Estado state) {
		this.state = state;
	}



	/**
	 * @return the fecha
	 */
    GregorianCalendar getFecha() {
		return fecha;
	}



	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}



	public static void main(String[] args) {
		
	}

}
