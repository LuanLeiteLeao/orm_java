package model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import utils.SyntaxConverter;

public abstract class ModelGeneric {
	public abstract PrimaryKey getPrimaryKey();

	protected abstract Hashtable<String, String> objectNameAndFieldNameTable();

	public String getObjectNameByFieldNameTable(String key) {
		return objectNameAndFieldNameTable().get(key);
	}

	public Object getPkValue() {
		String nameMethod = "get" + SyntaxConverter.firstCapitalLetter(getPrimaryKey().getObjectName());
		System.out.println(nameMethod);
		Object PkValue = setValueByNameMethod(nameMethod, null, null);

		return PkValue;
	}

	public String getNameTable() {
//		pega o nome da classe filha 
		String classNameSon = this.getClass().getSimpleName();
//		trasforma a string  de JavaPadraoClasse para java_padrao_classe  
//		este mesmo padrao tem queser usado na tabela do banco de dados se nao, nao funciona 
		String newString = SyntaxConverter.lowercaseAndUnderline(classNameSon);

		return newString;
	}

	public ArrayList<String> getNameFields() {
		Set<String> fieldsName = objectNameAndFieldNameTable().keySet();
		ArrayList<String> fieldsNameList = new ArrayList<String>();

		for (String string : fieldsName) {
			fieldsNameList.add(string);
		}

		return fieldsNameList;

	}

	public void setFieldsTables(Hashtable<String, Object> hashNameAttributeAndValue) {
		Set<String> keys = hashNameAttributeAndValue.keySet();
		for (String key : keys) {
			Object valueObject = hashNameAttributeAndValue.get(key);
			Field attribute = getAttributedByName(key);
			String nameMethod = "set" + SyntaxConverter.firstCapitalLetter(attribute.getName());
			setValueByNameMethod(nameMethod, attribute.getType(), valueObject);
		}
	}

	public ArrayList<Object> getFieldsTables() {
		Set<String> keys = objectNameAndFieldNameTable().keySet();
		ArrayList<Object> listValues = new ArrayList<Object>();
		for (String key : keys) {
			Object valueObject = objectNameAndFieldNameTable().get(key);
			Field attribute = getAttributedByName(key);
			String nameMethod = "get" + SyntaxConverter.firstCapitalLetter(this.getObjectNameByFieldNameTable(key));
			Object value = setValueByNameMethod(nameMethod, attribute.getType(), null);
			listValues.add(value);
		}
		return listValues;
	}

	private Field getAttributedByName(String name) {
		Field field = null;
		try {
			field = this.getClass().getField(name);
			return field;

		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
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

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		try {
			if (valueObject == null) {
				objeto = method.invoke(this);
			} else {
				objeto = method.invoke(this, valueObject);
			}

			return objeto;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return method;

	}

}
