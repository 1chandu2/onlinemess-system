package com.chandu.onlinemess.dto;

import com.chandu.onlinemess.common.enums.Gender;
import com.chandu.onlinemess.common.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
   @NotBlank
   @JsonProperty("user_name")
   private String userName;

   @JsonProperty("password")
   @NotBlank
   @ToString.Exclude
   private String password;

   @JsonProperty("first_name")
   private String firstName;

   @JsonProperty("last_name")
   private String lastName;

   private String email;
   private String phone;
   private Gender gender;

   private Role role;
}
