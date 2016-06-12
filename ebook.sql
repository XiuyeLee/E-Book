/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : ebook

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2016-06-12 16:10:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` char(50) NOT NULL,
  `bookname` varchar(50) NOT NULL,
  `summary` varchar(2000) DEFAULT NULL,
  `suffix` varchar(10) NOT NULL,
  `publishdate` date DEFAULT NULL,
  `publishhouse` varchar(50) DEFAULT NULL,
  `readsum` int(50) DEFAULT NULL,
  `category` varchar(100) NOT NULL,
  `author` varchar(100) DEFAULT NULL,
  `cover` varchar(300) DEFAULT NULL,
  `path` varchar(300) NOT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('01f2689e-1dc7-435c-b18f-64da659b6863', 'Effective Java中文版（第2版', '', 'pdf', '0002-11-29', '', '0', 'JA', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingAdvanced\\JavaProgrammingAdvanced\\Effective Java中文版（第2版）.pdf');
INSERT INTO `book` VALUES ('073bb692-ae6a-4122-bc99-79bcabd810d8', 'GNU_makefile中文手册', 'Linux 环境下的程序员如果不会使用 GNU make 来构建和管理自己的工程，应该\r\n不能算是一个合格的专业程序员，至少不能称得上是 Unix 程序员。在 Linux（unix）环\r\n境下使用 GNU 的 make 工具能够比较容易的构建一个属于你自己的工程，整个工程的\r\n编译只需要一个命令就可以完成编译、连接以至于最后的执行。不过这需要我们投入一\r\n些时间去完成一个或者多个称之为 Makefile 文件的编写。此文件正是 make 正常工作\r\n的基础。', 'pdf', '0002-11-29', 'GNU make中文手册 ', '0', 'C/C++', '徐海兵 ', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingLanguage\\C_C++\\GNU_makefile中文手册.pdf');
INSERT INTO `book` VALUES ('08d4657f-f5c6-47cb-b8de-14a0613992ee', '现代数学手册', '', 'pdf', '0002-11-29', '', '0', 'Math', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingAdvanced\\Math\\现代数学手册.pdf');
INSERT INTO `book` VALUES ('0f485c09-fb44-4860-8701-7e390511d629', 'Java核心技术,卷1(原书第8版)', '', 'pdf', '0002-11-29', '', '0', 'Java', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingLanguage\\java\\Java核心技术,卷1(原书第8版).pdf');
INSERT INTO `book` VALUES ('0f8b2fe8-607d-4bba-936e-e5dd987351ed', 'C++模板元编程', '《C++模板元编程》是关于C++模板元编程的著作。\r\n《C++模板元编程》主要介绍Traits和类型操纵、深入探索元函数、整型外覆器和操作、\r\n序列与迭代器、算法、视图与迭代器适配器、诊断、跨越编译期和运行期边界、领域特定的嵌入式语言、DSEL设计演练，\r\n另外附录部分还介绍了预处理元编程概述、typename和template关键字。\r\n《C++模板元编程》通过理论联系实践，深入讲解了C++高级编程技术', 'pdf', '0002-11-27', '机械工业出版社', '0', 'C/C++', 'David Abrahams', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingLanguage\\C_C++\\C++模板元编程.pdf');
INSERT INTO `book` VALUES ('1001', 'C++ Primer Plus（第6版）', 'C++是在C语言基础上开发的一种集面向对象编程、通用编程和传统的过程化编程于一体的编程语言，是C语言的超集。《C++ Primer Plus（第6版）（中文版）》是根据2003年的ISO/ANSI C++标准编写的。通过大量短小精悍的程序详细而全面地阐述了C++的基本概念和技术。全书分为18章和10个附录，分别介绍了C++程序的运行方式、基本数据类型、复合数据类型、循环和关系表达式、分支语句和逻辑操作符、函数重载和函数模板、内存模型和名称空间、类的设计和使用、多态、虚函数、动态内存分配、继承、代码重用、友元、异常处理技术、string类和标准模板库、输入/输出等内容。本书针对C++初学者，从C语言基础知识开始介绍，然后在此基础上详细阐述C++新增的特性，因此不要求读者有较多C语言方面的背景知识。本书可以作为高等院校C++课程的教材，也可以供初学者自学C++时使用。', 'pdf', '2012-06-30', '人民邮电出版社', '14', 'C/C++', 'Stephen Prata', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingLanguage\\C_C++\\C++ Primer Plus（第6版）.pdf');
INSERT INTO `book` VALUES ('1002', 'C++11', '国内首本全面深入解读C++11新标准的专著，由C++标准委员会代表和IBM XL编译器中国开发团队共同撰写。不仅详细阐述了C++11标准的设计原则，而且系统地讲解了C++11新标准中的所有新语言特性、新标准库特性、对原有特性的改进，以及如何应用所有这些新特性。', 'pdf', '2016-06-08', '机械工业出版社', '22', 'C/C++', 'Michael Wong', null, 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingLanguage\\C_C++\\C++11.pdf');
INSERT INTO `book` VALUES ('1003', 'primefaces_user_guide_5_3', 'PrimeFaces is an open source JSF component suite with various extensions', 'pdf', '2010-06-08', 'Primefaces出版社', '6', 'JSF', 'primefaces', null, 'F:\\ComputerScience_and_TechnologyDocument\\WebDevelopment\\JavaEE\\JSF\\primefaces_user_guide_5_3.pdf');
INSERT INTO `book` VALUES ('18fe4d41-c9d4-4126-b69a-6732d96a1d39', 'C++编程思想(第2版)_第1卷_标准C++引导', '本书第1版荣获美国“软件开发”杂志评选的1996年图书震撼大奖（Jolt Award），中文版自2000年推出以来，经久不衰，获得了读者的充分肯定和高度评价。 \r\n第2版与第1版相比，在章节安排上有以下改变。增加了两章：“对象的创建与使用”和“C++中的C”。前者与“对象导言”实际上是第1版“对象的演化”一章的彻底重写，增加了近几年面向对象方法和编程方法的最新研究与实践的丰硕成果；后者的添加使不熟悉C的读者可以直接使用本书。删去了四章：“输入输出流介绍”、“多重继承”、“异常处理”和“运行时类型识别”，删去的内容均为C++中较复杂的主题，作者将它们连同C++标准完成后增加的一些内容放到本书的第2卷中，使本书的第1卷内容显得更加集中，可以供不同程度的读者选择阅读。需要强调的是，第2版的改变不仅体现在这些章节的调整上，更多的改变体现在每一章的字里行间，包括例子的调整和练习的补充。与众不同的精心选材和认真推敲的叙述使得第2版更趋成熟。 \r\n本书是C++领域内一本权威的著作，书中的内容、讲授方法、例子和练习既适合课堂教学，又适合读者自学。无论是高等院校计算机及相关专业的学生，还是业界的从业人员，以及广大的计算机爱好者，都可从阅读本书中获益。 ', 'pdf', '0002-11-28', '机械工业出版社', '5', 'CA', 'Bruce Eckel', 'F:\\ComputerScience_and_TechnologyDocument\\Cover\\cppthinkingcover.jpg', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingAdvanced\\C++ProgrammingAdvanced\\C++编程思想(第2版)_第1卷_标准C++引导.pdf');
INSERT INTO `book` VALUES ('1a93d50c-89b1-418a-9237-a4638395279f', '数学之美', '', 'pdf', '0002-11-29', '', '0', 'Math', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingAdvanced\\Math\\数学之美.PDF');
INSERT INTO `book` VALUES ('3fd5ef70-3f63-415b-902d-d57c0d7f5608', 'JAVA解惑', '', 'pdf', '0002-11-29', '', '0', 'JA', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingAdvanced\\JavaProgrammingAdvanced\\JAVA解惑.pdf');
INSERT INTO `book` VALUES ('52227272-60c5-4710-a0b7-dc0f40386e93', 'Unity.3D游戏开发', '<span style=\"color: rgb(51, 51, 51); font-family: arial, 宋体, sans-serif; font-size: 14px; line-height: 24px; text-indent: 28px; background-color: rgb(255, 255, 255);\">《Unity 3D游戏开发》通过实例详细介绍了如何使用Unity进行游戏开发，书中先简要介绍了Unity环境搭建、编辑器和GUI游戏界面相关的知识，接着介绍了如何使用C#和JavaScript构建游戏脚本，添加树、草、石头等模型以及键盘事件、鼠标事件和3D模型动画相关的内容，然后介绍了持久化数据、音频与视频的播放等内容，最后以一款第一人称射击类游戏为原型，向读者详细介绍游戏制作的整个过程。</span>', 'pdf', '2012-06-01', '人民邮电出版社', '5', 'Unity3D', '宣雨松', '', 'F:\\ComputerScience_and_TechnologyDocument\\GameProgramming\\Unity3D\\Unity.3D游戏开发.pdf');
INSERT INTO `book` VALUES ('5c471ea2-28ec-4f02-bd6a-4a9e3644b42e', '编写高质量代码  改善Java程序的151个建议', '', 'pdf', '0002-11-29', '', '0', 'JA', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingAdvanced\\JavaProgrammingAdvanced\\编写高质量代码  改善Java程序的151个建议.pdf');
INSERT INTO `book` VALUES ('838aba9a-8313-4b18-abdc-eed3b01c9922', '世界是数字的', '', 'pdf', '0002-11-29', '', '0', 'Math', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingAdvanced\\Math\\世界是数字的.pdf');
INSERT INTO `book` VALUES ('861f619e-5ca6-4ad3-8a67-35ea512d3abd', 'Java 8 in Action.pdf', '', 'pdf', '0002-11-29', '', '1', 'Java', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingLanguage\\java\\Java 8 in Action.pdf');
INSERT INTO `book` VALUES ('8c7cdc04-840a-4476-ad1b-ec505b7b9a74', 'Head First设计模式(java高清版)', '', 'pdf', '0002-11-29', '', '0', 'JA', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingAdvanced\\JavaProgrammingAdvanced\\Head First设计模式(java高清版).pdf');
INSERT INTO `book` VALUES ('8cd00e45-31e3-4aba-90fa-45fb31b5d004', '图灵程序设计丛书：程序员的数学', '', 'pdf', '0002-11-29', '', '0', 'Math', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingAdvanced\\Math\\图灵程序设计丛书：程序员的数学.pdf');
INSERT INTO `book` VALUES ('980b240a-2fe6-482f-bc4b-92233119f2f2', 'C++ Templates(中文版)', '<p style=\"margin: 0px; text-indent: 2em; color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; font-size: 12px; line-height: 19.44px; background-color: rgb(255, 255, 255);\">本书是C++模板编程的完全指南，旨在通过基本概念、常用技巧和应用实例3方面的有用资料，为读者打下C++模板知识的坚实基础。</p><p style=\"margin: 0px; text-indent: 2em; color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; font-size: 12px; line-height: 19.44px; background-color: rgb(255, 255, 255);\">全书共22章。第1章全面介绍了本书的内容结构和相关情况。第1部分(第2~7章)以教程的风格介绍了模板的基本概念，第2部分(第8~13章)阐述了模板的语言细节，第3部分(第14~18章)介绍了C++模板所支持的基本设计技术，第4部分(第19~22章)深入探讨了各种使用模板的普通应用程序。附录A和B分别为一处定义原则和重载解析的相关资料。</p><p style=\"margin: 0px; text-indent: 2em; color: rgb(17, 17, 17); font-family: Helvetica, Arial, sans-serif; font-size: 12px; line-height: 19.44px; background-color: rgb(255, 255, 255);\">本书适合C++模板技术的初学者阅读，也可供有一定编程经验的C++程序员参考。</p>', 'pdf', '2004-01-01', '人民邮电出版社', '0', 'C/C++', 'David Vandevoord/Nicolai M.Josuttis', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingLanguage\\C_C++\\C++ Templates(中文版).pdf');
INSERT INTO `book` VALUES ('9ad1060f-1615-409e-8ffb-3c5f45f530ab', 'MySQL 5权威指南（第3版', '', 'pdf', '0002-11-29', '人民邮电出版社', '0', 'Mysql', 'Michael Kofler', '', 'F:\\ComputerScience_and_TechnologyDocument\\Database\\Mysql\\MySQL 5权威指南（第3版）.pdf');
INSERT INTO `book` VALUES ('a7a10f5f-72cc-45aa-b419-d4a1507029a1', '具体数学', '', 'pdf', '0002-11-29', '', '0', 'Math', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingAdvanced\\Math\\具体数学.pdf');
INSERT INTO `book` VALUES ('b734084e-61f6-41e1-a960-e19d93339e0f', 'Java核心技术(原书第8版)卷Ⅱ 高级特性', '', 'pdf', '0002-11-29', '', '0', 'Java', '', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingLanguage\\java\\Java核心技术(原书第8版)卷Ⅱ 高级特性.pdf');
INSERT INTO `book` VALUES ('c7690ddf-83a9-40bb-8d27-a04fe34aed87', 'Head First PHP & MySQL(中文版)', '《深入浅出PHP&MySQL(影印版)》静态HTML网页提升到下一个层次并使用PHP和MySQL建立数据库驱动的网站《深入浅出PHP& MysQL》是一本快捷实用的指南自己动手建立实际应用程序，从视频游戏高分留言板到在线交友网站。当你完成后，你将可以进行验证表单、使用会话ID和cookies工作、执行数据库查询和联接、处理文件I/0操作等等。', 'pdf', '2015-03-02', '清华大学出版社', '2', 'PHP', 'Head First ', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingLanguage\\PHP\\Head First PHP & MySQL(中文版).pdf');
INSERT INTO `book` VALUES ('e207d2fe-1163-43e4-a95d-5eb948130409', 'The C++ Programming Language (4th Edition)', 'C++ feels like a new language. That is, I can express my ideas more clearly, more simply, and\r\nmore directly in C++11 than I could in C++98. Furthermore, the resulting programs are better\r\nchecked by the compiler and run faster.\r\nIn this book, I aim for completeness. I describe every language feature and standard-library\r\ncomponent that a professional programmer is likely to need. For each, I provide:\r\n• Rationale: What kinds of problems is it designed to help solve? What principles underlie\r\nthe design? What are the fundamental limitations?\r\n• Specification: What is its definition? The level of detail is chosen for the expert programmer;\r\nthe aspiring language lawyer can follow the many references to the ISO standard.\r\n• Examples: How can it be used well by itself and in combination with other features? What\r\nare the key techniques and idioms? What are the implications for maintainability and performance?\r\nThe use of C++ has changed dramatically over the years and so has the language itself. From the\r\npoint of view of a programmer, most of the changes have been improvements. The current ISO\r\nstandard C++ (ISO/IEC 14882-2011, usually called C++11) is simply a far better tool for writing\r\nquality software than were previous versions. How is it a better tool? What kinds of programming\r\nstyles and techniques does modern C++ support? What language and standard-library features support\r\nthose techniques? What are the basic building blocks of elegant, correct, maintainable, and\r\nefficient C++ code? Those are the key questions answered by this book. Many answers are not the\r\nsame as you would find with 1985, 1995, or 2005 vintage C++: progress happens', 'pdf', '0002-11-28', 'U.S. Corporate and Government Sales', '0', 'C/C++', 'Bjarne Stroustrup', '', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingLanguage\\C_C++\\The C++ Programming Language (4th Edition).pdf');
INSERT INTO `book` VALUES ('f3101e3d-7c8e-4b1c-a3da-869dcf2f73a2', 'MySQL技术内幕(第4版)', '', 'pdf', '0002-11-29', '人民邮电出版社', '0', 'Mysql', 'Paul Dubois', '', 'F:\\ComputerScience_and_TechnologyDocument\\Database\\Mysql\\MySQL技术内幕(第4版).pdf');
INSERT INTO `book` VALUES ('fec7fb04-276c-40bc-9531-ff109720b15c', 'Java编程思想(第4版)', '《Java编程思想（第4版）》赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），《Java编程思想（第4版）》都能逐步指导你轻松掌握。\r\n从java编程思想这本书获得的各项大奖以及来自世界各地的读者评论中，不难看出这是一本经典之作。本书的作者拥有多年教学经验，对C、C++以及Java语言都有独到、深入的见解，以通俗易懂及小而直接的示例解释了一个个晦涩抽象的概念。《Java编程思想（第4版）》共22章，包括操作符、控制执行流程、访问权限控制、复用类、多态、接口、通过异常处理错误、字符串、泛型、数组、容器深入研究、Java I/O系统、枚举类型、并发以及图形化用户界面等内容。这些丰富的内容，包含了Java语言基础语法以及高级特性，适合各个层次的Java程序员阅读，同时也是高等院校讲授面向对象程序设计语言以及Java语言的绝佳教材和参考书。 \r\n第4版特点： \r\nJava编程思想(第4版)这本书特别适合初学者与专业人员的经典的面向对象叙述方式，为更新的Java SE5/6增加了新的示例和章节。\r\n 测验框架显示程序输出。\r\n 设计模式贯穿于众多示例中：适配器、桥接器、职责链、命令、装饰器、外观、工厂方法、享元、点名、数据传输对象、空对象、代理、单例、状态、策略、模板方法以及访问者。\r\n 为数据传输引入了XML，为用户界面引入了SWT和Flash。\r\n 重新撰写了有关并发的章节，有助于读者掌握线程的相关知识。\r\n 专门为第4版以及Java SE5/6重写了700多个编译文件中的500多个程序。\r\n 支持网站包含了所有源代码、带注解的解决方案指南、网络日志以及多媒体学习资料。\r\n 覆盖了所有基础知识，同时论述了高级特性。\r\n 详细地阐述了面向对象原理。', 'pdf', '0002-11-29', '机械工业出版社', '0', 'JA', '(美)Bruce Eckel', 'F:\\ComputerScience_and_TechnologyDocument\\Cover\\javathink.jpg', 'F:\\ComputerScience_and_TechnologyDocument\\ProgrammingAdvanced\\JavaProgrammingAdvanced\\Java编程思想(第4版).pdf');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `userid` char(50) NOT NULL,
  `content` varchar(500) NOT NULL,
  `fbdate` datetime NOT NULL,
  `isdeal` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');
INSERT INTO `feedback` VALUES ('12101010423', '把界面最好点', '2016-06-07 17:21:04', '1');

-- ----------------------------
-- Table structure for onlineuser
-- ----------------------------
DROP TABLE IF EXISTS `onlineuser`;
CREATE TABLE `onlineuser` (
  `userid` char(50) NOT NULL,
  `sessionid` char(50) NOT NULL,
  `deletedate` datetime NOT NULL,
  `createdate` datetime NOT NULL,
  `saveminutes` int(11) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of onlineuser
-- ----------------------------
INSERT INTO `onlineuser` VALUES ('0405db4c-dbf2-4d9e-8ca7-153c7fce2a85', 'D8121C42668866E1BCF14B25DBC8FC1B', '2016-06-14 01:27:02', '2016-06-09 01:27:02', '0');
INSERT INTO `onlineuser` VALUES ('fe681318-6fbb-41cf-9489-e90789976879', 'FB52A868E30F30765A49568F05B061C6', '2016-06-13 23:27:23', '2016-06-08 23:27:23', '0');

-- ----------------------------
-- Table structure for readinghistory
-- ----------------------------
DROP TABLE IF EXISTS `readinghistory`;
CREATE TABLE `readinghistory` (
  `userid` char(50) NOT NULL,
  `bookid` char(50) NOT NULL,
  `readingdate` date NOT NULL,
  `readtimes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readinghistory
