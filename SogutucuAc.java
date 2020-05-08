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

import java.util.Scanner;

public class SogutucuAc implements IIslem {

    private IEkran ekran;
    private ITusTakimi tusTakimi;
    private KullaniciHesabi kullaniciHesabi;

    public SogutucuAc(IEkran ekran, ITusTakimi tusTakimi, KullaniciHesabi kullaniciHesabi) {
        this.ekran = ekran;
        this.tusTakimi = tusTakimi;
        this.kullaniciHesabi = kullaniciHesabi;
    }

    @Override
    public void islemYap() {
        ekran.mesajGoruntule("Oda sicakliginizi azaltmak icin (1), arttirmak icin (2) tuslayiniz.");
        int secenek = tusTakimi.veriAl();

        if (secenek == 1) {
            ekran.mesajGoruntule("Sicakligi kac derece azaltmak istersiniz :");
            Scanner input = new Scanner(System.in);
            int dereceDusur = input.nextInt();
            kullaniciHesabi.setOdaSicakligi(kullaniciHesabi.getOdaSicakligi() - dereceDusur);
            ekran.mesajGoruntule("Oda sicakliginiz azaltiliyor...");
        } else if (secenek == 2) {
            ekran.mesajGoruntule("Sicakligi kac derece arttirmak istersiniz :");
            Scanner input = new Scanner(System.in);
            int dereceArttir = input.nextInt();
            kullaniciHesabi.setOdaSicakligi(kullaniciHesabi.getOdaSicakligi() + dereceArttir);
            ekran.mesajGoruntule("Oda sicakliginiz arttiriliyor...");
        } else {
            ekran.mesajGoruntule("Yanlis giris yaptiniz...");
        }

    }

}
