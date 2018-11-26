public class PunctColorat extends Punct {

    private String culoare;
    public PunctColorat(int x, int y,String culoare)
    {
        super(x,y);
        this.culoare = culoare;
    }

    public String getCuloare() {
        return culoare;
    }
    public String toString()
    {
        String s = super.toString();
        s = s+"culoare=" + culoare;
        return s;
    }
}
