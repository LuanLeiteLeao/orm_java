package model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import uteis.SyntaxConverter;

public class ModelGeneric {

	public String getNameTable() {
//		pega o nome da classe filha 
		String classNameSon = this.getClass().getSimpleName();
//		trasforma a string  de JavaPadraoClasse para java_padrao_classe  
//		este mesmo padrao tem queser usado na tabela do banco de dados se nao, nao funciona 
		String newString = SyntaxConverter.lowercaseAndUnderline(classNameSon);

		return newString;
	}

	public ArrayList<String> getNameTables() {
		Field[] fields = this.getClass().getDeclaredFields();
		ArrayList<String> listName = new ArrayList<String>();

		for (Field field : fields) {
			listName.add(field.getName());
		}
		return listName;

	}

	public void setFieldsTables(Hashtable<String, Object> hashNameAttributeAndValue) {
		Set<String> keys = hashNameAttributeAndValue.keySet();
		for (String key : keys) {
			Object valueObject = hashNameAttributeAndValue.get(key);
			Field attribute = getMethodByName(key);
			String nameAttribute = "set" + SyntaxConverter.firstCapitalLetter(attribute.getName());
			setValueByNameMethod(nameAttribute, attribute.getType(), valueObject);
		}
	}

	private Field getMethodByName(String name) {
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

	private void setValueByNameMethod(String nameMethod, Class<?> typeObject, Object valueObject) {
		Method method = null;
		try {
			method = this.getClass().getDeclaredMethod(nameMethod, typeObject);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		try {
			method.invoke(this, valueObject);
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

	}

}
