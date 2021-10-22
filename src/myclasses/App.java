/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Buyer;
import entity.History;
import entity.Product;
import entity.Seller;
import interfaces.Keeping;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import keeper.FileKeeper;



/**
 *
 * @author pupil
 */
public class App {
    Scanner scanner = new Scanner(System.in);
    List<Product> products = new ArrayList<>();
    List<Seller> sellers = new ArrayList<>();
    List<Buyer> buyers = new ArrayList<>();
    List<History> histories = new ArrayList<>();
    Keeping keeper = new FileKeeper();
    
    public App() {
        products = keeper.loadProducts();
        buyers = keeper.loadBuyers();
        histories = keeper.loadHistories();
    }
    public void run(){
        String repeat = "y";
        do{
            System.out.println("Выберите задачу");
            System.out.println("0: закончить программу");
            System.out.println("1: добавить товар");
            System.out.println("2: Вывести список товаров");
            System.out.println("3: Добавить покупателя");
            System.out.println("4: Список покупателей");
            System.out.println("5: Продать товар");
            System.out.println("6: Список проданных товаров");
            
            int task = scanner.nextInt();
            scanner.nextLine();
            switch(task){
                case 0: 
                    repeat ="q"; 
                    System.out.println("Программа закончена");
                    break;
                
                case 1: 
                    System.out.println("Добавление товара");
                    products.add(addProduct());//добавление в список
                    keeper.saveProducts(products);
                    break;
                    
                case 2:
                    System.out.println("Список товаров:");
                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i)!=null){
                           System.out.println((i+1)+ " " + products.get(i).toString()); 
                        }
                    }
                    break;
                
                case 3:
                    System.out.println("Добавления покупателя");
                    buyers.add(addBuyer());
                    keeper.saveBuyers(buyers);
                    break;
                   
                case 4:
                    System.out.println("Список покупателей");
                    for (int i = 0; i < buyers.size(); i++) {
                        if (buyers.get(i)!=null){
                           System.out.println(buyers.get(i).toString()); 
                        }
                    }
                    break;
                
                case 5:
                    System.out.println("Продать товар");
                    histories.add(addHistory());
                    keeper.saveHistories(histories);
                    break;
                case 6:
                    System.out.println("Проданные товары");
                    for (int i = 0; i < histories.size(); i++) {
                        if (histories.get(i)!=null){
                            System.out.printf("%d. Товар %s продан %s%n",
                                (i+1),
                                histories.get(i).getProduct().getProductName(), 
                                histories.get(i).getBuyer().getName());
                                //histories.get(i).getSeller().getName()); 
                        }
                    }
                    break;
            }
        }while("y".equals(repeat));
    }
    
    private Product addProduct(){
        Product product = new Product();
        System.out.print("Название товара: ");
        product.setProductName(scanner.nextLine());
        Seller seller = new Seller();
        System.out.print("Название продавца: ");
        seller.setName(scanner.nextLine());
        System.out.print("Категории товаров продавца: ");
        seller.setProductCategory(scanner.nextLine());
        product.setSeller(seller);
        System.out.print("Цена товара: ");
        product.setPrice(scanner.nextDouble()); scanner.nextLine();
        return product;        
    }
   
    private Buyer addBuyer(){
        Buyer buyer = new Buyer();
        System.out.print("Имя покупателя: ");
        buyer.setName(scanner.nextLine());
        System.out.print("Адрес покупателя: ");
        buyer.setAdress(scanner.nextLine());
        System.out.print("Телефон покупателя: ");
        buyer.setPhone(scanner.nextLine());
        System.out.print("Кол-во денег у покупателя: ");
        buyer.setMoney(scanner.nextDouble()); scanner.nextLine();
        return buyer;
    }
        
    private History addHistory(){
        History history = new History();
        System.out.println("");
        
        System.out.println("Список товаров:");
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i)!=null){
                System.out.println((i+1)+ " " + products.get(i).toString()); 
            }
        }
        
        System.out.print("Номер товара: ");
        int ProductNumber = scanner.nextInt(); 
        history.setProduct(products.get(ProductNumber-1));//???
        
        System.out.println("Список покупателей");
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i)!=null){
                System.out.printf("%d. %s%n", (i+1), buyers.get(i).toString()); 
            }
        }
        
        System.out.print("Номер покупателя: ");
        int buyerNumber = scanner.nextInt(); scanner.nextLine();
        history.setBuyer(buyers.get(buyerNumber-1));
        
        Calendar c = new GregorianCalendar();
        history.setDate(c.getTime());
        
        
        //buyer.setMoney(buyer.getMoney-product.price);
        return history;
    }

}//end programm


    
    

