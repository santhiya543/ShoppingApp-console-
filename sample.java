import java.util.Scanner;
import java.nio.file.*;
import java.io.*;  
import java.util.*;

class sample {
    public static void main(String args[]) {
        System.out.println("***************************************");
        System.out.println("*                                     *");
        System.out.println("*                                     *");
        System.out.println("*             ZMART                   *");
        System.out.println("*                                     *");
        System.out.println("*                                     *");
        System.out.println("***************************************");
        Entrance obj = new Entrance();
        obj.findEntrance();
        Product product=new Product();
        product.showlist();
    }
}


class Entrance {
    Scanner getInput = new Scanner(System.in);
    
    void findEntrance() {
        System.out.println("***************************************");
        System.out.println("*                                     *");
        System.out.println("*                                     *");
        System.out.println("*         1. Login                    *");
        System.out.println("*         2. Create new account       *");
        System.out.println("*                                     *");
        System.out.println("*                                     *");
        System.out.println("***************************************");
        int choice = getInput.nextInt();
        if (choice == 1) {
            System.out.println("``````````````````````````````````````");
            System.out.println("`                                    `");
            System.out.println("`         Login selected             `");
            System.out.println("`                                    `");
            System.out.println("``````````````````````````````````````");
            login();
        }
         else {
            System.out.println("``````````````````````````````````````");
            System.out.println("`                                    `");
            System.out.println("`                                    `");
            System.out.println("`        Sign Up selected            `");
            System.out.println("`                                    `");
            System.out.println("`                                    `");
            System.out.println("``````````````````````````````````````");
            //System.out.println("New account creation selected");
            newAccount();
        }
    }
    void login() {
        System.out.println("Enter the username");
        String name = getInput.next();
        System.out.println("Enter the password");
        String password = getInput.next();
        String fileName = name + ".txt";
        
        try {
            Scanner fileReader = new Scanner(new File(fileName));
            storedName = fileReader.nextLine();
            String storedPassword = fileReader.nextLine();
            fileReader.close();
            if (storedName.equals(name) && storedPassword.equals(password)) {
               System.out.println("============================================");
               System.out.println("==                                        ==");
               System.out.println("==            Login successful            ==");
               System.out.println("==                                        ==");
               System.out.println("============================================");
    
               System.out.println("============================================");
               System.out.println("==                                        ==");
               System.out.println("==             WELCOME "+name+"           ==");
               System.out.println("==                                        ==");
               System.out.println("============================================");
            } 
            else {
               System.out.println("============================================");
               System.out.println("==                                        ==");
               System.out.println("==   User Name && Password Missmatched    ==");
               System.out.println("==                                        ==");
               System.out.println("============================================");
                newAccount();
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("User not found. Please create an account.");
            findEntrance();
        }
    }
    static String storedName;
    static String getName(){
        return storedName;
    }
    void newAccount() {
        System.out.println("Enter the username");
        String name = getInput.next();
        System.out.println("Enter the password");
        String password = getInput.next();
        System.out.println("Enter the Mobile Number");
        String phNumber = getInput.next();
        System.out.println("Enter the Address Number");
        String address = getInput.next();
        String fileName = name + ".txt";
        try {
            FileWriter userFile = new FileWriter(fileName,true);
            userFile.write(name + "\n" + password+"\n"+phNumber+"\n"+address);
            userFile.close();
               System.out.println("============================================");
               System.out.println("==                                        ==");
               System.out.println("==      Account created successfully      ==");
               System.out.println("==                                        ==");
               System.out.println("============================================");
            login();
        } catch (IOException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }
    }
}

class Product{
Scanner getInput = new Scanner(System.in);
 float rating;
 void setPrice(float price){
   this.price=price;
 }
 void setRating(float rating){
   this.rating=rating;
 }
 float getRating(){
   return rating;
 }
 static float price;
 static float getPrice(){
   return price;
 }
 void showlist(){
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||             1.Search product                   ||");
  System.out.println("||             2.Product view                     ||");
  System.out.println("||             3.Profile                          ||");
  System.out.println("||             4.OrderList                        ||");
  System.out.println("||             5.WishList                         ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
  switch(choice) {
  case 1:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==        Search product selected         ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    System.out.println();
    System.out.println("Enter the product name");
    getInput.nextLine();
    String name = getInput.nextLine();
    Category call=new Category();
    
    String[] six={"T-shirt","Shirt","Ethnic Wear","Combo sets"};
    
  String[] five={"Pant","Track-pant","veshti","Lungi","Frock","Chudi","Skirt","Saree","Jeans","Tops","SkyBag","WildCraft","American","Gucci","Louis","Puma","Nike","Sparex","Nivia","Adidas"};
  String[] four={"Apple","Banana","Mango","Grapes","Orange","Milk","Eggs","Yogurt","Butter","Potato","Brinjal","Carrot","Beans","Cabbage"};
  String[] three={"Casio","Titan","Timex","Vacheron","Rolex","Dell","Asus","Mac","Gold","Lenova","Acer","Sliver","Platinum","Samsung","apple","Vivo","Redmi","Realme","Thiller","Romatic","Adventure","Fantasy","Fiction","Boat","JBC","Onemore","AKG","Sony","Canon","Nikon","Sonic","Red"};
     name=name.toLowerCase();
     if((Arrays.toString(six).toLowerCase()).contains(name)){
       call.findCategory(searchproduct(six,name),1);
     }
     else if((Arrays.toString(five).toLowerCase()).contains(name)){
       call.findCategory(searchproduct(five,name),2);
     }
     else if((Arrays.toString(four).toLowerCase()).contains(name)){
       call.findCategory(searchproduct(four,name),3);
     }
     else if((Arrays.toString(three).toLowerCase()).contains(name)){
       call.findCategory(searchproduct(three,name),4);
     }
     else{
       System.out.println("This product is not avabile");
     }
     System.out.println("Will you want to Continue shopping (y/n)");
     String yORn = getInput.next();
     if(yORn.equals("y")){
      System.out.println("Th");
      showlist();
     }
     else{
       System.out.println("Thank you");
       System.exit(0);
     }
    break;
  case 2:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==         Product view selected          ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    Category categories=new Category();
    categories.showCategory();
    break;
  case 3:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==            Profile selected            ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    System.out.println();
    System.out.println("1.Edit your profile");
    System.out.println("2.View your profile");
    int isEdit = getInput.nextInt();
    if(isEdit==1){
     System.out.println("Enter the Phone Number");
     String phNumber = getInput.next();
     System.out.println("Enter the Address");
     String address = getInput.next();
     Profile profile=new Profile(phNumber,address);
    }
    else{
     String userName=Entrance.getName();
     Profile profile=new Profile(userName);
     profile.showProfile();
    }
    System.out.println("Will you want to Continue shopping (y/n)");
     String yn = getInput.next();
     if(yn.equals("y")){
      showlist();
     }
     else{
       System.out.println("Thank you");
       System.exit(0);
     }
    break;
  case 4:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==          OrderList selected            ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    Order show=new Order();
    show.showOrderList();
    System.out.println("Will you want to Continue shopping (y/n)");
     String yOn = getInput.next();
     if(yOn.equals("y")){
      showlist();
     }
     else{
       System.out.println("Thank you");
       System.exit(0);
     }
    break;
    
  case 5:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==          WishList selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    Wishlist order=new Wishlist();
    order.showWishList();
    System.out.println("Will you want to Continue shopping (y/n)");
     String yOrn = getInput.next();
     if(yOrn.equals("y")){
      showlist();
     }
     else{
       System.out.println("Thank you");
       System.exit(0);
     }
    break;
  default:
    System.out.println("Enter correct input");
    //Product obj=new Product();
   showlist();
  }
}
 
 String searchproduct(String[] arr,String name){
    String temp;
    String val="";
       for(int i=0;i<arr.length;i++){
         temp=arr[i].toLowerCase();
         if(temp.equals(name)){
            val=arr[i];
         }
     }
     return val;
  }
}


class Order {
Scanner getInput = new Scanner(System.in);
Product obj=new Product();
    String name;
    float amount;
    float totalPrice = 0;
    List<String> itemsOrdered = new ArrayList<>();
    void order(String item) {
        itemsOrdered.add(item);
        totalPrice+=Float.parseFloat((item.split("\n")[2]).split(":")[1]);
    }
    
