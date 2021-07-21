package ee.mihkel.webshopbackend.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductErrorResponse {
    private Date date;
    private HttpStatus status;
    private String message;
}
