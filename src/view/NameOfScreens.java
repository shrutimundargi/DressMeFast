package view;

public enum NameOfScreens {
	
	LOGIN("login"),
	SINGUP("singup"),
	DIALOGSINGUP("dialogsingup"),
	HOME("home");
	
	private String name;
	
	NameOfScreens(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
