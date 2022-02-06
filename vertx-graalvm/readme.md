# Vertx3 Native

## 构建原生应用

mvn -Pnative package

运行
```
./target/vertx-graalvm-full
```

vertx3.8.2:native-image.properties

```
Args = --initialize-at-run-time=io.netty.handler.ssl.util.ThreadLocalInsecureRandom,\
io.netty.channel.DefaultChannelId,\
io.netty.util.NetUtil,\
io.netty.internal.tcnative.SSL,\
io.netty.channel.socket.InternetProtocolFamily,\
io.netty.resolver.HostsFileEntriesResolver,\
io.netty.resolver.dns.DnsNameResolver,\
io.netty.resolver.dns.DnsServerAddressStreamProviders,\
io.netty.resolver.dns.PreferredAddressTypeComparator\$1,\
io.netty.resolver.dns.DefaultDnsServerAddressStreamProvider,\
io.vertx.core.impl.AddressResolver,\
io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder,\
io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder,\
io.netty.handler.codec.http.HttpObjectEncoder,\
io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,\
io.netty.handler.codec.http2.Http2CodecUtil,\
io.netty.handler.codec.http2.Http2ConnectionHandler,\
io.netty.handler.codec.http2.DefaultHttp2FrameWriter,\
io.netty.util.internal.logging.Log4JLogger,\
io.netty.handler.ssl.ReferenceCountedOpenSslServerContext,\
io.netty.handler.ssl.JdkNpnApplicationProtocolNegotiator,\
io.netty.handler.ssl.ReferenceCountedOpenSslEngine,\
io.netty.handler.ssl.ConscryptAlpnSslEngine,\
io.netty.handler.ssl.JettyNpnSslEngine,\
io.netty.handler.ssl.JettyAlpnSslEngine$ClientEngine,\
io.netty.handler.ssl.JettyAlpnSslEngine$ServerEngine,\
io.netty.handler.ssl.ReferenceCountedOpenSslContext,\
io.netty.handler.ssl.ReferenceCountedOpenSslClientContext,\
io.vertx.core.net.impl.transport.EpollTransport,\
io.vertx.core.net.impl.transport.KQueueTransport,\
io.vertx.core.http.impl.VertxHttp2ClientUpgradeCodec,\
io.vertx.core.eventbus.impl.clustered.ClusteredEventBus \
       -H:ReflectionConfigurationResources=${.}/reflection-config.json \
       -Dio.netty.noUnsafe=true \
       -H:Name=vertx-graalvm \
       -H:+ReportUnsupportedElementsAtRuntime \
       -H:+ReportExceptionStackTraces -Dfile.encoding=UTF-8 
```

vertx4.1.0:native-image.properties

```
Args = --initialize-at-run-time=io.netty.handler.ssl.util.ThreadLocalInsecureRandom,\
io.netty.handler.codec.compression.BrotliDecoder,\
io.netty.channel.DefaultChannelId,\
io.netty.util.NetUtil,\
io.netty.internal.tcnative.SSL,\
io.netty.resolver.HostsFileEntriesResolver,\
io.netty.resolver.dns.DnsNameResolver,\
io.netty.resolver.dns.DnsServerAddressStreamProviders,\
io.netty.resolver.dns.PreferredAddressTypeComparator\$1,\
io.netty.resolver.dns.DefaultDnsServerAddressStreamProvider,\
io.vertx.core.impl.AddressResolver,\
io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder,\
io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder,\
io.netty.handler.codec.http.HttpObjectEncoder,\
io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,\
io.netty.handler.codec.http2.Http2CodecUtil,\
io.netty.handler.codec.http2.Http2ConnectionHandler,\
io.netty.handler.codec.http2.DefaultHttp2FrameWriter,\
io.netty.util.internal.logging.Log4JLogger,\
io.netty.handler.ssl.ReferenceCountedOpenSslServerContext,\
io.netty.handler.ssl.JdkNpnApplicationProtocolNegotiator,\
io.netty.handler.ssl.ReferenceCountedOpenSslEngine,\
io.netty.handler.ssl.ConscryptAlpnSslEngine,\
io.netty.handler.ssl.JettyNpnSslEngine,\
io.netty.handler.ssl.JettyAlpnSslEngine$ClientEngine,\
io.netty.handler.ssl.JettyAlpnSslEngine$ServerEngine,\
io.netty.handler.ssl.ReferenceCountedOpenSslContext,\
io.netty.handler.ssl.ReferenceCountedOpenSslClientContext,\
io.vertx.core.net.impl.transport.EpollTransport,\
io.vertx.core.net.impl.transport.KQueueTransport,\
io.vertx.core.http.impl.VertxHttp2ClientUpgradeCodec,\
io.vertx.core.eventbus.impl.clustered.ClusteredEventBus \
       -H:ReflectionConfigurationResources=${.}/reflection-config.json \
       -Dio.netty.noUnsafe=true \
       -H:Name=vertx-graalvm \
       -H:+ReportUnsupportedElementsAtRuntime \
       -H:+ReportExceptionStackTraces -Dfile.encoding=UTF-8 
```