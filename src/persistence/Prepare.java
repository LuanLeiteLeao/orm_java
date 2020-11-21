package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import model.ModelGeneric;
import utils.SyntaxConverter;

public class Prepare {
	public String fieldsNamesForSelection(ModelGeneric model) {
		ArrayList<String> listFildName = model.getNameFields();
		String fieldsNamesForSelection = "";
		for (String fildName : listFildName) {
			fieldsNamesForSelection += SyntaxConverter.lowercaseAndUnderline(fildName) + ",";
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
			Object object = rs.getObject(SyntaxConverter.lowercaseAndUnderline(NameFild));
			hash.put(NameFild, object);
		}
		return hash;
	}
}
