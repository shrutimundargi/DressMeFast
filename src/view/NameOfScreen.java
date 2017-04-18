package view;

public enum NameOfScreen {
	
	LOGIN("login"),
	SINGUP("singup");
	
	private String name;
	
	NameOfScreen(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
