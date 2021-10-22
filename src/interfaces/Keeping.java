/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Buyer;
import entity.History;
import entity.Product;
import java.util.List;

/**
 *
 * @author pupil
 */
public interface Keeping {
    public void saveBuyers(List<Buyer> buyers);
    public List<Buyer> loadBuyers();
    public void saveProducts(List<Product> products);
    public List<Product> loadProducts();
    public void saveHistories(List<History> histories);
    public List<History> loadHistories();
}
