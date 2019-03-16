import java.util.Scanner;

public class Ui {
    private Ctrl ctrl;

    public Ui(Ctrl ctrl)
    {
        this.ctrl = ctrl;
    }
    public void menu()
    {
        System.out.println("--------Menu--------");
        System.out.println("0.Exit");
        System.out.println("------Adaugare------");
        System.out.println("1.Adauga activitate");
        System.out.println("2.Adauga persoana");
        System.out.println("------Update------");
        System.out.println("3.Update activitate");
        System.out.println("4.Update persoana");
        System.out.println("------Stergere------");
        System.out.println("5.Sterge activitate");
        System.out.println("6.Sterge persoana");
        System.out.println("------Afisare------");
        System.out.println("7.Afiseaza activitatile");
        System.out.println("8.Afiseaza activitatile din ziua curenta");
        System.out.println("9.Afiseaza activitatile din urmatoarele 3 zile");
        System.out.println("10.Afiseaza persoanele");
        System.out.println("11.Afiseaza persoanele alfabetic");
        System.out.println("12.Afiseaza persoanele dupa varsta");
        System.out.println("13.Afiseaza persoanele dupa data");
        System.out.println("14.Afiseaza persoanele care au ziua de nastere in urmatoarele 3 zile");

    }

    public void readAgenda()
    {
        this.ctrl.readCtrl();
    }

    public void readAgendaNume()
    {
        this.ctrl.sortNume();
        this.ctrl.readCtrl();
    }

    public void readAgendaData()
    {
        this.ctrl.sortData();
        this.ctrl.readCtrl();
    }

    public void readAgendaVarsta()
    {
        this.ctrl.sortVarsta();
        this.ctrl.readCtrl();
    }

    public void addPersoana()
    {
        Scanner read = new Scanner(System.in);
        System.out.print("Nume: ");
        String nume = read.nextLine();
        System.out.print("Data: ");
        int zi,luna,an;
        zi = read.nextInt();
        luna = read.nextInt();
        an = read.nextInt();
        Data data = new Data(zi,luna,an);
        System.out.print("Varsta: ");
        int varsta = read.nextInt();

        this.ctrl.addCtrl(nume,data,varsta);
    }

    public void updatePersoana()
    {
        Scanner read = new Scanner(System.in);
        System.out.print("Nume: ");                                                                                     //Datele vechi la care le facem update
        String nume = read.nextLine();
        System.out.print("Data: ");
        int zi,luna,an;
        zi = read.nextInt();
        luna = read.nextInt();
        an = read.nextInt();
        Data data = new Data(zi,luna,an);
        System.out.print("Varsta: ");
        int varsta = read.nextInt();
        read.nextLine();
                                                                                                                        //Datele noi
        System.out.print("Nume nou: ");
        String numeN = read.nextLine();
        System.out.print("Data noua: ");
        int ziN,lunaN,anN;
        ziN = read.nextInt();
        lunaN = read.nextInt();
        anN = read.nextInt();
        Data dataN = new Data(ziN,lunaN,anN);
        System.out.print("Varsta noua: ");
        int varstaN = read.nextInt();


        this.ctrl.updateCtrl(nume,data,varsta,numeN,dataN,varstaN);

    }
    public void deletePersoana()
    {
        Scanner read = new Scanner(System.in);

        System.out.print("Nume: ");
        String nume = read.nextLine();

        System.out.print("Data: ");
        int zi,luna,an;
        zi = read.nextInt();
        luna = read.nextInt();
        an = read.nextInt();
        Data data = new Data(zi,luna,an);

        System.out.print("Varsta: ");
        int varsta = read.nextInt();


        this.ctrl.deleteCtrl(nume,data,varsta);

    }
    //------------------------------------------------------------------------------------------------------------------
    //Activitati
    public void addActivitate()
    {
        Scanner read = new Scanner(System.in);
        System.out.print("Nume: ");
        String nume = read.nextLine();
        System.out.print("Data: ");
        int zi,luna,an;
        zi = read.nextInt();
        luna = read.nextInt();
        an = read.nextInt();
        Data data = new Data(zi,luna,an);


        this.ctrl.addCtrlActivitate(nume,data);
    }

    public void updateActivitate()
    {
        Scanner read = new Scanner(System.in);
        System.out.print("Nume: ");                                                                                     //Datele vechi la care le facem update
        String nume = read.nextLine();
        System.out.print("Data: ");
        int zi,luna,an;
        zi = read.nextInt();
        luna = read.nextInt();
        an = read.nextInt();
        Data data = new Data(zi,luna,an);

        read.nextLine();
        //Datele noi
        System.out.print("Nume nou: ");
        String numeN = read.nextLine();
        System.out.print("Data noua: ");
        int ziN,lunaN,anN;
        ziN = read.nextInt();
        lunaN = read.nextInt();
        anN = read.nextInt();
        Data dataN = new Data(ziN,lunaN,anN);



        this.ctrl.updateCtrlActivitate(nume,data,numeN,dataN);

    }
    public void deleteActivitate()
    {
        Scanner read = new Scanner(System.in);

        System.out.print("Nume: ");
        String nume = read.nextLine();

        System.out.print("Data: ");
        int zi,luna,an;
        zi = read.nextInt();
        luna = read.nextInt();
        an = read.nextInt();
        Data data = new Data(zi,luna,an);


        this.ctrl.deleteCtrlActivitate(nume,data);

    }
    public void readAgendaActivitati()
    {
        this.ctrl.readCtrlActivitate();
    }
    public void activitatiAzi()
    {
        this.ctrl.readCtrlActivitatiAzi();
    }
    public void activitatiTreiZile()
    {
        this.ctrl.readCtrlActivitati3Zile();
    }
    public void persoaneTreiZile()
    {
        this.ctrl.readCtrlPersoane3Zile();
    }

    private void writeToFile()
    {

        this.ctrl.writeToFile();
    }

    public void run()
    {
        int option;
        Scanner read = new Scanner(System.in);
        menu();
        System.out.print("Choose an option: ");
        option = read.nextInt();


        while(option!=0)
        {
            switch(option)
            {

                case 1: {addActivitate()         ;menu();break;}
                case 2: {addPersoana()           ;menu();break;}
                case 3: {updateActivitate()        ;menu();break;}
                case 4: {updatePersoana()      ;menu();break;}
                case 5: {deleteActivitate()      ;menu();break;}
                case 6: {deletePersoana()        ;menu();break;}
                case 7: {readAgendaActivitati()  ;menu();break;}
                case 8: {activitatiAzi()      ;menu();break;}
                case 9: {activitatiTreiZile();        ;menu();break;}
                case 10:{readAgenda()            ;menu();break;}
                case 11: {readAgendaNume()       ;menu();break;}
                case 12: {readAgendaVarsta()     ;menu();break;}
                case 13: {readAgendaData()       ;menu();break;}
                case 14:{ persoaneTreiZile()   ;menu();break;}

                default: {System.out.println("Invalid option. Try again."); menu(); break; }

            }
            System.out.print("Choose an option: ");
            option = read.nextInt();
            if(option == 0)
                writeToFile();
        }
    }

}
