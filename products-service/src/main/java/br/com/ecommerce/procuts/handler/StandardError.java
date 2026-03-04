package br.com.ecommerce.procuts.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

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
