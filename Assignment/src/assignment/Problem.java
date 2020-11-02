package assignment;

public class Problem {
    private String problem;
    private String date;
    private String name;
    private String short_decrip;
    private String long_decrip;
    private double mark_weight;
    private int category;
    private String author;

    public Problem() {
    }

    public Problem(String problem, String date, String name, String short_decrip, String long_decrip, double mark_weight, int category, String author) {
        this.problem = problem;
        this.date = date;
        this.name = name;
        this.short_decrip = short_decrip;
        this.long_decrip = long_decrip;
        this.mark_weight = mark_weight;
        this.category = category;
        this.author = author;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_decrip() {
        return short_decrip;
    }

    public void setShort_decrip(String short_decrip) {
        this.short_decrip = short_decrip;
    }

    public String getLong_decrip() {
        return long_decrip;
    }

    public void setLong_decrip(String long_decrip) {
        this.long_decrip = long_decrip;
    }

    public double getMark_weight() {
        return mark_weight;
    }

    public void setMark_weight(double mark_weight) {
        this.mark_weight = mark_weight;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Problem{" + "problem=" + problem + ", date=" + date + ", name=" + name + ", short_decrip=" + short_decrip + ", long_decrip=" + long_decrip + ", mark_weight=" + mark_weight + ", category=" + category + ", author=" + author + '}';
    }
    
    
}
