public class Main {
    public static void main(String[] args) {
        Store st = new Store("my store", 3);

        Product p1 = new Product("Notebook", 12.5, 3);
        Product p2 = new Product("Pen", 4.0, 2);
        Product p3 = new Product("Bottle", 30.0, 0);

        System.out.println("add p1: " + st.addProduct(p1));
        System.out.println("add p2: " + st.addProduct(p2));
        System.out.println("add p3: " + st.addProduct(p3));

        Product p4 = new Product("Pencil", 2.0, 5);
        System.out.println("add p4: " + st.addProduct(p4));

        System.out.println("sell 2 notebook: " + st.sellProduct(p1.getId(), 2));
        System.out.println("sell 3 pen: " + st.sellProduct(p2.getId(), 3));
        System.out.println("sell 2 pen: " + st.sellProduct(p2.getId(), 2));

        System.out.println("set price -5: " + p1.setPrice(-5));
        System.out.println("notebook price now: " + p1.getPrice());

        st.printAvailableProducts();
        st.printSalesReport();
        System.out.println("total sold: " + st.getTotalUnitsSold());

        System.out.println("ids: " + p1.getId() + " " + p2.getId() + " " + p3.getId() + " " + p4.getId());
        System.out.println("next id: " + Product.getNextId());
    }
}