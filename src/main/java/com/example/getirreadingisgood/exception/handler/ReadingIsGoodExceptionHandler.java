package com.example.getirreadingisgood.exception.handler;

import com.example.getirreadingisgood.book.exception.BookException;
import com.example.getirreadingisgood.customer.exception.CustomerException;
import com.example.getirreadingisgood.order.exception.OrderException;
import com.example.getirreadingisgood.statistics.exception.StatisticsException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ReadingIsGoodExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BookException.class})
    public ResponseEntity<Object> handleBookException(BookException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler({CustomerException.class})
    public ResponseEntity<Object> handleCustomerException(CustomerException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler({OrderException.class})
    public ResponseEntity<Object> handleOrderException(OrderException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler({StatisticsException.class})
    public ResponseEntity<Object> handleOrderException(StatisticsException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        String bodyOfResponse = exception.getMessage();
        return new ResponseEntity(bodyOfResponse, headers, status);
    }
}
