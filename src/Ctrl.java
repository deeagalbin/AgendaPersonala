import java.io.FileWriter;
import java.util.Calendar;

public class Ctrl {
    private Repo repo;

    public Ctrl(Repo repo)
    {
        this.repo = repo;
    }

    public void  addCtrl(String nume, Data data_nasterii, int varsta)
    {
        Persoana p = new Persoana(nume,data_nasterii,varsta);
        this.repo.addRepoPersoana(p);

    }

    public void updateCtrl(String nume, Data data_nasterii, int varsta,String numeN, Data data_nasteriiN, int varstaN)
    {
        Persoana p = new Persoana(numeN,data_nasteriiN,varstaN);

        int i = 0;
        int n = this.repo.getLungimePersoane();
        while(i < n )
            if(nume.equals(this.repo.getRepoPersoane()[i].getNume()) && data_nasterii.equals(this.repo.getRepoPersoane()[i].getData())
                    && varsta == this.repo.getRepoPersoane()[i].getVarsta()) {
                this.repo.updateRepoPersoanaPos(p,i);
                i=n;
            }
            else
                i++;
    }

    public void deleteCtrl(String nume, Data data_nasterii, int varsta)
    {
        int i = 0;
        int n = this.repo.getLungimePersoane();
        while(i < n )
            if(nume.equals(this.repo.getRepoPersoane()[i].getNume()) && data_nasterii.equals(this.repo.getRepoPersoane()[i].getData())
                    && varsta== this.repo.getRepoPersoane()[i].getVarsta())
            {            this.repo.deleteRepoPersoanaPos(i);
                        i=n; }
            else
                i++;

    }
    /*
    public void read()
    {
        int n = repo.getLungimePersoane();
        System.out.println("Agenda");
        System.out.println();
        for(int i = 0 ; i<n ;i++)
            this.repo.getRepoPersoane()[i].showPersoana();
        System.out.println();

    }*/

    public void readCtrl()
    {
        String leftAlignFormat = "| %-12s | %-10s |%-8s  |%n";
        int n = repo.getLungimePersoane();
        System.out.format("+--------------+------------+----------+%n");
        System.out.format("| Nume         |   Data     |  Varsta  |%n");
        System.out.format("+--------------+------------+----------+%n");
        for (int i = 0; i < n; i++) {
            System.out.format(leftAlignFormat,this.repo.getRepoPersoane()[i].getNume() ,this.repo.getRepoPersoane()[i].getData().toString(),this.repo.getRepoPersoane()[i].getVarsta());
        }
        System.out.format("+--------------+------------+----------+%n");
    }

    public void sortNume()
    {
        int n = repo.getLungimePersoane();

        for(int  i = 0 ; i <n-1;i++)
            for( int j = i+1 ; j < n ; j++)
                if(repo.getRepoPersoane()[i].getNume().compareTo(repo.getRepoPersoane()[j].getNume()) > 0 ) {
                    Persoana p= new Persoana(repo.getRepoPersoane()[i]) ;
                    repo.getRepoPersoane()[i]=repo.getRepoPersoane()[j];
                    repo.getRepoPersoane()[j]=p;
                }


    }

    public void sortVarsta()
    {
        int n = repo.getLungimePersoane();

        for(int  i = 0 ; i <n-1;i++)
            for( int j = i+1 ; j < n ; j++)
                if(repo.getRepoPersoane()[i].getVarsta()>repo.getRepoPersoane()[j].getVarsta() ) {
                    Persoana p= new Persoana(repo.getRepoPersoane()[i]) ;
                    repo.getRepoPersoane()[i]=repo.getRepoPersoane()[j];
                    repo.getRepoPersoane()[j]=p;
                }


    }

