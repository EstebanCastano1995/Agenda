package co.edu.uniquindio.mybatis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Esta clase sirve para crear un objeto de conexion a la BD , y se implementa
 * un metodo para devolverlo publicamente
 * 
 * @author Martin y Mariana
 *
 */
public class ConexionBD {

	// Objeto para conectarse a la BD
	private static SqlSessionFactory sqlSessionFactory;

	/**
	 * Metodo en el que se lee y se realiza la conexion a la BD dependiendo del
	 * archivo de configuracion config.xml
	 */
	static {
		try {

			String resource = "co/edu/uniquindio/mapper/Config.xml";// archivo
																	// que
																	// contiene
																	// la
																	// configuracion
																	// para
																	// conectarse
																	// a la BD
			Reader reader = Resources.getResourceAsReader(resource);

			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}

	/**
	 * 
	 * @return objeto conectado a la BD
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
