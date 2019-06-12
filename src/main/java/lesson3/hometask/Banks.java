package lesson3.hometask;

public class Banks {
    private String name;
    private String url;
    private double sell;
    private double buy;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public double getSell() {
        return sell;
    }

    public double getBuy() {
        return buy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    @Override
    public String toString() {
        return "Banks{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", sell=" + sell +
                ", buy=" + buy +
                '}';
    }
}
