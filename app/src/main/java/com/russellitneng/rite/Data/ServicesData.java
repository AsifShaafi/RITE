package com.russellitneng.rite.Data;

import com.russellitneng.rite.R;

import java.util.ArrayList;
import java.util.List;


public class ServicesData {

    protected static List<Services> servicesList = new ArrayList<>();

    public static List<Services> getServicesList() {
        return servicesList;
    }

    static {
        servicesList.add(new Services("WEB DEVELOPMENT","*Responsive Business Website\n" +
                "\n*Personal Blogging Website\n\n" +
                "*E-commerce Website\nCreative Website",
                "NOTE: We can make your website and help you in domain and hosting", R.drawable.web_development));

        servicesList.add(new Services("WORDPRESS THEME DEVELOPMENT","Convert HTML To WordPress" +
                "\nCreate Normal WordPress\nCreative WordPress Theme\nRearrange WordPress Website\n" +
                "Fix WordPress Problem","NOTE: We can make your website in WordPress and give you full technical support.", R.drawable.wordpress));

        servicesList.add(new Services("GRAPHIC DESIGN", "*PSD Template Design\n" +
                "\n" +
                "*Poster Design\n" +
                "\n" +
                "*Banner Design\n" +
                "\n" +
                "*Logo Design\n" +
                "\n" +
                "*Business Card Design\n" +
                "\n" +
                "*2D and 3D Animation\n",
                "NOTE: We can design your office's or company's banner, poster, logo, ad poster. We can design your personal business card. " +
                "We can also make 2D and 3D animation for your company/business.", R.drawable.graphic_design));

        servicesList.add(new Services("APP DEVELOPMENT","Android App Development\n" +
                "Windows App Development\n" +
                "Windows Phone App Development\n",
                "NOTE: We can design and create app in windows and android platform.", R.drawable.application_development));

        servicesList.add(new Services("HARDWARE AND SOFTWARE SOLUTION","Software Related Problems & Solutions\n" +
                "Hardware Related Problems & Solutions\n" +
                "CCTV Camera Installation\n",
                "NOTE: We can provide hardware and software related solution within oir expertise.", R.drawable.software));

    }
}
