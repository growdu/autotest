---
sidebar_position: -1
---

# appium环境搭建


## 1 关于Android UI自动化测试

-   `Android UI`自动化测试工具有很多，这些工具基本是基于`Android`控件层面，涉及`Widgets`和`WebView`两类；
-   而关于其测试方法一般有二：

> 第一种是： 通过`Android`提供的各种服务来获取当前窗口的视图信息，如`UI Automator`。
> 
> 第二种是： 基于`Instrumention`，把测试APK和被测APK运行在同一个进程中，通过Java反射机制来获取当前窗口的所有视图，如`Robotium`

-   常用的测试工具有：`UI Automator`、`Appium`、`Espresso`、`Selendroid`、`Robotium`等；
-   本文主要介绍的是`Appium`。

-   `Appium`是开源的、跨平台的测试自动化测试框架；
-   主要用于测试移动端应用；
-   `Appium`支持模拟器和真机上的原生应用、混合应用、`Web`应用；
-   `Appium`使用`WebDriver`的`JSON wire`协议来驱动`Apple`系统的`UI Automator`库、`Android`系统的`UI Automator`框架；
-   因`Appium`集成了`Selendroid`框架，所以Appium支持比较老版本的`Android`；
-   `Appium`支持`Selenium WebDriver`支持的所有语言（`Java`、`Python`、`JavaScript`、`Objective-C`、`PHP`、`Ruby`、`C#`、`Clojure`、`Perl`等）。

## 3 Appium原理

### 3.1 Android端过程

