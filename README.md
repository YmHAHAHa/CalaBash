# 葫芦娃 — 最终之战

## 环境配置

项目开发所使用IDE为IntelliJ IDEA，所使用图形化框架为JavaFx，项目实测在Java8环境下可以运行。

## 概述

葫芦娃与妖怪的战斗终于迎来了最终章，今天他们要在战场上决出最后的胜负。葫芦娃一方阵容为葫芦七兄弟和老当益壮的老爷爷，而妖怪一方包括阴险狡诈的蛇精、力大无穷的蝎子精以及七只小喽啰。它们将在战场上战个痛快！！！

## 效果图

<div align=center>
    <img src = "pic\1.gif" width='100%'>
</div>

葫芦娃大胜！！！

<div align=center>
    <img src = "pic\2.gif" width='100%'>
</div>

妖怪大胜！！！

## 设计简介

### UI设计

在项目的开发中我尽量使界面整体显示得简洁而又大方，战场使用了一个比标准格式稍大一些的国际象棋棋盘，这使得整场战斗更像是双方在心理和斗志上的一场博弈。双方一开始摆出得意拿手的阵法，然后运用智慧和勇气去击败对手！在战场的右边是整个项目的一个海报式宣传（我的初衷是希望这个海报能给人以即将观看一场盛大电影的感觉，然而最终更像是我在为某款国产手游“大作”打广告），意在告诉大家，好戏要开演了。

### 人物图案

我们可以看到，每一位葫芦娃战士的形象都是卡通Q版头像，而妖怪阵容里的每一位则都是穷凶极恶的动画原版形象，这也充分契合了双方的形象设定，可爱呆萌的葫芦娃和阴森可怕的妖怪们哪一方才能取得最后的胜利呢？

<div align=center>
    <img src = "src\main\resources\1.png" width='15%'>
</div>

<div align=center>
    <img src = "src\main\resources\hamajing.png" width='15%'>
</div>

当每一位战士在战场上鏖战致死后，他的图像也会发生相应的变化，变成一个骷髅头（至于为什么是海贼王里的旗帜图案，别问，问就是要成为海贼王的男人！）每一个骷髅头都标志着有一位英勇的战士在这里牺牲了。

<div align=center>
    <img src = "src\main\resources\die.png" width='15%'>
</div>

### 战斗设计

每一个战士都是近战肉搏大师！它们在附近没有任何敌人时会向敌人们发起无畏的冲锋；当它们与敌人面对面时，当然是狭路相逢勇者胜！然而它们也不完全是莽夫，因为无论多么强大的战士也会有疲倦的时候。每一次轮到这位战士进行活动的时候，他都有一定的可能性休息或者回避最近的敌人，这个概率会随着这位战士每一次战斗获胜而逐渐增加，而当他进行了适量的休息后又会充满斗志的继续向敌人冲锋！

特殊的设定 — “拯救世界的老爷爷”：尽管老爷爷老当益壮，坚持要加入战场，但是岁月无情，老爷爷的战斗能力还是不如年轻力壮的葫芦娃和妖怪，然而随着葫芦娃一个一个阵亡，老爷爷会因为葫芦娃牺牲前传达的斗志不断变强，如果战场上葫芦娃一方只有孤独而愤怒的老爷爷时，他将变得异常强大，很有可能以一己之力扫荡残余妖怪。

P.S. 效果图一中我们可以看到，仅剩一名葫芦娃时，老爷爷已经变得相当强劲。

<div align=center>
    <img src = "pic\3.png" width='70%'>
</div>

当每一位战士牺牲后，他会在牺牲的位置留下一个标志死亡的骷髅头，然而这个骷髅头并不是一个具有实体的路障，任何一方的战士都可以继续在这个位置继续战斗，然而每一个骷髅头都寄托着牺牲的的战士的执念，当一名友方战士在这块区域战斗时，可以避免该战士的体力消耗（鞠躬尽瘁，死而后已）

## 运行说明

项目打包生成jar文件可以在命令行下通过执行"java -jar XXX.jar"命令执行。

程序运行后按下键盘的"SPACE"键位，可以开始一场新的战斗，会提示选择一个位置存储本次战斗的数据，我们可以将战斗数据储存在一个文本文档中；如果在程序运行后按下键盘上的"L"键位，就会执行复盘功能，我们可以通过一个对话框选择之前存储的一场战斗数据载入战斗过程。

## 代码设计

### 继承

<div align=center>
    <img src = "pic\4.png" width='100%'>
</div>

所有战士继承自Creature类，这是在之前作业不断迭代的基础上完成的。在本项目中，我极大的丰富了每一个战士自身的各种属性，使它们变得尽可能英勇而足智多谋，而不是像阅兵走方阵一般整齐进发。

### 封装

<div align=center>
    <img src = "pic\5.png" width='100%'>
</div>

各个类各司其职，合理有序的接口构建了项目所有功能。

### 泛型

<div align=center>
    <img src = "pic\6.png" width='100%'>
</div>

极大的增加了程序的灵活性，使变量更容易统一的进行调用，如对不同种类的妖怪进行布阵操作。

### 异常处理

```java
try {
    if (isGo) {
        Thread.sleep(rand.nextInt(500) + 300);
    } else {
        field.stopOneRun(indexRun);
    }
} catch (InterruptedException e) {
        e.printStackTrace();
}
```

### 文件IO

```java
public void setFile(File file) {
    this.file = file;
    try {
        fileWriter = new FileWriter(file);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

```java
try {
    scanner = new Scanner(file);
} catch (Exception e) {
    e.printStackTrace();
}
```

### 多线程机制

```java
//使用锁防止多线程的资源共享问题
public synchronized boolean Move(Creature c1, Creature c2, Random rand) {...}
public synchronized void Fight(Creature c1, Creature c2, Random rand) {...}
```

## 单元测试

本项目已经通过对位置改变，战场重绘等关键函数的单元测试。
