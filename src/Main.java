import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("==== TESTE 1, Find seller by id ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        System.out.println("\n==== TESTE 2, Find sellers by department id ===");
        List<Seller> sellers = sellerDao.findByDepartment(2);
        for (Seller sel : sellers) {
            System.out.println(sel);
        }
    }
}