-- ----------------------------
INSERT INTO `readinghistory` VALUES ('12101010423', '1001', '2016-05-27', '9');
INSERT INTO `readinghistory` VALUES ('12101010423', '1002', '2016-06-08', '11');
INSERT INTO `readinghistory` VALUES ('12101010423', '1003', '2016-06-08', '99');
INSERT INTO `readinghistory` VALUES ('12101010423', '1002', '2016-06-11', '2');
INSERT INTO `readinghistory` VALUES ('12101010423', '52227272-60c5-4710-a0b7-dc0f40386e93', '2016-06-11', '1');
INSERT INTO `readinghistory` VALUES ('12101010423', '18fe4d41-c9d4-4126-b69a-6732d96a1d39', '2016-06-12', '1');
INSERT INTO `readinghistory` VALUES ('12101010423', '18fe4d41-c9d4-4126-b69a-6732d96a1d39', '2016-06-12', '2');
INSERT INTO `readinghistory` VALUES ('12101010423', '18fe4d41-c9d4-4126-b69a-6732d96a1d39', '2016-06-12', '3');
INSERT INTO `readinghistory` VALUES ('12101010423', '1001', '2016-06-12', '2');
INSERT INTO `readinghistory` VALUES ('12101010423', '1001', '2016-06-12', '3');

