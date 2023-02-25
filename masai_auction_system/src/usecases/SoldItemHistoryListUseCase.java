package usecases;



import java.util.List;
import java.util.Scanner;

import DAO.SellerDao;
import DAO.SellerDaoImpl;
import DTO.SoldItems;
import Exception.SellerException;

public class SoldItemHistoryListUseCase {
    public static void main(String[] args) {
        soldItemHistory();
    }
    public static void soldItemHistory(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the SellerId to view Sold Items list");
        int sellerId =sc.nextInt();
        SellerDao dao=new SellerDaoImpl();
        try {
            List<SoldItems> list=dao.SoldItemHistory(sellerId);
            System.out.println("---------------------Table of all the Sold Items--------------------------");

            System.out.println("---------------------------------------------------------------------------------");

            System.out.printf("%7s %13s %15s %15s %10s %15s","Id", "ProductName","SellerName","CategoryName","Price", "Status" );
            System.out.println();
            System.out.print("---------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%2s %12s %12s %16s %13s %14s",li.getProductId(),li.getProductName(),li.getSellerName(),li.getCategoryName(),li.getPrice());
                System.out.println();

            });
            System.out.println("---------------------------------------------------------------------------------");

        } catch (SellerException e) {
            System.out.println(e.getMessage());
        }
    }
}
