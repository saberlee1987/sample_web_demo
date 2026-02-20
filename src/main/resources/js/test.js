function sum(...nums) {
    return nums.reduce((n1,n2) => {return n1+n2});
}
let list = [1,2,3,4,5,6,7,8,9,10];
console.log("sum ==> " + sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
console.log("sum ==> " + sum(...list)) ;
let names = ["saber","ali","reza","bruce"];
console.log(names[Symbol.iterator]())
for (let name of names) {
    console.log(name);
}