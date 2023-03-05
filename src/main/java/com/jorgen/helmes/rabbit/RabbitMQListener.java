package com.jorgen.helmes.rabbit;

import com.jorgen.helmes.ClassifierRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.jorgen.helmes.util.JsonConverterUtil.convertMessageToJson;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMQListener {

    @SneakyThrows
    @RabbitListener(queues = "queue")
    public void receiveMessage(ClassifierRequest classifier)  {
        log.info("RabbitMQ: Received a classifier: {}", convertMessageToJson(classifier));
    }
}
