package cibertec.pe;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    @RabbitListener(queues = "notificacion.queue")
    public void recibirMensaje(String mensaje) {
        System.out.println("Nuevo Mensaje Recibido: ");
        System.out.println("Detalle: " + mensaje);
        // Logica para enviar por correo
    }
}