-- ----------------------------
-- Table structure for requestforname
-- ----------------------------
DROP TABLE IF EXISTS `requestforname`;
CREATE TABLE `requestforname` (
  `userid` char(50) NOT NULL,
  `content` varchar(100) NOT NULL,
  `isdeal` char(1) NOT NULL,
  `requestdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of requestforname
-- ----------------------------
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');
INSERT INTO `requestforname` VALUES ('12101010423', ' 改名你好', '1', '2016-06-07');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `testname` varchar(255) DEFAULT NULL,
  `desc` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'xiuye', 'hello,OK!');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` char(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` char(20) NOT NULL,
  `sex` varchar(2) DEFAULT '保密',
  `birthday` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `qq` char(20) DEFAULT NULL,
  `phone` char(20) DEFAULT NULL,
  `isAdmin` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `usernameonly` (`username`),
  UNIQUE KEY `emailonly` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('00c9c2b7-1109-4c83-a657-0472a6b70493', 'cpp', '123456', '男', '2016-01-08', 'cpp@ww.com', '5555555', '5555555', '0');
INSERT INTO `user` VALUES ('0405db4c-dbf2-4d9e-8ca7-153c7fce2a85', 'fast', '123456', '男', '2016-01-01', 'qwe@cm.com', '9999999', '9999999', '0');
INSERT INTO `user` VALUES ('12101010411', 'dema', '123456', '男', '2016-05-15', 'dema@163.com', '647777878', '123456789', '0');
INSERT INTO `user` VALUES ('12101010423', 'xiuye', '123456', '男', '1992-12-25', 'xiuye_engineer@outlook.com', '648657883', '18381334381', '1');
INSERT INTO `user` VALUES ('1a3bc966-30be-4fb8-9a86-7ff9f090845b', 'ssss', 'sbsbsb', '男', '2016-01-01', '111111111@qq.com', '', '', '0');
INSERT INTO `user` VALUES ('1a7e9d26-9943-40e7-b55e-44e6c64defb0', 'sunting', '123456', '男', '2016-01-23', '163@qq.com', '12345678', '13755154545', '0');
INSERT INTO `user` VALUES ('82a46cba-2cef-4716-9584-2017852334c9', 'wu', '1234567', '女', '2016-01-04', 'qw2e@cm.com', '342342342', '2313123122', '0');
INSERT INTO `user` VALUES ('c4ad2b1c-489c-417d-9711-5b9053bbf496', 'xiuye3000', '123456', '保密', '2016-01-06', 'xiuye_engineer2016@outlook.com', '123456', '123456', '0');
INSERT INTO `user` VALUES ('c7b9c7c6-9ffb-4973-af7e-1c4def5424b4', 'yyyy', '123456', '男', '2016-01-06', 'qq@qq.com', '1232131', '', '0');
INSERT INTO `user` VALUES ('ca4e518a-a8a1-4c79-9466-c2093b0454a1', 'xiuye5000', '123456', '保密', '2016-01-08', 'xiuye@qq.com', '78567435', '3423424', '0');
INSERT INTO `user` VALUES ('d01e6144-0ea4-4bb6-971e-bd52c7629cd7', 'wer', '123456', '男', '2016-01-09', 'erq@wr.com', '', '', '0');
INSERT INTO `user` VALUES ('e3756df6-524b-4098-bd2e-276e4835cbe8', 'ffffff', '123456', '男', '2016-01-09', 'qwe@ds.com', '232323', '536463456', '0');
INSERT INTO `user` VALUES ('fe681318-6fbb-41cf-9489-e90789976879', 'jack', '123456', '男', '2016-01-08', 'ui@qq.com', '123456', '1111111111111', '0');

-- ----------------------------
-- Table structure for userfavoritebook
-- ----------------------------
DROP TABLE IF EXISTS `userfavoritebook`;
CREATE TABLE `userfavoritebook` (
  `userid` char(50) NOT NULL,
  `bookid` char(50) NOT NULL,
  `addDate` datetime NOT NULL,
  `readtimes` int(11) NOT NULL,
  PRIMARY KEY (`userid`,`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userfavoritebook
-- ----------------------------
INSERT INTO `userfavoritebook` VALUES ('12101010411', '1001', '2016-06-11 00:21:36', '1');
INSERT INTO `userfavoritebook` VALUES ('12101010411', '1002', '2016-06-11 00:21:33', '1');
INSERT INTO `userfavoritebook` VALUES ('12101010411', '1003', '2016-06-11 00:21:37', '1');
INSERT INTO `userfavoritebook` VALUES ('12101010411', 'c7690ddf-83a9-40bb-8d27-a04fe34aed87', '2016-06-11 00:21:42', '1');
INSERT INTO `userfavoritebook` VALUES ('12101010423', '073bb692-ae6a-4122-bc99-79bcabd810d8', '2016-06-12 08:33:41', '1');
INSERT INTO `userfavoritebook` VALUES ('12101010423', '0f8b2fe8-607d-4bba-936e-e5dd987351ed', '2016-06-12 08:33:40', '1');
INSERT INTO `userfavoritebook` VALUES ('12101010423', '1001', '2016-06-08 14:58:55', '6');
INSERT INTO `userfavoritebook` VALUES ('12101010423', '1002', '2016-06-08 14:42:53', '5');
INSERT INTO `userfavoritebook` VALUES ('12101010423', '18fe4d41-c9d4-4126-b69a-6732d96a1d39', '2016-06-12 08:33:30', '1');
INSERT INTO `userfavoritebook` VALUES ('12101010423', '52227272-60c5-4710-a0b7-dc0f40386e93', '2016-06-10 23:29:55', '2');
INSERT INTO `userfavoritebook` VALUES ('12101010423', '980b240a-2fe6-482f-bc4b-92233119f2f2', '2016-06-12 08:33:42', '1');
INSERT INTO `userfavoritebook` VALUES ('12101010423', 'c7690ddf-83a9-40bb-8d27-a04fe34aed87', '2016-06-10 23:29:52', '2');
INSERT INTO `userfavoritebook` VALUES ('12101010423', 'fec7fb04-276c-40bc-9531-ff109720b15c', '2016-06-12 04:43:48', '1');
