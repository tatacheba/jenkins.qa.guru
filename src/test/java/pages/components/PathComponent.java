package pages.components;

public class PathComponent {
    public String converterCheckPath(String path) {
        String[] pathArray = path.split("\\/");
        return pathArray[pathArray.length - 1];
    }
}
