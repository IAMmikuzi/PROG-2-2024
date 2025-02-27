public class App {
    public static void main(String[] args) throws Exception {
        Slice_o_Heaven pizza1=new Slice_o_Heaven();
        pizza1.takeOrder();
        Slice_o_Heaven pizza2=new Slice_o_Heaven("DEF-SOH-100","Cheese Pizza",20.00);
        pizza2.takeOrder();
    }
}
