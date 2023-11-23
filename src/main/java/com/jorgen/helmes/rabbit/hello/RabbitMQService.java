package com.jorgen.helmes.rabbit.hello;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    public void sendMessage(String queue, Object message) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(queue, message);
        log.info("RabbitMQ: sent a message: {}", convertMessageToJson(message));
    }
}
