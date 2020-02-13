package model_linkedlists.testers.testdata;

public abstract class Generics {
	public static final String type = "Generic";
	private String subType;

	protected void setSubType(String type) {
		this.subType = type;
	}
	
	public String getType() {
		return subType + " from " + type;
	}
	
	// public abstract String getType();
	public abstract String getKey();
	public abstract int compareTo(Object o);

}
