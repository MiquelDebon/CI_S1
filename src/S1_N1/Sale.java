package S1_N1;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> productList;
    private int totalPrice;

    public Sale(){
        this.productList = new ArrayList<>();
        this.totalPrice = 0;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer calcularTotal()throws EmptySaleException{
        //RunTimeException extended from OIException
        int total=0;
        if(this.getProductList().size()==0){
            throw new EmptySaleException("Epa Sales is empty");
        }else{
            for(Product i:productList){
                total+=i.getPrice();
            }
        }
        return total;
    }
}
