public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private static int nextId = 1000;

    public Product(String n, double p, int s) {
        id = nextId;
        nextId++;
        if (n == null || n.trim().equals("")) {
            name = "unknown";
        } else {
            name = n.trim();
        }
        if (p <= 0) {
            price = 1.0;
        } else {
            price = p;
        }
        if (s < 0) {
            stock = 0;
        } else {
            stock = s;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean setName(String n) {
        if (n == null || n.trim().equals("")) {
            return false;
        }
        name = n.trim();
        return true;
    }

    public boolean setPrice(double p) {
        if (p <= 0) {
            return false;
        }
        price = p;
        return true;
    }

    public boolean setStock(int s) {
        if (s < 0) {
            return false;
        }
        stock = s;
        return true;
    }

    public boolean sell(int q) {
        if (q <= 0 || q > stock) {
            return false;
        }
        stock = stock - q;
        return true;
    }

    public String getInfo() {
        return "id: " + id + " name: " + name + " price: " + price + " stock: " + stock;
    }

    public static int getNextId() {
        return nextId;
    }
}