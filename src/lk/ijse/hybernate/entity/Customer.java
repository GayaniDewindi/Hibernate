package lk.ijse.hybernate.entity;

import lk.ijse.hybernate.embaded.CustName;
import lk.ijse.hybernate.embaded.MobilNumber;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
        //@Entity(name = "customer") hedenn on table ekt name ekk denn puluwn mehem
        @Table(name="customer")
        //second way
        //first way

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;
    @Column(name = "customer_name")
    private CustName name;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_salary")
    private double salary;
    @Column(name = "customer_age",columnDefinition = "SMALLINT")
    private int age;

    @ElementCollection
    @CollectionTable(name = "customer_moblieNumber",
    joinColumns = @JoinColumn(name = "customer_id"))
    private List<MobilNumber>phoneNo;
    @Transient
    private String dob;
    @CreationTimestamp
    /*private Date createDate;*/
   /* private Time  createDate;
*/ private Timestamp createDate;
    public Customer(long id, CustName name, String address, double salary, int age, List<MobilNumber> phoneNo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.setAge(age);
        this.setPhoneNo(phoneNo);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustName getName() {
        return name;
    }

    public void setName(CustName name) {

        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Customer(long id, CustName name, String address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<MobilNumber> getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(List<MobilNumber> phoneNo) {
        this.phoneNo = phoneNo;
    }
}
