package my.homeprojects.springms.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private Integer id;
    private String streetName;
    private Integer district;
    private Integer streetNumber;
    private String County;
}
