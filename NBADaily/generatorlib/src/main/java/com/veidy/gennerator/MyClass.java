package com.veidy.gennerator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyClass {

    public static void main(String[] args) throws Exception {

        //数据库版本号与自动生成代码的包路径。
        Schema schema=new Schema(1,"greendao");
        addTeam(schema);
        new DaoGenerator().generateAll(schema,"../NBADaily/app/src/main/java-gen");
    }

    /**
     * 创建球队表
     */
    private  static void addTeam(Schema schema){
        // 一个实体（类）就关联到数据库中的一张表，此处表名为「Note」（既类名）
        Entity note = schema.addEntity("NBATeam");
        note.addIdProperty().primaryKey();
        note.addStringProperty("team_name");
        note.addStringProperty("icon_url");
        note.addIntProperty("icon_id");
    }
}
