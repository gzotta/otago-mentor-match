package web;

import org.jooby.Jooby;
import org.jooby.Results;

/**
 *
 * @author George Zotta
 */
public class AssetsModule extends Jooby {

    public AssetsModule() {
        assets("/*.html");
        assets("/css/*.css");
        assets("/js/*.js");
        assets("/img/*.png");
        assets("/img/*.jpeg");
        assets("/img/*.jpg");
// make index.html the default page
        assets("/", "index.html");
// prevent 404 errors due to browsers requesting favicons
        get("/favicon.ico", () -> Results.noContent());
    }
}
