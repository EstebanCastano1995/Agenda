package co.edu.uniquindio.co.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import co.edu.uniquindio.DAO.ContactoDAO;
import co.edu.uniquindio.mybatis.ConexionBD;
import co.edu.uniquindio.vo.Contacto;

/**
 * Esta clase sirve para administrar la interfaz index.xhtml , en esta se hace
 * uso de la clase tablaContactoBean para cargar todos los datos de los
 * contactos consultados en la BD en un DataTable, tambien , sirve para llamar
 * segun una opcion seleccionada en la interfaz si se quiere registrar ,
 * actualizar o eliminar un contacto.
 * 
 * @author Martin y Mariana
 *
 */
@ManagedBean(name = "contactoBean")
@RequestScoped
public class ContactoBean implements Serializable {

	private static final long serialVersionUID = 8995118759276351827L;
	private int identificador;
	private String nombre;
	private String apellido;
	private String numero;
	private String mensaje;
	private String ejecutarOperacion;
	private List<Contacto> contactos;
	private ContactoDAO personDAO = new ContactoDAO(ConexionBD.getSqlSessionFactory());

	@ManagedProperty("#{tablaContactoBean}")
	private tablaContactoBean tcb;

	/**
	 * Constructor de la clase donde se inicializa un objeto de tipo
	 * tablaContactoBean para cargar la data table con los contactos de la BD.
	 */
	public ContactoBean() {
		tcb = new tablaContactoBean();
		tcb.cargarContactos(personDAO);
		this.contactos = tcb.getContactos();
	}

	/**
	 * Metodo que sirve para saber que operacion ejecutar segun una lista
	 * desplegable de opciones y saber que me todo llamar , ya sea registrar ,
	 * actualizar o eliminar
	 */
	public void ejecutar() {
		switch (ejecutarOperacion) {
		case "Registrar":
			Contacto person = new Contacto();
			person.setIDENTIFICADOR(this.identificador);
			person.setNOMBRE(this.nombre);
			person.setAPELLIDO(this.apellido);
			person.setNUMERO(this.numero);
			personDAO.insert(person);
			break;
		case "Eliminar":
			person = new Contacto();
			person.setIDENTIFICADOR(this.identificador);
			person.setNOMBRE(this.nombre);
			person.setAPELLIDO(this.apellido);
			person.setNUMERO(this.numero);
			personDAO.delete(person);
			break;
		case "Actualizar":
			Contacto persona = new Contacto();
			persona.setIDENTIFICADOR(this.identificador);
			persona.setNOMBRE(this.nombre);
			persona.setAPELLIDO(this.apellido);
			persona.setNUMERO(this.numero);
			personDAO.update(persona);
			break;
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successful", "Your message: " + "Operacion satisfactorio"));
		context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));

		tcb.cargarContactos(personDAO);
		contactos = tcb.getContactos();
	}

	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador
	 *            the identificador to set
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the ejecutarOperacion
	 */
	public String getEjecutarOperacion() {
		return ejecutarOperacion;
	}

	/**
	 * @param ejecutarOperacion
	 *            the ejecutarOperacion to set
	 */
	public void setEjecutarOperacion(String ejecutarOperacion) {
		this.ejecutarOperacion = ejecutarOperacion;
	}

	/**
	 * @return the contactos
	 */
	public List<Contacto> getContactos() {
		return contactos;
	}

	/**
	 * @param contactos
	 *            the contactos to set
	 */
	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	/**
	 * @return the tcb
	 */
	public tablaContactoBean getTcb() {
		return tcb;
	}

	/**
	 * @param tcb
	 *            the tcb to set
	 */
	public void setTcb(tablaContactoBean tcb) {
		this.tcb = tcb;
	}

}
