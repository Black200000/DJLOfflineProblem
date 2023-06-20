# DJLOfflineProblem

离线运行的Arm架构服务器：
```
CPU: Phytium,D2000/8 E8C
OS: Linux greatwall-pc 5.4.18-85-generic #74-KYLINOS SMP aarch64 GNU/Linux
```
运行jar包的报错信息如下，求解答：

# java -jar DJLOfflineProblem-arm64.jar
```
Cannot download jni files: https://publish.djl.ai/pytorch/1.13.1/jnilib/0.21.0/linux-aarch64/cpu-precxx11/libdjl_torch.so
```
Loading:     100% |████████████████████████████████████████|
Exception in thread "main" ai.djl.engine.EngineException: Cannot download jni files: https://publish.djl.ai/pytorch/1.13.1/jnilib/0.21.0/linux-aarch64/cpu-precxx11/libdjl_torch.so
at ai.djl.pytorch.jni.LibUtils.downloadJniLib(LibUtils.java:507)
at ai.djl.pytorch.jni.LibUtils.findJniLibrary(LibUtils.java:248)
at ai.djl.pytorch.jni.LibUtils.loadLibrary(LibUtils.java:80)
at ai.djl.pytorch.engine.PtEngine.newInstance(PtEngine.java:53)
at ai.djl.pytorch.engine.PtEngineProvider.getEngine(PtEngineProvider.java:40)
at ai.djl.engine.Engine.getEngine(Engine.java:187)
at ai.djl.Model.newInstance(Model.java:99)
at ai.djl.repository.zoo.BaseModelLoader.createModel(BaseModelLoader.java:191)
at ai.djl.repository.zoo.BaseModelLoader.loadModel(BaseModelLoader.java:154)
at ai.djl.repository.zoo.Criteria.loadModel(Criteria.java:172)
at org.example.Final.main(Final.java:46)

Caused by: java.net.UnknownHostException: publish.djl.ai
at java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:196)
at java.net.SocksSocketImpl.connect(SocksSocketImpl.java:394)
at java.net.Socket.connect(Socket.java:606)
at sun.security.ssl.SSLSocketImpl.connect(SSLSocketImpl.java:303)
at sun.security.ssl.BaseSSLSocketImpl.connect(BaseSSLSocketImpl.java:173)
at sun.net.NetworkClient.doConnect(NetworkClient.java:180)
at sun.net.www.http.HttpClient.openServer(HttpClient.java:499)
at sun.net.www.http.HttpClient.openServer(HttpClient.java:594)
at sun.net.www.protocol.https.HttpsClient.<init>(HttpsClient.java:263)
at sun.net.www.protocol.https.HttpsClient.New(HttpsClient.java:366)
at sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.getNewHttpClient(AbstractDelegateHttpsURLConnection.java:207)
at sun.net.www.protocol.http.HttpURLConnection.plainConnect0(HttpURLConnection.java:1167)
at sun.net.www.protocol.http.HttpURLConnection.plainConnect(HttpURLConnection.java:1061)
at sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.connect(AbstractDelegateHttpsURLConnection.java:193)
at sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1584)
at sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1512)
at sun.net.www.protocol.https.HttpsURLConnectionImpl.getInputStream(HttpsURLConnectionImpl.java:268)
at java.net.URL.openStream(URL.java:1092)
at ai.djl.util.Utils.openUrl(Utils.java:461)
at ai.djl.util.Utils.openUrl(Utils.java:445)
at ai.djl.pytorch.jni.LibUtils.downloadJniLib(LibUtils.java:501)
... 10 more


