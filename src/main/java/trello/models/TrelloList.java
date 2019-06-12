package trello.models;

public class TrelloList {
    public String id;
    public String name;
    public Boolean closed;
    public String idBoard;
    String pos;

    @Override
    public String toString() {
        return "TrelloList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", closed=" + closed +
                ", pos=" + pos +
                ", idBoard=" + idBoard +
                '}';
    }
}
