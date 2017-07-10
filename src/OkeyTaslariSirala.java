/**
 * Created by ibrhm on 4.07.2017.
 */
public class OkeyTaslariSirala {

    int fonksiyonSayac =0;
    int diziSayac = 0;
    int okeySayac=0;
    public void operations() {
        int []sariDizi = new int[13];
        int []kirmiziDizi = new int[13];
        int []siyahDizi = new int[13];
        int []maviDizi = new int[13];
        int []outputDizi = new int[40];
        int input[] = {2, 2, 3, 4, 1, 13, 15, 52, 10, 15, 28,32};
        //dizilerin bütünelemanlarının -1 yapıldığı fonksiyon
        diziBosalt(sariDizi);
        diziBosalt(kirmiziDizi);
        diziBosalt(siyahDizi);
        diziBosalt(maviDizi);
        //input olarak verilen sayıların renk olarak ayrılması
        inputAyir(input,sariDizi,kirmiziDizi,siyahDizi,maviDizi);//input dizisini renkleregöre ayır
        diziBosalt(outputDizi);
        //renklere ayrılmış inputların 1,2,3 gibi sıralı olarak ayrılması
         siralaDizi(sariDizi,outputDizi);
         siralaDizi(kirmiziDizi,outputDizi);
         siralaDizi(siyahDizi,outputDizi);
         siralaDizi(maviDizi,outputDizi);
         //farklı renklerdeki sayıların per yapması sari8 mavi 8 siyah 8 gibi
         farkliRenkAyniSayiSirala(outputDizi,sariDizi,kirmiziDizi,siyahDizi,maviDizi);
        //12, 13 , durum kontrolu
        onikiOnucBirDurumu(outputDizi,sariDizi,0);
        onikiOnucBirDurumu(outputDizi,kirmiziDizi,1);
        onikiOnucBirDurumu(outputDizi,siyahDizi,2);
        onikiOnucBirDurumu(outputDizi,maviDizi,3);
        //12 , 13 var ama 1 kullanıldığı durumlara bakar
        onikiOnucvarSifirKullanilmis(outputDizi,sariDizi,0);
        onikiOnucvarSifirKullanilmis(outputDizi,kirmiziDizi,1);
        onikiOnucvarSifirKullanilmis(outputDizi,siyahDizi,2);
        onikiOnucvarSifirKullanilmis(outputDizi,maviDizi,3);
        //11,12,13 gibi sıralı per var ancak 1  boşta ise bu durumu kontrol eder
        sifirBostaOnucPerli(outputDizi,sariDizi,0);
        sifirBostaOnucPerli(outputDizi,kirmiziDizi,1);
        sifirBostaOnucPerli(outputDizi,siyahDizi,2);
        sifirBostaOnucPerli(outputDizi,maviDizi,3);
        //okey kullanıldıgı yerler
        okeyFonksiyonu(outputDizi,sariDizi,0);
        okeyFonksiyonu(outputDizi,kirmiziDizi,1);
        okeyFonksiyonu(outputDizi,siyahDizi,2);
        okeyFonksiyonu(outputDizi,maviDizi,3);
        //iki okeyin olduğu durumlar
        ikiokeydurumu(outputDizi,sariDizi,0);
        ikiokeydurumu(outputDizi,kirmiziDizi,1);
        ikiokeydurumu(outputDizi,siyahDizi,2);
        ikiokeydurumu(outputDizi,maviDizi,3);
        //bütün sıralamalar bittiğinde arada kalan sayılar
        ardaKalanSyilar(outputDizi,sariDizi);
        ardaKalanSyilar(outputDizi,kirmiziDizi);
        ardaKalanSyilar(outputDizi,siyahDizi);
        ardaKalanSyilar(outputDizi,maviDizi);
//output dizisini konsola yazdırma
        for(int i = 0; i<outputDizi.length;i++)
        {
            System.out.println(outputDizi[i]);
        }
    }

