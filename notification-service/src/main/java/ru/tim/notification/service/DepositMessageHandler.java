package ru.tim.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.tim.notification.config.RabbitMQConfig;

@Service
public class DepositMessageHandler {

    private final JavaMailSender javaMailSender;

    @Autowired
    public DepositMessageHandler(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_DEPOSIT)
    public void receive(Message message) throws JsonProcessingException {
        System.out.println(message);
        byte[] body = message.getBody();
        String jsonBody = new String(body);
        ObjectMapper objectMapper = new ObjectMapper();
       DepositResponseDTO depositResponseDTO = objectMapper.readValue(jsonBody,DepositResponseDTO.class);
       System.out.println(depositResponseDTO);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(depositResponseDTO.getMail());
        mailMessage.setFrom("0c31039241-871325@inbox.mailtrap.io");

        mailMessage.setSubject("Deposit");
        mailMessage.setText("Make deposit, sum:" + depositResponseDTO.getAmount());

        try {
            javaMailSender.send(mailMessage);
        } catch (Exception exception){
            System.out.println(exception);
        }
    }
}
