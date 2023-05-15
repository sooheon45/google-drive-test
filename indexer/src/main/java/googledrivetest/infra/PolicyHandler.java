package googledrivetest.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import googledrivetest.config.kafka.KafkaProcessor;
import googledrivetest.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    IndexRepository indexRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FileUploaded'"
    )
    public void wheneverFileUploaded_Index(@Payload FileUploaded fileUploaded) {
        FileUploaded event = fileUploaded;
        System.out.println(
            "\n\n##### listener Index : " + fileUploaded + "\n\n"
        );

        // Sample Logic //
        Index.index(event);
    }
}
