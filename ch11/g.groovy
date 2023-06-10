str = "Hello"

println str.getMetaClass().name

method = str.getMetaClass().getMetaMethod("toUpperCase")

println method.invoke(str)

print "Does String respond to toLowerCase()? "
println String.metaClass.respondsTo(str, 'toLowerCase') ? 'yes' : 'no'

print "Does String respond to toUpperCase(int)?"
println String.metaClass.respondsTo(str, 'toUpperCase', 5) ? 'yes' : 'no'


def printInfo(obj) {

    usrRequestedProperty = 'bytes'
    usrRequestedMethod = 'toUpperCase'

    println obj[usrRequestedProperty]
    println obj."$usrRequestedProperty"
    println obj."$usrRequestedMethod"()
    println obj.invokeMethod(usrRequestedMethod, null)
}

printInfo "haha"