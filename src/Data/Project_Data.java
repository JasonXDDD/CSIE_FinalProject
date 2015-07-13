package Data;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by JasonXDDD on 2015/7/13.
 */
public class Project_Data {
    ArrayList<String> Ptitle = new ArrayList<String>();
    ArrayList<String> Pcontent = new ArrayList<String>();
    boolean[] Project;


    public Project_Data(){
        Ptitle.add("G01 苛薄蚊的煩惱");
        Ptitle.add("G02 釣魚大師");
        Ptitle.add("G03 GameImpossible");
        Ptitle.add("G04 小遊戲大集合");
        Ptitle.add("G05 ");
        Ptitle.add("G06 ");
        Ptitle.add("G07 ");
        Ptitle.add("G08 ");
        Ptitle.add("G09 ");
        Ptitle.add("G10 ");
        Ptitle.add("G11 ");
        Ptitle.add("G12 ");
        Ptitle.add("G13 ");
        Ptitle.add("G14 ");
        Ptitle.add("G15 ");

        Pcontent.add("G01 劉冠林　施俊羽　柯博文　林靚婷");
        Pcontent.add("G02 吳佳全　賴建安　王柏翰　蘇群惠　許芮寧　陳乃嘉");
        Pcontent.add("G03 鄧力豪　王信凱　李易樺　陳　遠　王昱力　陳誼丞");
        Pcontent.add("G04 蕭智仁　陳謙睿　蔡子軒　林晉慶　徐梓翔");
        Pcontent.add("G05 洪子晴　胡安葶　黃楷傑　沈依儒　林易昇　孫久恒");
        Pcontent.add("G06 褚育瑋　呂柏遠　施佩妏　香卓榮　楊婉婉");
        Pcontent.add("G07 許智洋　林之恆　張顥瀚　狄祥偉");
        Pcontent.add("G08 吳澤南　張鈞淯　李承哲　李政逸");
        Pcontent.add("G09 賴博川　吳彥廷　韓覲陽　林子皓　吳涵薇　林彬彬");
        Pcontent.add("G10 吳俊翰　林羿丞　陳昱名　李哲宇　張雅欣");
        Pcontent.add("G11 陳信富　蔡仔為　張語唐　陳宏仲　蔡鈞智　黃信禮");
        Pcontent.add("G12 周泱仕　施家翔");
        Pcontent.add("G13 莊晴晴　楊　昕　丁羿慈　陳譽云　柯承輝");
        Pcontent.add("G14 張榛栩　張湞甯　林妤臻　陳欣媛　王柏森");
        Pcontent.add("G15 邱伊辰　王柏皓　謝佳哲　莊孟修");

        Project = new boolean[]{
                true,  true,  true,  true,  true,
                true, false, false,  true, false,
               false, false,  true, false,  true,
        };
    }

    public String getTitle(int i){
        return Ptitle.get(i - 1);
    }

    public String getContent(int i){
        return Pcontent.get(i - 1);
    }

    public boolean isProject(int i){
        return Project[i - 1];
    }

    public ImageIcon genHead(String filename){
        return new ImageIcon("./src/Data/Cover/" + filename);
    }
}
