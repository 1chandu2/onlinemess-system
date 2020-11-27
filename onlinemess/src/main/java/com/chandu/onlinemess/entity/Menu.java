package com.chandu.onlinemess.entity;

import com.chandu.onlinemess.common.enums.TimeSlot;
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
@Table(name="MENU")
public class Menu {

   @Id
   @Column(name="ID")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Enumerated(EnumType.STRING)
   @Column(name = "TIME_SLOT")
   private TimeSlot timeSlot;

   @Column(name = "ITEM_ID")
   private Long itemId;

   @Column(name = "DATE")
   private Date date;

   @Column(name = "COST")
   private Double itemCost;

   @Column(name = "IS_ACTIVE")
   private Boolean isActive;
}
