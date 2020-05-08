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

public class SogutucuKapa implements IIslem {

    private IEkran ekran;

    public SogutucuKapa(IEkran ekran) {

        this.ekran = ekran;

    }

    @Override
    public void islemYap() {
        ekran.mesajGoruntule("Sogutucu kapatiliyor...");
    }

}
