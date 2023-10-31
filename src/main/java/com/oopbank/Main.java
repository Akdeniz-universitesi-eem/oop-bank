package com.oopbank;


/*
* NYP ihtiyaç duyulan programı küçük parçalara ayırarak, yönetilebilir ve yeniden kullanılabilir program geliştirme yöntemidir.
* her küçük parçanın kendine ait nitelikleri ve iletişim yöntemi kendine özeldir.
*
* Kod yazarken, gerçek hayat problemlerini bilgisayarın anlayacağı şekilde modellere çeviriyoruz bu modellere nesne deniyor.
*
* Nesne(Object) nedir?
*
* Belli bir ağırlığı ve hacmi, rengi olan her türlü cansız varlık, şey, obje.
*
* örneğin araba, uçak, kitap, kalem, kolye, ...
*
* Sınıf(Class) nedir
*
* Gerçek hayat nesnelerinin yazılımdaki eşdeğeri classlardır
*
*/

/*
* Encapsulation
*
* Sarmalama ilkesi, bir sınıfa ait değişkenlerin veya niteliklerin ancak o sınıfa ait metotlar tarafından değiştirilebilmesi
* ve okunabilmesi ilkesidir.(Getter ve Setter methodlar)
* bu şekilde veriye doğrudan erişim ve düzeltme yapılamaz bu sayede veri bütünlüğü ve güvenliği sağlanır.
*/

/*
* Inheritance
*   Kalıtım, Bir sınıfın başka bir sınıftan nitelik ve davranışlarını kendisine alması demektir.
*   Kalıtımı yapan sınıfal alt sınıf(sub cass), kendisinden kalıtım yapılan sınıfa ata sınıf(super class) dersek,
*   ata sınıfta tanımlı olan her şeyin alt sınıf için de tanımlı olduğunu söyleyebiliriz.
*/

/*
* Polymorphism
*  NYP'de programlama dilinin farklı tip verileri ve sınıfları farklı şekilde işleme yeteneğini belirten özelliğidir.
*  Bu sayede alt sınıf ata sınıfından gelen davranışı kendine göre şekillendirebilir.
*/

import com.oopbank.atm.ATM;
import com.oopbank.atm.BankOffice;
import com.oopbank.customer.Customer;
import com.oopbank.employee.Employee;
import com.oopbank.generic.money.Money;
import com.oopbank.person.Person;
import com.oopbank.generic.money.Currency;
import com.oopbank.utils.db.DB;
import com.oopbank.utils.factory.IDBObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    private static List<Customer> customers;
    private static List<Employee>employees;
    private static List<ATM> atms;
    private static List<BankOffice> bankOffices;

    public static void main(String[] args) {

        init();
        printOut(Customer.class);
        printOut(Employee.class);
        printOut(ATM.class);
        printOut(BankOffice.class);

    }
    private static void init(){
        DB db = DB.getInstance();
        customers = db.getTable(Customer.class).getRows().stream().toList();
        employees = db.getTable(Employee.class).getRows().stream().toList();
        atms = db.getTable(ATM.class).getRows().stream().toList();
        bankOffices = db.getTable(BankOffice.class).getRows().stream().toList();
    }

    private static void printOut(Class<? extends IDBObject> clazz){
        if(clazz.equals(Customer.class)){
            printOutCustomers();
        } else if (clazz.equals(Employee.class)) {
            printOutEmployees();
        } else if (clazz.equals(ATM.class)) {
            printOutATMs();
        } else if (clazz.equals(BankOffice.class)) {
            printOutBankOffices();
        }
        else{
            System.out.println("No Such Table To Print!");
        }
    }

    private static void printOutBankOffices() {
        System.out.println("BANKALAR");
        bankOffices.forEach(bankOffice -> {
            System.out.println("ID : " + bankOffice.getId()
                    + "     Banka Adı : " + bankOffice.getName()
                    + "     Konum : " + bankOffice.getLocation());
            System.out.println("Banka Çalışanları");
            printOutEmployees(bankOffice.getWorkers().stream().toList());
        });
    }

    private static void printOutATMs() {
        System.out.println("ATM");
        atms.forEach(atm -> {
            System.out.println("ID : " + atm.getId()
                    + "     Konum : " + atm.getLocation()
                    + "     Bakiye : " + atm.getMoneyInATM().getAmount() + atm.getMoneyInATM().getCurrency());
        });
    }

    private static void printOutEmployees() {
        System.out.println("Çalışanlar");
        employees.forEach(employee -> {
            System.out.println("ID : " + employee.getId()
                    + "     Isım Soyisim : " + employee.getFullname()
                    + "     Email : " + employee.getEmail()
                    + "     Unvan : " + employee.getJob().name()
                    + "     Maaş : " + employee.getSalary().getAmount() + employee.getSalary().getCurrency());
        });
    }

    private static void printOutEmployees(List<Employee> employees) {
        System.out.println("Çalışanlar");
        employees.forEach(employee -> {
            System.out.println("ID : " + employee.getId()
                    + "     Isım Soyisim : " + employee.getFullname()
                    + "     Email : " + employee.getEmail()
                    + "     Unvan : " + employee.getJob().name()
                    + "     Maaş : " + employee.getSalary().getAmount() + employee.getSalary().getCurrency());
        });
    }

    private static void printOutCustomers(){
        System.out.println("Müşteriler");
        customers.forEach(customer -> {
            System.out.println("ID : " + customer.getId()
                    + "     Isım Soyisim : " + customer.getFullname()
                    + "     Bakiye : " + customer.getDepositedMoney().getAmount()+ customer.getDepositedMoney().getCurrency().name()
                    + "     Email : " + customer.getEmail());
        });
    }

}