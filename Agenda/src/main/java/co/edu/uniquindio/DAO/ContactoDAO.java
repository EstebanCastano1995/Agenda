package co.edu.uniquindio.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.edu.uniquindio.vo.Contacto;

/**
 * Esta clase sirve para ejecutar operaciones CRUD en la BD , con un objeto de
 * conexion enviado por parametro al constructor.
 * 
 * @author Martin y Mariana
 *
 */
public class ContactoDAO {

	// Esta variable sirve para guardar la conexion de la BD
	private SqlSessionFactory sqlSessionFactory = null;

	/**
	 * Este metodo es el constructor de la clase y en el se recibe un objeto de
	 * tipo conexion para poder realizar las operaciones CRUD en este objeto
	 * DAO.
	 * 
	 * @param sqlSessionFactory
	 */
	public ContactoDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * Seleccionar todos los Contactos de la BD
	 * 
	 * @return returna la lista de contactos de la BD
	 */
	public List<Contacto> selectAll() {
		List<Contacto> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Contacto.selectAll");
		} finally {
			session.close();
		}
		return list;

	}

	/**
	 * Seleccionar instancia Contacto de la BD dependiendo del id
	 * 
	 * @param Contactor
	 *            the instance to be persisted.
	 */
	public Contacto selectById(int id) {
		Contacto person = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			person = session.selectOne("Contacto.selectById", id);

		} finally {
			session.close();
		}
		return person;
	}

	/**
	 * Insertar una instancia de persona en la BD.
	 * 
	 * @param Instancia
	 *            del contacto para ser guardado.
	 */
	public int insert(Contacto person) {
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			id = session.insert("Contacto.insert", person);
		} finally {
			session.commit();
			session.close();
		}
		return id;
	}

	/**
	 * Actualizar una instancia de contacto en la BD
	 * 
	 * @param instancia
	 *            de contacto para ser actualizado
	 */
	public void update(Contacto person) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.update("Contacto.update", person);

		} finally {
			session.commit();
			session.close();
		}
	}

	/**
	 * Eliminar una instancia de la BD de contacto
	 * 
	 * @param valor
	 *            del id de el contacto a ser borrado
	 */
	public void delete(Contacto person) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			session.delete("Contacto.delete", person);
		} finally {
			session.commit();
			session.close();
		}
	}

}
