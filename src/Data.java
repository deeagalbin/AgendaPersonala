public class Data {
    private int zi,luna,an;

    //constructori
    public Data()
    {
        zi = 0;
        luna = 0;
        an = 0;
    }
    public Data(int z, int l, int a)
    {
        zi = z;
        luna = l;
        an = a;
    }
    public void setData(Data data)
    {
        zi = data.zi;
        luna = data.luna;
        an = data.an;
    }

    //set-eri si get-eri

    public void setZi(int z)
    {
        zi = z;
    }

    public void setLuna(int l)
    {
        luna = l;
    }

    public void setAn(int a)
    {
        an = a;
    }

    public int getZi()
    {
        return zi;
    }

    public int getLuna()
    {
        return luna;
    }

    public int getAn()
    {
        return an;
    }

    public boolean equals(Data d)
    {
        return this.zi == d.zi && this.luna == d.luna && this.an== d.an;
    }

    public int lexicografic(Data d)
    {
        if(an>d.getAn())
            return 0;
        else
        if(an == d.getAn())
            if(luna> d.getLuna())
                return 0;
            else
            if(luna == d.getLuna())
                if(zi > d.getZi())
                    return 0;
        return 1;

    }
    public String toString()
    {
        String string ;
        string=""+zi+"/"+luna+"/"+an;
        return string;
    }

}