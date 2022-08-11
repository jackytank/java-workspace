package com.example.lab8.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String address;
    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    Date createDate = new Date();
    @ManyToOne
    @JoinColumn(name = "Username")
    Account account;

    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;
}
