package Main;

import java.util.Scanner;

public class User {
    private String name;
    private int yearOfJoining;
    private String companyName;
    private String password;
    private String email;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getyearOfJoining() {
        return yearOfJoining;
    }
    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, int yearOfJoining, String companyName) {
        this.name = name;
        this.yearOfJoining = yearOfJoining;
        this.companyName = companyName;
        this.password=getPassword();
        this.email=getEmail();
    }

    public String crateEmail(){
        return String.format("%s%d@%s.com",getName().toLowerCase(),getyearOfJoining(),getCompanyName().toLowerCase());
    }

    public String getFirstFiveLettersofName(){
        if (getName().length()<5){
            int diffrence=5-getName().length();
            return (getName()+"0".repeat(diffrence)).toLowerCase();
        }
        else{
            return getName().substring(0,5);
        }
    }

    private static int generaterandomInteger(int limit){
        return (int)(Math.random()*limit);
    }

    private static char generateRandomCharacter(){
        int randomNumber = generaterandomInteger(26);
        return (char) ('a'+randomNumber);
    }
    private char generatesSprcialSymbol(){
        char[] arr = {'!','@','#','$','%','&','~','?'};
        return arr[generaterandomInteger(arr.length)];

    }
    public String createPassword(){
        StringBuilder sb = new StringBuilder();
        sb.append(generateRandomCharacter());
        for (int i = 0; i < 5; i++) {
            sb.append(generaterandomInteger(10));
        }
        sb.append(getFirstFiveLettersofName());
        sb.append(generatesSprcialSymbol());
        return sb.toString();
    }

}
class MyClass{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine().trim();
        System.out.println("Enter your Company name");
        String companyName = scanner.nextLine().trim();
        System.out.println("Enter your year of joining");
        int yearOfJoining = scanner.nextInt();
        User user = new User(name,yearOfJoining,companyName);
        System.out.println("Email ID is : " + user.crateEmail());
        System.out.println("Your Password is : " + user.createPassword());
    }
}