package br.com.ecommerce.users.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class StandardError {

    private Long timestamp;
    private Integer Status;
    private String error;
    private String message;
    private String path;

    public StandardError() {
        super();
    }

}
