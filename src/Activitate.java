public class Activitate {
    private String nume;
    private Data data;

    public Activitate(String nume, Data data) {
        this.nume = nume;
        this.data = data;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getNume() {
        return nume;
    }

    public Data getData() {
        return data;
    }

    public void showActivitate()
    {
        System.out.println("Nume:"+nume);
        System.out.println("Data:"+data.getZi()+"/"+data.getLuna()+"/"+data.getAn());
        System.out.println();

    }
}
