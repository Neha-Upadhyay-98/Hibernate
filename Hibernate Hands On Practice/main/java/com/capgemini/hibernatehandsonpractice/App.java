package com.capgemini.hibernatehandsonpractice;

import java.time.LocalDate;

import com.capgemini.hibernatehandsonpractice.dao.CustomersDao;
import com.capgemini.hibernatehandsonpractice.dao.ItemsDao;
import com.capgemini.hibernatehandsonpractice.entity.Addresses;
import com.capgemini.hibernatehandsonpractice.entity.Customers;
import com.capgemini.hibernatehandsonpractice.entity.Items;
import com.capgemini.hibernatehandsonpractice.entity.Orders;

public class App 
{
    public static void main( String[] args )
    {
        Customers cust1=new Customers("John Doe");
        Addresses adr1=new Addresses("12 Main St.,Houston TX 77001");
        
        Customers cust2=new Customers("Bruce Wayne");
        Addresses adr2=new Addresses("1007 Mountain Dr.,Gotham NY 10286");
        CustomersDao customersDao=new CustomersDao();
        ItemsDao itemsDao = new ItemsDao();

        //create some orders
        Orders ord1=new Orders(LocalDate.of(12, 9, 24),156.78);
        cust1.getOrdList().add(ord1);
        Orders ord2=new Orders(LocalDate.of(12, 9, 25),99.99);
        cust2.getOrdList().add(ord2);
        Orders ord3=new Orders(LocalDate.of(12, 9, 26),75.00);
        cust1.getOrdList().add(ord3);
        
        //create some items
        Items item1=new Items("Tickle Me Elmo","It wants to be tickled");
        Items item2=new Items("District 9 DVD","Awesome sci-fi movie");
        Items item3=new Items("Batarang","It is very sharp");
        itemsDao.saveItem(item1);
        itemsDao.saveItem(item2);
        itemsDao.saveItem(item3);
        
        //adding orders to items
        item1.getOrders().add(ord1);
        item2.getOrders().add(ord1);
        item2.getOrders().add(ord2);
        item3.getOrders().add(ord2);
        
        //adding items to the orders
        ord1.getItems().add(item1);
        ord1.getItems().add(item2);
        ord2.getItems().add(item2);
        ord2.getItems().add(item3);

        cust1.setAddress(adr1);
        cust2.setAddress(adr2);
        customersDao.saveCustomer(cust1);
        customersDao.saveCustomer(cust2);
 


    }
}
