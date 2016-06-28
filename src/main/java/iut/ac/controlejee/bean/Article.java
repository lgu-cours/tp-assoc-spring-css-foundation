package iut.ac.controlejee.bean;

public class Article {
	
	private String code ;
	private String nom ;
	
	private int    stock  ;
	private double prix ;
	
	
	
	public Article(String code, String nom, int stock, double prix) {
		super();
		this.code = code;
		this.nom = nom;
		this.stock = stock;
		this.prix = prix;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

	
}
