import java.io.*;
public class Repo {
    private int lungimePersoane=0;
    private int lungimeActivitati=0;
    private Persoana repoPersoane[] = new Persoana[150];
    private Activitate repoActivitati[] = new Activitate[150];
    Repo()
    {
        try{
            FileReader inPersoane= new FileReader("Persoane.txt");
            BufferedReader BR = new BufferedReader(inPersoane);
            lungimePersoane = Integer.parseInt(BR.readLine());
            for(int i=0; i<lungimePersoane;i++) {
                String nume= BR.readLine();
                int zi,luna,an;
                zi= Integer.parseInt(BR.readLine());
                luna= Integer.parseInt(BR.readLine());
                an=Integer.parseInt(BR.readLine());
                Data data= new Data(zi,luna,an);
                int varsta = Integer.parseInt(BR.readLine());
                BR.readLine();

                Persoana p =new Persoana(nume,data,varsta);
                addRepoPersoanaPos(p,i);


            }
        }catch (Exception ex){ex.printStackTrace();}

        try{
            FileReader inActivitati= new FileReader("Activitati.txt");
            BufferedReader BR = new BufferedReader(inActivitati);
            lungimeActivitati = Integer.parseInt(BR.readLine());
            for(int i=0; i<lungimeActivitati;i++) {
                String nume= BR.readLine();
                int zi,luna,an;
                zi= Integer.parseInt(BR.readLine());
                luna= Integer.parseInt(BR.readLine());
                an=Integer.parseInt(BR.readLine());
                Data data= new Data(zi,luna,an);
                BR.readLine();

                Activitate a =new Activitate(nume,data);
                addRepoActivitatePos(a,i);


            }
        }catch (Exception ex){ex.printStackTrace();}
    }

    //------------------------------------------------------------------------------------------------------------------
    //Persoane
    public void addRepoPersoana(Persoana p)
    {
        repoPersoane[lungimePersoane++] = p;
    }
    public void addRepoPersoanaPos(Persoana p, int pos)
    {
        repoPersoane[pos] = p;
    }

    public void addRepoActivitatePos(Activitate a, int pos)
    {
        repoActivitati[pos] = a;
    }


    public void deleteRepoPersoanaPos(int pos)
    {
        int i=pos;
        while(i<lungimePersoane-1)
            repoPersoane[i++]= repoPersoane[i];
        lungimePersoane--;
    }


    public void updateRepoPersoanaPos(Persoana persoana, int pos)
    {
        repoPersoane[pos]= persoana;
    }


    Persoana[] getRepoPersoane()
    {
        return repoPersoane;
    }

    int getLungimePersoane()
    {
        return this.lungimePersoane;
    }


    //------------------------------------------------------------------------------------------------------------------
    //Activitati
    public void addRepoActivitate(Activitate a)
    {
        repoActivitati[lungimeActivitati++] = a;
    }
    public void deleteRepoActivitatePos(int pos)
    {
        int i=pos;
        while(i<lungimeActivitati-1)
            repoActivitati[i++]= repoActivitati[i];
        lungimeActivitati--;
    }
    public void updateRepoActivitatePos(Activitate activitate, int pos)
    {
        repoActivitati[pos]= activitate;
    }
    Activitate[] getRepoActivitate()
    {
        return repoActivitati;
    }

    int getLungimeActivitati()
    {
        return this.lungimeActivitati;
    }
}