    private void ardaKalanSyilar(int[] outputDizi, int[] dizi)
    {
        int index;
        for(int i = outputDizi.length-1;i>0; i--)
        {
            if(outputDizi[i]!=-1)
            {
                index = i+2;
                for(int k =0;k<dizi.length;k++)
                {
                    if(dizi[k]!=-1)
                    {
                        outputDizi[index]=dizi[k];
                        index++;
                    }
                    i=0;
                }
            }
        }
    }

    private void ikiokeydurumu(int[] outputDizi, int[] dizi, int renkSayac)
    {
        if(okeySayac==2)
        {
        for(int i =0 ; i<dizi.length;i++)
        {
            if(dizi[i] !=-1)
            {
                outputDizi[diziSayac]=52;
                diziSayac++;
                outputDizi[diziSayac]=52;
                diziSayac++;
                outputDizi[diziSayac]=dizi[i];
                dizi[i]=elemanAta(dizi[i],renkSayac);
                diziSayac+=2;
                okeySayac=0;
                i=dizi.length;

            }
        }
        }
    }

    private void okeyFonksiyonu(int[] outputDizi, int[] dizi, int renkSayac)
    {
        if(dizi[12] !=-1 && dizi[11] !=-1 && okeySayac>0)
        {
            outputDizi[diziSayac] = 52;
            okeySayac--;
            diziSayac++;
            outputDizi[diziSayac]=dizi[11];
            diziSayac++;
            outputDizi[diziSayac]=dizi[12];
            diziSayac+=2;
            dizi[11]=elemanAta(dizi[11],renkSayac);
            dizi[12]=elemanAta(dizi[12],renkSayac);

        }
        else if(okeySayac>0)
        {
            for(int i = 0 ; i<dizi.length-3;i++)
            {
                if(dizi[i]!=-1 && dizi[i+1]==-1 && dizi[i+2]!=-1)
                {

                    outputDizi[diziSayac]=dizi[i];
                    dizi[i]=elemanAta(dizi[i],renkSayac);
                    diziSayac++;
                    outputDizi[diziSayac]=52;
                    diziSayac++;
                    outputDizi[diziSayac]=dizi[i+2];
                    dizi[i+2]=elemanAta(dizi[i+2],renkSayac);
                    diziSayac++;
                    if(dizi[i+3]!=-1)
                    {
                        outputDizi[diziSayac]=dizi[i+3];
                        dizi[i+3]=elemanAta(dizi[i+3],renkSayac);
                        diziSayac++;
                    }
                    diziSayac++;
                }
            }
        }
    }

    private int elemanAta(int i, int renkSayac) {

        if(i==-2)
        {
             i= 13*renkSayac+11;
        }else
        {
            i=-1;
        }
        return i;
    }


    private void sifirBostaOnucPerli(int[] outputDizi, int[] Dizi, int renkSayac)
    {
        if(Dizi[0] !=-1)
        {
            for (int i=0;i <outputDizi.length-2;i++)
            {
                if(outputDizi[i] == renkSayac*13+11 && outputDizi[i+1] == renkSayac*13+12)
                {
                    outputDizi[i+2] = Dizi[0];
                    int yedek, yedek1;
                    yedek = outputDizi[i+3];
                    outputDizi[i+3]=-1;
                    for (int k=i+3; k<outputDizi.length-1;k++)
                    {

                        yedek1 = outputDizi[k+1];
                        outputDizi[k+1]=yedek;
                        yedek = yedek1;

                    }
                    i= outputDizi.length;
                    if(Dizi[0]==-2)
                    {
                        Dizi[0]=renkSayac*13;
                    }else
                        {
                            Dizi[0]=-1;
                        }

                }
            }
        }
    }

