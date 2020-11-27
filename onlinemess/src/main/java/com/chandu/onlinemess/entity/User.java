package com.chandu.onlinemess.entity;

import com.chandu.onlinemess.common.enums.Gender;
import com.chandu.onlinemess.common.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER")
public class User {
   @Id
   @Column(name="ID")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name="USER_NAME")
   private String userName;

   @Column(name="PASSWORD")
   private String password;

   @Column(name="FIRST_NAME")
   private String firstName;

   @Column(name = "LAST_NAME")
   private String lastName;

   @Column(name = "EMAIL")
   private String email;

   @Column(name = "PHONE")
   private String phone;

   @Enumerated(EnumType.STRING)
   @Column(name = "GENDER")
   private Gender gender;

   @Enumerated(EnumType.STRING)
   @Column(name = "ROLE")
   private Role role;

}
