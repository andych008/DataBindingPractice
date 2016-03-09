#第一章 MVVM

*Read this in other languages: [English](01_mvvm.en.md).*


##MVVM简介

&emsp;&emsp;先谈一下我对MVVM、MVC、MVP等架构的理解，我认为它们都是在解决一个问题，那就是解耦M和V。



&emsp;&emsp;对于MVC，先理解“数据流”该怎么处理，就可以更好地理解MVC。通常，数据流是这样的：M--->C---->V，但是这只是最简单的单向数据流。除了数据流，还有事件流，事件通常在V上面产生，同时会产生新的数据，这个时候数据会以反方向流动，即：V--->M。V直接操作M，你的代码就开始变得混乱，因为这会使得V变得不再单纯，它不再只是负责显示。

&emsp;&emsp;MVP直接跳过，用的人本来就不多。

&emsp;&emsp;MVVM正是用来解决使用MVC时遇到的困惑。它提供了新的概念ViewModel，V中绑定并显示的是ViewModel的数据，而且在Android上ViewModel的数据更新会自动同步到V上。那么事件怎么处理呢，我们知道在Android上如果使用MVC的架构，Activity和Fragment都属于V和C。但是，如果使用MVVM架构Activity和Fragment是属于ViewModel（我们暂且定义为EventViewModel），并且，只处理事件，不绑定数据，绑定数据的事情交给专门的类（通常以ViewModel为后缀,我们暂且定义为DataViewModel），这个类要设计得尽可能简单，它只关心V上显示的数据。这个时候数据流是这样的：M--->VM--->V。

&emsp;&emsp;那么，反方向的数据流怎么处理呢？我们知道，Activity和Fragment作为EventViewModel，也会绑定到V上（在Android上V就是layout），并且处理V产生的事件。处理事件通常是修改M中的数据，并修改DataViewModel类中的数据。数据流是这样的：V<---EventViewModel--->DataViewModel--->M。V不会直接产生数据，而是在EventViewModel中产生数据，并且不和M直接交互，V只能操作ViewModel。

&emsp;&emsp;以下两张图片，很明确地显示出上面阐述的内容：

![mvc](/raw/images/mvc.png)
<br>
![mvvm](/raw/images/mvvm.png)

图片来源：[http://www.ruanyifeng.com/blog/2015/02/mvcmvp_mvvm.html](http://www.ruanyifeng.com/blog/2015/02/mvcmvp_mvvm.html)

##MVVM实践
&emsp;&emsp;你把mvvm架构说得再好，如果不能用代码表现出来，那都是扯！那就看01_mvvm这个分支的代码吧。
这个示例，要把inputBox中输入的内容打印到textview里。

- `NoteVMData`中的content会绑定在`fragment_note.xml`中，当content的内容改变，会自动更新在界面上。
- `NoteFragment`我认为它也是ViewModel这一层，主要用来绑定事件。
- `NoteModel`中的print()模拟打印的功能。
