package hr.ja.weboo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.ja.weboo.el.BaseElement;
import hr.ja.weboo.el.Button;
import hr.ja.weboo.el.ClickListener;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;

public class MyUtil {

    public static void clickListener(String componentId, ClickListener clickListener) {
    }

    public static String createPageId() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public static String createElementId() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public static void add(BaseElement element, String pageId) {

    }

    private static ObjectMapper mapper = new ObjectMapper();

    static  {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

    }

    @SneakyThrows
    public static String toJson(Object button) {
        return mapper.writeValueAsString(button);
    }

}

