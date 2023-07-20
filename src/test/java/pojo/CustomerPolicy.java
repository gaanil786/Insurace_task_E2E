package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPolicy {
    @JsonProperty("product_code")
    private String productCode;
    private String category;
    private String customer_email;
    private String customer_salutation;
    private String customer_first_name;
    private String customer_last_name;
    private String customer_street;
    private String customer_street_number;
    private String customer_zip;
    private String customer_city;
    private String customer_country;
    private String identifiers_0_serialNumber;
    private String identifiers_0_name;
    private String identifiers_0_orderNumber;
    private String identifiers_0_invoiceNumber;
}
