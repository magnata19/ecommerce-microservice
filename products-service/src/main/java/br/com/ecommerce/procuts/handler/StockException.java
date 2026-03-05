package br.com.ecommerce.procuts.handler;

public class StockException extends RuntimeException {
    public StockException(String message) {
        super(message);
    }
}
