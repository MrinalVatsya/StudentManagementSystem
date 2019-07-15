package javademo;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
class Product{  
    Integer id;  
    String name;  
    Integer qty;
    float price;  
    
    //using getters and setters.
    public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
    public Product(Integer id, String name,Integer qty,float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
        this.qty = qty;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}  
}   
public class GroupBy2 {
	public static void main(String[] args) {
		 List<Product> products = new ArrayList<Product>();  
	        //Adding Products  
	        products.add(new Product(1,"HP Laptop",10,25000f));  
	        products.add(new Product(2,"Dell Laptop",20,30000f));  
	        products.add(new Product(3,"Dell Laptop",30,28000f));  
	        products.add(new Product(4,"Sony Laptop",40,28000f));  
	        products.add(new Product(5,"Sony Laptop",50,90000f));  
	        
	        Map<String,Integer> m = products.stream().filter(x->{Boolean b = x.getName().startsWith("D") || x.getPrice() > 50000f;
	        return b;})
	        		.collect(Collectors.groupingBy(x->x.getName(),Collectors.summingInt(x->x.getQty())));
	        
	        
	        /*  products.stream().filter(x->{Boolean b = x.getName().startsWith("D") || x.getPrice() > 50000f;
	        return b;}).map(e->{
	        	System.out.println(e);
	        	return e;});*/
	        
	        System.out.println(m);
	        

	        
	        List<Product> l = products.stream().filter(x -> 
	        	{Boolean p = x.getName().startsWith("D") || x.getPrice() > 50000f;
	        	return p;}
	        ).map(e ->{ System.out.println(e.getName());
	        	return e;}).collect(Collectors.toList());
	        
	        
	        //using toMap function..
	        Map<Integer,String> ko = products.stream().collect(Collectors.toMap(x->x.getId(), x->x.getName()));
	        System.out.println(ko);
	}
}