    void placeOrder() {
        name=Entrance.getName();
        System.out.println("Total Price: " + totalPrice);
        
        System.out.println("Enter the Price");
        float amount = getInput.nextInt();
        if(amount<totalPrice){
         System.out.println("Enter the valid amount");
         amount = getInput.nextInt();
         placeOrder();
        }
        else if (amount >= totalPrice) {
        try {
            String fileName = this.name + "order.txt";
            System.out.println(this.name);
            FileWriter userFile = new FileWriter(fileName, true);

            for (String item : itemsOrdered) {
                userFile.write(item + "\n"); 
            }
            userFile.write("Total Price: " + totalPrice + ",\n");
            userFile.close();
            System.out.println("============================================");
            System.out.println("==                                        ==");
            System.out.println("==           Order confirmed              ==");
            System.out.println("==                                        ==");
            System.out.println("============================================");
            System.out.println("Will you want to Continue shopping (y/n)");
            String yORn = getInput.next();
           if(yORn.equals("y")){
            //System.out.println("Th");
              obj.showlist();
           }
           else{
             System.out.println("Thank you");
             System.exit(0);
           }
        } 
        catch (IOException e) {
            System.out.println("Error while placing order: " + e.getMessage());
        }
    }
  }
      ArrayList<String> fileContents = new ArrayList<String>();

