package self;
import java.util.ArrayList;
import java.util.Scanner;


public class Driver 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        Admin admin = new Admin("sp", "123");

        while (true)
        {
            System.out.println("1. Login as User");
            System.out.println("2. Login as Admin");
            System.out.println("3. Register as User");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice)
            {
                case 1:
                    User user = User.login(users, scanner);
                    if (user != null)
                    {
                        userMenu(user, scanner);
                    }
                    break;
                case 2:
                    Admin loggedInAdmin = Admin.login(admin, scanner);
                    if (loggedInAdmin != null)
                    {
                        adminMenu(loggedInAdmin, users, scanner);
                    }
                    break;
                case 3:
                    User.register(users, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void userMenu(User user, Scanner scanner)
    {
        while (true)
        {
            System.out.println("User Menu:");
            System.out.println("1. Create Outfit");
            System.out.println("2. View Cart");
            System.out.println("3. Remove Item from Cart");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice)
            {
                case 1:
                    Events event = createOutfit(scanner);
                    if (event != null)
                    {
                        user.addToCart(event);
                        System.out.println("Outfit added to cart.");
                    }
                    break;
                case 2:
                    user.viewCart();
                    break;
                case 3:
                    System.out.print("Enter the index of the item to remove: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    user.removeFromCart(index);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void adminMenu(Admin admin, ArrayList<User> users, Scanner scanner)
    {
        while (true) 
        {
            System.out.println("Admin Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. View Users");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice)
            {
                case 1:
                    User.register(users, scanner);
                    break;
                case 2:
                    admin.deleteUser(users, scanner);
                    break;
                case 3:
                    admin.viewUsers(users);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static Events createOutfit(Scanner scanner)
    {
        // Ask for occasion
        System.out.println("Select occasion:");
        System.out.println("1. Normal");
        System.out.println("2. Sports");
        System.out.println("3. Function");

        int occasionChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String occasion = null;
        if (occasionChoice == 1)
        {
            occasion = "Normal";
        }
        else if (occasionChoice == 2)
        {
            occasion = "Sports";
        }
        else if (occasionChoice == 3)
        {
            occasion = "Function";
        }
        else
        {
            System.out.println("Invalid occasion selection.");
            return null;
        }
       
        Upper_Garment selectedUpperGarment = null;
        if ("Normal".equalsIgnoreCase(occasion))
        {
            selectedUpperGarment = selectNormalUpperGarment(scanner);
        }
        else if ("Sports".equalsIgnoreCase(occasion))
        {
            selectedUpperGarment = selectSportsUpperGarment(scanner);
        }
        else if ("Function".equalsIgnoreCase(occasion))
        {
            selectedUpperGarment = selectFunctionUpperGarment(scanner);
        }
       
      
        // Ask for Shirt color
        System.out.print("Enter shirt color: ");
        String shirtColor = scanner.nextLine();

        // Ask for Shirt fit
        System.out.println("Select shirt fit:");
        System.out.println("1. Baggy");
        System.out.println("2. Straight");
        System.out.println("3. Slim");
        System.out.println("4. Regular");

        int shirtFitChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String shirtFit = null;
        if (shirtFitChoice == 1)
        {
            shirtFit = "Baggy";
        }
        else if (shirtFitChoice == 2)
        {
            shirtFit = "Straight";
        }
        else if (shirtFitChoice == 3)
        {
            shirtFit = "Slim";
        }
        else if (shirtFitChoice == 4)
        {
            shirtFit = "Regular";
        }
        else
        {
            System.out.println("Invalid shirt fit selection.");
            return null;
        }

      
        lower_Garments selectedLowerGarment = null;
        if ("Normal".equalsIgnoreCase(occasion))
        {
            selectedLowerGarment = selectNormalLowerGarment(scanner);
        }
        else if ("Sports".equalsIgnoreCase(occasion))
        {
            selectedLowerGarment = selectSportsLowerGarment(scanner);
        }
        else if ("Function".equalsIgnoreCase(occasion))
        {
            selectedLowerGarment = selectFunctionLowerGarment(scanner);
        }

        shoe selectedShoe = null;
        if ("Normal".equalsIgnoreCase(occasion)) 
        {
            selectedShoe = selectNormalShoe(scanner);
        }
        else if ("Sports".equalsIgnoreCase(occasion))
        {
            selectedShoe = selectSportsShoe(scanner);
        }
        else if ("Function".equalsIgnoreCase(occasion))
        {
            selectedShoe = selectFunctionShoe(scanner);
        }

        ArrayList<Accessory> selectedAccessories = new ArrayList<>();
        while (true)
        {
            System.out.println("Select an accessory (enter 'done' to finish):");
            System.out.println("1. Belt");
            System.out.println("2. Watch");
            System.out.println("3. Exit");

            String accessoryChoice = scanner.nextLine();
            if ("done".equalsIgnoreCase(accessoryChoice))
            {
                break;
            }

            Accessory accessory = null;
            if ("1".equals(accessoryChoice)) {
                System.out.print("Enter belt color: ");
                String color = scanner.nextLine();
                System.out.print("Enter belt material: ");
                String material = scanner.nextLine();
                accessory = new Abelt(color, material);
            }
            else if ("2".equals(accessoryChoice))
            {
                System.out.print("Enter watch brand: ");
                String brand = scanner.nextLine();
                System.out.print("Enter watch type: ");
                String type = scanner.nextLine();
                accessory = new Awatch(brand, type);
            }
            else if ("3".equals(accessoryChoice))
            {
            	break;
            }
            else
            {
                System.out.println("Invalid accessory selection.");
                continue;
            }

            selectedAccessories.add(accessory);
        }

        return new Events(occasion, selectedUpperGarment, selectedLowerGarment, selectedShoe, selectedAccessories);
    }
    private static Upper_Garment selectNormalUpperGarment(Scanner scanner)
    {
        System.out.println("Select Shirt type:");
        System.out.println("1. Checks Shirt");
        System.out.println("2.T-shirt");
        System.out.println("3. Polo Shirt");

        int ShirtTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String ShirtType = null;
        if (ShirtTypeChoice == 1)
        {
            ShirtType = "Checks Shirt";
        }
        else if (ShirtTypeChoice == 2) 
        {
            ShirtType = "T-shirt";
        }
        else if (ShirtTypeChoice == 3)
        {
            ShirtType = "Polo Shirt";
        }
        else
        {
            System.out.println("Invalid Shirt type selection.");
            return null;
        }

        System.out.print("Enter Shirt color: ");
        String shirtColor = scanner.nextLine();
        System.out.println("Select shirt fit:");
        System.out.println("1. Baggy");
        System.out.println("2. Straight");
        System.out.println("3. Slim");
        System.out.println("4. Regular");

        int shirtFitChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String shirtFit = null;
        if (shirtFitChoice == 1)
        {
            shirtFit = "Baggy";
        }
        else if (shirtFitChoice == 2)
        {
            shirtFit = "Straight";
        }
        else if (shirtFitChoice == 3)
        {
            shirtFit = "Slim";
        }
        else if (shirtFitChoice == 4)
        {
            shirtFit = "Regular";
        }
        else
        {
            System.out.println("Invalid shirt fit selection.");
            return null;
        }

        return new Upper_Garment(ShirtType, shirtColor,shirtFit);
    }

    //function
    
    private static Upper_Garment selectFunctionUpperGarment(Scanner scanner)
    {
        System.out.println("Select Shirt  type:");
        System.out.println("1. Kurta");
        System.out.println("2. Formal Shirt");
        System.out.println("3. T-Shirt");

        int ShirtTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String ShirtType = null;
        if (ShirtTypeChoice == 1)
        {
            ShirtType = "Kurta";
        }
        else if (ShirtTypeChoice == 3) 
        {
            ShirtType = "T-shirt";
        }
        else if (ShirtTypeChoice == 2)
        {
            ShirtType = "Formal T-Shirt";
        }
        else
        {
            System.out.println("Invalid Shirt type selection.");
            return null;
        }

        System.out.print("Enter Shirt color: ");
        String shirtColor = scanner.nextLine();
        System.out.println("Select shirt fit:");
        System.out.println("1. Baggy");
        System.out.println("2. Straight");
        System.out.println("3. Slim");
        System.out.println("4. Regular");

        int shirtFitChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String shirtFit = null;
        if (shirtFitChoice == 1)
        {
            shirtFit = "Baggy";
        }
        else if (shirtFitChoice == 2)
        {
            shirtFit = "Straight";
        }
        else if (shirtFitChoice == 3)
        {
            shirtFit = "Slim";
        }
        else if (shirtFitChoice == 4)
        {
            shirtFit = "Regular";
        }
        else
        {
            System.out.println("Invalid shirt fit selection.");
            return null;
        }

        return new Upper_Garment(ShirtType, shirtColor,shirtFit);
    }

    
    private static lower_Garments selectNormalLowerGarment(Scanner scanner)
    {
        System.out.println("Select pants type:");
        System.out.println("1. Jeans");
        System.out.println("2. Chinos");
        System.out.println("3. Shorts");

        int pantsTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String pantsType = null;
        if (pantsTypeChoice == 1)
        {
            pantsType = "Jeans";
        }
        else if (pantsTypeChoice == 2) 
        {
            pantsType = "Chinos";
        }
        else if (pantsTypeChoice == 3)
        {
            pantsType = "Shorts";
        }
        else
        {
            System.out.println("Invalid pants type selection.");
            return null;
        }

        System.out.print("Enter pants color: ");
        String pantsColor = scanner.nextLine();

        return new lower_Garments(pantsType, pantsColor);
    }
    
    //sport
    private static Upper_Garment selectSportsUpperGarment(Scanner scanner)
    {
        System.out.println("Select pants type:");
        System.out.println("1. Jersy");
        System.out.println("2. T-shirt");
        System.out.println("3. Sando");

        int pantsTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String ShirtType = null;
        if (pantsTypeChoice == 1)
        {
            ShirtType = "Jersy";
        }
        else if (pantsTypeChoice == 2) 
        {
            ShirtType = "T-shirt";
        }
        else if (pantsTypeChoice == 3)
        {
            ShirtType = "Sando";
        }
        else
        {
            System.out.println("Invalid Shirt type selection.");
            return null;
        }

        System.out.print("Enter pants color: ");
        String shirtColor = scanner.nextLine();
        System.out.println("Select shirt fit:");
        System.out.println("1. Baggy");
        System.out.println("2. Straight");
        System.out.println("3. Slim");
        System.out.println("4. Regular");

        int shirtFitChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String shirtFit = null;
        if (shirtFitChoice == 1)
        {
            shirtFit = "Baggy";
        }
        else if (shirtFitChoice == 2)
        {
            shirtFit = "Straight";
        }
        else if (shirtFitChoice == 3)
        {
            shirtFit = "Slim";
        }
        else if (shirtFitChoice == 4)
        {
            shirtFit = "Regular";
        }
        else
        {
            System.out.println("Invalid shirt fit selection.");
            return null;
        }

        return new Upper_Garment(ShirtType, shirtColor,shirtFit);
    }


    private static lower_Garments selectSportsLowerGarment(Scanner scanner)
    {
        System.out.println("Select pants type:");
        System.out.println("1. Track Pants");
        System.out.println("2. Shorts");

        int pantsTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String pantsType = null;
        if (pantsTypeChoice == 1)
        {
            pantsType = "Track Pants";
        }
        else if (pantsTypeChoice == 2)
        {
            pantsType = "Shorts";
        }
        else
        {
            System.out.println("Invalid pants type selection.");
            return null;
        }

        System.out.print("Enter pants color: ");
        String pantsColor = scanner.nextLine();

        return new lower_Garments(pantsType, pantsColor);
    }

    private static lower_Garments selectFunctionLowerGarment(Scanner scanner)
    {
        System.out.println("Select pants type:");
        System.out.println("1. Dress Pants");
        System.out.println("2. Khakis");

        int pantsTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String pantsType = null;
        if (pantsTypeChoice == 1)
        {
            pantsType = "Dress Pants";
        }
        else if (pantsTypeChoice == 2) 
        {
            pantsType = "Khakis";
        }
        else
        {
            System.out.println("Invalid pants type selection.");
            return null;
        }

        System.out.print("Enter pants color: ");
        String pantsColor = scanner.nextLine();

        return new lower_Garments(pantsType, pantsColor);
    }

    private static shoe selectNormalShoe(Scanner scanner)
    {
        System.out.println("Select shoe type:");
        System.out.println("1. Sneakers");
        System.out.println("2. Loafers");
        System.out.println("3. Boots");

        int shoeTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String shoeType = null;
        if (shoeTypeChoice == 1)
        {
            shoeType = "Sneakers";
        }
        else if (shoeTypeChoice == 2)
        {
            shoeType = "Loafers";
        }
        else if (shoeTypeChoice == 3)
        {
            shoeType = "Boots";
        }
        else
        {
            System.out.println("Invalid shoe type selection.");
            return null;
        }

        System.out.print("Enter shoe color: ");
        String shoeColor = scanner.nextLine();

        return new shoe(shoeType, shoeColor);
    }

    private static shoe selectSportsShoe(Scanner scanner)
    {
        System.out.println("Select shoe type:");
        System.out.println("1. Running Shoes");
        System.out.println("2. Sports Shoes");

        int shoeTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String shoeType = null;
        if (shoeTypeChoice == 1)
        {
            shoeType = "Running Shoes";
        }
        else if (shoeTypeChoice == 2)
        {
            shoeType = "Sports Shoes";
        }
        else
        {
            System.out.println("Invalid shoe type selection.");
            return null;
        }

        System.out.print("Enter shoe color: ");
        String shoeColor = scanner.nextLine();

        return new shoe(shoeType, shoeColor);
    }

    private static shoe selectFunctionShoe(Scanner scanner)
    {
        System.out.println("Select shoe type:");
        System.out.println("1. Dress Shoes");
        System.out.println("2. Loafers");

        int shoeTypeChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String shoeType = null;
        if (shoeTypeChoice == 1)
        {
            shoeType = "Dress Shoes";
        }
        else if (shoeTypeChoice == 2)
        {
            shoeType = "Loafers";
        }
        else 
        {
            System.out.println("Invalid shoe type selection.");
            return null;
        }

        System.out.print("Enter shoe color: ");
        String shoeColor = scanner.nextLine();

        return new shoe(shoeType, shoeColor);
    }
}
