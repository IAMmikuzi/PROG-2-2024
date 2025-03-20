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

    public static final double PIZZA_BASE_PRICE=10.0;

    private static final String[] pizzaOrdered=new String[10];
    private static final String[] pizzaSizeOrdered=new String[10];
    private static final String[] sideDishOrdered=new String[20];
    private static final String[] drinksOrdered=new String[20];
    int orderIndex=0;
    double totalorderPrice=0;
    Scanner input=new Scanner(System.in);


    enum PizzaSelection{
        PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
        HAWAIIAN("Hawaiian", "Pineapple, ham, and extra cheese", 22),
        VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
        BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
        EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);
        
        private final String pizzaName;
        private final String pizzaToppings;
        private final int price;

        PizzaSelection(String pizzaName,String pizzaToppings,int price){
            this.pizzaName=pizzaName;
            this.pizzaToppings=pizzaToppings;
            this.price=price;
        }
    

        public String getPizzaName(){
            return pizzaName;
        }

        public String getPizzaToppings(){
            return pizzaToppings;
        }

        public int getPrice(){
            return price;
        }

        @Override
        public String toString(){
            return"pizzaName:"+pizzaName+",pizzaToppings"+pizzaToppings+",price"+price;
        }
    }

    enum PizzaToppings{
        HAM("Ham", 2), 
        PEPPERONI("Pepperoni", 2),
        BEEF("Beef", 2),
        CHICKEN("Chicken", 2), 
        SAUSAGE("Sausage", 2),
        PINEAPPLE("Pineapple", 1),
        ONION("Onion", 0.5), 
        TOMATOES("Tomatoes", 0.4), 
        GREEN_PEPPER("Green Pepper", 0.5), 
        BLACK_OLIVES("Black Olives", 0.5), 
        SPINACH("Spinach", 0.5), 
        CHEDDAR_CHEESE("Cheddar Cheese", 0.8), 
        MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8), 
        FETA_CHEESE("Feta Cheese", 1), 
        PARMESAN_CHEESE("Parmesan Cheese", 1);

        private final String topping;
        private final double toppingPrice; 

        PizzaToppings(String topping,double toppingPrice){
            this.topping=topping;
            this.toppingPrice=toppingPrice;
        }

        public String getTopping(){
            return topping;
        }

        public double getToppingPrice(){
            return toppingPrice;
        }

        @Override
        public String toString(){
            return"topping:"+topping+",toppingPrice:"+toppingPrice;
        }
    }

    enum PizzaSize{
        LARGE("Large", 10), 
        MEDIUM("Medium", 5),
        SMALL("Small", 0);

        private final String pizzaSize;
        private final int addToPizzaPrice;

        PizzaSize(String pizzaSize,int addToPizzaPrice){
            this.pizzaSize=pizzaSize;
            this.addToPizzaPrice=addToPizzaPrice;
        }

        public String getpizzaSize(){
            return pizzaSize;
        }

        public int getaddToPizzaPrice(){
            return addToPizzaPrice;
        }

        @Override
        public String toString(){
            return"pizzaSide:"+pizzaSize+",addToPizzaPrice"+pizzaSize;
        }

    }

    enum SideDish{
        CALZONE("Calzone", 15), 
        CHICKEN_PUFF("Chicke Puff", 20),
        MUFFIN("Muffin", 12),
        NOTHING("No side dish", 0);

        private final String sideDishName;
        private final int addToPizzaPrice;

        SideDish(String sisdeDishName,int addToPizzaPrice){
            this.sideDishName=sisdeDishName;
            this.addToPizzaPrice=addToPizzaPrice;
        }

        public String getsideDishName(){
            return sideDishName;
        }

        public int getaddToPizzaPrice(){
            return addToPizzaPrice;
        }

        @Override
        public String toString(){
            return "sideDishName:"+sideDishName+",addToPizzaPrice:"+addToPizzaPrice;
        }
        }

    enum Drinks{
        COCA_COLA("Coca Cola", 8), 
        COCOA_DRINK("Cocoa Drink", 10),
        NOTHING("No drinks", 0);

        private final String drinkName;
        private final int addToPizzaPrice;
            
        Drinks(String drinkName,int addToPizzaPrice){
            this.drinkName=drinkName;
            this.addToPizzaPrice=addToPizzaPrice;           
        }

        public String getdrinkName(){
            return drinkName;
        }
        public int getaddToPizzaPrice(){
            return addToPizzaPrice;
        }
        
        @Override
        public String toString(){
            return "drinkName:"+drinkName+",addToPizzaPrice:"+addToPizzaPrice;
        }

    }
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
        int orderIndex=0;
        double totalorderPrice=0;
    
        while(true){

            System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here's what we serve:");
            PizzaSelection[] pizzaSelections=PizzaSelection.values();
            for(int i=0;i<pizzaSelections.length;i++){
                System.out.println((i+1)+"."+pizzaSelections[i].getPizzaName()+"with"+pizzaSelections[i].getPizzaToppings()+",for €"+pizzaSelections[i].getPrice());
            }
            System.out.println("6.Custom Pizza with a maximum of 10 toppings that you choose");
            System.out.println("Please enter your choice (1 - 6):");
            int choice=scanner.nextInt();

            if (choice>=1&& choice<=5) {
                totalorderPrice+=pizzaSelections[choice-1].getPrice();
            }
            else if(choice==6){
                System.out.println("Availble toppings: ");
                PizzaToppings[] toppings= PizzaToppings.values();

                for(int i =1;i<pizzaSelections.length;i++){
                    System.out.println((i+1)+"."+toppings[i].getTopping()+"€"+toppings[i].getToppingPrice());
                }
                double customPizzaPrice=PIZZA_BASE_PRICE;
                StringBuilder customPizzaDesc=new StringBuilder("Custom Pizza with");

                System.out.println("Please enter a maximum of 10 choices :");
                int numToppings=scanner.nextInt();

                if(numToppings>10||numToppings<1){
                    System.out.println("Invalid number of toppings");
                    continue;
                }
                for(int i=0;i<numToppings;i++){
                    System.out.println("Enter topping choice"+(i+1)+":");
                    int toppingChoice=scanner.nextInt();
                    if(toppingChoice<1||toppingChoice>toppings.length){
                        System.out.println("Invalid topping choice!");
                        i--; 
                        continue;
                    }
                    customPizzaPrice+=toppings[toppingChoice-1].getToppingPrice();
                    customPizzaDesc.append(toppings[toppingChoice-1].getTopping()).append(",");
                    
                }
                customPizzaDesc.setLength(customPizzaDesc.length()-2);
                customPizzaDesc.append(",for €").append(customPizzaPrice);
            }
            else{
                System.out.println("Invalid Choice");
                continue;
            }

            System.out.println("Choose Pizza Size:");
            PizzaSize[] sizes=PizzaSize.values();
            for(int i=0;i<sizes.length;i++){
                System.out.println((i+1)+"."+sizes[i].getpizzaSize()+"€"+sizes[i].getaddToPizzaPrice());
            }
            int sizeChoice=scanner.nextInt();

            pizzaSizeOrdered[orderIndex]=sizes[sizeChoice-1].getpizzaSize();
            totalorderPrice+=sizes[sizeChoice-1].getaddToPizzaPrice();


            System.out.println("Choose side dish:");
            SideDish[] sideDishes=SideDish.values();
            for(int i=0;i<sideDishes.length;i++){
                System.out.println((i+1)+"."+sideDishes[i].getsideDishName()+"€"+sideDishes[i].getaddToPizzaPrice());
            }
            int sideDishChoice=scanner.nextInt();

            sideDishOrdered[orderIndex]=sideDishes[sideDishChoice-1].getsideDishName();
            totalorderPrice+=sideDishes[sideDishChoice-1].getaddToPizzaPrice();


            System.out.println("Choose drinks:");
            Drinks[] drinks=Drinks.values();
            for(int i=0;i<drinks.length;i++){
                System.out.println((i+1)+"."+drinks[i].getdrinkName()+"€"+drinks[i].getaddToPizzaPrice());
            }
            int drinkChoice=scanner.nextInt();

            drinksOrdered[orderIndex]=drinks[drinkChoice-1].getdrinkName();
            totalorderPrice+=drinks[drinkChoice-1].getaddToPizzaPrice();
            orderIndex++;

            System.out.println("Do you want to order more?(Y/N)");
            String morechoice=scanner.nextLine();
            if(!morechoice.equalsIgnoreCase("Y")){
                break;
            } 
            
            System.out.println("Do you want to have a discount?");
            wantDiscount=input.nextLine();
            if(wantDiscount.equals("Y")){
                isItYourBirthday();
            }

            makeCardPayment();
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
