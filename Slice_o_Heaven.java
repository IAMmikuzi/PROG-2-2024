import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

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

    private String ing1,ing2,ing3;
    private String pizzaSize;
    private String extraCheese;
    private String sideDish;
    private String wantDiscount;
    private LocalDate birthDate;
    private long cardNumber;
    private int cvv;
    private String expiryDate;

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

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String[]ingredients=scanner.nextLine().split("");
        ing1=ingredients[0];
        ing2=ingredients[1];
        ing3=ingredients[2];

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        pizzaSize=scanner.nextLine();

        System.out.println("Do you want extra cheese (Y/N):");
        extraCheese=scanner.nextLine();

        System.out.println("”Enter one side dish (Calzone, Garlic bread, None):");
        sideDish=scanner.nextLine();

        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        drinks=scanner.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        wantDiscount=scanner.nextLine();

        if(wantDiscount.equalsIgnoreCase("Y")){
            isItYourBirthday();
        }
        else{
            makeCardPayment();
        }

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

    public void processCardPayment(long cardNumber ,String expiryDate,int cvv){

        String cardNumberStr=Long.toString(cardNumber);
        
        if(cardNumberStr.length()==14){
            System.out.println("Card accepted");
        }
        else{
            System.out.println("Invalid card");
        }

        long firstCardDigit=Long.parseLong(cardNumberStr.substring(0, 1)); 

        String blacklistedNumber="12345678910111";
        if(cardNumberStr.equals(blacklistedNumber)){
            System.out.println("”Card is blacklisted. Please use another card");
        }

        int lastFourDigits=Integer.parseInt(cardNumberStr.substring(cardNumberStr.length()-4));

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

    public void isItYourBirthday(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your birthday(formart:yyyy-mm-dd):");
        String birthDateStr=scanner.nextLine();
        birthDate=LocalDate.parse(birthDateStr);

        LocalDate now=LocalDate.now();
        Period period=Period.between(birthDate, now);
        int age=period.getYears();

        if(age<18&&birthDate.getDayOfYear()==now.getDayOfYear()){
            System.out.println(" Congratulations! You pay only half the price for your order");
            orderTotal=orderTotal/2;
        }
        else{
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
        }
    }

    public void makeCardPayment(){
        Scanner scanner=new Scanner(System.in);

        System.out.println("Entern your cardNumber:");
        cardNumber=scanner.nextLong();

        System.out.println("Enter the expiry date(formart:yyyy-mm-dd)");
        expiryDate=scanner.nextLine();

        System.out.println("Enter the card's cvv");
        cvv=scanner.nextInt();
    

        processCardPayment(cardNumber, expiryDate, cvv);

    }
    
    

}