import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("==== TEST 1, Find seller by id ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n==== TEST 2, Find sellers by department id ===");
        List<Seller> sellers = sellerDao.findByDepartment(2);
        for (Seller sel : sellers) {
            System.out.println(sel);
        }

        System.out.println("\n==== TEST 3, Find all sellers ===");
        List<Seller> sellers2 = sellerDao.findAll();
        for (Seller sel : sellers2) {
            System.out.println(sel);
        }

        System.out.println("\n==== TEST 4, Seller insert ===");
        Seller departmentInsert = new Seller(0, "Greg", "greg@gmail.com", new Date(), 2000.00, new Department(1, ""));
        sellerDao.insert(departmentInsert);
        System.out.println("\nSeller inserted!");

        System.out.println("\n==== TEST 5, Seller update ===");
        departmentInsert.setName("João Pedro");
        sellerDao.update(departmentInsert);
        System.out.println("\nSeller updated!");

        System.out.println("\n==== TEST 6, Seller delete ===");
        System.out.println("Enter id for delete test:");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("\nDelete completed!");

        System.out.println("==== DEPARTMENT TESTS ===");

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("==== TEST 1, Find department by id ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n==== TEST 3, Find all department ===");
        List<Department> departments2 = departmentDao.findAll();
        for (Department dep : departments2) {
            System.out.println(dep);
        }

        System.out.println("\n==== TEST 4, Department insert ===");
        Department departmentsInsert = new Department(0, "House");
        departmentDao.insert(departmentsInsert);
        System.out.println("\nDepartment inserted!");

        System.out.println("\n==== TEST 5, Department update ===");
        departmentsInsert.setName("Computers");
        departmentDao.update(departmentsInsert);
        System.out.println("\nSeller updated!");

        System.out.println("\n==== TEST 6, Department delete ===");
        System.out.println("Enter id for delete test:");
        int idDepartment = sc.nextInt();
        departmentDao.deleteById(idDepartment);
        System.out.println("\nDelete completed!");
        sc.close();
    }
}