public class Product {
    
    private String name;
    private int quantity;
    
    public String getName() {
        return this.name;
    }
    
    private void setName(String name) {
        this.name = name;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        if (quantity < 1) {
            this.quantity = 1;
        } else {
            this.quantity = quantity;
        }
    }
    
    public Product(String name) {
        

        
        this.name = name;
        this.quantity = 1;
    }
}