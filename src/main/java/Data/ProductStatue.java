package Data;

import java.time.LocalDate;

public class ProductStatue {
    private int productId;
    private boolean isAvailable = true;
    private String checkoutCustomerName = null;
    private LocalDate checkoutDate = null;
    private LocalDate returnData = null;

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getCheckoutCustomerName() {
        return checkoutCustomerName;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getReturnData() {
        return returnData;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setCheckoutCustomerName(String checkoutCustomerName) {
        this.checkoutCustomerName = checkoutCustomerName;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public void setReturnData(LocalDate returnData) {
        this.returnData = returnData;
    }
}
