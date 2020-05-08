package sogutmasistemi_nyat.veritabani;

import sogutmasistemi_nyat.Araclar;
import sogutmasistemi_nyat.IYardimMasasi;
import sogutmasistemi_nyat.KullaniciHesabi;
import sogutmasistemi_nyat.Musteri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSqlSurucu implements IYardimMasasi {
    boolean girdiMi=false;
    boolean baglantiKontrol=false;
    @Override
    public KullaniciHesabi kullaniciDogrula(int hesapNo, int sifre) {
        KullaniciHesabi kullaniciHesabi = null;

        while (girdiMi==false) {
            System.out.println("Kullanici dogrulaniyor...");
            Araclar.bekle(2000);
            System.out.println("Veritabanina baglaniliyor ve kullanici sorgulaniyor...");
            Araclar.bekle(2000);

            girdiMi=true;
        }

        //veritabani.baglan(hesapNo,sifre);

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sogutmaSistemi", "postgres", "103438");

            if (conn != null && baglantiKontrol==false) {
                System.out.println("Veritabanina baglanildi.");
                baglantiKontrol = true;
            }
            if (conn == null){
                System.out.println("Baglanti girisimi basarisiz.");
            }

            String sql = "SELECT*FROM \"Musteri\" WHERE \"id\"=" + hesapNo + "AND id =" + sifre;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            int hesapNumarasi;
            int sicaklik;
            String adi="tempAd";
            String soyadi="tempSoyad";

            Musteri musteriYeni=new Musteri(adi,soyadi);



            while (rs.next()) {

                hesapNumarasi = rs.getInt("id");
                adi = rs.getString("adi");
                soyadi = rs.getString("soyadi");
                sicaklik=rs.getInt("sicaklik");
                musteriYeni.setAd(adi);
                musteriYeni.setSoyad(soyadi);

                kullaniciHesabi=new KullaniciHesabi(hesapNumarasi,musteriYeni,sicaklik);
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return kullaniciHesabi;
    }

    @Override
    public KullaniciHesabi hesapGuncelle(KullaniciHesabi kullaniciHesabi) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sogutmaSistemiSql", "postgres", "103438");


            if (conn != null)
                System.out.println("Veritabanina baglanildi.");
            else
                System.out.println("Baglanti girisimi basarisiz.");

            String sql = "UPDATE";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kullaniciHesabi;
    }

}
