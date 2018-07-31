package co.edu.uniquindio.vo;
/**
 * Clase que sirve para hacer un objeto identico al que se va a mappear de la entidad
 * Contacto de la BD 
 * @author Martin y Mariana
 *
 */
public class Contacto {
	private int IDENTIFICADOR;
	private String NOMBRE;
	private String APELLIDO;
	private String NUMERO;
	/**
	 * @return the iDENTIFICADOR
	 */
	public int getIDENTIFICADOR() {
		return IDENTIFICADOR;
	}
	/**
	 * @param iDENTIFICADOR the iDENTIFICADOR to set
	 */
	public void setIDENTIFICADOR(int iDENTIFICADOR) {
		IDENTIFICADOR = iDENTIFICADOR;
	}
	/**
	 * @return the nOMBRE
	 */
	public String getNOMBRE() {
		return NOMBRE;
	}
	/**
	 * @param nOMBRE the nOMBRE to set
	 */
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	/**
	 * @return the aPELLIDO
	 */
	public String getAPELLIDO() {
		return APELLIDO;
	}
	/**
	 * @param aPELLIDO the aPELLIDO to set
	 */
	public void setAPELLIDO(String aPELLIDO) {
		APELLIDO = aPELLIDO;
	}
	/**
	 * @return the nUMERO
	 */
	public String getNUMERO() {
		return NUMERO;
	}
	/**
	 * @param nUMERO the nUMERO to set
	 */
	public void setNUMERO(String nUMERO) {
		NUMERO = nUMERO;
	}

	

}
