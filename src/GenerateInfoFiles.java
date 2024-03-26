import java.io.FileWriter;
import java.io.IOException;

public class GenerateInfoFiles {

    private static final int NUMBER_OF_SALES = 50;
    private static final int NUMBER_OF_PRODUCTS = 50;
    private static final int NUMBER_OF_SALES_MAN = 50;

    // array with 20 products
    private static final String[] PRODUCTS = {
            "T-shirt", "Jeans", "Shoes", "Scarf", "Hat", "Sunglasses", "Watch", "Bag", "Gloves", "Dress",
            "Sweater", "Skirt", "Jacket", "Boots", "Socks", "Belt", "Suit", "Blouse", "Tie", "Coat"
    };

    // Arrays with names and surnames
    private static final String[] NAMES = { "John", "Emily", "Michael", "Jessica", "David", "Sarah", "Daniel",
            "Jennifer", "James", "Emma" };
    private static final String[] SURNAMES = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller",
            "Wilson", "Moore", "Taylor" };

    // for random numbers
    private static final int MIN_NUMBER = 1;

    public static void main(String[] args) {

        try {
            // CreateSalesMenFile
            String vendor_name = "John Cena";
            long id_name = 12345;
            createSalesMenFile(NUMBER_OF_SALES, vendor_name, id_name);

            // createProductsFile
            createProductsFile(NUMBER_OF_PRODUCTS);

            // createSalesManInfoFile
            createSalesManInfoFile(NUMBER_OF_SALES_MAN);

            System.err.println("Files generated successfully");

        } catch (IOException e) {
            System.err.println("Error generating files: " + e.getMessage());
        }

    }

    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {

        String fileName = name.replaceAll("\\s", "") + "_sales.txt";
        fileName = "files/" + fileName;

        try (FileWriter writer = new FileWriter(fileName)) {

            // First line
            String header = id + ";" + name;
            writer.write(header + System.lineSeparator());

            // Sales
            for (int i = 0; i < randomSalesCount; i++) {
                // Generate a random sale
                String sale = generateRandomSale();
                writer.write(sale + System.lineSeparator());
            }
        }
    }

    private static String generateRandomSale() {

        // Structure sales returned: IDProducto1;CantidadProducto1Vendido;
        int sale_id = getRandomNumber(100);
        int sale_sum = getRandomNumber(10);
        return sale_id + ";" + sale_sum;
    }

    public static void createProductsFile(int productsCount) throws IOException {
        String fileName = "products.txt";
        fileName = "files/" + fileName;

        try (FileWriter writer = new FileWriter(fileName)) {
            // Products
            for (int i = 0; i < productsCount; i++) {
                // Generate random sales
                String product = generateRandomProduct();
                writer.write(product + System.lineSeparator());
            }
        }
    }

    private static String generateRandomProduct() {
        // Structure product returned:
        // IDProducto1;NombreProducto1;PrecioPorUnidadProducto1
        int id_product = getRandomNumber(100);
        String name_product = PRODUCTS[getRandomNumber(PRODUCTS.length) - 1];
        int price_product = getRandomNumber(50000);
        return id_product + ";" + name_product + ";" + price_product;
    }

    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        String fileName = "vendors.txt";
        fileName = "files/" + fileName;

        try (FileWriter writer = new FileWriter(fileName)) {
            // Vendors
            for (int i = 0; i < salesmanCount; i++) {
                // Generate random salesMans
                String product = generateRandomSalesMan();
                writer.write(product + System.lineSeparator());
            }
        }
    }

    private static String generateRandomSalesMan() {
        // Structure salesman returned: TipoDocumento;NúmeroDocumento;NombresVendedor1;ApellidosVendedor1;
        String document_type = "1"; 
        int document_number = getRandomNumber(1000000000);
        String vendor_name = NAMES[getRandomNumber(NAMES.length) - 1];
        String vendor_lastname = SURNAMES[getRandomNumber(SURNAMES.length) - 1];

        return document_type + ";" + document_number + ";" + vendor_name + ";" + vendor_lastname;
    }

    private static int getRandomNumber(int max_number) {
        return (int) (Math.random() * (max_number - MIN_NUMBER + 1)) + MIN_NUMBER;
    }

}
