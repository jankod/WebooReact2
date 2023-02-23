package hr.ja.weboo;

import hr.ja.weboo.el.Page;
import hr.ja.weboo.el.Route;
import io.javalin.http.Context;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class PageManager {

    private Map<String, Class<? extends Page>> urlPageMap = new HashMap<>();

    @SneakyThrows
    public Page getPage(Context ctx, String routeUrl) {
        PageSessionHolder sess = ctx.sessionAttribute("_page");
        if (sess == null) {
            Class<? extends Page> pageClass = urlPageMap.get(routeUrl);
            Page page = pageClass.getConstructor().newInstance();
            sess = new PageSessionHolder(page, routeUrl);
            ctx.sessionAttribute("_page", sess);
            return page;
        }
        return sess.getPage();

    }

    public String add(Class<? extends Page> pageClass) {
        Route annotation = pageClass.getAnnotation(Route.class);
        String routeUrl = annotation.value();
        urlPageMap.put(routeUrl, pageClass);
        return routeUrl;
    }
}

@Data
class PageSessionHolder {

    private final Page page;
    private final String routeUrl;

    public PageSessionHolder(Page page, String routeUrl) {
        this.page = page;
        this.routeUrl = routeUrl;
    }

}
