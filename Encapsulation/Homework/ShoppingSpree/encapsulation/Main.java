package encapsulation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        List<Person> personList = new LinkedList<>();
        List<Product> products = new LinkedList<>();

        try {

        getPersons(bfr, personList);

        getProducts(bfr, products);

        String command = bfr.readLine();
        while (!command.equals("END")) {

            String[] tokens = command.split(" ");
            String name = tokens[0];
            String productName = tokens[1];

            for (Person person : personList) {
                if (person.getName().equals(name)) {
                    for (Product product : products) {
                        if (product.getProductName().equals(productName)){
                            person.buyProduct(new Product(product.getProductName(), product.getCost()));
                        }
                    }
                }
            }

            command = bfr.readLine();
        }

            for (Person person : personList) {
                System.out.println(person);
            }


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }




    private static void getPersons(BufferedReader bfr, List<Person> personList) throws IOException {
        String personInfo = bfr.readLine();
        if (personInfo.contains(";")) {
            String[] personTokens = personInfo.split(";");
            String[] firstPerson = personTokens[0].split("=");
            String person1 = firstPerson[0];
            double money1 = Double.parseDouble(firstPerson[1]);

            Person personF = new Person(person1, money1);
            personList.add(personF);

            String[] secondPerson = personTokens[1].split("=");
            String person2 = secondPerson[0];
            double money2 = Double.parseDouble(secondPerson[1]);
            Person personS = new Person(person2,money2);
            personList.add(personS);
        }else {
            String[] tokens = personInfo.split("=");
            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);
            Person person = new Person(name,money);
            personList.add(person);
        }
    }

    private static void getProducts(BufferedReader bfr, List<Product> products) throws IOException {
        String productInfo = bfr.readLine();
        if (productInfo.contains(";")) {
            String[] productTokens = productInfo.split(";");
            String[] firstProduct = productTokens[0].split("=");
            String product1 = firstProduct[0];
            double cost1 = Double.parseDouble(firstProduct[1]);

            Product productF = new Product(product1,cost1);
            products.add(productF);

            String[] secondProduct = productTokens[1].split("=");
            String product2 = secondProduct[0];
            double cost2 = Double.parseDouble(secondProduct[1]);
            Product productS = new Product(product2,cost2);
            products.add(productS);
        }else {
            String[] tokens = productInfo.split("=");
            String name = tokens[0];
            double cost = Double.parseDouble(tokens[1]);
            Product product = new Product(name,cost);
            products.add(product);
        }
    }
}
