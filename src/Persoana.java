class Persoana {
    //atribute
    private String nume;
    private Data data_nasterii = new Data() ;
    private int varsta;

    //constructori
    public Persoana()
    {
        nume="";
        data_nasterii= new Data(1,1,1);
        varsta = 0;
    }
    public Persoana(String nume, Data data, int varsta)
    {
        this.nume = nume;
        this.data_nasterii.setData(data);
        this.varsta = varsta;
    }


   public Persoana(Persoana p)
   {
       this.nume = p.nume;
       this.data_nasterii.setData(p.data_nasterii);
       this.varsta = p.varsta;
   }

   public String getNume()
   {
       return this.nume;
   }

   public Data getData()
   {
       return this.data_nasterii;
   }

   public int getVarsta()
   {
       return this.varsta;
   }

   public void showPersoana()
   {
       System.out.println("Nume:"+nume);
       System.out.println("Data:"+data_nasterii.getZi()+"/"+data_nasterii.getLuna()+"/"+data_nasterii.getAn());
       System.out.println("Varsta:"+varsta);
       System.out.println();

   }

   public void setNume(String nume)
   {
       this.nume =new String(nume);
   }
   public void setData(Data data)
   {
       this.data_nasterii = data;
   }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
