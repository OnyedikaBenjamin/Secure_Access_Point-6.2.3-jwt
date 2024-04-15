package com.benjamin.sbs_jwt.dtos;

import com.benjamin.sbs_jwt.entities.OurUsers;
import com.benjamin.sbs_jwt.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)                                                                                   // This annotation is used during deserialization (converting JSON into Java objects). It instructs Jackson to ignore any properties in the incoming JSON that don't have corresponding fields in the RequestResponse class. This can be helpful when dealing with JSON data that might contain additional properties you don't expect or use in your application. By ignoring them, you avoid potential errors or unexpected behavior.
@JsonInclude(JsonInclude.Include.NON_NULL)                                                                                   // This annotation is used during serialization (converting Java objects into JSON). It tells Jackson to only include fields in the resulting JSON that have non-null values. This can help reduce the size of the JSON output and eliminate unnecessary information, especially if your RequestResponse class has many fields.
public class RequestResponse {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String name;
    private String email;
    private String role;
    private String password;
    private List<Product> productList;
    private OurUsers ourUsers;
}