    void showOrderList() {
        name = Entrance.getName();
        String fileName = this.name + "order.txt";
        Path filePath = Paths.get(fileName); 
        try {
            fileContents.addAll(Files.readAllLines(filePath));
            for (String line : fileContents) {
                System.out.println(line);
            }
        } catch (IOException e) {
           System.out.println("WishList is not found");
            //System.out.println("Error reading wish list: " + e.getMessage());
        }
    }
}

class Wishlist {
 Product obj1=new Product();
    List<String> itemsOrdered = new ArrayList<>();
    Scanner getInput = new Scanner(System.in);
    String name, allDetails;
    //float totalPrice;
    int code;
    void addList(String obj) {
        itemsOrdered.add(obj);
        //totalPrice += Float.parseFloat(obj.split(",")[1].split(":")[1].trim());
    }

    void addFile() {
        name = Entrance.getName();
        try {
            String fileName = this.name + "wishList.txt";
            FileWriter userFile = new FileWriter(fileName, true);

            for (String item : itemsOrdered) {
            System.out.println(item);
                userFile.write(item + "\n");
            }
            //userFile.write("Total Price: " + totalPrice + ",\n");
            userFile.close();
            System.out.println("============================================");
            System.out.println("==                                        ==");
            System.out.println("==             Add to Wishlist            ==");
            System.out.println("==                                        ==");
            System.out.println("============================================");
            System.out.println("Will you want to Continue shopping (y/n)");
             String yORn = getInput.next();
                if(yORn.equals("y")){
                 System.out.println("Th");
                      obj1.showlist();
                }
                else{
                   System.out.println("Thank you");
                   System.exit(0);
                }
        } catch (IOException e) {
            System.out.println("Error while creating wishlist: " + e.getMessage());
        }
    }
    ArrayList<String> fileContents = new ArrayList<String>();
    void showWishList() {
        name = Entrance.getName();
        String fileName = this.name + "wishList.txt";
        Path filePath = Paths.get(fileName); 
        try {
            fileContents.addAll(Files.readAllLines(filePath));
            for (String line : fileContents) {
                System.out.println(line);
            }
        } catch (IOException e) {
             System.out.println("WishList is not found");
            //System.out.println("Error reading wish list: " + e.getMessage());
        }
    }
}

class AllFileList{
    ArrayList<ArrayList<String>> TshirtList = new ArrayList<>();
    ArrayList<String> tshirtList;
    void readTShirtDetails(String name) {
        try {
            String file = name+".txt";
            FileReader inputFileReader = new FileReader(file);
            Scanner fileScanner = new Scanner(inputFileReader);

            while (fileScanner.hasNextLine()) {
                tshirtList  = new ArrayList<>();
                String line = fileScanner.nextLine();
                String[] details = line.split(",");

                Collections.addAll(tshirtList, details);
                TshirtList.add(tshirtList);
            }

            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error reading details: " + e.getMessage());
        }
    }
    

