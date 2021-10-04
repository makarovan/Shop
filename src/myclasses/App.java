/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Product;
import entity.Seller;



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
        
        
    }
}
