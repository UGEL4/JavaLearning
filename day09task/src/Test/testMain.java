package Test;

import java.util.Scanner;

//import dao.ProductDao;
import entity.Product;
import service.ProductService;

public class testMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductService service = new ProductService();
		Product product = null;
		//Product product = new Product("篮球","1000",35);
		//service.saveProduct(product);
		//System.out.println(ProductDao.productList[0].toString());
		//System.out.println("数量" + ProductDao.productCount);
		
		select(sc, service, product);
		sc.close();
		//UI();
	}
	
	private static void select(Scanner sc, ProductService service, Product product) {
		String choose ="";
		boolean flag = true;
		while(flag) {
			UI();
			choose = sc.nextLine();
			choose = choose.trim();
			switch(choose) {
				case "1":
					product = new Product();
					service.saveProduct(product, sc);
					break;
				case "2":
					service.show();
					break;
				case "3":
					service.updateById(sc);
					break;
				case "4":
					service.deleteById(sc);
					break;
				case "5":{
					int number;
					while(true) {
						System.out.println("\t1:按id查找，2:按名称查找");
						System.out.print("\t请选择：");
						number = Integer.valueOf(sc.nextLine());
						if(number < 1 || number > 2) {
							System.out.println("\t输入有误，请重新选择！");
							continue;
						}
						break;
					}
					if(number ==1)
						service.findById(sc);
					if(number == 2)
						service.findByName(sc);
				}
					break;
				case "6":
					System.out.println("\t谢谢使用:)");
					flag = false;
					break;
				default :break;
			}
		}
	}

	public static void UI() {
		System.out.println("********************************\n" + 
				"\t|     1. 增加商品        |\n" + 
				"\t|     2. 显示商品        |\n" + 
				"\t|     3. 修改商品        |\n" + 
				"\t|     4. 删除商品        |\n" + 
				"\t|     5. 查找商品        |\n" + 
				"\t|     6. 退出程序        |\n" + 
				"\t |    请输入选择（1-6）：|");
		System.out.print("\t:");
	}
}