    private void onikiOnucvarSifirKullanilmis(int[] outputDizi, int[] Dizi, int renkSayac)
    {
        if(Dizi[11]!=-1 && Dizi[12]!=-1)
        {
            for(int i = 0; i<outputDizi.length;i++)
            {
                if(outputDizi[i]==renkSayac*13)
                {
                    int sayac=0;
                    int yedek = i;
                    i++;
                   while (outputDizi[i]!=-1)
                   {
                        sayac++;
                       i++;
                   }
                   if(sayac>2)
                   {
                       fonksiyonOnbirOnucBir(outputDizi,11,Dizi,renkSayac);
                       fonksiyonOnbirOnucBir(outputDizi,12,Dizi,renkSayac);
                       outputDizi[diziSayac]=renkSayac*13;
                       outputDizi[yedek]=-1;
                       diziSayac++;
                   }
                }
            }

        }
    }

    private void onikiOnucBirDurumu(int[] outputDizi, int[] Dizi,int renkSayac)
    {
        if(Dizi[11]!=-1 && Dizi[12]!=-1 && Dizi[0] !=-1)
        {
          fonksiyonOnbirOnucBir(outputDizi,11,Dizi,renkSayac);
          fonksiyonOnbirOnucBir(outputDizi,12,Dizi,renkSayac);
          fonksiyonOnbirOnucBir(outputDizi,0,Dizi,renkSayac);
          diziSayac++;
        }
    }
    private void fonksiyonOnbirOnucBir(int[] outputDizi,int index,int[] Dizi, int renkSayac)
    {
        if (Dizi[index] == -2) {
            Dizi[index] = index + 13 * renkSayac;
            outputDizi[diziSayac] = Dizi[index];
            diziSayac++;
        } else {
            outputDizi[diziSayac] = Dizi[index];
            diziSayac++;
            Dizi[index] = -1;
        }
    }

    private void inputAyir(int[] input,int[] sariDizi,int[] kirmiziDizi,int[] siyahDizi ,int[] maviDizi)
    {
        for(int i = 0 ; i<input.length; i++)
        {
            if(input[i]<13)
            {
                if(sariDizi[input[i]]==-1)
                {
                    sariDizi[input[i]] = input[i];
                }else
                {
                    sariDizi[input[i]] = -2;
                }

            }else if(input[i]<26)
            {
                if(kirmiziDizi[input[i]%13]==-1)
                {
                    kirmiziDizi[input[i]%13] = input[i];
                }else
                {
                    kirmiziDizi[input[i]%13] = -2;
                }
            }else if(input[i]<39)
            {
                if(siyahDizi[input[i]%13]==-1)
                {
                    siyahDizi[input[i]%13] = input[i];
                }else
                {
                    siyahDizi[input[i]%13] = -2;
                }

            }else if(input[i]<52)
            {
                if(maviDizi[input[i]%13]==-1)
                {
                    maviDizi[input[i]%13] = input[i];
                }else
                {
                    maviDizi[input[i]%13] = -2;
                }

            } else if(input[i] == 52)
            {
                okeySayac++;
            }
        }
    }

