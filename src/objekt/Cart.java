package objekt;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
	private ArrayList<Product> products;
	
	public Cart() {
		products = new ArrayList<Product>();
	}
	
	public int size() {
		return products.size();
	}
	public void add(Product p) {
		products.add(p);
	}
	public boolean remove(Product p) {
		return products.remove(p);
	}
	public void printList() {
		System.out.println("Liste over varer");
		if(size() == 0) {
			System.out.println("Handlevognen er tom");
		}else {
			for(int i = 0; i < size(); i++) {
				System.out.print(i+1 + ") ");
				System.out.println(products.get(i).getpName());
			}
		}
		
		System.out.println("----------------");
	}
	public void lesFraFil() {
		Path path = Paths.get("resources/produkter.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(path);
			while(scanner.hasNext()) {
				String[] linje = scanner.nextLine().split(":");
				products.add(new Product(Integer.parseInt(linje[0]), linje[1], new Float(linje[2]), linje[3]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
}
