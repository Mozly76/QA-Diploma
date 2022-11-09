package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ru.netology.data.DBUtils.CreditRequestEntity;
import ru.netology.data.DBUtils.OrderEntity;
import ru.netology.data.DBUtils.PaymentEntity;

import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertNull;

public class DBHelper {
    private static String url = System.getProperty("datasource.url");
    private static String user = "app";
    private static String password = "pass";

    private DBHelper() {
    }

    @SneakyThrows
    public static void cleanData() {
        var runner = new QueryRunner();
        var cleanCreditRequest = "DELETE FROM credit_request_entity;";
        var cleanPayment = "DELETE FROM payment_entity;";
        var cleanOrder = "DELETE FROM order_entity;";

        try (var conn = DriverManager.getConnection(url, user, password)) {
            runner.update(conn, cleanCreditRequest);
            runner.update(conn, cleanPayment);
            runner.update(conn, cleanOrder);
        }
    }

    @SneakyThrows
    public static PaymentEntity payData() {
        var runner = new QueryRunner();
        var reqStatus = "SELECT * FROM payment_entity ORDER BY created DESC LIMIT 1;";
        try (var conn = DriverManager.getConnection(url, user, password)) {
            var payData = runner.query(conn, reqStatus, new BeanHandler<>(PaymentEntity.class));
            return payData;
        }
    }

    @SneakyThrows
    public static CreditRequestEntity creditData() {
        var runner = new QueryRunner();
        var selectStatus = "SELECT * FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
        try (var conn = DriverManager.getConnection(url, user, password)) {
            var creditData = runner.query(conn, selectStatus, new BeanHandler<>(CreditRequestEntity.class));
            return creditData;
        }
    }

    @SneakyThrows
    public static OrderEntity orderData() {
        var runner = new QueryRunner();
        var selectStatus = "SELECT * FROM order_entity ORDER BY created DESC LIMIT 1;";
        try (var conn = DriverManager.getConnection(url, user, password)) {
            var orderData = runner.query(conn, selectStatus, new BeanHandler<>(OrderEntity.class));
            return orderData;
        }
    }

    @SneakyThrows
    public static void checkEmptyOrderEntity() {
        var runner = new QueryRunner();
        var orderRequest = "SELECT * FROM order_entity;";
        try (var conn = DriverManager.getConnection(url, user, password)) {
            var orderBlock = runner.query(conn, orderRequest, new BeanHandler<>(OrderEntity.class));
            assertNull(orderBlock);
        }
    }

    @SneakyThrows
    public static void checkEmptyPaymentEntity() {
        var runner = new QueryRunner();
        var orderRequest = "SELECT * FROM payment_entity";
        try (var conn = DriverManager.getConnection(url, user, password)) {
            var paymentBlock = runner.query(conn, orderRequest, new BeanHandler<>(PaymentEntity.class));
            assertNull(paymentBlock);
        }
    }

    @SneakyThrows
    public static void checkEmptyCreditEntity() {
        var runner = new QueryRunner();
        var orderRequest = "SELECT * FROM credit_request_entity;";
        try (var conn = DriverManager.getConnection(url, user, password)) {
            var creditBlock = runner.query(conn, orderRequest, new BeanHandler<>(CreditRequestEntity.class));
            assertNull(creditBlock);
        }
    }
}