    private void farkliRenkAyniSayiSirala(int[] output,int[] sariDizi, int[] kirmiziDizi, int[] siyahDizi, int[] maviDizi)
    {
        for(int i = 0 ; i<sariDizi.length;i++)
        {
            if(sariDizi[i]!=-1 && kirmiziDizi[i]!=-1 && siyahDizi[i]!=-1 && maviDizi[i]!=-1)
            {

               // System.out.println(sariDizi[i]+"---"+ kirmiziDizi[i]+"---"+ siyahDizi[i]+"---" +maviDizi[i]);
                if(sariDizi[i]==-2)
                {
                    sariDizi[i]=i;
                    output[diziSayac]=i;
                    diziSayac++;
                }else {output[diziSayac]=sariDizi[i]; sariDizi[i]=-1;diziSayac++;}
                if(kirmiziDizi[i]==-2)
                {
                    kirmiziDizi[i]=i+13;
                    output[diziSayac]=i;
                    diziSayac++;
                }else{ output[diziSayac]=kirmiziDizi[i];kirmiziDizi[i]=-1;diziSayac++; }
                if(siyahDizi[i]==-2)
                {
                    siyahDizi[i]=i+26;
                    output[diziSayac]=i+26;
                    diziSayac++;
                }else {  output[diziSayac]=siyahDizi[i];
                    diziSayac++;siyahDizi[i]=-1;}
                if(maviDizi[i]==-2)
                {
                    maviDizi[i]=i+39;
                    output[diziSayac]=i+39;
                    diziSayac++;
                }else {  output[diziSayac]=maviDizi[i];
                    diziSayac++;maviDizi[i]=-1;}
                diziSayac++;


            }
            if(sariDizi[i]!=-1 && kirmiziDizi[i]!=-1 && siyahDizi[i]!=-1)
            {
                //System.out.println(sariDizi[i]+"---"+ kirmiziDizi[i]+"---"+ siyahDizi[i]);
               // sifirlaIndexs(sariDizi);
                if(sariDizi[i]==-2)
                {
                    sariDizi[i]=i;
                    output[diziSayac]=i;
                    diziSayac++;
                }else {output[diziSayac]=sariDizi[i]; sariDizi[i]=-1;diziSayac++;}
                if(kirmiziDizi[i]==-2)
                {
                    kirmiziDizi[i]=i+13;
                    output[diziSayac]=i+13;
                    diziSayac++;
                }else{ output[diziSayac]=kirmiziDizi[i];kirmiziDizi[i]=-1;diziSayac++; }
                if(siyahDizi[i]==-2)
                {
                    siyahDizi[i]=i+26;
                    output[diziSayac]=i+26;
                    diziSayac++;
                }else {  output[diziSayac]=siyahDizi[i];
                    diziSayac++;siyahDizi[i]=-1;}
                diziSayac++;

            }
            if(kirmiziDizi[i]!=-1&& siyahDizi[i]!=-1 && maviDizi[i]!=-1)
            {
                //System.out.println(kirmiziDizi[i]+"---"+ siyahDizi[i]+"---" +maviDizi[i]);
                if(kirmiziDizi[i]==-2)
                {
                    kirmiziDizi[i]=i+13;
                    output[diziSayac]=kirmiziDizi[i];
                    diziSayac++;
                }else{ output[diziSayac]=kirmiziDizi[i];kirmiziDizi[i]=-1;diziSayac++; }
                if(siyahDizi[i]==-2)
                {
                    siyahDizi[i]=i+26;
                    output[diziSayac]=i+26;
                    diziSayac++;
                }else {  output[diziSayac]=siyahDizi[i];
                    diziSayac++;siyahDizi[i]=-1;}
                if(maviDizi[i]==-2)
                {
                maviDizi[i]=i+39;
                output[diziSayac]=i+39;
                diziSayac++;
                 }else {  output[diziSayac]=maviDizi[i];
                diziSayac++;maviDizi[i]=-1;}
                diziSayac++;

            }
            if(sariDizi[i]!=-1 && kirmiziDizi[i]!=-1 && maviDizi[i]!=-1)
            {
                //System.out.println(sariDizi[i]+"---"+ kirmiziDizi[i]+"---"+maviDizi[i]);
                if(sariDizi[i]==-2)
                {
                    sariDizi[i]=i;
                    output[diziSayac]=i;
                    diziSayac++;
                }else {output[diziSayac]=sariDizi[i]; sariDizi[i]=-1;diziSayac++;}
                if(kirmiziDizi[i]==-2)
                {
                    kirmiziDizi[i]=i+13;
                    output[diziSayac]=i;
                    diziSayac++;
                }else{ output[diziSayac]=kirmiziDizi[i];kirmiziDizi[i]=-1;diziSayac++; }
                if(maviDizi[i]==-2)
                {
                    maviDizi[i]=i+39;
                    output[diziSayac]=i+39;
                    diziSayac++;
                }else {  output[diziSayac]=maviDizi[i];
                    diziSayac++;maviDizi[i]=-1;};
                diziSayac++;
            }

            if(sariDizi[i]!=-1 && siyahDizi[i]!=-1 && maviDizi[i]!=-1)
            {
                if(sariDizi[i]==-2)
                {
                    sariDizi[i]=i;
                    output[diziSayac]=i;
                    diziSayac++;
                }else {output[diziSayac]=sariDizi[i]; sariDizi[i]=-1;diziSayac++;}
                if(siyahDizi[i]==-2)
                {
                    siyahDizi[i]=i+26;
                    output[diziSayac]=i+26;
                    diziSayac++;
                }else {  output[diziSayac]=siyahDizi[i];
                    diziSayac++;siyahDizi[i]=-1;}
                if(maviDizi[i]==-2)
                {
                    maviDizi[i]=i+39;
                    output[diziSayac]=i+39;
                    diziSayac++;
                }else {  output[diziSayac]=maviDizi[i];
                    diziSayac++;maviDizi[i]=-1;};
                diziSayac++;
            }
        }
    }


