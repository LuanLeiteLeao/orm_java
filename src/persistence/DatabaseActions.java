package persistence;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import model.ModelGeneric;

public class DatabaseActions extends DataBaseConnection {
	Prepare prepare = null;

	public DatabaseActions() {
		super();
	}

	public ArrayList<ModelGeneric> select(String sqlSelect, ModelGeneric model) {

		ArrayList<ModelGeneric> modelList = new ArrayList<>();
		PreparedStatement stmt;
		prepare = new Prepare();
		try {
			stmt = (PreparedStatement) this.con.prepareStatement(sqlSelect);

			// executa um select
			ResultSet rs = stmt.executeQuery();

			// itera no ResultSet
			int cont = 0;
			while (rs.next()) {

//					model.getClass().getDeclaredConstructor().newInstance();
				ModelGeneric newInstance;
				try {
					newInstance = model.getClass().getDeclaredConstructor().newInstance();
					newInstance.setFieldsTables(prepare.getCamposValores(rs, model));
					modelList.add(newInstance);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return modelList;

	}
}
