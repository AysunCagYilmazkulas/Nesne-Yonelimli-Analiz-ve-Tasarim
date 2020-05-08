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

public class SicaklikGoruntule implements IIslem {

    private IEkran ekran;
    private KullaniciHesabi kullaniciHesabi;

    public SicaklikGoruntule(IEkran ekran, KullaniciHesabi kullaniciHesabi) {
        this.ekran = ekran;
        this.kullaniciHesabi = kullaniciHesabi;
    }

    @Override
    public void islemYap() {
        ekran.mesajGoruntule("Oda Sicakliginiz: " + kullaniciHesabi.getOdaSicakligi() + " derecedir.");
    }

}
