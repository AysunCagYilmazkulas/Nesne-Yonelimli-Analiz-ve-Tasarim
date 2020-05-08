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

public interface IYardimMasasi {

    public KullaniciHesabi kullaniciDogrula(int hesapNo, int sifre);

    public KullaniciHesabi hesapGuncelle(KullaniciHesabi kullaniciHesabi);
}
