package com.twistral.planegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class PlaneGameMain extends ApplicationAdapter {

    static final int CUSTOM_WIDTH = 800;
    static final int CUSTOM_HEIGHT = 480;

    //gerekli değişkenler
    private SpriteBatch oyunSayfasi;
    private OrthographicCamera hareketliKamera;
    private Texture bgResmi;
    private Animation ucak;
    private Vector2 ucakPozisyonu;
    private float gecenZaman = 0;
    private Texture ucakFrame1, ucakFrame2, ucakFrame3;
    private static final float UCAK_BASLANGIC_X_KONUM = 50;
    private static final float UCAK_BASLANGIC_Y_KONUM = 240;
    private enum OyunDurumu{Start, Running, GameOver}
    private OyunDurumu oyunDurumu = OyunDurumu.Start;
    private Vector2 yercekimi = new Vector2();
    private Vector2 ucakYercekimi = new Vector2();
    private static final float UCAK_ZIPLAMASI = 350;
    private static final float YERCEKIMI = -20;
    private static final float UCAK_HIZ_X = 200;
    private TextureRegion zeminResmi, tavanResmi;
    private float ilkZeminPozisyonX;
    private TextureRegion kayaResmi, kayaAsagiResmi;
    private Array<Kaya> kayalar = new Array<Kaya>();
    private TextureRegion readyResim, gameOverResmi;
    private Sound patlama;
    private Rectangle ucakCerceve = new Rectangle();
    private OrthographicCamera arayuzKamera;

    private ShapeRenderer shapeRenderer;
    private BitmapFont font;
    private int puan = 0;
    private Music music;

    @Override
    public void create () {

        oyunSayfasi = new SpriteBatch();

        hareketliKamera = new OrthographicCamera();
        hareketliKamera.setToOrtho(false, CUSTOM_WIDTH, CUSTOM_HEIGHT);

        bgResmi = new Texture("planeGame/background.png");

        ucakFrame1 = new Texture("planeGame/ucak1.png");
        ucakFrame2 = new Texture("planeGame/ucak2.png");
        ucakFrame3 = new Texture("planeGame/ucak3.png");

        ucak = new Animation(0.05f, new TextureRegion(ucakFrame1), new TextureRegion(ucakFrame2), new TextureRegion(ucakFrame3));
        ucak.setPlayMode(Animation.PlayMode.LOOP);

        ucakPozisyonu = new Vector2();

        zeminResmi = new TextureRegion(new Texture("planeGame/zemin.png"));
        tavanResmi = new TextureRegion(zeminResmi);
        tavanResmi.flip(true, true);

        kayaResmi = new TextureRegion(new Texture("planeGame/kaya.png"));
        kayaAsagiResmi = new TextureRegion(kayaResmi);
        kayaAsagiResmi.flip(true, true);

        arayuzKamera = new OrthographicCamera();
        arayuzKamera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        arayuzKamera.update();

        readyResim = new TextureRegion(new Texture("planeGame/ready.png"));
        gameOverResmi = new TextureRegion(new Texture("planeGame/gameover.png"));
        patlama = Gdx.audio.newSound(Gdx.files.internal("planeGame/patlama.wav"));

        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont(Gdx.files.internal("planeGame/arial.fnt"));

        music = Gdx.audio.newMusic(Gdx.files.internal("planeGame/music.mp3"));
        music.setLooping(true);
        music.setVolume(0.05f);
        music.play();

        dunyayiResetle();
    }

    @Override
    public void render () {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        dunyayiGuncelle();
        dunyayiCizdir();
    }

    private void dunyayiResetle() {

        ucakPozisyonu.set(UCAK_BASLANGIC_X_KONUM, UCAK_BASLANGIC_Y_KONUM);
        hareketliKamera.position.x = 400;

        yercekimi.set(0, YERCEKIMI);
        ucakYercekimi.set(0, 0);

        ilkZeminPozisyonX = 0;

        //rasgele aşağı veya yukarı kayalar üretip diziye atacağız
        kayalar.clear();
        for(int i = 0; i < 5; i++){

            boolean isDown = MathUtils.randomBoolean();

            kayalar.add(new Kaya(700 + i * 200, isDown ? 480 - kayaResmi.getRegionHeight():0, isDown ? kayaAsagiResmi: kayaResmi, isDown));

        }

        puan = 0;

    }

    private void dunyayiGuncelle() {

        //oyunun frame değişimleri arasındaki geçen zaman
        float deltaTime = Gdx.graphics.getDeltaTime();
        gecenZaman += deltaTime;

        //ekrana dokunduğumda
        if(Gdx.input.justTouched()){

            if(oyunDurumu == OyunDurumu.Start){

                oyunDurumu = OyunDurumu.Running;

            }

            if(oyunDurumu == OyunDurumu.Running){

                ucakYercekimi.set(UCAK_HIZ_X, UCAK_ZIPLAMASI);

            }

            if(oyunDurumu == OyunDurumu.GameOver){

                oyunDurumu = OyunDurumu.Start;
                dunyayiResetle();

            }

        }

        if(oyunDurumu != OyunDurumu.Start){

            ucakYercekimi.add(yercekimi);

        }

        //ucakYercekimi vektörünü ölçekleyip ucakPozisyonu vektörüne ekle
        ucakPozisyonu.mulAdd(ucakYercekimi, deltaTime);

        //konumu günceller
        hareketliKamera.position.x = ucakPozisyonu.x + 350;


        //zeminin devamlılığını sağlar
        if(hareketliKamera.position.x > zeminResmi.getRegionWidth() + ilkZeminPozisyonX + 400){

            ilkZeminPozisyonX += zeminResmi.getRegionWidth();

        }

        //uçağın cercevesini uçağa sabitliyoruz.
        ucakCerceve.set(ucakPozisyonu.x, ucakPozisyonu.y, ((TextureRegion)ucak.getKeyFrames()[0]).getRegionWidth(), ((TextureRegion)ucak.getKeyFrames()[0]).getRegionHeight());

        //kaya pozisyonlarını günceller
        for(Kaya kaya: kayalar){

            //geçilen kayaları ileriye atar
            if(hareketliKamera.position.x - kaya.pozisyon.x > 400 + kaya.resim.getRegionWidth()){

                boolean isDown = MathUtils.randomBoolean();
                kaya.pozisyon.x += 5 * 200;
                kaya.pozisyon.y = isDown ? 480 - this.kayaResmi.getRegionHeight() : 0;
                kaya.resim = isDown ? kayaAsagiResmi : this.kayaResmi;
                kaya.gecildi = false;

            }

            //kayaResmi çercevesini yerleştirir
            kaya.kayaCerceve.set(kaya.isDown ? kaya.pozisyon.x + (kaya.resim.getRegionWidth() / 2) - 20 : kaya.pozisyon.x + (kaya.resim.getRegionWidth() / 2), kaya.pozisyon.y, 20, kaya.resim.getRegionHeight());

            //uçak kayaya çarptıysa gameover olur
            if(ucakCerceve.overlaps(kaya.kayaCerceve)){

                if(oyunDurumu != OyunDurumu.GameOver){

                    long id = patlama.play(0.025f);
                }

                oyunDurumu = OyunDurumu.GameOver;
                ucakYercekimi.x = 0;

            }


            //kaya geçildiyse puanı bir artır
            if(kaya.pozisyon.x < ucakPozisyonu.x && !kaya.gecildi){

                puan++;
                kaya.gecildi = true;

            }


        }


        //uçak zemin veya tavana çarptıysa gameover olur
        if(ucakPozisyonu.y < zeminResmi.getRegionHeight() - 20 ||
                ucakPozisyonu.y + ((TextureRegion)ucak.getKeyFrames()[0]).getRegionHeight() >
                        480 - zeminResmi.getRegionHeight() + 20){


            if(oyunDurumu != OyunDurumu.GameOver){

                patlama.play();

            }

            oyunDurumu = OyunDurumu.GameOver;
            ucakYercekimi.x = 0;

        }

    }

    private void dunyayiCizdir() {

        hareketliKamera.update();

        //oyun sayfasını hareketli kameraya ayarla
        oyunSayfasi.setProjectionMatrix(hareketliKamera.combined);

        oyunSayfasi.begin();

        oyunSayfasi.draw(bgResmi, hareketliKamera.position.x - bgResmi.getWidth() / 2, 0);

        for(Kaya kaya : kayalar){

            oyunSayfasi.draw(kaya.resim, kaya.pozisyon.x, kaya.pozisyon.y);

        }

        //zemin ve tavan ikişer defa çizdiriliyor
        oyunSayfasi.draw(zeminResmi, ilkZeminPozisyonX, 0);
        oyunSayfasi.draw(zeminResmi, ilkZeminPozisyonX + zeminResmi.getRegionWidth(), 0);

        oyunSayfasi.draw(tavanResmi, ilkZeminPozisyonX, 480 - tavanResmi.getRegionHeight());
        oyunSayfasi.draw(tavanResmi, ilkZeminPozisyonX + tavanResmi.getRegionWidth(), 480 - tavanResmi.getRegionHeight());

        oyunSayfasi.draw((TextureRegion)ucak.getKeyFrame(gecenZaman), ucakPozisyonu.x, ucakPozisyonu.y);

        oyunSayfasi.end();

        //oyun sayfasını arayayüz kameraya ayaralar
        oyunSayfasi.setProjectionMatrix(arayuzKamera.combined);

        oyunSayfasi.begin();


        if(oyunDurumu == OyunDurumu.Start){

            oyunSayfasi.draw(readyResim, Gdx.graphics.getWidth() / 2 - readyResim.getRegionWidth() / 2, Gdx.graphics.getHeight() / 2 - readyResim.getRegionHeight() / 2);

        }

        if(oyunDurumu == OyunDurumu.GameOver){

            oyunSayfasi.draw(gameOverResmi , Gdx.graphics.getWidth() / 2 - gameOverResmi.getRegionWidth() / 2, Gdx.graphics.getHeight() / 2 - gameOverResmi.getRegionHeight() / 2);

        }

        if(oyunDurumu == OyunDurumu.GameOver || oyunDurumu == OyunDurumu.Running){

            font.draw(oyunSayfasi, "" + puan, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() - 60);

        }

        oyunSayfasi.end();

        //shapeRenderer
        shapeRenderer.setProjectionMatrix(hareketliKamera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(1, 0, 0, 1);

        shapeRenderer.rect(ucakCerceve.x, ucakCerceve.y, ucakCerceve.width, ucakCerceve.height);

        for(Kaya kaya : kayalar){

//            shapeRenderer.rect(kaya.pozisyon.x + (kaya.resim.getRegionWidth() - 30) / 2 + 20, kaya.pozisyon.y, kayaCerceve.width, kayaCerceve.height);


            shapeRenderer.rect(kaya.kayaCerceve.x, kaya.kayaCerceve.y, kaya.kayaCerceve.width, kaya.kayaCerceve.height);

        }

        shapeRenderer.end();

    }

}