-   客户端`client`，指咱们的测试脚本；
-   `Appium`在服务端启动一个`Server`（4723端口），用来接口`WebDriver client`标准的`rest`请求，调用对应框架响应操作；
-   `Appium Server`把请求转发给[中间件](https://cloud.tencent.com/product/message-queue-catalog?from_column=20065&from=20065)`Bootstrap.jar`（手机上），`Bootstrap.jar`监听4724端口并接收`Appium`命令；
-   `Bootstrap`将执行结果返回给`Appium Server`；
-   `Appium Server`再将结果返回给`Appium Client`。

### 3.2 iOS端过程

-   客户端`client`，指咱们的测试脚本；
-   `Appium`在服务端启动一个`Server`（4723端口），用来接口`WebDriver client`标准的`rest`请求，调用对应框架响应操作；
-   `Appium Server`调用`instruments.js`，启动`socket server`，分出子进程`instruments.app`，将`bootstrap.js`注入`device`；
-   `bootstrap.js`将执行结果返回给`Appium Server`；
-   `Appium Server`再将结果返回给`Appium Client`。

## 4 补充内容

-   `UI Automator`测试框架是`Android SDK`自带的`APP UI`自动化测试`Java`库；
-   而`UI Automator`对`H5`支持有限；
-   `Appium`引入了`chromedriver`等来实现基于H5的自动化；
-   Android和iOS启动过程的区别在Appium将请求转发给了`Bootstrap.jar`或`bootstrap.js`,再由`Bootstrap`驱动`UI Automator`或`UI Automation`。

## 5 JDK下载

-   安装地址：[Java Downloads](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Fwww.oracle.com%2Fjava%2Ftechnologies%2Fdownloads%2F&objectId=2367971&objectType=1&isNewArticle=undefined)；
    
       
    
-   根据操作系统选择下载，我的是`Windows`平台；
-   双击安装文件，按照提示，可以一步步安装，中间会有两次选择安装路径，第一次是安装`Jre`，第二次是安装`Jdk`，两次的安装目录，建议单独放在一个磁盘的根目录，如下，笔者的是：`jdk-11.0.8`；
    
    
    
    

## 6 JDK配置

-   新建系统环境变量`JAVA_HOME`：
    
    
    
    
-   编辑系统变量`Path`：

Windows10 电脑，新建变量值：

```python
%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin; 
```

Windows7 电脑，在变量值最后输入：(注意用;号分隔)

```cmd
%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;
```

-   新建系统变量`CLASSPATH`变量：

```python
变量名：CLASSPATH 变量值：.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar
```

-   验证`java`环境：
    
    
    
    

## 7 SDK下载

-   `SDK`下载： [SDK官网](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Fdeveloper.android.com%2Fstudio%2Findex.html&objectId=2367971&objectType=1&isNewArticle=undefined)和 [下载较快的SDK网站](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Fwww.androiddevtools.cn%2F&objectId=2367971&objectType=1&isNewArticle=undefined)；
-   比如我们选第二个进入下载页面：   
    
    
-   选择对应的平台下载即可，我这里是`windows`平台的；
-   下载后解压到指定目录
    
    
    

## 8 SDK配置

-   将`SDK`的`platform-tools`、根目录、`tools`配置到系统环境变量`path`中；

```python
D:\android-sdk-windows\platform-tools D:\android-sdk-windows D:\android-sdk-windows\tools
```



## 9 配置Android环境

-   新建系统环境变量`ANDROID_HOME`值为`SDK`根目录:

```python
ANDROID_HOME D:\android-sdk-windows
```



-   新建系统环境变量`ANDROID_PATH`值为`SDK`的`platform-tools`目录：

```python
ANDROID_PATH D:\android-sdk-windows\platform-tools
```



## 10 安装NodeJs

-   安装这个只要是用它来安装`appium`以及验证后续安装的`Appium`是否成功；
-   下载地址：[NodeJs](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Fnodejs.org%2Fen&objectId=2367971&objectType=1&isNewArticle=undefined)：
    
    
    
-   下载后直接双击运行即可`node-v20.10.0-x64.msi`；
-   安装完在命令行可以执行`npm`则表示`node`安装成功了：

    
    

## 11 解决node安装时提示不是内部命令

-   需要配置`node.js`的一些环境变；
-   在`node.js`的安装目录下新建两个文件夹如下`node_global`和`node_cache`：
    
    
-   打开系统环境变量，新增`NODE_PATH`变量：

```python
NODE_PATH D:\nodejs\node_modules
```




-   在系统环境变量的`path`新增：`%NODE_PATH%`：
    

    
    
    
-   打开用户环境变量，修改`path`中的`npm`路径为：`D:\nodejs\node_global`：
    
    
    
    
-   重启电脑、重启电脑、重启电脑（重要的事情说三遍）。

## 12 安装配置Appium

-   [Appium官网](https://cloud.tencent.com/developer/tools/blog-entry?target=http%3A%2F%2Fappium.io%2F&objectId=2367971&objectType=1&isNewArticle=undefined)：
    
    
    
    
-   点击左侧的`install Appium`使用`NPM`安装：

```python
npm i --location=global appium
```

-   命令行输入`appium`即可：

```python
PS C:\Users\growd> appium
[Appium] Welcome to Appium v2.16.2
[Appium] The autodetected Appium home path: C:\Users\growd\.appium
[Appium] Attempting to load driver uiautomator2...
[Appium] Attempting to load driver espresso...
[Appium] Requiring driver at C:\Users\growd\.appium\node_modules\appium-uiautomator2-driver\build\index.js
[Appium] Requiring driver at C:\Users\growd\.appium\node_modules\appium-espresso-driver\build\index.js
[Appium] AndroidUiautomator2Driver has been successfully loaded in 8.809s
[Appium] EspressoDriver has been successfully loaded in 16.366s
[Appium] Appium REST http interface listener started on http://0.0.0.0:4723
[Appium] You can provide the following URLs in your client code to connect to this server:
        http://192.168.75.1:4723/
        http://192.168.19.1:4723/
        http://192.168.3.104:4723/
        http://127.0.0.1:4723/ (only accessible from the same host)
[Appium] Available drivers:
[Appium]   - uiautomator2@4.1.0 (automationName 'UiAutomator2')
[Appium]   - espresso@4.1.0 (automationName 'Espresso')
[Appium] Available plugins:
[Appium]   - images@3.0.30
[Appium] No plugins activated. Use the --use-plugins flag with names of plugins to activate
```

-   关于安装可参考官网：
    
    
    
-   还有环境的要求：
    
    
    
    
-   还有一种安装方式为使用`GUI`界面去安装[appium-desktop](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Fgithub.com%2Fappium%2Fappium-desktop&objectId=2367971&objectType=1&isNewArticle=undefined)；
    
    
    
    
-   选择的对应包即可：
    
    
    
    
-   这里需要注意下，官网给出了明确说明，`appium-desktop`将不再支持 `Appium 2.0+`版本，建议使用命令行方式，
    
    
    
    

## 13 appium环境验证

-   先安装`appium-doctor`：

```python
npm install -g appium-doctor
```

-   命令行输入`appium-doctor`，检查环境是否ok：
    
    
    
    

## 14 appium安装问题排查

-   `appium`给出这几个错误的安装方法，但是有的地址无法访问了，所以以下对每个错误进行了排查：

```python
PS C:\Users\growd> appium-doctor
WARN AppiumDoctor [Deprecated] Please use appium-doctor installed with "npm install @appium/doctor --location=global"
info AppiumDoctor Appium Doctor v.1.16.2
info AppiumDoctor ### Diagnostic for necessary dependencies starting ###
info AppiumDoctor  ✔ The Node.js binary was found at: E:\dev_tool\node-v22.14.0-win-x64\node.EXE
info AppiumDoctor  ✔ Node version is 22.14.0
info AppiumDoctor  ✔ ANDROID_HOME is set to: E:\dev_tool\android-sdk-windows
info AppiumDoctor  ✔ JAVA_HOME is set to: E:\dev_tool\jdk-23.0.2
info AppiumDoctor    Checking adb, android, emulator, apkanalyzer.bat
info AppiumDoctor      'adb' is in E:\dev_tool\android-sdk-windows\platform-tools\adb.exe
info AppiumDoctor      'android' is in E:\dev_tool\android-sdk-windows\tools\android.bat
info AppiumDoctor      'emulator' is in E:\dev_tool\android-sdk-windows\tools\emulator.exe
info AppiumDoctor      'apkanalyzer.bat' is in E:\dev_tool\android-sdk-windows\platform-tools\apkanalyzer.bat
info AppiumDoctor  ✔ adb, android, emulator, apkanalyzer.bat exist: E:\dev_tool\android-sdk-windows
info AppiumDoctor  ✔ 'bin' subfolder exists under 'E:\dev_tool\jdk-23.0.2'
info AppiumDoctor ### Diagnostic for necessary dependencies completed, no fix needed. ###
info AppiumDoctor
info AppiumDoctor ### Diagnostic for optional dependencies starting ###
WARN AppiumDoctor  ✖ opencv4nodejs cannot be found.
info AppiumDoctor  ✔ ffmpeg is installed at: E:\dev_tool\ffmpeg-7.1-essentials_build\bin\ffmpeg.EXE. ffmpeg version 7.1-essentials_build-www.gyan.dev Copyright (c) 2000-2024 the FFmpeg developers
WARN AppiumDoctor  ✖ mjpeg-consumer cannot be found.
info AppiumDoctor  ✔ bundletool.jar is installed at: E:\dev_tool\android-sdk-windows\bundle-tools\bundletool.jar
info AppiumDoctor  ✔ gst-launch-1.0.exe and gst-inspect-1.0.exe are installed at: E:\dev_tool\gstreamer\1.0\mingw_x86_64\bin\gst-launch-1.0.exe and E:\dev_tool\gstreamer\1.0\mingw_x86_64\bin\gst-inspect-1.0.exe
info AppiumDoctor ### Diagnostic for optional dependencies completed, 2 fixes possible. ###
info AppiumDoctor
info AppiumDoctor ### Optional Manual Fixes ###
info AppiumDoctor The configuration can install optionally. Please do the following manually:
WARN AppiumDoctor  ➜ Why opencv4nodejs is needed and how to install it: http://appium.io/docs/en/writing-running-appium/image-comparison/
WARN AppiumDoctor  ➜ mjpeg-consumer module is required to use MJPEG-over-HTTP features. Please install it with 'npm i -g mjpeg-consumer'.
info AppiumDoctor
info AppiumDoctor ###
info AppiumDoctor
info AppiumDoctor Bye! Run appium-doctor again when all manual fixes have been applied!
info AppiumDoctor
PS C:\Users\growd>
```

### 14.1 cmdline-tools问题

-   我这一大堆错的，挨个排查吧，先看下这个：

```python
apkanalyzer.bat could NOT be found in D:\android-sdk-windows!
```

-   安装：[commandlinetools](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Fdeveloper.android.google.cn%2Fstudio%3Fhl%3Dzh-cn&objectId=2367971&objectType=1&isNewArticle=undefined)：
    
    
    
-   解压到`SDK`的目录下：
    
   
    
    
    
-   把`cmdline-tools\bin`目录下的`apkanalyzer.bat`文件复制到`platform-tools`下：
    

    
    
    
-   重新打开`cmd`,输入`appium-doctor` ，查看问题解决了：
    
   
    
    
    

### 14.2 opencv4nodejs问题

-   第二个问题：

```python
opencv4nodejs cannot be found.
```

-   安装`opencv4nodejs`，[CMake官网](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Fcmake.org%2Fdownload%2F&objectId=2367971&objectType=1&isNewArticle=undefined)：
    
   
    
    
    
-   下载后双击`cmake-3.28.0-rc5-windows-x86_64.msi`，安装到默认路径，并勾选增加环境变量给所有用户：
    
   
    
    
    
   
    
    
    

![](https://developer.qcloudimg.com/http-save/10298071/96b53f7b45f26328d24c1727b93f699e.png)



-   如果还是不行，建议手动将其目录添加到系统环境变量中：

```python
C:\Program Files\CMake\bin\
```

-   输入`cmake -version`查看：

-   安装`opencv4nodejs`：

```python
npm -g install opencv4nodejs --ignore-scripts
```

-   重新检查看是否还会报错`opencv4nodejs`错误，发现是ok了：
    
   
    
    
    

### 14.3 ffmpeg问题

-   第三个错误：

-   下载`ffmpeg`安装包：[ffmpeg安装](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Fffmpeg.org%2Fdownload.html&objectId=2367971&objectType=1&isNewArticle=undefined)：
    
   
    
    
    
   
    
    
    
-   下载后`ffmpeg-release-essentials.zip`解压到某个目录下：

```python
D:\ffmpeg-6.1-essentials_build
```

-   并添加环境变量：

```python
D:\ffmpeg-6.1-essentials_build\bin
```

-   再次检查发现`ffmpeg`也是ok的：
    
   
    
    
    

### 14.4 mjpeg-consumer问题

-   第四个问题：

```python
mjpeg-consumer cannot be found
```

-   直接使用`npm i -g mjpeg-consumer`安装即可；
-   排查也是ok了：
    
   
    
    
    

### 14.5 bundletool.jar问题

-   第五个问题：

```python
bundletool.jar cannot be found
```

-   下载安装`bundletool.jar`，[bundletool.jar下载](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Fgithub.com%2Fgoogle%2Fbundletool%2Freleases&objectId=2367971&objectType=1&isNewArticle=undefined)：
    
   
    
    
    
-   下载后为`bundletool-all-1.15.6.jar`重新命名为`bundletool.jar`，在`android sdk`目录下，新建`bundle-tools`目录，把`bundletool.jar`包放入其中：
    
   
    
    
    
-   配置环境，在用户和系统环境的`path`后都追加上述路径的环境：

```python
D:\android-sdk-windows\bundle-tools
```

-   修改环境变量中的 `PATHTEXT` 添加：`;.JAR`
    
   
    
    
    
-   验证也是ok了：
    
   
    
    
    

### 14.6 gst-launch问题

-   第六个问题：

```python
gst-launch-1.0.exe and/or gst-inspect-1.0.exe cannot be found
```

-   下载`gst-launch-1.0.exe and gst-inspect-1.0.exe`：[gst下载地址](https://cloud.tencent.com/developer/tools/blog-entry?target=https%3A%2F%2Fgstreamer.freedesktop.org%2Fdownload%2F&objectId=2367971&objectType=1&isNewArticle=undefined)：
    
   
    
    
    
-   双击下载的`gstreamer-1.0-mingw-x86_64-1.22.7.msi`：
    
   
    
    
    
-  
    
    
    
-   增加环境变量：

```python
F:\gstreamer\1.0\mingw_x86_64\bin
```

-   验证是ok了：
    
   
    
    
    

## 15 完整无报错的Appium信息

-   所有的错误都排查后，完整的信息应该如下：

```python
PS C:\Users\growd> appium-doctor
WARN AppiumDoctor [Deprecated] Please use appium-doctor installed with "npm install @appium/doctor --location=global"
info AppiumDoctor Appium Doctor v.1.16.2
info AppiumDoctor ### Diagnostic for necessary dependencies starting ###
info AppiumDoctor  ✔ The Node.js binary was found at: E:\dev_tool\node-v22.14.0-win-x64\node.EXE
info AppiumDoctor  ✔ Node version is 22.14.0
info AppiumDoctor  ✔ ANDROID_HOME is set to: E:\dev_tool\android-sdk-windows
info AppiumDoctor  ✔ JAVA_HOME is set to: E:\dev_tool\jdk-23.0.2
info AppiumDoctor    Checking adb, android, emulator, apkanalyzer.bat
info AppiumDoctor      'adb' is in E:\dev_tool\android-sdk-windows\platform-tools\adb.exe
info AppiumDoctor      'android' is in E:\dev_tool\android-sdk-windows\tools\android.bat
info AppiumDoctor      'emulator' is in E:\dev_tool\android-sdk-windows\tools\emulator.exe
info AppiumDoctor      'apkanalyzer.bat' is in E:\dev_tool\android-sdk-windows\platform-tools\apkanalyzer.bat
info AppiumDoctor  ✔ adb, android, emulator, apkanalyzer.bat exist: E:\dev_tool\android-sdk-windows
info AppiumDoctor  ✔ 'bin' subfolder exists under 'E:\dev_tool\jdk-23.0.2'
info AppiumDoctor ### Diagnostic for necessary dependencies completed, no fix needed. ###
info AppiumDoctor
info AppiumDoctor ### Diagnostic for optional dependencies starting ###
WARN AppiumDoctor  ✖ opencv4nodejs cannot be found.
info AppiumDoctor  ✔ ffmpeg is installed at: E:\dev_tool\ffmpeg-7.1-essentials_build\bin\ffmpeg.EXE. ffmpeg version 7.1-essentials_build-www.gyan.dev Copyright (c) 2000-2024 the FFmpeg developers
WARN AppiumDoctor  ✖ mjpeg-consumer cannot be found.
info AppiumDoctor  ✔ bundletool.jar is installed at: E:\dev_tool\android-sdk-windows\bundle-tools\bundletool.jar
info AppiumDoctor  ✔ gst-launch-1.0.exe and gst-inspect-1.0.exe are installed at: E:\dev_tool\gstreamer\1.0\mingw_x86_64\bin\gst-launch-1.0.exe and E:\dev_tool\gstreamer\1.0\mingw_x86_64\bin\gst-inspect-1.0.exe
info AppiumDoctor ### Diagnostic for optional dependencies completed, 2 fixes possible. ###
info AppiumDoctor
info AppiumDoctor ### Optional Manual Fixes ###
info AppiumDoctor The configuration can install optionally. Please do the following manually:
WARN AppiumDoctor  ➜ Why opencv4nodejs is needed and how to install it: http://appium.io/docs/en/writing-running-appium/image-comparison/
WARN AppiumDoctor  ➜ mjpeg-consumer module is required to use MJPEG-over-HTTP features. Please install it with 'npm i -g mjpeg-consumer'.
info AppiumDoctor
info AppiumDoctor ###
info AppiumDoctor
info AppiumDoctor Bye! Run appium-doctor again when all manual fixes have been applied!
info AppiumDoctor
PS C:\Users\growd>
```

