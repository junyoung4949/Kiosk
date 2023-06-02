import java.util.ArrayList;

public class Cart {
    private final ArrayList<Product> pdCt = new ArrayList<Product>();

    public ArrayList<Product> getPdCt() {
        return pdCt;
    }

    public void add(Product product) {
        pdCt.add(product);

    }
}
