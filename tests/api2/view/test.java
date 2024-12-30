package tests.api2.view;

public class test {

    //ex4
    public static void display(String data){
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        for(int i = 0;i < data.length();i++){
            if(i %2 == 0){
                line1.append(data.charAt(i));
            }else{
                line2.append(data.charAt(i));

            }
        }
        System.out.println(line1);
        System.out.println(line2);
    }
    public static void main(String[] args) {
        
    }
}
