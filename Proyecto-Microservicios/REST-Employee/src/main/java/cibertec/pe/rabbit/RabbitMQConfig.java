package cibertec.pe.rabbit;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class RabbitMQConfig {
    public static final String EXCHANGE = "empleado.exchange";
    public static final String ROUTING_KEY = "empleado.routingkey";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);

    }
}
