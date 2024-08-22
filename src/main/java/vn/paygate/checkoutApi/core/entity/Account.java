package vn.paygate.checkoutApi.core.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Account {
    @Id
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobile;
    private String fullName;
    @Column(name = "end_date_balance")
    private BigDecimal endDateBalance;
    @Column(name = "end_date")
    private Date endDate;
}
