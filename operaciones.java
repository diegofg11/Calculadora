class operaciones {
    private int a;
    private int b;

    public operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int suma() {
        return a + b;
    }

    public int resta() {
        return a - b;
    }

    public int producto() {
        return a * b;
    }

    public double cociente() {
        return (double) a / b;
    }
}