    void showTShirtDetails(int name){
         for (int i=0; i<tshirtList.size(); i++) {
            System.out.println(getTShirtByCode(i,name));
        }
    }
    
    String getTShirtByCode(int idx,int name){
    if(name==1){
    	return "\nNAME: " +TshirtList.get(0).get(idx)  +"\nPRICE: " + TshirtList.get(1).get(idx)+ "\nCOLOR: " + TshirtList.get(2).get(idx) + "\nSIZE: " + TshirtList.get(3).get(idx) + "\nRATING: " + TshirtList.get(4).get(idx) + "\nSLEEVE: " + TshirtList.get(5).get(idx)+"\nCODE: "+(idx+1);
    	}
    else if(name==2){
    	return "\nNAME: " +TshirtList.get(0).get(idx)  +"\nPRICE: " + TshirtList.get(1).get(idx)+ "\nCOLOR: " + TshirtList.get(2).get(idx) + "\nSIZE: " + TshirtList.get(3).get(idx)  + "\nRATING: " + TshirtList.get(4).get(idx) +"\nCODE: "+(idx+1);
    }
    else if(name==3){
    	return "\nNAME: " +TshirtList.get(0).get(idx) + "\nPRICE: " + TshirtList.get(1).get(idx) + "\nRATING: " + TshirtList.get(2).get(idx) + "\nWeight: " + TshirtList.get(3).get(idx) +"\nCODE: "+(idx+1);
    }
    else{
    	return "\nNAME: " +TshirtList.get(0).get(idx) +"\nPRICE: " + TshirtList.get(1).get(idx) + "\nRATING: " + TshirtList.get(2).get(idx) +"\nCODE: "+(idx+1);
    }
    }
}

class Profile {
   Scanner getInput = new Scanner(System.in);
    String name;
    String phNumber;
    String address;
    ArrayList<String> orders=new ArrayList<String>();

    Profile(String name){
      this.name = name;
        String fileName = this.name + ".txt";
        Path filePath = Paths.get(fileName); 
        try {
            orders.addAll(Files.readAllLines(filePath));
        } 
        catch (IOException e) {
            System.out.println("Error reading wish list: " + e.getMessage());
        }
    }    
    Profile( String phNumber, String address) {
        this.name = Entrance.getName();
        this.phNumber = phNumber;
        this.address = address;
        name = Entrance.getName();
        String fileName = this.name + ".txt";
        Path filePath = Paths.get(fileName); 
        try {
            orders.addAll(Files.readAllLines(filePath));
            FileWriter userFile = new FileWriter(fileName);
            userFile.write(orders.get(0) + "\n" + orders.get(1)+"\n"+this.phNumber+"\n"+this.address);
            userFile.close();
            //Profile(name);
        } catch (IOException e) {
            System.out.println("Error reading wish list: " + e.getMessage());
        }
    }

