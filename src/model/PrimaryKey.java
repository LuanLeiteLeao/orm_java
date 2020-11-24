package model;

public class PrimaryKey {
	private String fieldName;
	private String objectName;
	private Boolean isAutoIncrement = true;

	public PrimaryKey(String fieldName, String objectName) {
		super();
		this.fieldName = fieldName;
		this.objectName = objectName;
	}

	public PrimaryKey(String fieldName, String objectName, Boolean isAutoIncrement) {
		super();
		this.fieldName = fieldName;
		this.objectName = objectName;
		this.isAutoIncrement = isAutoIncrement;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public Boolean getIsAutoIncrement() {
		return isAutoIncrement;
	}

	public void setIsAutoIncrement(Boolean isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}

}
