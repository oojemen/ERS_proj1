package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reimbursements")
public class Reimbursement {


    @Id
    @Column(name = "reimb_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id_fk")
    private User user;

    @ManyToOne(targetEntity = Status.class)
    @JoinColumn(name = "status_id_fk")
    private Status status;

}

// referencedColumnName = "person_id"

// referencedColumnName = "status_id"