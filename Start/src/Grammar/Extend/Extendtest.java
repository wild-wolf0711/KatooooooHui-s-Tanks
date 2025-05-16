package Grammar.Extend;

public class Extendtest {
    public static void main(String[] args){
        PC pc = new PC();
        NotePad np = new NotePad();
        pc.setBrand("英伟达");
        pc.info();
        np.setColor("黑色");
        np.info();
    }
}

class Computer{
    private String cpu;
    private String nc;
    private String yp;

    Computer(){
        cpu = "abc";
        nc = "1TB";
        yp = "666";
    }
    Computer(String c,String n,String y){
        cpu = c;
        nc = n;
        yp = y;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setNc(String nc) {
        this.nc = nc;
    }

    public void setYp(String yp) {
        this.yp = yp;
    }

    public void getDetails(){
        System.out.println("cpu : " + cpu);
        System.out.println("内存 : " + nc);
        System.out.println("硬盘 : " + yp);
    }
}

class PC extends Computer{
    String brand;
    PC(){
        super("abc","1TB","donk");
        brand = "英伟达";
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void info(){
        System.out.println("======");
        getDetails();
        System.out.println("Brand : " + brand);
        System.out.println("======");
    }
}

class NotePad extends Computer{
    String color;
    NotePad(){
        super("abc","1TB","donk");
        color = "黑色";
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void info(){
        System.out.println("======");
        getDetails();
        System.out.println("color : " + color);
        System.out.println("======");
    }
}