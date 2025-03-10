import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Slice_o_Heaven {
     /*store information*/
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;
    /*pizza infotmation*/
    public String pizzaIngredients;
    public double pizzaPrice;
    public int sides;
    public String drinks;
    /*order information*/
    private String orderID;
    public String orderDetail;
    private double orderTotal;
    /*extra information*/
    private String ing1,ing2,ing3;
    private String pizzaSize;
    private String extraCheese;
    private String sideDish;
    private String wantDiscount;
    private LocalDate birthDate;
    private long cardNumber;
    private int cvv;
    private String expiryDate;
    private static final String blacklistedNumber="12345678912345";

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
        while (true) {
            System.out.println("Please pick any three of the following ingredients:");
            System.out.println("1. Mushroom");
            System.out.println("2. Paprika");
            System.out.println("3. Sun-dried tomatoes");
            System.out.println("4. Chicken");
            System.out.println("5. Pineapple");
            System.out.println("Enter any three choices (1, 2, 3,…) separated by spaces:");
        
            try{
                int ingChoice1=scanner.nextInt();
                int ingChoice2=scanner.nextInt();
                int ingChoice3=scanner.nextInt();
                if(isValidChoice(ingChoice1)&&isValidChoice(ingChoice2)&&isValidChoice(ingChoice3)){
                    ing1=convertChoiceToIngredients(ingChoice1);
                    ing2=convertChoiceToIngredients(ingChoice2);
                    ing3=convertChoiceToIngredients(ingChoice3);
                    break;
                }else{
                System.out.println("Invalid choice(s). Please pick only from the given list:");
                scanner.nextLine();
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input(s).Please enter valid numbers");
                scanner.nextLine();
            } 
        }
        

        while (true) {
            System.out.println("What size should your pizza be?");
            System.out.println("1. Large");
            System.out.println("2. Medium");
            System.out.println("3. Small");
            System.out.println("Enter only one choice (1, 2, or 3):");
            try{
                int sizeChoice=scanner.nextInt();
                if (isValidSizeChoice(sizeChoice)) {
                    pizzaSize=convertSizeChoiceToSize(sizeChoice);
                    break;
                }
                else{
                    System.out.println("Invalid choice(s). Please pick only from the given size");
                    scanner.nextInt();
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input(s).Please enter valid numbers");
                scanner.nextInt();
            }
        }


        System.out.println("Do you want extra cheese (Y/N):");
        extraCheese=scanner.nextLine();


        while (true) {
            System.out.println("Following are the side dish that go well with your pizza:");
            System.out.println("1. Calzone");
            System.out.println("2. Garlic bread");
            System.out.println("3. Chicken puff");
            System.out.println("4. Muffin");
            System.out.println("5. Nothing for me");
            System.out.println("What would you like? Pick one (1, 2, 3,…):");
            try{
                int sideDishChoice=scanner.nextInt();
                if (isValidSideDishChoice(sideDishChoice)) {
                    sideDish=convertSideDishChoiceToSideDish(sideDishChoice);
                    break;
                }
                else{
                    System.out.println("Invalid choice(s). Please pick only from the given side dish");
                    scanner.nextInt();
                }
            }
            catch(InputMismatchException e){
                System.out.println("c");
                scanner.nextLine();
            }
        }


        while (true) {
            System.out.println("”Choose from one of the drinks below. We recommend Coca Cola:");
            System.out.println("1. Coca Cola");
            System.out.println("2. Cold coffee");
            System.out.println("3. Cocoa Drink");
            System.out.println("4. No drinks for me");
            System.out.println("Enter your choice:");
            try{
                int drinkChoice=scanner.nextInt();
                if (isValidDrinkChoice(drinkChoice)) {
                    drinks=convertDrinkChoiceToDrink(drinkChoice);
                    break;
                }
                else{
                    System.out.println("Invalid choice(s). Please pick only from the given drinks");
                    scanner.nextInt();
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid choice(s). Please pick only from the given side dish");
                scanner.nextInt();
            }
            
        }

        
        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        wantDiscount=scanner.nextLine();
    }


        private boolean isValidChoice(int choice){
            return choice >=1 && choice<=5;
            
        }
        private String convertChoiceToIngredients(int choice) {
            switch (choice) {
                case 1:
                    return "Mushroom";
                case 2:
                    return "Paprika";
                case 3:
                    return "Sun - dried tomatoes";
                case 4:
                    return "Chicken";
                case 5:
                    return "Pineapple";
                default:
                    return "";
            }
        }
    
        private boolean isValidSizeChoice(int choice) {
            return choice >= 1 && choice <= 3;
        }
    
        private String convertSizeChoiceToSize(int choice) {
            switch (choice) {
                case 1:
                    return "Large";
                case 2:
                    return "Medium";
                case 3:
                    return "Small";
                default:
                    return "";
            }
        }
    
        private boolean isValidSideDishChoice(int choice) {
            return choice >= 1 && choice <= 5;
        }
    
        private String convertSideDishChoiceToSideDish(int choice) {
            switch (choice) {
                case 1:
                    return "Calzone";
                case 2:
                    return "Garlic bread";
                case 3:
                    return "Chicken puff";
                case 4:
                    return "Muffin";
                case 5:
                    return "Nothing for me";
                default:
                    return "";
            }
        }
    
        private boolean isValidDrinkChoice(int choice) {
            return choice >= 1 && choice <= 4;
    }
    
        private String convertDrinkChoiceToDrink(int choice) {
            switch (choice) {
                case 1:
                    return "Coca Cola";
                case 2:
                    return "Cold coffee";
                case 3:
                    return "Cocoa Drink";
                case 4:
                    return "No drinks for me";
                default:
                    return "";
            }
        }
    
    

    private void makePizza(){
        System.out.println("Your pizza is making!");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println("Pizza is ready for pickup!");
        }
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Your order is ready!");
        sb.append("Order ID: ").append(orderID).append("\n");
        sb.append("Order detail:").append(pizzaIngredients).append("\n");
        sb.append("Order Total:").append(orderTotal).append("\n");
        return sb.toString();

    }

    public void processCardPayment(String cardNumber ,String expiryDate,int cvv){
        Scanner scanner=new Scanner(System.in);
        String cardNumberStr;
        do{
            System.out.println("Please enter your card number:");
            cardNumberStr=scanner.nextLine();
            if(cardNumberStr.length()==14){
            System.out.println("Card accepted");
            continue;
        }
            if(cardNumberStr.equals(blacklistedNumber)){
                System.out.println("”Card is blacklisted. Please use another card");
        }
            System.out.println("Card Accepted!");
            long firstCardDigit=Long.parseLong(cardNumberStr.substring(0, 1)); 

        String blacklistedNumber="12345678910111";
        if(cardNumber.equals(blacklistedNumber)){
            System.out.println("”Card is blacklisted. Please use another card");
        }

            int lastFourDigits=Integer.parseInt(cardNumberStr.substring(cardNumberStr.length()-4));

        String cardNumberToDisplay=firstCardDigit+"*********"+lastFourDigits;
        System.out.println("displayable cardNumber:"+cardNumberToDisplay);
        }
        while(cardNumberStr.length()!=14||cardNumberStr.equals(blacklistedNumber));
        
            scanner.close();

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
        LocalDate now=LocalDate.now();
        while(true){
            System.out.println("Enter your birthday(formart:yyyy-mm-dd):"); 
            String birthDateStr=scanner.nextLine();
            try{
                birthDate=LocalDate.parse(birthDateStr);
                if (now.minusYears(5).isAfter(birthDate)||now.minusYears(120).isBefore(birthDate)) {
                    System.out.println("Invalid date. You are either too young or too dead to order. Please enter a valid date:");
                }
                else{
                    break;
                }
            }
            catch(Exception e){
                System.out.println("Invalid format");
            }
        }

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
        LocalDate now =LocalDate.now();

        while (true) {
            System.out.println("Enter your birthday(formart:yyyy-mm-dd)");
            expiryDate=scanner.nextLine();
            try{
                LocalDate inpuDate=LocalDate.parse(expiryDate);
                if (inpuDate.isBefore(now)) {
                    System.out.println("Invalid date!Please enter a future date:");
                }
                else{
                    break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid format!");
            }
        }

        System.out.println("Entern your cardNumber:");
        cardNumber=scanner.nextLong();

        System.out.println("Enter the expiry date(formart:yyyy-mm-dd)");
        expiryDate=scanner.nextLine();

        System.out.println("Enter the card's cvv");
        cvv=scanner.nextInt();
    }
}