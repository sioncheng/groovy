list = [1,3,4,1,8,9,2,5]
println list
println list.getClass().name
println list[0]
println list[-1]
println list[1..3]
// sub = list[2..5]
// println sub.dump()

list.each {it -> println it}

println list.collect { it * 2}

println list.find { it % 2 == 0}
println list.findAll { it % 2 == 0}

def nums(a,b,c,d,e) {
    println "$a $b $c $d $e"
}
l5 = [1,2,3,4,5]
nums(*l5)