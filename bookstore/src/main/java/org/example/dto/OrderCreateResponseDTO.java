package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class OrderCreateResponseDTO {
        @JsonProperty("status")
        private Status status;

        @JsonProperty("redirectUri")
        private String redirectUri;

        @JsonProperty("orderId")
        private String orderId;

        @JsonProperty("extOrderId")
        private String extOrderId;

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public String getRedirectUri() {
            return redirectUri;
        }

        public void setRedirectUri(String redirectUri) {
            this.redirectUri = redirectUri;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getExtOrderId() {
            return extOrderId;
        }

        public void setExtOrderId(String extOrderId) {
            this.extOrderId = extOrderId;
        }

    @Override
    public String toString() {
        return "OrderCreateResponse{" +
                "status=" + status +
                ", redirectUri='" + redirectUri + '\'' +
                ", orderId='" + orderId + '\'' +
                ", extOrderId='" + extOrderId + '\'' +
                '}';
    }
}
