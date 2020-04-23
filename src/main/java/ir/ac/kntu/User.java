package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private AccessLevel accessLevel;


    public User(){

    }
    public User(String userName, String password, String email, String phoneNumber, AccessLevel accessLevel) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accessLevel = accessLevel;
    }

    public String getUserName() {
        return userName;
    }

    public boolean setUserName(String userName) {
        if (userName.contains(" ") || userName.equals("")){
            return false;
        }
        else {
            this.userName = userName;
            return true;
        }
    }

    public String getPassword() {
        return password;
    }


    public void setPassword2(String password){
        this.password = password;
    }
    public boolean setPassword(String password) {
        if (userName.contains(" ") || userName.equals("")){
            return false;
        }
        else {
            this.password = password;
            return true;
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        String regex = "^[a-zA-Z0-9]+[._a-zA-Z0-9!#$%&'*+-/=?^`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}.[a-zA-Z.]{2,6}$";
        if (Pattern.matches( regex , email )){
            this.email = email;
            return true ;
        }
        else {
            System.out.println("Error!!! wrong path for E-mail!!!");
            return false;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        String regex = "^[0][9][0-9]{9}$";
        if (Pattern.matches( regex , phoneNumber )){
            this.phoneNumber = phoneNumber;
            return true ;
        }
        else {
            System.out.println("Error!!! wrong path for cellphone number!!!");
            return false;
        }
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
    /*----------------------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------------------*/
    public static User signIn(List<User> acceptedUsers){
        User signInUser ;
        while (true){
            signInUser = null;
            Scanner scanner = new Scanner(System.in);
            String userName , password;
            System.out.println("\n<< sign in >>\nUser Name: ");
            userName = scanner.nextLine();
            for (User acceptedUser : acceptedUsers) {
                if (acceptedUser.userName.equals(userName)) {
                    signInUser = acceptedUser;
                    break;
                }
            }
            if (signInUser == null){
                System.out.println("this username does'nt exist.");
            }
            else {
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("password:");
                password = scanner2.nextLine();
                if (signInUser.getPassword().equals(password) ){
                    System.out.println("signed in...");
                    break;
                }
                else {
                    System.out.println("wrong password!!!");
                }
            }
        }
        return signInUser;
    }
    /*----------------------------------------------------------------------------------------------------------------------------*/
    public static void userMenu(List<User> acceptedUsers,User signedInUser , AccessLevel accessLevel){
        if (accessLevel == AccessLevel.Admin){
            adminSetting(acceptedUsers,signedInUser);
        }
        else if (accessLevel == AccessLevel.Employee){
            employeeSetting(acceptedUsers,signedInUser);
        }
        else if (accessLevel == AccessLevel.TourLeader){
            tourLeaderSetting(acceptedUsers,signedInUser);
        }
        else if (accessLevel == AccessLevel.Customer){
            customerSetting(signedInUser);
        }
    }
    /*----------------------------------------------------------------------------------------------------------------------------*/
    public static void adminSetting(List<User> acceptedUsers,User signedInUser){
        Scanner scanner = new  Scanner(System.in);
        while (true){
            int choice;
            System.out.println("1.Edit profile\n2.Employers\n3.TourLeaders\n4.Customers\n5.Back\nEnter a number:" );
            choice = scanner.nextInt();
            if (choice == 1){
                customerSetting(signedInUser);
            } else if (choice == 2){
                while (true){
                    System.out.println("\n1.add Employee\n2.edit Employee\n3.delete Employee\n4.Back\nEnter a number:");
                    int choice2;
                    choice2 = scanner.nextInt();
                    if (choice2 == 1){
                        addUser(AccessLevel.Employee,acceptedUsers);
                    }else if (choice2 == 2){
                        editSameAccessGroupOfUsers(acceptedUsers,AccessLevel.Employee);
                    }else if (choice2 == 3){
                        deleteUser(AccessLevel.Employee,acceptedUsers);
                    }else if (choice2 == 4){break;}
                }
            } else if (choice == 3){
                while (true){
                    System.out.println("\n1.add tour leader\n2.edit tour leader\n3.Back\nEnter a number:");
                    int choice2;
                    choice2 = scanner.nextInt();
                    if (choice2 == 1){
                        addUser(AccessLevel.TourLeader,acceptedUsers);
                    }else if (choice2 == 2){
                        editSameAccessGroupOfUsers(acceptedUsers,AccessLevel.TourLeader);
                    }else if (choice2 == 3){break;}
                }
            } else if (choice == 4) {
                while (true){
                    System.out.println("\n1.add Customer\n2.edit Customer\n3.delete Customer\n4.Back\nEnter a number:");
                    int choice2;
                    choice2 = scanner.nextInt();
                    if (choice2 == 1){
                        addUser(AccessLevel.Customer,acceptedUsers);
                    }else if (choice2 == 2){
                        editSameAccessGroupOfUsers(acceptedUsers,AccessLevel.Customer);
                    }else if (choice2 == 3){
                        deleteUser(AccessLevel.Customer,acceptedUsers);
                    }else if (choice2 == 4){break;}
                }
            } else if (choice == 5) {
                break;
            }
        }
    }
    /*----------------------------------------------------------------------------------------------------------------------------*/
    public static void employeeSetting(List<User> acceptedUsers,User signedInUser){
        Scanner scanner = new  Scanner(System.in);
        while (true){
            int choice;
            System.out.println("1.Edit profile\n2.Tour Leaders\n3.Customers\n4.Back\nEnter a number:");
            choice = scanner.nextInt();
            if (choice == 1){
                customerSetting(signedInUser);
            } else if (choice == 2){
                while (true){
                    System.out.println("\n1.add tour leader\n2.edit tour leader\n3.Back\nEnter a number:");
                    int choice2;
                    choice2 = scanner.nextInt();
                    if (choice2 == 1){
                        addUser(AccessLevel.TourLeader,acceptedUsers);
                    }else if (choice2 == 2){
                        editSameAccessGroupOfUsers(acceptedUsers,AccessLevel.TourLeader);
                    }else if (choice2 == 3){break;}
                }
            } else if (choice == 3){
                while (true){
                    System.out.println("\n1.add Customer\n2.delete Customer\n3.Back\nEnter a number:");
                    int choice2;
                    choice2 = scanner.nextInt();
                    if (choice2 == 1){
                        addUser(AccessLevel.Customer,acceptedUsers);
                    }else if (choice2 == 2){
                        deleteUser(AccessLevel.Customer,acceptedUsers);
                    }else if (choice2 == 3){break;}
                }
            } else if (choice == 4) { break;}
        }
    }
    /*----------------------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------------------*/
    public static void tourLeaderSetting(List<User> acceptedUsers,User signedInUser ){
        Scanner scanner = new  Scanner(System.in);
        while (true){
            int choice;
            System.out.println("1.Edit profile\n2.Customers\n3.Back\nEnter a number:");
            choice = scanner.nextInt();
            if (choice == 1){
                customerSetting(signedInUser);
            }
            else if (choice == 2){
                while (true){
                    System.out.println("\n1.add Customer\n2.Back\nEnter a number:");
                    int choice2;
                    choice2 = scanner.nextInt();
                    if (choice2 == 1){
                        addUser(AccessLevel.Customer,acceptedUsers);
                    }else if (choice2 == 2){break;}                }
            }
            else if (choice == 3){
                break;
            }
        }
    }
    public static void editSameAccessGroupOfUsers(List<User> acceptedUsers , AccessLevel accessLevel){
        Scanner scanner = new  Scanner(System.in);
        while (true){
            int choice;
            List<User> sameAccessUsers;
            sameAccessUsers = getSameAccessGroupOfUsers(accessLevel,acceptedUsers);
            System.out.println("0.Back\nEnter a number:");
            choice = scanner.nextInt();
            if (choice == 0){break;}
            else if (choice > 0 && choice <= sameAccessUsers.size() ){
                customerSetting(sameAccessUsers.get(choice-1));
            }
        }
    }
    /*----------------------------------------------------------------------------------------------------------------------------*/
    public static List<User> getSameAccessGroupOfUsers(AccessLevel accessLevel , List<User> acceptedUsers){
        List<User> sameAccessUsers = new ArrayList<>();
        System.out.println(accessLevel+"s:");
        int num=1;
        for (User user : acceptedUsers){
            if (user.getAccessLevel() == accessLevel){
                System.out.println(num+"."+user.getUserName());
                sameAccessUsers.add(user);
            }
        }
        return sameAccessUsers;
    }
    /*----------------------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------------------*/
    public static void customerSetting(User signedInUser){
        Scanner scanner = new  Scanner(System.in) , scanner1 = new Scanner(System.in);
        while (true){
            int choice;
            System.out.println("1.Edit Username\n2.Edit Password\n3.Edit E-mail\n4.Edit Phone Number");
            if (signedInUser.getAccessLevel() == AccessLevel.Employee){
                System.out.println("5.edit base salary");
            }
            System.out.println("0.Back\nEnter a number:");
            choice = scanner.nextInt();
            if (choice == 1){
                while (true){
                    String username;
                    System.out.println("'"+signedInUser.getUserName()+"' changes to :");
                    username = scanner1.nextLine();
                    boolean isValid = signedInUser.setUserName(username);
                    if (isValid){
                        break;
                    }
                }
            } else if (choice == 2){
                while (true){
                    String password;
                    System.out.println("'"+signedInUser.getPassword()+"' changes to :");
                    password = scanner1.nextLine();
                    boolean isValid = signedInUser.setPassword(password);
                    if (isValid){
                        break;
                    }
                }
            } else if (choice == 3){
                while (true){
                    String Email;
                    System.out.println("'"+signedInUser.getEmail()+"' changes to :");
                    Email = scanner1.nextLine();
                    boolean isValid = signedInUser.setEmail(Email);
                    if (isValid){
                        break;
                    }
                }
            } else if (choice == 4){
                while (true){
                    String phoneNumber;
                    System.out.println("'"+signedInUser.getPhoneNumber()+"' changes to :");
                    phoneNumber = scanner1.nextLine();
                    boolean isValid = signedInUser.setPhoneNumber(phoneNumber);
                    if (isValid){
                        break;
                    }
                }
            }else if (choice == 5 && signedInUser.getAccessLevel() == AccessLevel.Employee){
                int baseSalary;
                Employee signedInEmployee = (Employee)signedInUser;
                System.out.println("'"+signedInEmployee.getBaseSalary()+"' changes to :");
                baseSalary = scanner1.nextInt();
                signedInEmployee.setBaseSalary(baseSalary);
            } else if (choice == 0){ break; }
        }
    }
    /*----------------------------------------------------------------------------------------------------------------------------*/
    public static void addUser(AccessLevel accessLevel , List<User> acceptedUsers){
        Scanner scanner = new  Scanner(System.in);
        User newUser = new User();
        if (accessLevel == AccessLevel.Employee){
            newUser = new Employee();
        }
        newUser.setAccessLevel(accessLevel);
        while (true){
            String username;
            System.out.println("Username:");
            username = scanner.nextLine();
            boolean isValid = newUser.setUserName(username);
            if (isValid){
                break;
            }
        }

        while (true){
            String password;
            System.out.println("Password:");
            password = scanner.nextLine();
            boolean isValid = newUser.setPassword(password);
            if (isValid){
                break;
            }
        }

        while (true){
            String Email;
            System.out.println("E-mail:");
            Email = scanner.nextLine();
            boolean isValid = newUser.setEmail(Email);
            if (isValid){
                break;
            }
        }

        while (true){
            String phoneNumber;
            System.out.println("Phone Number:");
            phoneNumber = scanner.nextLine();
            boolean isValid = newUser.setPhoneNumber(phoneNumber);
            if (isValid){
                break;
            }
        }
        if (accessLevel == AccessLevel.Employee){
            Employee newEmployee = (Employee) newUser;
            while (true){
                System.out.println("\nEmployment Date: day->");
                int day = scanner.nextInt();
                System.out.println("\nmonth->");
                int month = scanner.nextInt();
                System.out.println("\nyear->");
                int year = scanner.nextInt();
                Date employmentDate = new Date(year,month,day);
                if (employmentDate.getDay() == 0 && employmentDate.getMonth() == 0 && employmentDate.getYear() == 0 ){
                    System.out.println("\n wrong path !!!");
                    continue;
                }
                newEmployee.setEmploymentDate(employmentDate);
                break;
            }
            int baseSalary;
            System.out.println("\nbase salary:");
            baseSalary = scanner.nextInt();
            newEmployee.setBaseSalary(baseSalary);
            acceptedUsers.add(newEmployee);
        }
        else {
            acceptedUsers.add(newUser);
        }
    }
    /*----------------------------------------------------------------------------------------------------------------------------*/
    public static void deleteUser(AccessLevel accessLevel , List<User> acceptedUsers){
        Scanner scanner = new  Scanner(System.in);
        int choice;
        while (true){
            List<User> sameAccessUsers = getSameAccessGroupOfUsers(accessLevel,acceptedUsers);
            System.out.println("0.Back\nEnter a number:");
            choice = scanner.nextInt();
            if (choice == 0){break;}
            else if (choice > 0 && choice <= sameAccessUsers.size() ){
                acceptedUsers.remove(sameAccessUsers.get(choice-1));
            }
        }
    }
}