package pageUI.wordpress;

public class AbstractPageUI {
    public static final String POST_NAVIGATION_MENU = "//div[@class='wp-menu-name' and text() = 'Posts']";
    public static final String MEDIA_NAVIGATION_MENU = "//div[@class='wp-menu-name' and text() = 'Media']";
    public static final String PAGE_NAVIGATION_MENU = "//div[@class='wp-menu-name' and text() = 'Pages']";
    public static final String DASHBOARD_NAVIGATION_MENU = "//div[@class='wp-menu-name' and text() = 'Dashboard']";
    public static final String DYNAMIC_NAVIGATION = "//div[@class='wp-menu-name' and text() = '%s']";

    //Dynamic locator
    public static final String UPLOAD_TYPE = "//input[@type = 'file']";
    public static final String MEDIA_PROGRESS = "//div[@class='thumbnail']/div[@class='media-progress-bar']";
    public static final String ALL_UPLOADED_IMAGE = "//div[@class=thumbnail']//img";
}
