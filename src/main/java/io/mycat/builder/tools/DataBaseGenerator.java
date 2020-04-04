package io.mycat.builder.tools;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.TemplateException;
import io.mycat.builder.bean.ERRelation;
import io.mycat.builder.service.CrudGenrator;

/**
 * 数据库脚本生成的命令行工具 1 生成数据库表结构 2 索引 3 样本数据
 * 
 * @author Leader us
 */
public class DataBaseGenerator {
    Logger log = LoggerFactory.getLogger(DataBaseGenerator.class);

    public static void main(String[] args) {
        List<ERRelation> ers = new LinkedList<>();
        ers.add(new ERRelation("mk_contract", "user_id", "mk_user"));
        ers.add(new ERRelation("mk_bill", "user_id", "mk_user"));
        CrudGenrator gen = new CrudGenrator(
                "jdbc:mysql://localhost:3306/imkingroom?characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC",
                "root", "MyNewPass@123", "io.mycat.myweb.housesys", true, null, ers);
        try {
            gen.generator();
        } catch (ClassNotFoundException | SQLException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}