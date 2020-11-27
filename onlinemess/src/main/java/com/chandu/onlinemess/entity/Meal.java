package com.chandu.onlinemess.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MEAL")
public class Meal {

   @Id
   @Column(name="ID")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "MENU_ID")
   private Long menuId;

   @Column(name = "DATE")
   private Date date;

   @Column(name = "QUANTITY")
   private Integer quantity;

   @Column(name = "COST")
   private Double cost;

}
