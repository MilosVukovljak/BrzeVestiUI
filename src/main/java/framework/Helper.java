package framework;

public class Helper {
     
    public static String getRandomText() {
        return "Milos-" + getRandomInteger();
    }
     
    private static int getRandomInteger() {
        return (int) (Math.random() * 1000);
    }
    public static String getRandomEmail(){
        return "milos" + getRandomInteger() + "@gmail.com";
    }
    public static String getRandomUrl(){
        return "www" + getRandomText() + ".com";
    }
}
