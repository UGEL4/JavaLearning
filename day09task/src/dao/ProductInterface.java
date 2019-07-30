package dao;

import java.util.Scanner;

import entity.Product;

public interface ProductInterface {
	public boolean saveProduct(Product product);
	public int findProductById(String id);
	public Product getProduct(int index);
	public boolean findProductByName(String name, Product[] product);
	public boolean deleteProductById(String id);
	public boolean updateProductById(String id, Scanner sc);
	public void showProduct();
}
