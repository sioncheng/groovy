

println String.metaClass


class InspectMe {
    int outer() {
        return inner()
    }

    private int inner() {
        return 1
    }
}

def tracer = new TracingInterceptor(writer: new StringWriter())
def proxyMetaClass = ProxyMetaClass.getInstance(InspectMe)
proxyMetaClass.interceptor = tracer

def inspectMe = new InspectMe()
inspectMe.metaClass = proxyMetaClass

assert 1 == inspectMe.outer()
println tracer.writer.toString()