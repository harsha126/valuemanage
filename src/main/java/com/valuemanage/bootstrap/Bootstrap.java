package com.valuemanage.bootstrap;

import com.valuemanage.domain.*;
import com.valuemanage.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final AttendenceRepository attendenceRepository;
    private final CommentRepository commentRepository;
    private final ManagerRepository managerRepository;
    private final OrderRepository orderRepository;
    private final ReportRepository reportRepository;
    private final RepresentativeRepository representativeRepository;
    private final RetailerRepository retailerRepository;

    public Bootstrap(AddressRepository addressRepository, AttendenceRepository attendenceRepository, CommentRepository commentRepository, ManagerRepository managerRepository, OrderRepository orderRepository, ReportRepository reportRepository, RepresentativeRepository representativeRepository, RetailerRepository retailerRepository) {
        this.addressRepository = addressRepository;
        this.attendenceRepository = attendenceRepository;
        this.commentRepository = commentRepository;
        this.managerRepository = managerRepository;
        this.orderRepository = orderRepository;
        this.reportRepository = reportRepository;
        this.representativeRepository = representativeRepository;
        this.retailerRepository = retailerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
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

        Attendence attendence1 = Attendence.builder().date(date).build();
        Attendence attendence2 = Attendence.builder().date(date).build();
        Attendence attendence3 = Attendence.builder().date(date).build();
        Attendence attendence4 = Attendence.builder().date(date).build();
        attendenceRepository.save(attendence1);
        attendenceRepository.save(attendence2);
        attendenceRepository.save(attendence3);
        attendenceRepository.save(attendence4);

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
        Order order11= Order.builder().supplierName("supp11").build();

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

        Retailer retailer1 = Retailer.builder().name("retailer1").build();
        Retailer retailer2 = Retailer.builder().name("retailer2").build();
        Retailer retailer3 = Retailer.builder().name("retailer3").build();
        Retailer retailer4 = Retailer.builder().name("retailer4").build();
        Retailer retailer5 = Retailer.builder().name("retailer5").build();
        Retailer retailer6 = Retailer.builder().name("retailer6").build();
        Retailer retailer7 = Retailer.builder().name("retailer7").build();
        Retailer retailer8 = Retailer.builder().name("retailer8").build();
        Retailer retailer9 = Retailer.builder().name("retailer9").build();
        Retailer retailer10 = Retailer.builder().name("retailer10").build();

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

        representative1.getAttendances().add(attendence1);
        representative2.getAttendances().add(attendence2);
        representative5.getAttendances().add(attendence3);

        representativeRepository.save(representative1);
        representativeRepository.save(representative2);
        representativeRepository.save(representative3);
        representativeRepository.save(representative4);
        representativeRepository.save(representative5);

        Manager manager1 = Manager.builder().name("Man1").build();
        Manager manager2 = Manager.builder().name("Man2").build();

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
