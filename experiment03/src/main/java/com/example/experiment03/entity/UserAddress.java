package com.example.experiment03.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter@Setter
@NoArgsConstructor
@Entity
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Address address;
    @Column(columnDefinition = "Timestamp not null default current_timestamp",
                                insertable = false,updatable = false)
    private LocalDateTime insertTime;
    public UserAddress(User user1,Address address1){
        this.user = user1;
        this.address = address1;
    }

}
