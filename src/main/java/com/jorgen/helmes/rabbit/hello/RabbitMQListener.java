package com.jorgen.helmes.rabbit.hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jorgen.helmes.ClassifierRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.jorgen.helmes.util.JsonConverterUtil.convertMessageToJson;

@Component
@Slf4j
@RequiredArgsConstructor
//@RabbitHandler TODO: What the fuck is this?
public class RabbitMQListener {

    @RabbitListener(queues = "classification")
    public void receiveMessage(ClassifierRequest classifier) throws JsonProcessingException {
        log.info("RabbitMQ: Received a classifier: {}", convertMessageToJson(classifier));
    }

    @RabbitListener(queues = "everything")
    public void receiveMessage(String everything)  {
        log.info("RabbitMQ: Received a message: {}", everything);
    }
}
