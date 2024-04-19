package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BuyerDTO {
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String customerId;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String extCustomerId;
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String email;
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String phone;
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String firstName;
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String lastName;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getExtCustomerId() {
            return extCustomerId;
        }

        public void setExtCustomerId(String extCustomerId) {
            this.extCustomerId = extCustomerId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

}
