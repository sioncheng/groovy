
class PropPertender {

    def propertyMissing(String name) {
        "access $name"
    }
}

def bounce = new PropPertender()
assert bounce.hello == "access hello"
// assert bounce.getHello() == "access hello"

def propertyMissing(String name) {
    int result = 0
    name.each {
        result <<= 1
        if (it == 'I') result++
    }
    return result
}

assert IIOI + IOI == IOOIO
println IIOI