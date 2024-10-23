package main.lesson20;

public class Counter {
    private Integer count;

    public Counter(Integer count) {
        this.count = count;
    }

    public void increase(){
        count++;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }
}
