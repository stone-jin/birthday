### birthday
###### Looking for a software to help to design the markdown language,now using github gist
* an android app for anroid
* the first time to use github & git
* the first time to create a repository
* 2014/04/29:ADT(eclipse) 
* 2014/04/30:Switch to Android Studio


### 2014年4月21日
```
版本1
1.新建一个项目，学习git遇到一些问题
```
### 2014年4月22日
```
版本1
1.strings配合anim中加入各种android模式
2.加入了cx_faapp_icon.png的android图标
3.创建测试版本

版本2
1.mainactivity界面的设计---->此处用tabhost来实现
2.tabs搞定了
3.明天思考下mainactivity的background是不是需要的
```
### 2014年4月23日
```
版本1
1.早上完成了登陆模块的界面设计，代码部分下午开始编写
2.生日界面的界面完成设计，短信页面和个人中心页面和更多设置页面都还没设计

版本2
1.完成生日人首界面的串接
2.接下来要完成生日人模块的总体设置，对照生日人界面模块流程图设计

版本3
1.正在做生日人模块的添加生日人的主线
2.当前是在做界面上的主线过程
3.这个版本完成生日人界面的add_birthday的界面
4.下个版本要解决添加生日人主线中的search_contact的界面，从而生日人界面模块会完成添加生日人的功能模块
```
### 2014年4月24日
```
版本1
1.完成生日人界面的search_contact的界面
2.下午要完成的是生日人界面模块的添加生日人的功能主线，自己构造数据库表

版本2
1.完成生日人界面的search_contact的所有界面
2.成功导入手机内部的通讯录信息，没完成中午的任务
3.晚上继续生日人界面模块的添加生日人的功能模块
```
### 2014年4月25日
```
版本1
1.正在创建数据库的表，得思考下表的内容
2.完成生日人界面模块的添加生日人主线的大体功能

版本2
1.生日人主界面的listview的item界面的设计，还有数据库生日人表已经搞定，还有保存已经测试过，完成数据库基础模块的设计
2.明天要完成保存的时候计算生肖，星座等信息的计算方面，并且完成主界面和添加生日人模块的串接
```
### 2014年4月26日
```
版本1
1.完成添加生日人界面的所有功能，生肖计算，星座计算都完成了
2.晚上需要完成主界面listview的显示，需要从数据库查询出来，不能直接使用sql语句的查询，好像只能使用sqlite的qure函数了
```
### 2014年4月27日
```
版本1
1.解决了4月26日中出的一个listview的问题，发现控件在设置setText时，要将函数的参数设置为string类型，如果设置为int类型的话，会去寻找R中的资源，导致程序崩溃了
2.完成界面的显示，明天完成生日人主界面的功能模块和添加生日人模块的串接，传参。

版本2
1.解决了添加生日人界面的一个bug，由于calendar.get(Calendar.MONTH)获得的January是0，所以出了这个bug
2.完成生日人首界面按照生日距离排序，数据库这块也进行了一定修改
3.完成生日人主界面功能模块和添加生日人模块的串接
4.查看生日人功能主线还未进行编写
5.并在DayUtil中封装了一些跟时间有关的函数
```
### 2014年4月28日
```
版本1
1.完成查看生日人功能主线的界面模块
2.今天将生日人查看模块的代码写完，并设计短信发送的界面和功能

版本2
1.修复了生日管家birth界面的一个bug，并且修改了md文件的更新记录的顺序，下午完成短信发送的界面设计

版本3
1.完成发送短信的界面的设计
2.需要开始编写实现代码的设计
```
### 2014年4月29日
```
版本1
1.简单看了markdown的书写语法，修改了文档说明
2.正在实现birth_info界面的东西，完成进度进度：50%

版本2
1.编写公历时间转化时间类 -> GregorianUtil.java
```
### 2014年4月30日
```
版本1
1.使用了Android Studio发现调试和提示等功能挺不错的，就是界面有点丑，然后就将项目切换到了android studio下面，设置了下android studio软件的快捷键
2.代码方面昨天没怎么动，今天下午开始继续努力
```

### 2014年5月1日
```
版本1
1.从昨天下午开始整起，发现从eclipse导出android studio的项目，虽然android studio中中文显示OK了，但是发现android
  studio的apk安装的时候，出现了一些问题，如system.out.println和Toast的中文乱码显示问题，所以准备先把这个项目做完
  再去使用androi studio软件，然后将版本roll back回2014年4月29日版本2
2.发现github的一些指令还没有用的很明白，遇到困难迎难而上，才能变强
3.等会继续出版本，将项目进度推进
```

### 2014年5月3日
```
版本1
1.birth_info界面的农历算法没搞定
2.先跳过这个农历算法，先把框架搭出来，后面开分支搞定
```

### 2014年5月4日
```
版本1
1.做事风格也得改变，就是遇到难不可怕，先把软件整体结构搭出来，有bug也没事，先把整体框架搭出来，到时本地用php搭个测试问题库，
  自己提单自己解决，问题要记录的，还有就是后期软件做完后要进行代码review和软件测试。
2.今天将几个串了起来，后面add_birthday的数据库更新要改下，现在是先删除后添加来使用的。
3.今天白天在修改论文的事。
```

### 2014年5月5日
```
版本1
1.早起编程，努力努力，完成了从birth_info跳转到短信发送界面
2.上午实现下短信发送功能和电话拨打功能。

版本2
1.完成短信发送功能和电话拨打功能。
2.接下来需要完成sms模块

版本3
1.完成sms界面的编写，后面实现功能
2.数据库表需要因为需要而继续构建添加
```

### 2014年5月6日
```
版本1
1.早起编程，努力努力，编写了sms_info界面，从sms.birth界面跳转过来
2.估计由于焦点问题，导致了listview的onItemclick出了点问题
3.今天要搞定这部分，然后再构建数据库

版本2
1.sms_info页面就差数据库的数据了，收藏夹的界面弄好了
2.先搭整体界面框架准备，所以第一第二页面差不多了
3.继续搭建后面的三四界面

版本3
1.more界面完成了一部分，但是出现了一定问题，明天继续把界面部分设计完，以后做应用就是先得把界面部分弄好
  android软件感觉是这样子，C#这种还不得而知
2.今天进度略慢，得明天继续努力。
```

### 2014年5月7日
```
版本1
1.今天看了下activity的生命周期的各模式，并实现了下，还有弄毕业设计的中期答辩的事情
2.完成了more界面的界面设计，后面把所有界面模块的界面弄完，代码部分到时传接会快点。
```

### 2014年5月8日
```
版本1
1.完成center界面的设计，思考下还有哪些界面功能模块，并实现sms那边的数据库的信息。
2.修改了更多设置中的界面
```

### 2014年5月9日
```
版本1
1.今天去租房的地方取了另一台电脑
2.思考了短信数据库的内容，
  create table sms_info(id integer primary key, positionx integer, positiony integer, popularity integer, 
  content text, iscollect boolean);
3.明天把数据库这块弄过来，还有就是center功能都要做起来，然后弄http协议方面的东西。
```