package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	//parse pois pode dar excessao na data
	public static void main(String[] args) throws ParseException {
		
		//localidade USA
		Locale.setDefault(Locale.US);
		//leitor de teclado
		Scanner sc = new Scanner(System.in);
		
		//formatacao da data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		//dados do cliente
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		//instanciei um cliente
		Client client = new Client(name, email, birthDate);
		
		//dados do pedido
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		//intanciei o pedido
		Order order = new Order(new Date(), status, client);
		
		//itens do pedido
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			//instanciei o produto
			Product product = new Product(productName, productPrice);
			
			//quantidade de produtos
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			//instanciei um item do pedido
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			//inclui o item na pedido
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}
