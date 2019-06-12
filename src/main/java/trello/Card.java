package trello;

import com.google.gson.annotations.SerializedName;

public class Card {
    public String id;
    public String desc;
    public String idBoard;
    public String idList;
    public String name;
    public String url;

    //public Ship ship;

    //(serialize -> to underline String)
    @SerializedName("1_WOW_ASD$q")
    public String wow;

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", iBoard='" + idBoard + '\'' +
                ", idList='" + idList + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
