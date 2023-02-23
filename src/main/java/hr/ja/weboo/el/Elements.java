package hr.ja.weboo.el;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Elements {

    public static void main(String[] args) throws JsonProcessingException {
        VerticalStack v = new VerticalStack();
        v.add(new Button("Pero", e -> {
            log.debug("Dobio neki event ", e.eventInfo());
            v.add(new Button("adasd"));
        }));
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(v);
        System.out.println(json);
    }
}


