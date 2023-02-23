package hr.ja.weboo.el;

import lombok.Data;

@Data
public class Div {

    String name = "ddd";


    String html = """
            <div class='bold'></div>
            """;

    String classNames;
}
