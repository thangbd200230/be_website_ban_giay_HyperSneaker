package com.spring.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Bill")
public class Bill implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    @Column(name = "Code")
    private String Code;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PurchaseDate")
    private Date PurchaseDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EstimatedDate")
    private Date EstimatedDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PaymentDate")
    private Date PaymentDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DelyveryDate")
    private Date DelyveryDate;
    @Column(name = "TotalPrice")
    private BigDecimal TotalPrice;
    @Column(name = "ShipPrice")
    private BigDecimal ShipPrice;
    @Column(name = "TotalPriceLast")
    private BigDecimal TotalPriceLast;
    @Column(name = "Note")
    private String Note;
    @Column(name = "PayType")
    private Integer PayType;
    @Column(name = "PayStatus")
    private Integer PayStatus;
    @Column(name = "CodeGHN")
    private String CodeGHN;
    @Column(name = "IdCoupon")
    private Integer IdCoupon;
    @Column(name = "Status")
    private Integer Status;
    @Column(name = "TypeStatus")
    private Integer TypeStatus;
    @ManyToOne
    @JoinColumn(name = "IdAddress")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "IdCustomer")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "IdEmployee")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "IdVoucher")
    private Voucher voucher;
    @OneToMany(mappedBy = "bill")
    private Set<BillDetail> billDetails = new HashSet<BillDetail>();
    @JsonIgnore
    @OneToMany(mappedBy = "bill")
    private Set<BillHistory> billHistories = new HashSet<BillHistory>();

}
