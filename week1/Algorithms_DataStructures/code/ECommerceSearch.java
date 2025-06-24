import java.util.Scanner;
class Product {
    int productId;
    String productName;
    String category;
    Product(int id, String name, String cat) {
        productId = id;
        productName = name;
        category = cat;
    }
    void display() {
        System.out.println("ID: " + productId + ", Name: " + productName + ", Category: " + category);
    }
}

public class ECommerceSearch{
    public static Product linearSearch(Product[] products, String name) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(name)) {
                return products[i];
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            String midName = products[mid].productName.toLowerCase();
            String targetName = name.toLowerCase();
            if (midName.equals(targetName)) {
                return products[mid];
            } else if (midName.compareTo(targetName) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
    public static void sortProductsByName(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - i - 1; j++) {
                if (products[j].productName.compareToIgnoreCase(products[j + 1].productName) > 0) {
                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[5];
        products[0] = new Product(1, "Laptop", "Electronics");
        products[1] = new Product(2, "Shirt", "Clothing");
        products[2] = new Product(3, "Headphones", "Electronics");
        products[3] = new Product(4, "Shoes", "Footwear");
        products[4] = new Product(5, "Camera", "Electronics");
        System.out.print("Enter product name to search: ");
        String searchName = sc.nextLine();
        System.out.println("\nUsing Linear Search:");
        Product result1 = linearSearch(products, searchName);
        if (result1 != null) {
            result1.display();
        } else {
            System.out.println("Product not found.");
        }
        sortProductsByName(products);
        System.out.println("\nUsing Binary Search:");
        Product result2 = binarySearch(products, searchName);
        if (result2 != null) {
            result2.display();
        } else {
            System.out.println("Product not found.");
        }
        sc.close();
    }
}
