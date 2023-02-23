package hr.ja.weboo.el;

import hr.ja.weboo.MyUtil;
import io.javalin.http.Context;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Page {


    private String pageId = MyUtil.createPageId();

    private List<BaseElement> elements = new ArrayList<>();

    public void doGet(Context ctx) {
    }

    public BaseElement add(BaseElement element) {
        elements.add(element);
        MyUtil.add(element, pageId);
        return element;
    }
}
