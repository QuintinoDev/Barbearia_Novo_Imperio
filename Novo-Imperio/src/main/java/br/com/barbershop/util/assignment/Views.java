package br.com.barbershop.util.assignment;

public class Views {
	public interface  Editable {}
	public interface  Create extends Editable {} 
    public interface  Update extends Editable {} 
    public interface  Viewable extends Create, Update {}
    public interface  Internal extends Viewable {}
}
