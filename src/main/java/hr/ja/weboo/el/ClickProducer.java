package hr.ja.weboo.el;

import hr.ja.weboo.MyUtil;

public interface ClickProducer extends HasId {

    default void addClickListener(ClickListener clickListener) {
        MyUtil.clickListener(getId(), clickListener);
    }
}