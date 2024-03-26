public class GenerateInfoFiles {

    private int NUMBER_OF_SALES = 50;
    private int NUMBER_OF_PRODUCTS = 50;
    private int NUMBER_OF_SALES_MAN = 50;

    // for random numbers
    private int MIN_NUMBER = 1;
    private int MAX_NUMBER = 100;

    public static void main(String[] args) {

        //vendor
        String vendor_name = "Jhon Cena";
        long id_name = 12345;
        int rows_to_generate = getRandomNumber();

        createSalesMenFile(rows_to_generate,vendor_name, id_name);
    }

    public boolean createSalesMenFile(int randomSalesCount, String name, long id) {
        return true;
    }

    public boolean createProductsFile(int productsCount) {
        return true;
    }

    public boolean createSalesManInfoFile(int salesmanCount) {
        return true;
    }

    private long getRandomNumber() {
        return (long) (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1)) + MIN_NUMBER;
    }

}
