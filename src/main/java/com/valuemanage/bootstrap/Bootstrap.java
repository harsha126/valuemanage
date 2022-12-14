package com.valuemanage.bootstrap;

import com.valuemanage.domain.*;
import com.valuemanage.repositories.*;
import com.valuemanage.services.DistributorService;
import com.valuemanage.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
@AllArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final DistributorService distributorService;
    private final AttendenceRepository attendenceRepository;
    private final CommentRepository commentRepository;
    private final ManagerRepository managerRepository;
    private final OrderRepository orderRepository;
    private final ReportRepository reportRepository;
    private final RepresentativeRepository representativeRepository;
    private final RetailerRepository retailerRepository;
    private final UserRepository userRepository;
    private final UserService userService;

//    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Date date = new Date();
        Date date1 = formatter.parse("05/10/2022");
        Date date2 = formatter.parse("03/10/2022");
        Date date3 = formatter.parse("05/09/2022");
        Date date4 = formatter.parse("01/10/2022");
        Date date5 = formatter.parse("12/10/2022");

        userService.saveNewUser("man0", "admin", "MANAGER", 1L);
        userService.saveNewUser("man1", "admin", "MANAGER", 2L);
        userService.saveNewUser("rep0", "admin", "REPRESENTATIVE", 1L);
        userService.saveNewUser("rep1", "admin", "REPRESENTATIVE", 2L);
        userService.saveNewUser("rep2", "admin", "REPRESENTATIVE", 3L);
        userService.saveNewUser("rep3", "admin", "REPRESENTATIVE", 4L);
        userService.saveNewUser("rep4", "admin", "REPRESENTATIVE", 5L);

        Comment comment1 = Comment.builder().text("comment1").build();
        Comment comment2 = Comment.builder().text("comment2").build();
        Comment comment3 = Comment.builder().text("comment3").build();
        Comment comment4 = Comment.builder().text("comment4").build();
        Comment comment5 = Comment.builder().text("comment5").build();
        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
        commentRepository.save(comment4);
        commentRepository.save(comment5);

        Address address1 = Address.builder().city("hyd").build();
        Address address2 = Address.builder().city("del").build();
        Address address3 = Address.builder().city("chennai").build();
        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);

        Attendence attendence1 = Attendence.builder().date(date).build();
        Attendence attendence2 = Attendence.builder().date(date).build();
        Attendence attendence3 = Attendence.builder().date(date).build();
        Attendence attendence4 = Attendence.builder().date(date).build();
        Attendence attendence5 = Attendence.builder().date(date1).build();
        Attendence attendence6 = Attendence.builder().date(date2).build();
        Attendence attendence7 = Attendence.builder().date(date3).build();
        Attendence attendence8 = Attendence.builder().date(date4).build();
        Attendence attendence9 = Attendence.builder().date(date5).build();
        attendenceRepository.save(attendence1);
        attendenceRepository.save(attendence2);
        attendenceRepository.save(attendence3);
        attendenceRepository.save(attendence4);
        attendenceRepository.save(attendence5);
        attendenceRepository.save(attendence6);
        attendenceRepository.save(attendence7);
        attendenceRepository.save(attendence8);
        attendenceRepository.save(attendence9);

        Order order1 = Order.builder().supplierName("supp1").build();
        Order order2 = Order.builder().supplierName("supp2").build();
        Order order3 = Order.builder().supplierName("supp3").build();
        Order order4 = Order.builder().supplierName("supp4").build();
        Order order5 = Order.builder().supplierName("supp5").build();
        Order order6 = Order.builder().supplierName("supp6").build();
        Order order7 = Order.builder().supplierName("supp7").build();
        Order order8 = Order.builder().supplierName("supp8").build();
        Order order9 = Order.builder().supplierName("supp9").build();
        Order order10 = Order.builder().supplierName("sup10").build();
        Order order11 = Order.builder().supplierName("supp11").build();

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);
        orderRepository.save(order5);
        orderRepository.save(order6);
        orderRepository.save(order7);
        orderRepository.save(order8);
        orderRepository.save(order9);
        orderRepository.save(order10);
        orderRepository.save(order11);

        Retailer retailer1 = Retailer.builder().name("retailer1").businessName("Buss Ret 1").address(address1).build();
        Retailer retailer2 = Retailer.builder().name("retailer2").businessName("Buss Ret 2").address(address2).build();
        Retailer retailer3 = Retailer.builder().name("retailer3").businessName("Buss Ret 3").address(address3).build();
        Retailer retailer4 = Retailer.builder().name("retailer4").businessName("Buss Ret 4").build();
        Retailer retailer5 = Retailer.builder().name("retailer5").businessName("Buss Ret 5").build();
        Retailer retailer6 = Retailer.builder().name("retailer6").businessName("Buss Ret 6").build();
        Retailer retailer7 = Retailer.builder().name("retailer7").businessName("Buss Ret 7").build();
        Retailer retailer8 = Retailer.builder().name("retailer8").businessName("Buss Ret 8").build();
        Retailer retailer9 = Retailer.builder().name("retailer9").businessName("Buss Ret 9").build();
        Retailer retailer10 = Retailer.builder().name("retailer10").businessName("Buss Ret 10").build();

        retailer1.getOrders().add(order1);
        retailer2.getOrders().add(order2);
        retailer3.getOrders().add(order3);
        retailer4.getOrders().add(order4);
        retailer5.getOrders().add(order5);
        retailer6.getOrders().add(order6);
        retailer7.getOrders().add(order7);
        retailer8.getOrders().add(order8);
        retailer9.getOrders().add(order9);
        retailer10.getOrders().add(order10);

        retailer1.getComments().add(comment1);
        retailer2.getComments().add(comment2);
        retailer3.getComments().add(comment3);

        retailerRepository.save(retailer1);
        retailerRepository.save(retailer2);
        retailerRepository.save(retailer3);
        retailerRepository.save(retailer4);
        retailerRepository.save(retailer5);
        retailerRepository.save(retailer6);
        retailerRepository.save(retailer7);
        retailerRepository.save(retailer8);
        retailerRepository.save(retailer9);
        retailerRepository.save(retailer10);

        Representative representative1 = Representative.builder().name("Rep1").build();
        Representative representative2 = Representative.builder().name("Rep2").build();
        Representative representative3 = Representative.builder().name("Rep3").build();
        Representative representative4 = Representative.builder().name("Rep4").build();
        Representative representative5 = Representative.builder().name("Rep5").build();


        representative1.getRetailers().add(retailer1);
        representative1.getRetailers().add(retailer2);
        representative2.getRetailers().add(retailer3);
        representative2.getRetailers().add(retailer4);
        representative3.getRetailers().add(retailer5);
        representative4.getRetailers().add(retailer6);
        representative4.getRetailers().add(retailer7);
        representative5.getRetailers().add(retailer8);
        representative5.getRetailers().add(retailer9);
        representative3.getRetailers().add(retailer10);

