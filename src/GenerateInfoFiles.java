import java.io.FileWriter;
import java.io.IOException;

public class GenerateInfoFiles {

    private static final int NUMBER_OF_SALES = 50;
    private static final int NUMBER_OF_PRODUCTS = 50;
    private static final int NUMBER_OF_SALES_MAN = 50;

    // for random numbers
    private static final int MIN_NUMBER = 1;

    public static void main(String[] args) {

        try {
            // CreateSalesMenFile
            String vendor_name = "John Cena";
            long id_name = 12345;
            createSalesMenFile(NUMBER_OF_SALES, vendor_name, id_name);

            // createProductsFile

            // createSalesManInfoFile

            System.err.println("Archivos generados correctamente");

        } catch (IOException e) {
            System.err.println("Error al generar archivos: " + e.getMessage());
        }

    }

    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {

        String fileName = name.replaceAll("\\s", "") + "_sales.txt";
        fileName = "files/" + fileName;

        try (FileWriter writer = new FileWriter(fileName)) {

            // First line
            String header = id + ";" + name;
            writer.write(header + System.lineSeparator());

            // Products
            for (int i = 0; i < randomSalesCount; i++) {
                // generate random sales
                String sale = generateRandomSale();
                writer.write(sale + System.lineSeparator());
            }
        }
    }

    private static String generateRandomSale() {

        // Structure sale returned: IDProducto1;CantidadProducto1Vendido;
        int sale_id = getRandomNumber(100);
        int sale_sum = getRandomNumber(10);
        return sale_id + ";" + sale_sum;
    }

    public static boolean createProductsFile(int productsCount) {
        return true;
    }

    public static boolean createSalesManInfoFile(int salesmanCount) {
        return true;
    }

    private static int getRandomNumber(int max_number) {
        return (int) (Math.random() * (max_number - MIN_NUMBER + 1)) + MIN_NUMBER;
    }

}
