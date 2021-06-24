package T06objectsAndClasses.lab.P04Songs;

public class P04Song {
    private String typeList;
    private String name;
    private String time;

    public P04Song(String typeList, String name, String time) {
        this.typeList = typeList;
        this.name = name;
        this.time = time;
    }

    public String getTypeList() {
        return typeList;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
}
