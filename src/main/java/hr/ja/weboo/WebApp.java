package hr.ja.weboo;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.ja.weboo.el.Page;
import hr.ja.weboo.el.Route;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WebApp {


    private int port;

    private List<Class<? extends Page>> pageClassList = new ArrayList<>();

    private PageManager pageManager = new PageManager();

    public void addPage(Class<? extends Page> pageClass) {
        pageClassList.add(pageClass);
    }

    public static void main(String[] args) {
        WebApp app = new WebApp();
        app.addPage(Page1.class);
        app.start(8888);
    }

    public void start(int port) {
        this.port = port;
        Javalin app = Javalin.create(c -> {
            c.showJavalinBanner = false;
            //c.plugins.enableCors(corsContainer -> corsContainer.add(corsPluginConfig -> corsPluginConfig.allowCredentials = true));
            //c.staticFiles.add("/home/tag/IdeaProjects/Weboo2/Weboo2/src/main/resources/public", Location.EXTERNAL);
//            ObjectMapper objectMapper = new ObjectMapper();
//            c.jsonMapper(new JavalinJackson(objectMapper));
        }).start(port);


        for (Class<? extends Page> aClass : pageClassList) {
            String routeUrl = pageManager.add(aClass);

            app.get(routeUrl, ctx -> {
                Page page = pageManager.getPage(ctx, routeUrl);
                page.doGet(ctx);
            });
        }


    }

}

