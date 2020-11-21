package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.DatabaseConfiguration;

/***
 * 
 * @author Kaleb Vieira Evangelista
 * @author Luan Leite Le�o
 * 
 *         Esta classe gerencia uma conexao com o banco de dados uma unica vez,
 *         este padrao garante a existencia de apenas uma instancia de uma
 *         classe, mantendo um ponto global de acesso ao seu objeto.
 * 
 */

public class DataBaseConnection {

	protected Connection con;
	protected static DataBaseConnection dao;

	/***
	 * O metodo valida se possui uma instancia de conexao, se nao possuir ele entao
	 * recebe uma nova instancia de conexao;
	 * 
	 * @return Uma instancia global da conexao.
	 */
	public static DataBaseConnection getIntancia() {
		if (dao == null) {
			dao = new DataBaseConnection();
		}
		return dao;
	}

	/***
	 * O metodo construtor cria uma conexao com o banco de dados uma unica vez
	 * utilizando as informa�oes de configura�oes e o drive de banco de dados, e
	 * validado se a conexao foi bem sucedida e se nao for e gerado uma mensagem
	 * descrevendo o problema.
	 * 
	 * @throws RuntimeException
	 */
	protected DataBaseConnection() throws RuntimeException {
		DatabaseConfiguration conf = DatabaseConfiguration.getInstance();
		String driver = conf.getDriveBd();
		try {
			Class.forName(driver);
			// padrao jdbc ://nomeserver:porta/database
			con = DriverManager.getConnection(conf.getUrlConexao(), conf.getUsuarioBd(), conf.getSenhaBd());
			System.out.println("Conectado ao banco de dados");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			throw new RuntimeException("DAOFuncionarioSQL erro(1):" + e.getMessage());
		}
	}

}