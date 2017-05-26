package Bookshelf;

public class Libro {
	
	private String book;
	private String author;
	private String review;
	private int rating;
	private double price;
	
	public Libro(String book, String author, int rating, double price, String review){
		
		this.book = book;
		this.author = author;		
		this.rating = rating;
		this.price = price;
		this.review = review;
		
	}
	
	public void setReview(String review){	//setter
		
		this.review = review;}
	
	public void setRating(int rating){		//setter
		
		this.rating = rating;}
	
	public void setPrice(double price){		//setter
		
		this.price = price;}
	
	public String getTitle (){		
		return book;}
	
	public String getAuthor(){
		return author;}
	
	public int getRating(){
		return rating;}
	
	public double getPrice(){
		return price;}
	
	public String getDesc(){
		return review;}
	
	public String toString(){
		return "El nombre del libro es " + book + " del autor " + author + ". " + review + ". Su calificación es "
				+ rating + " y su precio es " + price; 
		
	}

}






