package com.jorgen.helmes.rabbit.worker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMQListener {
    @RabbitListener(queues = "worker_queue")
    public void firstReceiver(String message) {
        System.out.println(" [x] Received '" + message + "'");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Task interrupted");
        }

        System.out.println(" [x] Done processing '" + message + "'");
    }

    @RabbitListener(queues = "worker_queue")
    public void secondReceiver(String message) {
        System.out.println(" [x] Received '" + message + "'");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Task interrupted");
        }

        System.out.println(" [x] Done processing '" + message + "'");
    }
}