    public static void diziBosalt(int[] dizi)
    {
        for(int i =0 ; i<dizi.length;i++)
        {
            dizi[i]=-1;
        }
    }
    public void siralaDizi(int[] dizi, int[] output)
    {

        int sayac = 0;
        int sifirSayac=0;
        int sayac1 =0;
        int sayac2=0;
        for (int i = 0; i<dizi.length; i++)
        {
            if(dizi[i] != -1 )
            {
                sayac++;

               /* if(dizi[i]==-2)
                {
                    output[diziSayac] = i+fonksiyonSayac*13;
                    sifirSayac++;
                    if(sayac>2 && i+1<=dizi.length )
                    {
                        for(int k =i;k>i-sayac;k--)
                        {
                            if(dizi[k]!=-2)
                            {
                                dizi[k]=-1;
                                ciftsayi=k;
                            }else
                            {
                                dizi[k]=k+fonksiyonSayac*13;
                            }
                        }
                    }

                }*/
                        if(dizi[i]==-2) {
                            output[diziSayac] = fonksiyonSayac*13+i;
                        }else
                            {
                                output[diziSayac] = dizi[i];
                            }
                        if(sayac>2)
                        {
                            if(sayac2 == 0){
                            for(int k =i;k>i-sayac;k--)
                            {
                                if(dizi[k]!=-2)
                                {
                                dizi[k]=-1;
                                }else
                                    {

                                        dizi[k]=k+fonksiyonSayac*13;
                                    }
                            }
                            sayac2++;
                            }
                            else
                                {
                                    for(int k =i;k>i-1;k--)
                                    {
                                        if(dizi[k]!=-2)
                                        {
                                            dizi[k]=-1;
                                        }else
                                        {

                                            dizi[k]=k+fonksiyonSayac*13;
                                        }
                                    }
                                }
                        }



                if(i== dizi.length-1 && sayac<3)
                {
                    for(int j =diziSayac; j>diziSayac-sayac;j--)
                    {
                        output[j]=-1;
                    }

                    diziSayac = diziSayac - sayac;

                }

                if(sayac>2 && i == dizi.length-1){
                    diziSayac++;
                    output[diziSayac] = -1;

                }

                diziSayac++;
            }else
                {
                   if(sayac<3)
                         {
                             for(int j =diziSayac; j>=diziSayac-sayac;j--)
                             {
                                 output[j]=-1;


                             }

                          diziSayac = diziSayac - sayac;


                         }else
                             {

                                 output[diziSayac]=-1;
                                 diziSayac++;

                             }

                         sayac = 0;

                }
                if(sifirSayac >0 && (i) == dizi.length-1 && sayac1 ==0)
                {
                   // output[diziSayac]=-1;
                   // diziSayac++;
                    i=0;
                    sifirSayac =0;
                    sayac =0;
                    sayac1++;

                }
    }
  fonksiyonSayac++;
        if(fonksiyonSayac>1)
        {
            output[diziSayac]=-1;

        }
}
}
