package model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import model.DBField;
import utils.SyntaxConverter;

public abstract class ModelGeneric {

	public Object getPKValue() {
		String nameField = getNameFieldPk();
		Object objeto = null;
		try {
			Method method = this.getClass().getDeclaredMethod("get" + SyntaxConverter.firstCapitalLetter(nameField));
			objeto = method.invoke(this);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return objeto;
	}

	private String getNameFieldPk() {
		for (Field field : this.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(DBField.class)) {
				DBField anotacao = field.getAnnotation(DBField.class);
				if (anotacao.isPrimaryKey()) {
					return field.getName();
				}
			}
		}
		return null;
	}

	public String getPKName() {
		for (Field field : this.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(DBField.class)) {
				DBField anotacao = field.getAnnotation(DBField.class);
				return anotacao.colummn();
			}
		}
		return null;
	}

	public String getNameTable() {
		String tabela = null;
		// Tenta obter nossa anotação na classe
		DBTable persistable = this.getClass().getAnnotation(DBTable.class);
		// Se tiver a anotação...
		if (persistable != null) {
			tabela = persistable.table();
		}
		return tabela;
	}

	public ArrayList<String> getFieldsNameTable() {
		ArrayList<String> namesFields = new ArrayList<String>();

		for (Field field : this.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(DBField.class)) {
				DBField anotacao = field.getAnnotation(DBField.class);
				namesFields.add(anotacao.colummn());
			}
		}
		return namesFields;
	}

	public ArrayList<String> getFieldsNameClass() {
		ArrayList<String> namesFields = new ArrayList<String>();

		for (Field field : this.getClass().getDeclaredFields()) {
			namesFields.add(field.getName());
		}
		return namesFields;
	}

	public void setFieldsTables(ArrayList<Object> listObject) {
		ArrayList<String> fieldsNames = this.getFieldsNameClass();
		for (int i = 0; i < fieldsNames.size(); i++) {
			Field type = getAttributedByName(fieldsNames.get(i));
			String nameMethod = "set" + SyntaxConverter.firstCapitalLetter(fieldsNames.get(i));
			Object valueObject = listObject.get(i);
			setValueByNameMethod(nameMethod, type.getType(), valueObject);
		}
	}

	public ArrayList<Object> getFieldsValue() {
		ArrayList<String> fieldsNames = this.getFieldsNameClass();
		ArrayList<Object> listValues = new ArrayList<Object>();

		for (String field : fieldsNames) {
			String nameMethod = "get" + SyntaxConverter.firstCapitalLetter(field);
			Object value = setValueByNameMethod(nameMethod, null, null);
			listValues.add(value);
		}
		return listValues;
	}

	private Field getAttributedByName(String name) {
		Field field = null;
		try {
			field = this.getClass().getField(name);
			return field;

		} catch (SecurityException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return field;
	}

	private Object setValueByNameMethod(String nameMethod, Class<?> typeObject, Object valueObject) {
		Method method = null;
		Object objeto = null;
		try {
			if (valueObject == null) {
				method = this.getClass().getDeclaredMethod(nameMethod);
			} else {
				method = this.getClass().getDeclaredMethod(nameMethod, typeObject);
			}

		} catch (SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			if (valueObject == null) {
				objeto = method.invoke(this);
			} else {
				objeto = method.invoke(this, valueObject);
			}

			return objeto;
		} catch (InvocationTargetException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return method;
	}

}
