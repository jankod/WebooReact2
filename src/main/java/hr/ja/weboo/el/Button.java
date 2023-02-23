package hr.ja.weboo.el;

import hr.ja.weboo.MyUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Button extends BaseElement implements ClickProducer {

    private String label;

    public Button(String label, ClickListener clickListener) {
        this.label = label;
        this.addClickListener(clickListener);
    }

    public Button(String label) {
        this.label = label;
    }


    @Override
    public String render() {
        String json = MyUtil.toJson(this);
        String templateRect = """
                """;
        String template = """
                <button x-data='${this}' x-text='label' :class='classes' :id='id' type='button' @click=''>label</button>
                """;
        return template.replace("${this}", json);
    }

    public static void main(String[] args) {
        Button b = new Button("pero");
        b.addClass("btn btn-primary dva");
        b.addClickListener(event -> {
            b.setLabel("new label");
            log.debug("dela", event.eventInfo());
        });
        String html = b.render();
        b.removeClass("dva");

        log.debug(html);
    }

    public void setLabel(String label) {
        this.label = label;
        Alpine.data("label", label);
        //Browser.innerText(getId(), label);

    }
}