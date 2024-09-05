package online.store.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CheckoutRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String shippingAddress;

    private List<ProductInfo> products;

    private String creditCard;

    public static class ProductInfo {
        private long productId;
        private long quantity;

        public ProductInfo(long productId, long quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public long getProductId() {
            return productId;
        }

        public void setProductId(long productId) {
            this.productId = productId;
        }

        public long getQuantity() {
            return quantity;
        }

        public void setQuantity(long quantity) {
            this.quantity = quantity;
        }
    }

    public static boolean isNullOrBlank(String input){
        return input == null || input.isEmpty() || input.trim().length() == 0;
    }

}
