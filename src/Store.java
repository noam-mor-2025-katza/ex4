public class Store {
    private String storeName;
    private Product[] products;
    private int[] soldCount;
    private int productCount;

    public Store(String sn, int cap) {
        storeName = sn;
        products = new Product[cap];
        soldCount = new int[cap];
        productCount = 0;
    }

    public boolean addProduct(Product p) {
        if (p == null) {
            return false;
        }
        if (productCount == products.length) {
            return false;
        }
        if (findProductIndex(p.getId()) != -1) {
            return false;
        }
        products[productCount] = p;
        soldCount[productCount] = 0;
        productCount++;
        return true;
    }

    public int findProductIndex(int id) {
        int i = 0;
        int idx = -1;
        while (i < productCount) {
            if (products[i].getId() == id) {
                idx = i;
                break;
            }
            i++;
        }
        return idx;
    }

    public boolean sellProduct(int id, int q) {
        int idx = findProductIndex(id);
        if (idx == -1) {
            return false;
        }
        boolean ok = products[idx].sell(q);
        if (ok == true) {
            soldCount[idx] = soldCount[idx] + q;
            return true;
        }
        return false;
    }

    public void printAvailableProducts() {
        System.out.println("available products:");
        for (int i = 0; i < productCount; i++) {
            if (products[i].getStock() <= 0) {
                continue;
            }
            System.out.println(products[i].getInfo());
        }
    }

    public void printSalesReport() {
        System.out.println("sales report for " + storeName);
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].getName() + " sold: " + soldCount[i]);
        }
    }

    public int getTotalUnitsSold() {
        int sum = 0;
        for (int i = 0; i < productCount; i++) {
            sum = sum + soldCount[i];
        }
        return sum;
    }
}