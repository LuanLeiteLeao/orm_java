package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import model.ModelGeneric;
import model.PrimaryKey;

public class Prepare {
	public String fieldsNames(ModelGeneric model, Boolean isInsertData) {
		ArrayList<String> listFildName = model.getNameFields();
		PrimaryKey pk = model.getPrimaryKey();
		String fieldsNamesForSelection = "";

		if (pk != null && !isInsertData) {
			fieldsNamesForSelection = model.getPrimaryKey().getFieldName() + ",";
		}

		for (String fildName : listFildName) {
			fieldsNamesForSelection += model.getObjectNameByFieldNameTable(fildName) + ",";
		}
//		remove o ultimo campo pois sobra um ","
		fieldsNamesForSelection = fieldsNamesForSelection.substring(0, fieldsNamesForSelection.length() - 1);
		return fieldsNamesForSelection;

	}

	public Hashtable<String, Object> getCamposValores(ResultSet rs, ModelGeneric model) throws SQLException {
		ArrayList<Object> list = new ArrayList<>();
		ArrayList<String> listNameFilds = model.getNameFields();
		Hashtable<String, Object> hash = new Hashtable<String, Object>();
		for (String NameFild : listNameFilds) {
			Object object = rs.getObject(model.getObjectNameByFieldNameTable(NameFild));
			hash.put(NameFild, object);
		}
		if (model.getPrimaryKey() != null) {
			Object object = rs.getObject(model.getPrimaryKey().getFieldName());
			hash.put(model.getPrimaryKey().getObjectName(), object);
		}
		return hash;
	}

	public String prepararCamposParaStament(ModelGeneric tabela) {
		List<String> campos = new ArrayList();
		List<String> listcampos = tabela.getNameFields();

		campos.add("(");

		for (String string : listcampos) {
			campos.add("?");
			campos.add(",");
		}

		campos.remove(campos.size() - 1);
		campos.add(")");

		return String.join("", campos);
	}
}