//        representative1.getAttendances().add(attendence1);
//        representative1.getAttendances().add(attendence4);
        representative1.getAttendances().add(attendence5);
        representative1.getAttendances().add(attendence6);
        representative2.getAttendances().add(attendence2);
        representative2.getAttendances().add(attendence7);
        representative2.getAttendances().add(attendence8);
        representative5.getAttendances().add(attendence3);
        representative5.getAttendances().add(attendence9);

        representativeRepository.save(representative1);
        representativeRepository.save(representative2);
        representativeRepository.save(representative3);
        representativeRepository.save(representative4);
        representativeRepository.save(representative5);

        Manager manager1 = Manager.builder().name("Man1").build();
        Manager manager2 = Manager.builder().name("Man2").build();

        Distributor distributor1 = Distributor.builder().name("dis1").address(address2).build();
        Distributor distributor2 = Distributor.builder().name("dis2").address(address1).build();
        Distributor distributor3 = Distributor.builder().name("dis3").build();
        Distributor distributor4 = Distributor.builder().name("dis4").address(address3).build();
        Distributor distributor5 = Distributor.builder().name("dis5").build();
        System.out.println(distributor5.getId());
        distributorService.save(distributor1);
        distributorService.save(distributor2);
        distributorService.save(distributor3);
        distributorService.save(distributor4);
        distributorService.save(distributor5);


        manager1.getDistributors().add(distributor1);
        manager1.getDistributors().add(distributor2);
        manager2.getDistributors().add(distributor3);
        manager2.getDistributors().add(distributor4);
        manager2.getDistributors().add(distributor5);
        System.out.println(distributor5.getId());

        manager1.getRepresentatives().add(representative1);
        manager1.getRepresentatives().add(representative2);
        manager1.getRepresentatives().add(representative3);
        manager2.getRepresentatives().add(representative4);
        manager2.getRepresentatives().add(representative5);

        manager1.getAttendances().add(attendence1);

        managerRepository.save(manager1);
        managerRepository.save(manager2);

    }
}
