package framework;

public class Helper {
     
    public static String getRandomText() {
        return "Example-" + getRandomInteger();
    }
     
    private static int getRandomInteger() {
        return (int) (Math.random() * 1000);
    }
    public static String getRandomEmail(){
        return "example" + getRandomInteger() + "@gmail.com";
    }
    public static String getRandomUrl(){
        return "https://www" + getRandomText() + ".com";
    }
}
