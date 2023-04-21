package S1_01_N1;

public class Main {
    public static void main(String[] args) {
        //Create products
        Product product_1 = new Product("Pasta", 3);
        Product product_2 = new Product("Oil", 4);
        Product product_3 = new Product("Tomato", 7);

        //Initialize Sale instance
        Sale sale_1 = new Sale();

        //Generate our exception on purpose
        try {
            sale_1.calcularTotal();
        } catch (EmptySaleException e) {
            System.out.println(e.getMessage());
        }

        //Add product
        sale_1.addProduct(product_1);
        sale_1.addProduct(product_2);
        sale_1.addProduct(product_3);

        try {
            sale_1.calcularTotal();
        } catch (EmptySaleException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Total price = " + sale_1.getTotalPrice());

    }

}
