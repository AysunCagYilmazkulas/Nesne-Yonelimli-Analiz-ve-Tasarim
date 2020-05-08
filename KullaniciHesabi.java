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

public class KullaniciHesabi {

    private int odaSicakligi;
    private Musteri musteri;
    private int hesapNo;

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public int getHesapNo() {
        return hesapNo;
    }

    public void setHesapNo(int hesapNo) {
        this.hesapNo = hesapNo;
    }

    public int getOdaSicakligi() {
        return odaSicakligi;
    }

    public void setOdaSicakligi(int odaSicakligi) {
        this.odaSicakligi = odaSicakligi;
    }

    public KullaniciHesabi(int hesapNo, Musteri musteri,int odaSicakligi) {
        this.hesapNo=hesapNo;
        this.musteri = musteri;
        this.odaSicakligi = odaSicakligi;
    }

    @Override
    public String toString() {
        return "KullaniciHesabi{ Adi: " + musteri.getAd() + " Soyadi: " + musteri.getSoyad() + '}';
    }

}