    void showProfile() {
        System.out.println("PROFILE");
        System.out.println("Name: " + orders.get(0));
        System.out.println("Phone Number: " + orders.get(2));
        System.out.println("Address: " + orders.get(3));
        System.out.println("Will you want to Continue shopping (y/n)");
     String yORn = getInput.next();
     if(yORn.equals("y")){
      Product obj=new Product();
      obj.showlist();
     }
     else{
       System.out.println("Thank you");
       System.exit(0);
     }
    }
} 


class Category extends Product{
  void showCategory(){
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||              1.Fashion                         ||");
  System.out.println("||              2.Grocery                         ||");
  System.out.println("||              3.Electronics                     ||");
  System.out.println("||              4.Books                           ||");
  System.out.println("||              5.Back                            ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
  switch(choice) {
  case 1:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==            Fashion selected            ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    Fashion fashion=new Fashion();
    fashion.showFashion();
    break;
  case 2:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==            Grocery selected            ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    Grocery grocery=new Grocery();
    grocery.showSection();  
    break;
  case 3:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==         Electronics selected           ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    Electronic electronic=new Electronic();
    electronic.showFashion();
    break;
  case 4:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==             Books selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    Book book=new Book();
    book.showSection();
    break;
   case 5:
     showlist();
     break;
  default:
    System.out.println("Enter correct input");
    showCategory();
  }
 }
  void findCategory(String name,int empty){
     AllFileList pant=new AllFileList();
     pant.readTShirtDetails(name);
     pant.showTShirtDetails(empty);
     System.out.println("Enter the code number");
     int count2 = getInput.nextInt();
     System.out.println(pant.getTShirtByCode((count2-1),empty));
     System.out.println("1.Add to Wishlist");
     System.out.println("2.Add to cart");
     int choose2 = getInput.nextInt();
     if(choose2==1){
      Wishlist wishlist=new Wishlist();
      wishlist.addList(pant.getTShirtByCode((count2-1),empty));
      wishlist.addFile();
     }
     else{
      Order book=new Order();
      book.order(pant.getTShirtByCode((count2-1),empty));
      book.placeOrder();
     }
    }
}

class Fashion extends Category{
 void showFashion(){
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||              1.Dress                           ||");
  System.out.println("||              2.Bags                            ||");
  System.out.println("||              3.Jewells                         ||");
  System.out.println("||              4.Shoes                           ||");
  System.out.println("||              5.Back                            ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
  switch(choice) {
  case 1:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==             Dress selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    Dress dress=new Dress();
    dress.showSection();
    break;
  case 2:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==              Bags selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    Bags bags=new Bags();
    bags.showSection();
    break;
  case 3:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==         Jewellery selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    Jewells jewells=new Jewells();
    jewells.showSection();
    break;
  case 4:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==             Shoes selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    Shoes shoes=new Shoes();
    shoes.showSection();
    break;
   case 5:
    showCategory();
    break;
  default:
    System.out.println("Enter correct input");
    showFashion();
  }
 }
}

class Dress extends Fashion{
 void showSection(){
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||              1.Men                             ||");
  System.out.println("||              2.Women                           ||");
  System.out.println("||              3.Kids                            ||");
  System.out.println("||              4.back                            ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
  switch(choice) {
  case 1:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==             Shoes selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    System.out.println("Men selected");
    ManOutFit man=new ManOutFit();
    man.showCollection();
    break;
  case 2:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==             Shoes selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    System.out.println("Women selected");
    WomanOutFit woman=new WomanOutFit();
    woman.showCollection();
    break;
  case 3:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==             Shoes selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    System.out.println("Kids selected");
    KidsOutFit kids=new KidsOutFit();
    kids.showCollection();
    break;
  case 4:
    showFashion();
  break;
  default:
    System.out.println("Enter correct input");
    showSection();
  }
 }
}

//dress collection

class ManOutFit extends Dress{
 void showCollection(){
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||              1.T-shirt                         ||");
  System.out.println("||              2.Pant                            ||");
  System.out.println("||              3.Shirt                           ||");
  System.out.println("||              4.Track Pant                      ||");
  System.out.println("||              5.Veshti/Dhoti                    ||");
  System.out.println("||              6.Lungi                           ||");
  System.out.println("||              7.back                            ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  Category call=new Category();
  switch(choice) {
  case 1:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           T-shirt selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("T-shirt",1);
    break;
  case 2:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==              Pant selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    call.findCategory("Pant",2);
    break;
  case 3:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==             Shirt selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    call.findCategory("Shirt",1);
    break;
  case 4:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==         Track Pant selected            ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Track-pant",2);
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==         Veshti/Dhoti selected          ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Veshti",2);
    break;
  case 6:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Lungi selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Lungi",2);
    break;
   case 7:
    showSection();
    break; 
  default:
    System.out.println("Enter correct input");
    showCollection();
  }  
 }
}

class WomanOutFit extends Dress{
 void showCollection(){
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||                 1.Frock                        ||");
  System.out.println("||                 2.Chudi                        ||");
  System.out.println("||                 3.Skirt                        ||");
  System.out.println("||                 4.Saree                        ||");
  System.out.println("||                 5.Jeans                        ||");
  System.out.println("||                 6.Tops                         ||");
  System.out.println("||                 7.back                         ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  Category call=new Category();
  switch(choice) {
  case 1:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Frock selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Frock",2);
    break;
  case 2:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==             Chudi selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    call.findCategory("Chudi",2);
    break;
  case 3:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==             Skirt selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    call.findCategory("Skirt",2);
    break;
  case 4:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Saree selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Saree",2);
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Jeans selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Jeans",2);
    break;
  case 6:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==              Tops selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Tops",2);
    break;
  case 7:
    showSection();
    break; 
  default:
    System.out.println("Enter correct input");
    showCollection();
  }
 } 
}

class KidsOutFit extends Dress{
 void showCollection(){
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||                 1.T-Shirt                      ||");
  System.out.println("||                 2.Pant                         ||");
  System.out.println("||                 3.Shirt                        ||");
  System.out.println("||                 4.Ethnic Wear                  ||");
  System.out.println("||                 5.Combo sets                   ||");
  System.out.println("||                 6.back                         ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
 
  Category call=new Category();
  switch(choice) {
  case 1:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             T-shirt selected           ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("T-shirt",1);
    break;
  case 2:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==              Pant selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    call.findCategory("Pant",2);
    break;
  case 3:
    System.out.println("============================================");
    System.out.println("==                                        ==");
    System.out.println("==             Shirt selected             ==");
    System.out.println("==                                        ==");
    System.out.println("============================================");
    call.findCategory("Shirt",1);
    break;
  case 4:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==          Ethnic Wear selected          ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Ethnic-Wear",1);
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==         Combo sets selected            ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Combo-Sets",1);
    break;
  case 6:
    showSection();
    break; 
  default:
    System.out.println("Enter correct input");
    showCollection();
  }  
 }
}

class Bags extends Fashion{
 void showSection(){
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||             1.SkyBag                           ||");
  System.out.println("||             2.American Tourister               ||");
  System.out.println("||             3.WildCraft                        ||");
  System.out.println("||             4.Gucci                            ||");
  System.out.println("||             5.Louis vuitton                    ||");
  System.out.println("||             6.back                             ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
  Category call=new Category();
  switch(choice) {
  case 1:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            SkyBag selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("SkyBag",2);
    break;
  case 2:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==      American Tourister selected       ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("American",2);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==         WildCraft selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("WildCraft",2);
    break;
  case 4:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Gucci selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Gucci",2);
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==          Louis vuitton selected        ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Louis",2);
    break;
  case 6:
    showFashion();
    break;
  default:
    System.out.println("Enter correct input");
    showSection();
  } 
 }
}

class Jewells extends Fashion{
 void showSection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||                1.Gold                          ||");
  System.out.println("||                2.Sliver                        ||");
  System.out.println("||                3.Platinum                      ||");
  System.out.println("||                4.back                          ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");

