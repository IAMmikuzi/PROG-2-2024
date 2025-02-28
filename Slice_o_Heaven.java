public class Slice_o_Heaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public double pizzaPrice;
    public int sides;
    public String drinks;
    private String orderID;
    public String orderDetail;
    private double orderTotal;

    final String DEF_ORDER_ID="DEF-SOH-099";
    final String DEF_PIZZA_INGREDIENTS="Mozzarella Cheese";
    final double DEF_ORDER_TOTAL=15.00;


    public Slice_o_Heaven(){
        orderID=DEF_ORDER_ID;
        pizzaIngredients=DEF_PIZZA_INGREDIENTS;
        orderTotal=DEF_ORDER_TOTAL;
    }
    public Slice_o_Heaven(String orderID,String pizzaIngredients,double orderTotal){
        this.orderID=orderID;
        this.pizzaIngredients=pizzaIngredients;
        this.orderTotal=orderTotal;
    }
    public String getOrderID(){
        return orderID;
    }
    public void setOrderID(String orderID){
        this.orderID=orderID;
    }
    public String getPizzaIngredients(){
        return pizzaIngredients;
    }
    public void setPizzaIngredients(String pizzaIngredients){
        this.pizzaIngredients=pizzaIngredients;
    }
    public double getOrderTotal(){
        return orderTotal;
    }
    public void setOrderTotal(double orderTotal){
        this.orderTotal=orderTotal;
    }
    public void takeOrder(){
        System.out.println("Order accepted!");
        System.out.println("Order is being prepared!");
        makePizza();
        printReceipt();
    }
    private void makePizza(){
        System.out.println("Your pizza is making!");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println("Pizza is ready for pickup!");
        }
    }
    private void printReceipt(){
        
        System.out.println("Your order is ready!");
        System.out.println("Order ID: "+orderID);
        System.out.println("Order detail: "+pizzaIngredients);
        System.out.println("Order Total: "+orderTotal);
    }

    public void processCardPayment(String cardNumber ,String expiryDate,int cvv){

        int cardLenth=cardNumber.length();
        if(cardLenth==14){
            System.out.println("Card accepted");
        }
        else{
            System.out.println("Invalid card");
        }

        int firstCardDigit=Integer.parseInt(cardNumber.substring(0, 1));

        String blacklistedNumber="12345678910111";
        if(cardNumber.equals(blacklistedNumber)){
            System.out.println("”Card is blacklisted. Please use another card");
        }

        int lastFourDigits=Integer.parseInt(cardNumber.substring(11, 14));

        String cardNumberToDisplay=firstCardDigit+"*********"+lastFourDigits;
        System.out.println("displayable cardNumber:"+cardNumberToDisplay);

    }

    public void specialOfTheDay(String pizzaOfTheDay,String sideOfTheDay,String specialPrice){
        StringBuilder sb = new StringBuilder();
        sb.append("Today Special:");
        sb.append("Today Pizza:").append(pizzaOfTheDay).append("\n");
        sb.append("Today Side:").append(sideOfTheDay).append("\n");
        sb.append("Today price:").append(specialPrice).append("\n");
        
        System.out.println(sb.toString());
    }

}