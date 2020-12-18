package persistence;

import java.util.ArrayList;

import model.ModelGeneric;

public class DatabaseQuerys {
	Prepare prepare = new Prepare();
	DatabaseActions actions = new DatabaseActions();

	public ArrayList<?> listar(ModelGeneric model) {
		String sqlSelect = "select " + prepare.fieldsNames(model, false) + " from " + model.getNameTable();
		System.out.println(sqlSelect);
		return actions.select(sqlSelect, model);
	}

	public void inserir(ModelGeneric model) {
//		INSERT INTO tabela (a,b,c) VALUES (1,2,3);
		String sqlInsert = "INSERT INTO " + model.getNameTable() + " (" + prepare.fieldsNames(model, true) + ")"
				+ " VALUES " + prepare.prepararCamposParaStament(model);
		System.out.println(sqlInsert);
		actions.insert(sqlInsert, model);

	}

	public void remover(ModelGeneric model) {
		String sqlDelet = "delete from " + model.getNameTable() + " where " + model.getPrimaryKey().getFieldName()
				+ " = " + model.getPkValue();
		System.out.println(sqlDelet);
		actions.delete(sqlDelet, model);
	}

	public ModelGeneric getById(ModelGeneric model) {
		String sqlSelect = "select " + prepare.fieldsNames(model, false) + " from " + model.getNameTable() + " where " + model.getPrimaryKey().getFieldName()
				+ " = " + model.getPkValue();
		
		return actions.select(sqlSelect, model).get(0);
	}

}
