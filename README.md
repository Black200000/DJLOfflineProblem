# DJLOfflineProblem

## 如何把所有依赖项都打入jar包中，将jar包部署到离线且无ai.djl缓存文件的机器中？
我现在只会通过[拷贝ai.djl缓存文件的方式](https://github.com/deepjavalibrary/djl/discussions/2666#discussioncomment-6234140)提前将所需依赖拷贝进离线机器中。
```
我有两台Win10笔记本电脑A和B，做了如下实验，以下是电脑A和B的信息
OS: Win10
java version: "1.8.0_341"
```

``` 
首先在电脑A上执行如下命令，
mvn package
将生成DJLOfflineProblem-win.jar包和model文件夹拷贝到电脑B中
```

```
电脑B无网络连接，执行如下运行命令 
java -jar DJLOfflineProblem-win.jar -Doffline=true
```
可以观察到无网络连接的电脑B的 C:\Users\Test 目录下生成.djl.ai文件夹，.djl.ai下包含pytorch\1.13.1-20221220-cpu-win-x86_64子文件夹

报错信息如下
```
Loading:     100% |========================================|

Exception in thread "main" java.lang.reflect.InvocationTargetException
at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)

Caused by: ai.djl.engine.EngineException: Cannot download jni files: https://publish.djl.ai/pytorch/1.13.1/jnilib/0.21.0/win-x86_64/cpu/djl_torch.dll
at ai.djl.pytorch.jni.LibUtils.downloadJniLib(LibUtils.java:507)
at ai.djl.pytorch.jni.LibUtils.findJniLibrary(LibUtils.java:248)
at ai.djl.pytorch.jni.LibUtils.loadLibrary(LibUtils.java:80)

....
```
我将电脑A中的**1.13.1-20221220-cpu-win-x86_64**文件夹拷贝进电脑B中，电脑B在离线情况下可运行jar包