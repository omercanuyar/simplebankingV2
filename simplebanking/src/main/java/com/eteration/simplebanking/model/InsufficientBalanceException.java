package com.eteration.simplebanking.model;

public class InsufficientBalanceException extends Exception {
    private static final long serialVersionUID = 1L; // Serileştirme için uzun bir numara

    // Yapıcı metod
    public InsufficientBalanceException(String message) {
        super(message); // Üst sınıfın yapıcısına mesajı ilet
    }
}