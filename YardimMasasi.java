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

import sogutmasistemi_nyat.veritabani.PostgreSqlSurucu;

public class YardimMasasi implements IYardimMasasi {
    
    private IYardimMasasi veritabani;
    
    public YardimMasasi() { veritabani=new PostgreSqlSurucu(); }

    private KullaniciHesabi kullaniciHesabi;

    @Override
    public KullaniciHesabi kullaniciDogrula(int hesapNo, int sifre) {
        
        return veritabani.kullaniciDogrula(hesapNo,sifre);
    }

    public KullaniciHesabi hesapGuncelle(KullaniciHesabi kullaniciHesabi) {
        
        veritabani.hesapGuncelle(kullaniciHesabi);
        return kullaniciHesabi;
    }

}