    public void sortData()
    {
        int n = repo.getLungimePersoane();

        for(int  i = 0 ; i <n-1;i++)
            for( int j = i+1 ; j < n ; j++)
                if(repo.getRepoPersoane()[i].getData().lexicografic(repo.getRepoPersoane()[j].getData()) == 0 ) {
                    Persoana p= new Persoana(repo.getRepoPersoane()[i]) ;
                    repo.getRepoPersoane()[i]=repo.getRepoPersoane()[j];
                    repo.getRepoPersoane()[j]=p;
                }

        }
    /*
    public void readCtrlPersoane3Zile()
    {
        Data data_curenta = new Data();
        Calendar now = Calendar.getInstance();
        data_curenta.setAn(now.get(Calendar.YEAR));
        data_curenta.setLuna(now.get(Calendar.MONTH)+1);
        data_curenta.setZi(now.get(Calendar.DAY_OF_MONTH)+1);

        int n = this.repo.getLungimePersoane();
        System.out.println("Agenda Persoane care au ziua in astea 3 zile");
        System.out.println();
        for(int i = 0 ; i<n ;i++)
            if(data_curenta.getLuna() == this.repo.getRepoPersoane()[i].getData().getLuna()
                    && data_curenta.getZi() <= this.repo.getRepoPersoane()[i].getData().getZi()
                    &&  this.repo.getRepoPersoane()[i].getData().getZi() <=data_curenta.getZi()+3)
                this.repo.getRepoPersoane()[i].showPersoana();
        System.out.println();
    }*/
    public void readCtrlPersoane3Zile()
    {
        Data data_curenta = new Data();
        Calendar now = Calendar.getInstance();
        data_curenta.setAn(now.get(Calendar.YEAR));
        data_curenta.setLuna(now.get(Calendar.MONTH)+1);
        data_curenta.setZi(now.get(Calendar.DAY_OF_MONTH)+1);

        String leftAlignFormat = "| %-12s | %-10s |%-8s  |%n";
        int n = repo.getLungimePersoane();
        System.out.format("+--------------+------------+----------+%n");
        System.out.format("| Nume         |   Data     |  Varsta  |%n");
        System.out.format("+--------------+------------+----------+%n");
        for (int i = 0; i < n; i++) {
            if(data_curenta.getLuna() == this.repo.getRepoPersoane()[i].getData().getLuna()
                    && data_curenta.getZi() <= this.repo.getRepoPersoane()[i].getData().getZi()
                    &&  this.repo.getRepoPersoane()[i].getData().getZi() <=data_curenta.getZi()+3)
            System.out.format(leftAlignFormat,this.repo.getRepoPersoane()[i].getNume() ,this.repo.getRepoPersoane()[i].getData().toString(),this.repo.getRepoPersoane()[i].getVarsta());
        }
        System.out.format("+--------------+------------+----------+%n");
    }

    //------------------------------------------------------------------------------------------------------------------
    //Activitati
    public void  addCtrlActivitate(String nume, Data data)
    {
        Activitate a = new Activitate(nume,data);
        this.repo.addRepoActivitate(a);
    }

    public void updateCtrlActivitate(String nume, Data data,String numeN, Data dataN)
    {
        Activitate a = new Activitate(numeN,dataN);

        int i = 0;
        int n = this.repo.getLungimeActivitati();
        while(i < n )
            if(nume.equals(this.repo.getRepoActivitate()[i].getNume()) && data.equals(this.repo.getRepoActivitate()[i].getData())) {
                this.repo.updateRepoActivitatePos(a,i);
                i=n;
            }
            else
                i++;
    }

    public void deleteCtrlActivitate(String nume, Data data)
    {
        int i = 0;
        int n = this.repo.getLungimeActivitati();
        while(i < n )
            if(nume.equals(this.repo.getRepoActivitate()[i].getNume()) && data.equals(this.repo.getRepoActivitate()[i].getData()))
            {            this.repo.deleteRepoActivitatePos(i);
                i=n; }
            else
                i++;

    }
    /*
    public void readCtrlActivitate()
    {
        int n = repo.getLungimeActivitati();
        System.out.println("Agenda Activitati");
        System.out.println();
        for(int i = 0 ; i<n ;i++)
            this.repo.getRepoActivitate()[i].showActivitate();
        System.out.println();

    }
    */
     /*
    public void readCtrlActivitatiAzi()
    {
        Data data_curenta = new Data();
        Calendar now = Calendar.getInstance();
        data_curenta.setAn(now.get(Calendar.YEAR));
        data_curenta.setLuna(now.get(Calendar.MONTH)+1);
        data_curenta.setZi(now.get(Calendar.DAY_OF_MONTH));
        int n = repo.getLungimeActivitati();
        System.out.println("Agenda Activitati");
        System.out.println();
        for(int i = 0 ; i<n ;i++)
            if(this.repo.getRepoActivitate()[i].getData().equals(data_curenta))
            this.repo.getRepoActivitate()[i].showActivitate();
        System.out.println();

    }
    */
    public void readCtrlActivitate()
    {
        String leftAlignFormat = "| %-21s | %-10s |%n";
        int n = repo.getLungimeActivitati();
        System.out.format("+-----------------------+------------+%n");
        System.out.format("|     Nume              |   Data     |%n");
        System.out.format("+-----------------------+------------+%n");
        for (int i = 0; i < n; i++) {
            System.out.format(leftAlignFormat,this.repo.getRepoActivitate()[i].getNume() ,this.repo.getRepoActivitate()[i].getData().toString());
        }
        System.out.format("+-----------------------+------------+%n");
    }

