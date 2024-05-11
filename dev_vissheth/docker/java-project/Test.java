import java.util.Properties;
class Test{
    public static void print(){
        System.out.println("In method...!");
        Properties props = System.getProperties();
        System.out.println(props);
    }
    public static void main(String args[]){
        System.out.println("Hello.... This is my first java docker project.");
        print();
    }
}