import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {

            // Generate Sales Report
            /**
             * TODO: Review this integration
             * This function generates the files fine, 
             * but there is only one salesperson left in the report, 
             * because the file generation class only generates pseudo sales 
             * for a single salesperson
            */
            generateSalesReport();

            // Generate Product Sales Report
            generateProductSalesReport();

            System.out.println("Archivos de reporte generados exitosamente.");
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
            System.err.println("Error al generar archivos de reporte: " + e.getMessage());
        }
    }

    // Generate Sales Report
    private static void generateSalesReport() throws IOException {
        Map<String, Integer> salesMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("files/vendors.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String vendorName = parts[2] + " " + parts[3];
                salesMap.put(vendorName, 0);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader("files/sales.txt"))) {
            String line;
            boolean isFirstLine = false;
            String vendorName="";
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if(!isFirstLine){
                    vendorName = parts[1];
                    isFirstLine = true;
                }else{
                    int saleAmount = Integer.parseInt(parts[0]);
                    salesMap.put(vendorName, salesMap.getOrDefault(vendorName, 0) + saleAmount);
                }
            }
        }

        List<Map.Entry<String, Integer>> sortedSales = new ArrayList<>(salesMap.entrySet());
        sortedSales.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        try (FileWriter writer = new FileWriter("files/sales_report.csv")) {
            for (Map.Entry<String, Integer> entry : sortedSales) {
                writer.write(entry.getKey() + ";" + entry.getValue() + System.lineSeparator());
            }
        }
    }

    // Generate Product Sales Report
    private static void generateProductSalesReport() throws IOException {
        Map<String, Integer> productSalesMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("files/products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String productName = parts[1];
                int productPrice = Integer.parseInt(parts[2]);
                productSalesMap.put(productName, productPrice);
            }
        }

        List<Map.Entry<String, Integer>> sortedProducts = new ArrayList<>(productSalesMap.entrySet());
        sortedProducts.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        try (FileWriter writer = new FileWriter("files/product_sales_report.csv")) {
            for (Map.Entry<String, Integer> entry : sortedProducts) {
                writer.write(entry.getKey() + ";" + entry.getValue() + System.lineSeparator());
            }
        }
    }
}