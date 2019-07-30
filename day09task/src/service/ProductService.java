package service;

import java.util.Scanner;

import dao.ProductDao;
import entity.Product;

public class ProductService {
	ProductDao productDao = new ProductDao();
	
	public void saveProduct(Product product, Scanner sc) {
		if(ProductDao.productCount == ProductDao.productList.length) {
			System.out.println("\t库存已满！！！");
			return;
		}
		
		System.out.print("\t请输入商品名称：");
		String name = sc.nextLine();
		name = name.trim();
		System.out.print("\t请输入商品价格：");
		double price = Double.parseDouble(sc.nextLine().trim());
		product.setName(name);
		product.setId(String.valueOf(ProductDao.productCount + 100));
		product.setPrice(price);
		productDao.saveProduct(product);
		System.out.println("\t入库成功！");
	}
	
	public void show() {
		productDao.showProduct();
	}
	
	public void findById(Scanner sc) {
		if(ProductDao.productCount == 0) {
			System.out.println("\t库存为空");
			return;
		}
		
		System.out.print("\t输入要查找的商品的编号：");
		String id = sc.nextLine();
		id = id.trim();
		int index = productDao.findProductById(id);
		
		if(index == -1) {
			System.out.println("\t抱歉，没有该商品。");
		}else {
			System.out.println(productDao.getProduct(index));
		}
	}
	
	public void findByName(Scanner sc) {
		if(ProductDao.productCount == 0) {
			System.out.println("\t库存为空");
			return;
		}
		Product[] product = new Product[20];
		System.out.print("\t输入要查找的商品的名称：");
		String name = sc.nextLine();
		name = name.trim();
		boolean isFound = productDao.findProductByName(name, product);
		if(isFound) {
			for(int i = 0; i < product.length; i++) {
				if(product[i] == null) {
					break;
				}
				System.out.println(product[i]);
			}
		}else {
			System.out.println("\t没有找到商品");
		}
	}
	
	public void deleteById(Scanner sc) {
		
		if(ProductDao.productCount == 0) {
			System.out.println("\t库存为空！");
			return;
		}
		
		System.out.print("\t输入要删除的编号：");
		String id = sc.nextLine();
		if(productDao.deleteProductById(id.trim()) == true) {
			System.out.println("\t删除成功！");
		}else {
			System.out.println("\t删除失败！");
		}
	}
	
	public void updateById(Scanner sc) {
		if(ProductDao.productCount == 0) {
			System.out.println("\t库存为空！");
			return;
		}
		
		System.out.print("\t输入编号:");
		String id = sc.nextLine();
		int index = productDao.findProductById(id);
		if(index == -1) {
			System.out.println("\t没有这个商品");
			return;
		}
		productDao.updateProductById(id, sc);
		System.out.println("\t修改成功");
		System.out.println(ProductDao.productList[index]);
	}
}
