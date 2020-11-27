package com.chandu.onlinemess.entity;

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
@Table(name="ITEM")
public class Item {

   @Id
   @Column(name="ID")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "FULL_NAME")
   private String fullName;

   @Column(name = "SHORT_NAME")
   private String shortName;

   @Column(name = "DESCRIPTION")
   private String description;

   @Column(name = "IS_AVAILABLE")
   private Boolean isAvailable;

}
