package S1_02_N1;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> productList;
    private int totalPrice;

    public Sale(){
        this.productList = new ArrayList<Product>();
        this.totalPrice = 0;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
    public void addProduct(Product newProduct){
        this.productList.add(newProduct);
    }
    public int getTotalPrice() {
        return this.totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }


    public void calcularTotal()throws EmptySaleException{
        //RunTimeException extended from OIException
        if(this.productList.size() == 0){
            throw new EmptySaleException("To sell you need to add products first");
        }else{
            for(Product i:productList){
                this.totalPrice += i.getPrice();
            }
        }
    }


    public void calcularTotal_MEJORADA(){
        try{
            if(this.productList.size() == 0){
                throw new EmptySaleException("No hay productos");
            }else{
                for(Product i:productList){
                    this.totalPrice += i.getPrice();
                }
                System.out.println("Total price: " + this.getTotalPrice());
            }
        }catch (EmptySaleException ese){
            System.out.println(ese.getMessage());
        }
    }
}
