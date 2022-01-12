package com.codecool.shop.config;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.database.DatabaseManager;
import com.codecool.shop.dao.implementation.memory.CartDaoMem;
import com.codecool.shop.dao.implementation.memory.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.memory.ProductDaoMem;
import com.codecool.shop.dao.implementation.memory.SupplierDaoMem;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.service.ErrorLogging;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Properties;

@WebListener
public class Initializer implements ServletContextListener {

    private String dao;
    private String dbUserName;
    private String dbPassword;
    private String dbUrl;
    private String dbName;
    private static DatabaseManager databaseManager;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Properties conProps = DatabaseConfig.setupApplication();

        dao = conProps.getProperty("dao");
        dbUserName = conProps.getProperty("user");
        dbPassword = conProps.getProperty("password");
        dbUrl = conProps.getProperty("url");
        dbName = conProps.getProperty("database");

        try {


            if (dao.equals("memory")) {

                ProductDao productDataStore = ProductDaoMem.getInstance();
                ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
                SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
                CartDao cartDataStore = CartDaoMem.getInstance();

                Cart cart = new Cart();
                cartDataStore.add(cart);

                //setting up a new supplier
                Supplier leioa = new Supplier("Leioa", "");
                supplierDataStore.add(leioa);
                Supplier onePhone = new Supplier("1Phone", "");
                supplierDataStore.add(onePhone);
                Supplier samsong = new Supplier("Samsong", "");
                supplierDataStore.add(samsong);
                Supplier gameStation = new Supplier("Game Station", "");
                supplierDataStore.add(gameStation);
                Supplier bintendo = new Supplier("Bintendo", "");
                supplierDataStore.add(bintendo);
                Supplier chuWi = new Supplier("ChuWi", "");
                supplierDataStore.add(chuWi);
                Supplier fujigama = new Supplier("Fujigama", "");
                supplierDataStore.add(fujigama);

                //setting up a new product category
                ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
                productCategoryDataStore.add(tablet);
                ProductCategory console = new ProductCategory("Console", "Hardware", "");
                productCategoryDataStore.add(console);
                ProductCategory cellPhone = new ProductCategory("Cell Phone", "Hardware", "");
                productCategoryDataStore.add(cellPhone);
                ProductCategory smartWatch = new ProductCategory("Smart Watch", "Hardware", "");
                productCategoryDataStore.add(smartWatch);
                ProductCategory computer = new ProductCategory("Computer", "Hardware", "");
                productCategoryDataStore.add(computer);
                ProductCategory camera = new ProductCategory("Camera", "Hardware", "");
                productCategoryDataStore.add(camera);
                ProductCategory television = new ProductCategory("Television", "Hardware", "");
                productCategoryDataStore.add(television);

                //setting up products and printing it
                productDataStore.add(new Product("ChuWi HeroBook Por+", new BigDecimal("81232"), "HUF", "CHUWI legújabb 13,3 hüvelykes laptop HeroBook Pro + 3200 * 1800 képernyő Intel J3455 processzor Win10 OS 8 GB RAM + 128 GB ROM Super PC", computer, chuWi));
                productDataStore.add(new Product("1Phone Smart Watch", new BigDecimal("580"), "HUF", "Az új férfiak és nők okosóra Android IOS okosóra Elektronikus intelligens óra Fitness Tracker Szilikonszíj Okosóra óra", smartWatch, onePhone));
                productDataStore.add(new Product("Samsong Smart Watch", new BigDecimal("3769"), "HUF", "Forró eladású új termék Q18S intelligens karóra, kompatibilis a Samsung, a Xiaomi Huaiwei, az IPHONE készülékkel. Android, iOS okostelefonok iPhone", smartWatch, samsong));
                productDataStore.add(new Product("1Phone Fit Smart Watch", new BigDecimal("1719"), "HUF", "Színes képernyő intelligens karkötőóra 115 Plusz vérnyomásmérő pulzusmérő intelligens karszalag", smartWatch, onePhone));
                productDataStore.add(new Product("Samsong Tablet", new BigDecimal("41221"), "HUF", "2022 Netbook PC Tablets Support NETFLIX!!! Newest Upgrade RAM 12G+ROM 1024GB+ 10Core WiFi Tablet PC Android 12.0 Arge 2560*1600 IPS Screen Dual SIM Dual Camera Rear 13.0 MP IPS Tablet Call Phone Tablet Gift with Earphone+256GB memory card 11.6inch Tablet with Keyboard", tablet, samsong));
                productDataStore.add(new Product("Leioa Tablet", new BigDecimal("135385"), "HUF", "Android Tablet 10 inch,Tablet with Keyboard Mouse 3GB RAM 32GB ROM/128GB, Android 9.0 Pie, Dual SIM 4G, 8MP Camera, 8000mAh, Quad Core, OTG, GPS (Gray)", tablet, leioa));
                productDataStore.add(new Product("1Phone Tablet", new BigDecimal("17916"), "HUF", "2021 Tablets Support NETFLIX!!! Tablet Newest Upgrade RAM 12G+ROM 640GB+ 12 Core WiFi Tablet PC Android 12.0 Arge 2560*1600 IPS Screen Dual SIM Dual Camera Rear 13.0 MP IPS Tablet Call Phone Tablet Tablet-PC Tablette 9.6-inch tablet computer", tablet, onePhone));
                productDataStore.add(new Product("Game Station PXP", new BigDecimal("5270"), "HUF", "Legjobb minőségű PXP 3 kézi játékkonzol 150 + játékok ajándék játékok gyerekeknek", console, gameStation));
                productDataStore.add(new Product("Bintendo Retro Console", new BigDecimal("5631"), "HUF", "2020 Super Classic Retro SUPER MINISNES Mini Beépített 620 Mini Nostalgic Video Game Console", console, bintendo));
                productDataStore.add(new Product("Game Station PS1 Retro Console", new BigDecimal("4935"), "HUF", "Klasszikus 8 bites játékkonzol PS1 Mini Home 620 akciójáték-rajongó szórakoztató rendszerhez Retro kettős csatakonzol", console, gameStation));
                productDataStore.add(new Product("Bintendo Retro Hand Console", new BigDecimal("2556"), "HUF", "Új stílusú retro játékkonzol Beépített 268/400/800 játékok Retro játékkonzol Pocket kézi videojáték-konzol 2.0 / 3.0 LCD 8 bites mini hordozható játéklejátszó", console, bintendo));
                productDataStore.add(new Product("Bintendo Switch", new BigDecimal("8709"), "HUF", "2020 új frissítésű 4.3 / 5.1 hüvelykes kézi játéklejátszó 8 GB-os ROM PSP konzolos kézi játékgép Beépített 20000+ játékkal PK Bintendo Switch X7 / X7Plus Opciók", console, bintendo));
                productDataStore.add(new Product("1Phone i13 Pro Max", new BigDecimal("25000"), "HUF", "Unlocked Cell Phones I13pro Max Cell Phones 4G 5G Dual SIM Cards Support T Card (12GB RAM+512GB ROM) Android 10.0 Smartphone", cellPhone, onePhone));
                productDataStore.add(new Product("Samsong S30", new BigDecimal("31854"), "HUF", "In 2021, a newly launched 6.7-inch 3K HD screen 16+512GB fingerprint smartphone (champagne gold, psychedelic blue, dark night green)", cellPhone, samsong));
                productDataStore.add(new Product("Leioa P60 Pro", new BigDecimal("36198"), "HUF", "2021 Fashion New Handy Smartphone P60 Pro 5G with 16+768GB Large Memory 48+64MP HD camara Dual Sim Cards Bluetooth Wifi 6000mA/h battery Mobile Phone Android 10.0 Ten Core", cellPhone, leioa));
                productDataStore.add(new Product("Samsong S21 U+", new BigDecimal("33823"), "HUF", "2021 Brand New S21+ Ultra 5G 6.1Inch HD Screen 16+512GB Unlocked Global Version Smartphone (Black/Blue/Green)", cellPhone, samsong));
                productDataStore.add(new Product("Samsong Note30 Plus", new BigDecimal("15600"), "HUF", "New Note30 Plus Smartphone the thinest 6.1 Inches Large Memory 12GB+512GB Android 10.0 Face Unlock Dual Card Phone Supports T-card Smartphone", cellPhone, samsong));
                productDataStore.add(new Product("Game Station 4 pro", new BigDecimal("45354"), "HUF", "Tedd próbára magad a változatos játékokban! A Game Station 4 Pro TV-re köthető játékgéppel egyszerre ketten is játszhattok barátoddal, így a kiválasztott játékban megküzdhettek egymással.", console, gameStation));
                productDataStore.add(new Product("Fujigama TPT 16X Pro", new BigDecimal("8628"), "HUF", "Digital Camera 16X Focus Zoom Design Camera1280x720 Supported 32GB Card Portable Digital Camera for Travel Photo Taking", camera, fujigama));
                productDataStore.add(new Product("Fujigama ZMP 24X", new BigDecimal("10878"), "HUF", "Full HD Digital Camera, 33MP Digital DSLR Camera 0.5X Auto Focus Wide Angle Lens Kit, Rechargeable 24X Optical Zoom Multifunctional Portable Camera, Best Gift For Photography Lovers", camera, fujigama));
                productDataStore.add(new Product("Samsong UHD Televison 65'", new BigDecimal("72854"), "HUF", "Merülj el a képben a szélesebb színskálával! A Crystal Display biztosítja az optimalizált színkifejezést, így minden részletet láthatsz.", television, samsong));
                productDataStore.add(new Product("Samsong FULL HD Televison 45'", new BigDecimal("35624"), "HUF", "Keskeny és elegáns kialakítás, amely a legtisztább képet tárja eléd. Minden elemében, szögében minimalista kialakítású, keret nélküli, amely új mércét állít fel. Magával ragadó látvány tárul eléd.", television, samsong));
            } else if (dao.equals("jdbc")) {
                databaseManager = new DatabaseManager(dbName, dbUserName, dbPassword);
                try {
                    databaseManager.setup();
                } catch (SQLException e) {
                    e.printStackTrace();
                    ErrorLogging.log(e);
                }
            }
        } catch (NullPointerException e) {
            ErrorLogging.log(e);
        }
    }

    // use this in controllers
    public static DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}
