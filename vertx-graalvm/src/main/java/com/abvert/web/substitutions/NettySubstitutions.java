package com.abvert.web.substitutions;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.InjectAccessors;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.RecomputeFieldValue.Kind;
import com.oracle.svm.core.annotate.TargetClass;

import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.NetUtil;
import io.netty.util.internal.PlatformDependent;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.function.Predicate;

@TargetClass(className = "io.netty.buffer.AbstractReferenceCountedByteBuf", onlyWith = PlatformHasClass.class)
final class Target_io_netty_buffer_AbstractReferenceCountedByteBuf {
    @Alias
    @RecomputeFieldValue(kind = Kind.FieldOffset, //
            declClassName = "io.netty.buffer.AbstractReferenceCountedByteBuf", //
            name = "refCnt") //
    private static long REFCNT_FIELD_OFFSET;
}

@TargetClass(className = "io.netty.util.AbstractReferenceCounted", onlyWith = PlatformHasClass.class)
final class Target_io_netty_util_AbstractReferenceCounted {
    @Alias
    @RecomputeFieldValue(kind = Kind.FieldOffset, //
            declClassName = "io.netty.util.AbstractReferenceCounted", //
            name = "refCnt") //
    private static long REFCNT_FIELD_OFFSET;
}

@TargetClass(NetUtil.class)
final class NetUtilSubstitutions {
    @Alias
    @InjectAccessors(NetUtilLocalhost4Accessor.class)
    public static Inet4Address LOCALHOST4;

    @Alias
    @InjectAccessors(NetUtilLocalhost6Accessor.class)
    public static Inet6Address LOCALHOST6;

    private static class NetUtilLocalhost4Accessor {
        static Inet4Address get() {
            // using https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
            return NetUtilLocalhost4LazyHolder.LOCALHOST4;
        }

        static void set(Inet4Address ignored) {
            // a no-op setter to avoid exceptions when NetUtil is initialized at run-time
        }
    }

    private static class NetUtilLocalhost4LazyHolder {
        private static final Inet4Address LOCALHOST4;

        static {
            byte[] LOCALHOST4_BYTES = {127, 0, 0, 1};
            // Create IPv4 loopback address.
            try {
                LOCALHOST4 = (Inet4Address) InetAddress.getByAddress("localhost", LOCALHOST4_BYTES);
            } catch (Exception e) {
                // We should not get here as long as the length of the address is correct.
                PlatformDependent.throwException(e);
                throw new IllegalStateException("Should not reach here");
            }
        }
    }

    private static class NetUtilLocalhost6Accessor {
        static Inet6Address get() {
            // using https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
            return NetUtilLocalhost6LazyHolder.LOCALHOST6;
        }

        static void set(Inet6Address ignored) {
            // a no-op setter to avoid exceptions when NetUtil is initialized at run-time
        }
    }
    
    private static class NetUtilLocalhost6LazyHolder {
        private static final Inet6Address LOCALHOST6;

        static {
            byte[] LOCALHOST6_BYTES = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
            // Create IPv6 loopback address.
            try {
                LOCALHOST6 = (Inet6Address) InetAddress.getByAddress("localhost", LOCALHOST6_BYTES);
            } catch (Exception e) {
                // We should not get here as long as the length of the address is correct.
                PlatformDependent.throwException(e);
                throw new IllegalStateException("Should not reach here");
            }
        }
    }
    
    @Alias
    @InjectAccessors(NetUtilLocalhostAccessor.class)
    public static InetAddress LOCALHOST;

    // NOTE: this is the simpliest implementation I could invent to just demonstrate the idea; it is probably not
    // too efficient. An efficient implementation would only have getter and it would compute the InetAddress
    // there; but the post is already very long, and NetUtil.LOCALHOST computation logic in Netty is rather cumbersome.
    private static class NetUtilLocalhostAccessor {
        private static volatile InetAddress ADDR;

        static InetAddress get() {
            return ADDR;
        }

        static void set(InetAddress addr) {
            ADDR = addr;
        }
    }
}


@TargetClass(InternetProtocolFamily.class)
final class InternetProtocolFamilySubstitutions {
    @Alias
    @InjectAccessors(InternetProtocolFamilyLocalhostAccessor.class)
    private InetAddress localHost;

    private static class InternetProtocolFamilyLocalhostAccessor {
        static InetAddress get(InternetProtocolFamily family) {
            switch (family) {
                case IPv4:
                    return NetUtil.LOCALHOST4;
                case IPv6:
                    return NetUtil.LOCALHOST6;
                default:
                    throw new IllegalStateException("Unsupported internet protocol family: " + family);
            }
        }

        static void set(InternetProtocolFamily family, InetAddress address) {
            // storing nothing as the getter derives all it needs from its argument
        }
    }
}

/**
 * A predicate to tell whether this platform includes the argument class.
 */
final class PlatformHasClass implements Predicate<String> {
    @Override
    public boolean test(String className) {
        try {
            @SuppressWarnings({ "unused" })
            final Class<?> classForName = Class.forName(className);
            return true;
        } catch (ClassNotFoundException cnfe) {
            return false;
        }
    }
}

public class NettySubstitutions {
}