  int choice = getInput.nextInt();
  
  Category call=new Category();
  switch(choice) {
  case 1:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Gold selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Gold",4);
    break;
  case 2:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Sliver selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Sliver",4);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==          Platinum selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Platinum",4);
    break;
  case 4:
    showFashion();
    break;
  default:
    System.out.println("Enter correct input");
    showSection();
  } 
 }
}

class Shoes extends Fashion{
 void showSection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||                 1.Puma                         ||");
  System.out.println("||                 2.Nike                         ||");
  System.out.println("||                 3.Sparex                       ||");
  System.out.println("||                 4.Nivia                        ||");
  System.out.println("||                 5.Adidas                       ||");
  System.out.println("||                 6.back                         ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
  Category call=new Category();
  switch(choice) {
  case 1:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==              Puma selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Puma",2);
    break;
  case 2:
    System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Nike selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Nike",2);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Sparex selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Sparex",2);
    break;
  case 4:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Nivia selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Nivia",2);
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Adidas selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Adidas",2);
    break;
   case 6:
    showFashion();
    break;
  default:
    System.out.println("Enter correct input");
    showSection();
  }
 } 
}

class Grocery extends Category{
 void showSection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||             1.Fruits                           ||");
  System.out.println("||             2.Vegetables                       ||");
  System.out.println("||             3.Dairy                            ||");
  System.out.println("||             4.back                             ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
    int choice = getInput.nextInt();
  
  switch(choice) {
  case 1:
    System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Fruits selected            ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    Fruits fruits=new Fruits();
    fruits.showCollection();
    break;
  case 2:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Vegetables selected          ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    Vegtables vegtables=new Vegtables();
    vegtables.showCollection();
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Dairy selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    Dairy dairy=new Dairy();
    dairy.showCollection();
    break;
  case 4:
   showCategory();
   break;
  default:
    System.out.println("Enter correct input");
    showSection();
  }
 }
}

class Fruits extends Grocery{
 void showCollection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||                  1.Apple                       ||");
  System.out.println("||                  2.Banana                      ||");
  System.out.println("||                  3.Mango                       ||");
  System.out.println("||                  4.Grapes                      ||");
  System.out.println("||                  5.Orange                      ||");
  System.out.println("||                  6.back                        ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
  Category call=new Category();
  switch(choice) {
  case 1:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Apple selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Apple",3);
    break;
  case 2:  
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Banana selected            ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Banana",3);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Mango selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Mango",3);
    break;
  case 4:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Grapes selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Grapes",3);
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Orange selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Orange",3);
    break;
   case 6:
     showSection();
     break;
  default:
    System.out.println("Enter correct input");
    showCollection();
  }
 } 
}

class Dairy extends Grocery{
 void showCollection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||             1.Milk                             ||");
  System.out.println("||             2.Eggs                             ||");
  System.out.println("||             3.Yogurt                           ||");
  System.out.println("||             4.Butter                           ||");
  System.out.println("||             5.back                             ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
  Category call=new Category();
  switch(choice) {
  case 1:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Milk selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Milk",3);
    break;
  case 2:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Eggs selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Eggs",3);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Yogurt selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Yogurt",3);
    break;
  case 4:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Butter selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Butter",3);
    break;
   case 5:
     showSection();
     break;
  default:
    System.out.println("Enter correct input");
    showCollection();
  }
 } 
}


class Vegtables extends Grocery{
 void showCollection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||             1.Potato                           ||");
  System.out.println("||             2.Brinjal                          ||");
  System.out.println("||             3.Carrot                           ||");
  System.out.println("||             4.Beans                            ||");
  System.out.println("||             5.Cabbage                          ||");
  System.out.println("||             6.back                             ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
    Category call=new Category();
  switch(choice) {
  case 1:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Potato selected            ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Potato",3);
    break;
  case 2:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Brinjal selected             ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Brinjal",3);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Carrot selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Carrot",3);
    break;
  case 4:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Beans selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Beans",3);
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==          Cabbage selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Cabbage",3);
    break;
  case 6:
     showSection();
     break;
  default:
    System.out.println("Enter correct input");
    showCollection();
  }
 } 
}
class Electronic extends Category{
 void showFashion(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||             1.Watch                            ||");
  System.out.println("||             2.Mobile                           ||");
  System.out.println("||             3.Laptop                           ||");
  System.out.println("||             4.Camera                           ||");
  System.out.println("||             5.HeadPhone&Speaker                ||");
  System.out.println("||             6.back                             ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
    switch(choice) {
  case 1:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Watch selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    Watch watch=new Watch();
    watch.showSection();
    break;
  case 2:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Mobile selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    System.out.println("Mobile selected");
    Mobile mobile=new Mobile();
    mobile.showSection();
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Laptop selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    Laptop laptop=new Laptop();
    laptop.showSection();
    break;
  case 4:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Camera selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    Camera camera=new Camera();
    camera.showSection();
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==       HeadPhone&Speaker  selected      ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    Speaker speaker=new Speaker();
    speaker.showSection();
    break;
  case 6:
   showCategory();
   break;
  default:
    System.out.println("Enter correct input");
    showFashion();
  }
 }
}

class Watch extends Electronic{
 void showSection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||             1.Casio                            ||");
  System.out.println("||             2.Titan                            ||");
  System.out.println("||             3.Timex                            ||");
  System.out.println("||             4.Vacheron constantin              ||");
  System.out.println("||             5.Rolex                            ||");
  System.out.println("||             6.back                             ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
      Category call=new Category();
  switch(choice) {
  case 1:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Casio selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Casio",4);
    break;
  case 2:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Titan selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Titan",4);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Timex selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Timex",4);
    break;
  case 4:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==      Vacheron constantin selected      ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Vacheron",4);
    break;
  case 5:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==          Rolex selected                ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Rolex",4);
    break;
   case 6:
    showFashion();
    break;
  default:
    System.out.println("Enter correct input");
    showSection();
  }
 } 
}
 
class Mobile extends Electronic{
 void showSection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||                1.Samsung                       ||");
  System.out.println("||                2.Apple                         ||");
  System.out.println("||                3.Vivo                          ||");
  System.out.println("||                4.Redmi                         ||");
  System.out.println("||                5.Realme                        ||");
  System.out.println("||                6.back                          ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt(); 
  
   Category call=new Category();
  switch(choice) {
  case 1:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==          Samsung selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Samsung",4);
    break;
  case 2:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Apple selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("apple",4);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Vivo selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Vivo",4);
    break;
  case 4:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Redmi selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Redmi",4);
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Realme selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Realme",4);
    break;
  case 6:
    showFashion();
    break;
  default:
    System.out.println("Enter correct input");
    showSection();
  }
 } 
}

class Laptop extends Electronic{
 void showSection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||                 1.Dell                         ||");
  System.out.println("||                 2.Asus                         ||");
  System.out.println("||                 3.Mac                          ||");
  System.out.println("||                 4.Lenova                       ||");
  System.out.println("||                 5.Acer                         ||");
  System.out.println("||                 6.back                         ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
     Category call=new Category();
  switch(choice) {
  case 1:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Dell selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Dell",4);
    break;
  case 2:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Asus selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Asus",4);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Mac selected                ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Mac",4);
    break;
  case 4:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Lenova selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Lenova",4);
    break;
  case 5:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Acer selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Acer",4);
    break;
  case 6:
    showFashion();
    break;
  default:
    System.out.println("Enter correct input");
    showSection();
  }
 } 
}
 
class Camera extends Electronic{
 void showSection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||                 1.Sony                         ||");
  System.out.println("||                 2.Canon                        ||");
  System.out.println("||                 3.Nikon                        ||");
  System.out.println("||                 4.Panasonic                    ||");
  System.out.println("||                 5.Red                          ||");
  System.out.println("||                 6.back                         ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
       Category call=new Category();
  switch(choice) {
  case 1:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Sony selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Sony",4);
    break;
  case 2:
    System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==            Canon selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Canon",4);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==           Nikon selected               ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Nikon",4);
    break;
  case 4:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==        Panasonic selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Sonic",4);
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Red selected               ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Red",4);
    break;
   case 6:
    showFashion();
    break;
  default:
    System.out.println("Enter correct input");
    showSection();
  }
 } 
}

class Speaker extends Electronic{
 void showSection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||                1.Boat                          ||");
  System.out.println("||                2.JBC                           ||");
  System.out.println("||                3.Onemore                       ||");
  System.out.println("||                4.AKG                           ||");
  System.out.println("||                5.Sony                          ||");
  System.out.println("||                 6.back                         ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
    Category call=new Category();
  switch(choice) {
  case 1:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             Boat selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Boat",4);
    break;
  case 2:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             JBC selected               ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("JBC",4);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==          Onemore selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Onemore",4);
    break;
  case 4:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==             AKG selected               ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("AKG",4);
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==          SonySpeak selected            ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("SonySpeak",4);
    break;
  case 6:
    showFashion();
    break;
  default:
    System.out.println("Enter correct input");
    showSection();
  }
 } 
}

class Book extends Category{
 void showSection(){
   System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||             1.Thiller                          ||");
  System.out.println("||             2.Romatic                          ||");
  System.out.println("||             3.Adventure                        ||");
  System.out.println("||             4.Fantasy                          ||");
  System.out.println("||             5.Non Fiction                      ||");
  System.out.println("||             6.back                             ||");
  System.out.println("||                                                ||");
  System.out.println("||                                                ||");
  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
  int choice = getInput.nextInt();
  
    Category call=new Category();
  switch(choice) {
  case 1:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==          Thiller selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Thiller",4);
    break;
  case 2:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==          Romatic selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Romatic",4);
    break;
  case 3:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==        Adventure selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
    call.findCategory("Adventure",4);
    break;
  case 4:
      System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==          Fantasy selected              ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Fantasy",4);
    break;
  case 5:
     System.out.println("============================================");
     System.out.println("==                                        ==");
     System.out.println("==        Non Fiction selected            ==");
     System.out.println("==                                        ==");
     System.out.println("============================================");
     call.findCategory("Fiction",4);
    break;
    case 6:
      showCategory();
      break;
  default:
    System.out.println("Enter correct input");
    showSection();
  }
 } 
}

