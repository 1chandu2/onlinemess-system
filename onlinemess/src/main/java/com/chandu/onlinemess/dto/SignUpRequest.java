package com.chandu.onlinemess.dto;

import com.chandu.onlinemess.common.enums.Gender;
import com.chandu.onlinemess.common.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
public class SignUpRequest {

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
}
