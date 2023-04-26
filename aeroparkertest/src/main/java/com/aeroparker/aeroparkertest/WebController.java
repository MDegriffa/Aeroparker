package com.aeroparker.aeroparkertest;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
   @Autowired
   DataSource dataSource;
   String INSERT_CUSTOMER_QUERY = "insert into customers (first_name, last_name, email_address, title, address_line_1, address_line_2, city, postcode, phone_number, registered) values ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
   @RequestMapping(value = "/registration")
   public String index() {
      return "registration";
   }

   private boolean isValidInput(Customer customer){
      if(customer.getFirst_name() == null || customer.getLast_name() == null
      || customer.getAddress_line_1() == null || customer.getTitle() == null
      || customer.getEmail_address() == null || customer.getPostcode() == null)
         return false;
      return true;
   }

   @RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
   public String handleRegistration(@RequestParam Map <String, String> body) {
      Customer customer = new Customer();
      customer.setFirst_name(body.get("fname"));
      customer.setLast_name(body.get("lname"));
      customer.setEmail_address(body.get("email_address"));
      customer.setTitle(body.get("title"));
      customer.setCity(body.get("city"));
      customer.setPostcode(body.get("postcode"));
      customer.setPhone_number(body.get("phone_number"));
      customer.setAddress_line_1(body.get("address_line_1"));
      customer.setAddress_line_2(body.get("address_line_2"));

      if(isValidInput(customer)){
         try {
            dataSource.getConnection().prepareStatement(prepareStatement(customer)).executeUpdate();
         } catch (SQLException e) {
            return "error";
         }
         return "success";
      }
      return "error";
 
   }
   private String prepareStatement(Customer customer){
      LocalDateTime myDateObj = LocalDateTime.now();
      DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String formattedDate = myDateObj.format(myFormatObj);
      return String.format(INSERT_CUSTOMER_QUERY,customer.getFirst_name(), customer.getLast_name(), customer.getEmail_address(),customer.getTitle(), customer.getAddress_line_1(),customer.getAddress_line_2(),customer.getCity(), customer.getPostcode(), customer.getPhone_number(), formattedDate);     
   }
}