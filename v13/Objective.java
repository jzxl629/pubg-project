public class Objective {
    String name;
    double priority;
    public Objective(String name){
        this.name = name;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double p){
        this.priority = p;
    }

    @Override
    public String toString() {
        return name + "\nPV: " + priority + "\n";
    }
}
