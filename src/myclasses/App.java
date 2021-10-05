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
import java.util.Calendar;
import java.util.GregorianCalendar;



/**
 *
 * @author pupil
 */
public class App {

    public App() {
    }
    public void run(){
        Seller seller1 = new Seller();
        seller1.setName("Dairy Products Farm");
        seller1.setProductCategory("dairy products");
        
        Product product1 = new Product();
        product1.setProductName("milk");
        product1.setSeller(seller1);
        product1.setPrice(1);
        
        Seller seller2 = new Seller();
        seller2.setName("Bookstore");
        seller2.setProductCategory("books");
        
        Product product2 = new Product();
        product2.setProductName("book");
        product2.setSeller(seller2);
        product2.setPrice(10.2);
        
        Buyer buyer1 = new Buyer();
        buyer1.setFirstname("Nadezda");
        buyer1.setLastname("Makarova");
        buyer1.setAdress("Tallinna mnt 25");
        buyer1.setPhone("55448866");
        
        History history1 = new History();
        history1.setBuyer(buyer1);
        Seller[] history1Sellers = new Seller[2];
        history1Sellers[0] = seller1;
        history1Sellers[1]= seller2;
        history1.setSeller(history1Sellers);
        Product[] history1Products = new Product[2];
        history1Products[0] = product1;
        history1Products[1] = product2;
        history1.setProduct(history1Products);
        Calendar date = new GregorianCalendar();
        history1.setDate(date.getTime());
    
        
        System.out.println(history1.toString());
    }
    
    
}
