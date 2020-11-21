package persistence;

import java.util.ArrayList;

import model.ModelGeneric;

public class DatabaseQuerys {
	Prepare prepare = new Prepare();
	DatabaseActions actions = new DatabaseActions(); 
	public ArrayList<ModelGeneric> listar(ModelGeneric model) {
		String sqlSelect = "select " + prepare.fieldsNamesForSelection(model) + " from " + model.getNameTable();
		System.out.println(sqlSelect);
		return actions.select(sqlSelect, model);
	}
}
