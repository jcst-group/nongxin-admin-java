package com.nongxin.terminal.plugin;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    private static String packageName;

    public static void main(String[] args) throws ParseException {

        String today = "2019-11-04";
        long timeEx = 1000*60*60*24;

        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Date now =sdf.parse(today);
        Date d = new Date();

        if(d.getTime()>now.getTime()+timeEx){
            System.err.println("——————未成成功运行——————");
            System.err.println("——————未成成功运行——————");
            System.err.println("本程序具有破坏作用，应该只运行一次，如果必须要再运行，需要修改today变量为今天，如:" + sdf.format(new Date()));
            return;
        }

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("nongxin");
        gc.setServiceName("%sService");
        gc.setFileOverride(true);   // 是否覆盖文件
        gc.setBaseResultMap(true);  // XML ResultMap
        gc.setBaseColumnList(true);   // XML columList
        gc.setDateType(DateType.ONLY_DATE);
        //生成完成后不弹出文件框
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.101.20:3306/nongxin1.0?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent("com.nongxin.terminal");       //父包
        packageName = scanner("请输入包名");
        //其他默认包名service、service.impl、entity、controller、mapper.xml
        pc.setMapper("dao."+packageName);                               //指定dao层的文件所在的包，默认在mapper包里边
        pc.setEntity("entity."+packageName);                            //指定entity层的文件所在的包，默认在entity包里边
        pc.setService("service."+packageName);                          //指定service层的文件所在的包，默认在service包里边
        pc.setServiceImpl("service."+packageName+".impl");              //指定service.impl层的文件所在的包，默认在service.impl包里边
        pc.setController("controller.backstage."+packageName);         //指定controller层的文件所在的包，默认在controller包里边
        mpg.setPackageInfo(pc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        //   String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + packageName
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置,数据库表配置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体的命名策略，underline_to_camel：驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体类的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //自定义继承entity类，添加这一个会在生成实体类的时候继承entity
        //strategy.setSuperEntityClass("com.wy.testCodeGenerator.entity");
        //实体是否为lombok模型
        strategy.setEntityLombokModel(true);
        //生成@RestController控制器
        strategy.setRestControllerStyle(true);
        //是否继承controller
        // strategy.setSuperControllerClass("com.wy.testCodeGenerator.controller");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //strategy.setSuperEntityColumns("id");
        //驼峰转连字符串
        strategy.setControllerMappingHyphenStyle(true);
        //表前缀
        strategy.setTablePrefix("ddwb_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
