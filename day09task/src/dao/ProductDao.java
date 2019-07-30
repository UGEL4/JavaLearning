package dao;

import java.util.Scanner;

import entity.Product;

public class ProductDao implements ProductInterface {

	/*
	 * 	静态数组 productList
	 * 	productCount 记录当前下标
	 * */
	public static Product productList[] = new Product[100];
	public static int productCount = 0;
	
	/*
	 *	 保存数据
	 * */
	@Override
	public boolean saveProduct(Product product) {
	/*
		if(productCount == productList.length) {
			System.out.println("\t库存已满！！！");
			return false;
		}else {
		productList[productCount++] = product;
		System.out.println("\t入库成功！");
		return true;
		}
		**/
		productList[productCount++] = product;
		//System.out.println("\t入库成功！");
		return true;
	}

	/*
	 * 	按编号查找，找到后返回数据的位置；找不到则返回-1
	 * */
	@Override
	public int findProductById(String id) {
		int i = 0;
		while(i < productCount) {
			if(id.equals(productList[i].getId())) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	/*
	 * 	用下下标来读取数据
	 * */
	@Override
	public Product getProduct(int index) {
		return productList[index];
	}

	
	/*
	 * 	按名称查找，返回一个对象数组
	 *	当没有匹配的数据时，index = 0；
	 *	当查找到的数据容量超过 product 数组容量时，也停止继续查找
	 * */
	@Override
	public boolean findProductByName(String name, Product[] product) {
		
		int index = 0;
		for(int i = 0; i < productCount; i++) {
			if(name.equals(productList[i].getName())) {
				product[index] = productList[i];
				index++;
			}
			if(index == product.length)
			{
				break;
			}
		}
		if(index == 0) {
			return false;
		}
		return true;
	}

	/*
	 * 	按 id 删除数据,找到后删除数组元素
	 * */
	@Override
	public boolean deleteProductById(String id) {
		int i = 0;
		/*
		if(productCount == 0) {
			System.out.println("\t库存为空！");
			return false;
		}else {
			for(; i < productCount; i++) {
				if(id.equals(productList[i].getId())) {
					
					for(int j = i; j < productCount - 1; j++) {
						productList[j] = productList[j + 1];
					}
					productList[productCount-1] = null;
					//productCount-=1;
					break;
				}
			}
		}
		*/
		for(; i < productCount; i++) {
			if(id.equals(productList[i].getId())) {
				
				for(int j = i; j < productCount - 1; j++) {
					productList[j] = productList[j + 1];
				}
				productList[productCount-1] = null;
				break;
			}
		}
		/*
		 * 	i == productCount 表示没有找到匹配的编号，删除失败
		 * */
		if(i == productCount) {
			return false;
		}
		
		productCount-=1;
		
		return true;
	}

	/*
	 *	 按编号 id 修改商品名称
	 *	用函数 findProductById() 找到数据位置，然后修改名称
	 * */
	@Override
	public boolean updateProductById(String id, Scanner sc) {
		
		int index = findProductById(id);
		String name = "";
		while(true) {
			System.out.println(productList[index]);
			System.out.print("\t输入商品名：");
			name = sc.nextLine().trim();
			if(name.equals(productList[index].getName())){
				System.out.println("\t不能和当前名称相同，请重新输入：");
				continue;
			}
			break;
		}
		productList[index].setName(name);
		return true;
	}

	/*
	 * 	遍历数组打印输出
	 * */
	@Override
	public void showProduct() {
		if(productCount == 0) {
			System.out.println("\t库存为空！");
		}else {
			for(int i = 0; i < productCount; i++) {
			System.out.println(ProductDao.productList[i]);
			}
		}
	}
}
