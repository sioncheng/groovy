
class NoParens {

    def getProperty(String propertyName) {
        if (metaClass.hasProperty(this, propertyName)) {
            println "getProperty $propertyName"
            return metaClass.getProperty(this, propertyName)
        }
        println "invokeMethod $propertyName"
        invokeMethod propertyName, null
    }
}

class PropUser extends NoParens {
    boolean p = true
}

def user = new PropUser()
assert user.p
assert user.toString() == user.toString