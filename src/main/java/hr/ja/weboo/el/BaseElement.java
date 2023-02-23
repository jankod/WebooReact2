package hr.ja.weboo.el;

import hr.ja.weboo.MyUtil;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BaseElement implements HasId {

    private String id = MyUtil.createElementId();

    private String classes = "";

    private List<BaseElement> children = new ArrayList<>();

    public void add(BaseElement element) {
        children.add(element);
    }


    public BaseElement addClass(String classes) {
        this.classes += " " + classes;
        return this;
    }

    public BaseElement removeClass(String... clazz) {
        this.classes.replace(classes, " ");
        return this;
    }

    public String render() {
        return "<div>no render</div>";
    }
}