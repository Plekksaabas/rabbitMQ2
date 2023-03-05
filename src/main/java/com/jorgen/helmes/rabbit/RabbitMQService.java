package com.jorgen.helmes.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.jorgen.helmes.util.JsonConverterUtil.convertMessageToJson;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQService {
    private final RabbitTemplate rabbitTemplate;

    @SneakyThrows
    public void sendMessage(String queue, Object message) {
        rabbitTemplate.convertAndSend(queue, message);
        log.info("RabbitMQ: sent a message: {}", convertMessageToJson(message));
    }
}