    public void readCtrlActivitatiAzi()
    {
        Data data_curenta = new Data();
        Calendar now = Calendar.getInstance();
        data_curenta.setAn(now.get(Calendar.YEAR));
        data_curenta.setLuna(now.get(Calendar.MONTH)+1);
        data_curenta.setZi(now.get(Calendar.DAY_OF_MONTH));
        String leftAlignFormat = "| %-21s | %-10s |%n";
        int n = repo.getLungimeActivitati();
        System.out.format("+-----------------------+------------+%n");
        System.out.format("|     Nume              |   Data     |%n");
        System.out.format("+-----------------------+------------+%n");
        for (int i = 0; i < n; i++) {
            if(this.repo.getRepoActivitate()[i].getData().equals(data_curenta))
                System.out.format(leftAlignFormat,this.repo.getRepoActivitate()[i].getNume() ,this.repo.getRepoActivitate()[i].getData().toString());
        }
        System.out.format("+-----------------------+------------+%n");
    }
    /*
    public void readCtrlActivitati3Zile()
    {
        Data data_curenta = new Data(),treiZile = new Data();
        Calendar now = Calendar.getInstance();
        data_curenta.setAn(now.get(Calendar.YEAR));
        data_curenta.setLuna(now.get(Calendar.MONTH)+1);
        data_curenta.setZi(now.get(Calendar.DAY_OF_MONTH)+1);
        treiZile.setAn(now.get(Calendar.YEAR));
        treiZile.setLuna(now.get(Calendar.MONTH)+1);
        treiZile.setZi(now.get(Calendar.DAY_OF_MONTH)+3);

        int n = repo.getLungimeActivitati();
        System.out.println("Agenda Activitati");
        System.out.println();
        for(int i = 0 ; i<n ;i++)
            if(data_curenta.lexicografic(this.repo.getRepoActivitate()[i].getData()) == 1
                    && this.repo.getRepoActivitate()[i].getData().lexicografic(treiZile) == 1 )
                this.repo.getRepoActivitate()[i].showActivitate();
        System.out.println();

    }*/
    public void readCtrlActivitati3Zile()
    {
        Data data_curenta = new Data(),treiZile = new Data();
        Calendar now = Calendar.getInstance();
        data_curenta.setAn(now.get(Calendar.YEAR));
        data_curenta.setLuna(now.get(Calendar.MONTH)+1);
        data_curenta.setZi(now.get(Calendar.DAY_OF_MONTH)+1);
        treiZile.setAn(now.get(Calendar.YEAR));
        treiZile.setLuna(now.get(Calendar.MONTH)+1);
        treiZile.setZi(now.get(Calendar.DAY_OF_MONTH)+3);
        String leftAlignFormat = "| %-21s | %-10s |%n";
        int n = repo.getLungimeActivitati();
        System.out.format("+-----------------------+------------+%n");
        System.out.format("|     Nume              |   Data     |%n");
        System.out.format("+-----------------------+------------+%n");
        for (int i = 0; i < n; i++) {
            if(data_curenta.lexicografic(this.repo.getRepoActivitate()[i].getData()) == 1
                    && this.repo.getRepoActivitate()[i].getData().lexicografic(treiZile) == 1 )
                System.out.format(leftAlignFormat,this.repo.getRepoActivitate()[i].getNume() ,this.repo.getRepoActivitate()[i].getData().toString());
        }
        System.out.format("+-----------------------+------------+%n");
    }


    public void writeToFile() {
        try{
            FileWriter outPersoane= new FileWriter("Persoane.txt");
            FileWriter outActivitati= new FileWriter("Activitati.txt");
            int n=this.repo.getLungimeActivitati();
            int m= this.repo.getLungimePersoane();
            outActivitati.write(n+"\n");
            outPersoane.write(m+"\n");
            for(int i=0;i<n;i++)
                outActivitati.write(this.repo.getRepoActivitate()[i].getNume() + "\n" + + this.repo.getRepoActivitate()[i].getData().getZi()+"\n"
                        +this.repo.getRepoActivitate()[i].getData().getLuna()+"\n"+this.repo.getRepoActivitate()[i].getData().getAn()+"\n"+"\n");
            for(int i=0;i<m;i++)
                outPersoane.write(this.repo.getRepoPersoane()[i].getNume() + "\n" + this.repo.getRepoPersoane()[i].getData().getZi()+"\n"
                        +this.repo.getRepoPersoane()[i].getData().getLuna()+"\n"+this.repo.getRepoPersoane()[i].getData().getAn()
                        +"\n"+this.repo.getRepoPersoane()[i].getVarsta()+"\n"+"\n");


            outPersoane.close();
            outActivitati.close();
        }catch (Exception ex){ex.printStackTrace();}
    }
}
