package hr.ja.weboo;

import hr.ja.weboo.el.*;
import io.javalin.http.Context;
import lombok.Data;

@Data
@Route("/page1")
public class Page1 extends Page {
    Button button = new Button("klikni me");

    @Override
    public void doGet(Context ctx) {
        VerticalStack verticalStack = new VerticalStack();
        verticalStack.add(button);

        button.addClickListener(event -> {
          //  Browser.innerText(button.getId(), "novi text");

            button.setLabel("pero");
            Button bb = new Button("dsas");
            verticalStack.add(bb);
        });

        add(verticalStack);
    }


}