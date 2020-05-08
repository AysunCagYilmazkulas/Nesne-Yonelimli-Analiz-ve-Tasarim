/**
 *
 * Aysun ÇAĞ YILMAZKULAŞ
 * aysun.yilmazkulas@ogr.sakarya.edu.tr
 * 08.05.2020
 *
 * Sogutucu sistemi calistiran program.
 *
 **/
package sogutmasistemi_nyat;

public class SogutmaSistemi {

    private IEkran ekran;
    private ITusTakimi tusTakimi;
    public KullaniciHesabi kullaniciHesabi;

    private static final int Sicaklik_Goruntule = 1;
    private static final int Sogutucu_Ac = 2;
    private static final int Sogutucu_Kapa = 3;
    private static final int Cikis = 4;

    public SogutmaSistemi() {
        ekran = new Ekran();
        tusTakimi = new TusTakimi();
    }

    public void basla() {
        if (bilgiDogrulama()) {
            ekran.mesajGoruntule("Lutfen sifrenizi giriniz...");
            Araclar.bekle();
            int sifre = tusTakimi.veriAl();
            IYardimMasasi yardimMasasi = new YardimMasasi();
            KullaniciHesabi kullaniciHesabi = kullaniciDogrulama(1, sifre, yardimMasasi);
            KullaniciHesabi kullaniciHesabi1 = kullaniciDogrulama(2, sifre, yardimMasasi);
            KullaniciHesabi kullaniciHesabi2 = kullaniciDogrulama(3, sifre, yardimMasasi);

            if (kullaniciHesabi != null ) {
                ekran.mesajGoruntule(kullaniciHesabi.toString());
                islemSecimi(kullaniciHesabi);
            }
            else if(kullaniciHesabi1!=null )
            {
                ekran.mesajGoruntule(kullaniciHesabi1.toString());
                islemSecimi(kullaniciHesabi1);
            }

            else if(kullaniciHesabi2!=null )
            {
                ekran.mesajGoruntule(kullaniciHesabi2.toString());
                islemSecimi(kullaniciHesabi2);
            }
            else {
                System.out.println("Sifreniz dogrulanamadi...");
            }
        } else {
            System.out.println("Bilgileriniz dogrulanamadi...");
        }
    }

    private boolean bilgiDogrulama() {
        return tusTakimi.bilgiDogrulama();
    }

    private KullaniciHesabi kullaniciDogrulama(int hesapNumarasi, int sifre, IYardimMasasi yardimMasasi) {
        return yardimMasasi.kullaniciDogrula(hesapNumarasi, sifre);

    }

    private void islemSecimi(KullaniciHesabi kullaniciHesabi) {
        int secim;
        do {
            secim = anaMenuyuGoster();
            switch (secim) {
                case Sicaklik_Goruntule:
                    ekran.mesajGoruntule("Oda sicakligi goruntuleniyor...");
                    IIslem sicaklikGoruntule = new SicaklikGoruntule(ekran, kullaniciHesabi);
                    sicaklikGoruntule.islemYap();
                    break;
                case Sogutucu_Ac:
                    ekran.mesajGoruntule("Sogutucu acma islemini sectiniz.");
                    IIslem sogutucuAc = new SogutucuAc(ekran, tusTakimi, kullaniciHesabi);
                    sogutucuAc.islemYap();
                    break;

                case Sogutucu_Kapa:
                    ekran.mesajGoruntule("Sogutucu kapatma islemini sectiniz.");
                    IIslem sogutucuKapa = new SogutucuKapa(ekran);
                    sogutucuKapa.islemYap();
                    break;

                case Cikis:
                    ekran.mesajGoruntule("Iyi gunler dileriz.");
                    break;
                default:
                    ekran.mesajGoruntule("1-4 arasında bir sayı girmelisiniz");
            }
        } while (secim != 4);
    }

    private int anaMenuyuGoster() {
        ekran.mesajGoruntule("******************************************");
        ekran.mesajGoruntule("Ana Menu");
        ekran.mesajGoruntule("1-Sicaklik Görüntüle");
        ekran.mesajGoruntule("2-Sogutucu Ac");
        ekran.mesajGoruntule("3-Sogutucu Kapa");
        ekran.mesajGoruntule("4-Cikis");
        ekran.mesajGoruntule("Seciminiz:");
        ekran.mesajGoruntule("******************************************");

        return tusTakimi.veriAl();
    }

}
